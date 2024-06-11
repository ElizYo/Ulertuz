package org.tensorflow.lite.examples.objectdetection

import RetrofitClient
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.objectdetection.databinding.ActivityLoginBinding
import org.tensorflow.lite.examples.objectdetection.login.Login
import org.tensorflow.lite.examples.objectdetection.login.LoginResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private val DB_NAME = "odoo"
    private lateinit var sharedPreferences: SharedPreferences // Declarar SharedPreferences

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginButton = findViewById<Button>(R.id.loginButton)

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("mi_app_pref", Context.MODE_PRIVATE)

        if (sharedPreferences.contains(getString(R.string.user_uid_key))) {
            // Si ya hay un userId, redirigir a la pantalla de inicio
            goToInicio()
            return // Salir del método onCreate para evitar que el usuario pueda iniciar sesión nuevamente
        }

        loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            val request =
                Login(
                    DB_NAME,
                    username,
                    password
                )
            val apiService = RetrofitClient.getApiService()
            val call = apiService.login(request)

            call?.enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(
                    call: Call<LoginResponse?>,
                    response: Response<LoginResponse?>
                ) {
                    if (response.isSuccessful) {

                        val loginResponse: LoginResponse? = response.body()
                        if (loginResponse != null && loginResponse.result!!.isAuthentication) {
                            val userUid = loginResponse.result.userUid
                            val mensaje = "¡Bienvenido!"
                            Toast.makeText(this@LoginActivity, mensaje, Toast.LENGTH_SHORT).show()

                            // Guardar el valor en SharedPreferences
                            val editor = sharedPreferences.edit()
                            editor.putString(getString(R.string.user_uid_key), userUid.toString())
                            editor.apply()

                            goToInicio()

                        } else {
                            val mensaje = "¡Error de autenticación! Verifica tus credenciales."
                            Toast.makeText(this@LoginActivity, mensaje, Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        val mensaje = "¡Error en la solicitud! Inténtalo de nuevo más tarde."
                        Toast.makeText(this@LoginActivity, mensaje, Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                }
            })

        }

    }
    private fun goToInicio()
    {
        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
        finish()
    }

    override fun onBackPressed() {
        val intent = Intent(this, InicioActivity::class.java)
        startActivity(intent)
        finish()
    }

}

package org.tensorflow.lite.examples.objectdetection

import RegistroResponse
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import org.tensorflow.lite.examples.objectdetection.databinding.ActivityRegistroBinding
import org.tensorflow.lite.examples.objectdetection.login.Registro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroActivity : AppCompatActivity() {
    private val DB_NAME = "odoo"

    private lateinit var binding : ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, InicioActivity::class.java)
        val registroButton = findViewById<Button>(R.id.registerButton)

        registroButton.setOnClickListener {
            val email = binding.emailRegister.text.toString()
            val name = binding.nombreRegister.text.toString()
            val username = binding.usernameRegister.text.toString()
            val password = binding.passwordRegister.text.toString()

            val registroRequest = Registro(
                name,
                email,
                username,
                password

            )


            val apiService = RetrofitClient.getApiService()
            val call = apiService.registro(registroRequest)

            call?.enqueue(object : Callback<RegistroResponse?> {
                override fun onResponse(
                    call: Call<RegistroResponse?>,
                    response: Response<RegistroResponse?>
                ) {

                    if (response.isSuccessful) {
                        val registroResponse: RegistroResponse? = response.body()
                        val userId = registroResponse?.userId

                        if (userId != null && userId > 0) {
                            val mensaje = "Usuario creado exitosamente"
                            Toast.makeText(this@RegistroActivity, mensaje, Toast.LENGTH_SHORT).show()
                            gotoLogin()

                        } else {
                            val mensaje = "Error al crear usuario, por favor rellene los datos."
                            Toast.makeText(this@RegistroActivity, mensaje, Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        val mensaje = "Error en la solicitud. Inténtalo de nuevo más tarde."
                        Toast.makeText(this@RegistroActivity, mensaje, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<RegistroResponse?>, t: Throwable) {
                    Toast.makeText(this@RegistroActivity, "no funciono", Toast.LENGTH_SHORT).show()
                }
            })

        }



    }
    override fun onBackPressed() {
        val intent = Intent(this, InicioActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun gotoLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }


}
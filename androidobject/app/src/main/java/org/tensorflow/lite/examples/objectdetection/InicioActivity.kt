package org.tensorflow.lite.examples.objectdetection

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class InicioActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var sharedPreferences: SharedPreferences // Declarar SharedPreferences

        sharedPreferences = getSharedPreferences("mi_app_pref", MODE_PRIVATE)
        if (sharedPreferences.contains(getString(R.string.user_uid_key))) {
            val intent = Intent(this, HomeActivity::class.java)

            startActivity(intent)
            finish()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        val tensorButton: Button = findViewById(R.id.tensorButton)
        val loginButton: Button = findViewById(R.id.loginButton)
        val registrarButton: Button = findViewById(R.id.registrarButton)

        tensorButton.setOnClickListener {
            // Crea un intent para iniciar MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Inicia MainActivity
            startActivity(intent)
            finish()

        }

        loginButton.setOnClickListener {
            // Crea un intent para iniciar LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            // Inicia LoginActivity
            startActivity(intent)
            finish()
        }
        registrarButton.setOnClickListener {
            // Crea un intent para iniciar RegistrarActivity
            val intent = Intent(this, RegistroActivity::class.java)
            // Inicia RegistrarActivity
            startActivity(intent)
            finish()
        }

    }
}
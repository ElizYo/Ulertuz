package org.tensorflow.lite.examples.objectdetection.fragments

import JsonRequestParams
import RequestParams
import RetrofitClient
import Va
import Vals
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import org.tensorflow.lite.examples.objectdetection.HomeActivity
import org.tensorflow.lite.examples.objectdetection.R
import org.tensorflow.lite.examples.objectdetection.login.ObtenerUser
import org.tensorflow.lite.examples.objectdetection.login.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilFragment : Fragment() {
    val db = "odoo"
    val login = "odoo"
    val password = "odoo"
    val model = "res.users"
    private val apiService = RetrofitClient.getApiService()
    private var userUid: String? = null
    private lateinit var imageView: ImageView

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { galleryUri ->
        try {
            imageView.setImageURI(galleryUri)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error al cargar la imagen", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userUid = it.getString(ARG_PARAM1)
        }
    }

    private fun openGallery() {
        galleryLauncher.launch("image/*")
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        userUid?.let { obtenerDatosUser(it) }

        val btnImagen = view.findViewById<Button>(R.id.cambiarImagen)
        btnImagen.setOnClickListener {
            openGallery()
        }

        val btnEnviarDatos = view.findViewById<Button>(R.id.buttonGuardarCambios)
        btnEnviarDatos.setOnClickListener {

       guardarCambios()

        }

        imageView = view.findViewById(R.id.imagenUser)
        return view
    }



    private fun guardarCambios() {
        val nombre = view?.findViewById<EditText>(R.id.editTextNombre)?.text.toString()
        val loginUser = view?.findViewById<EditText>(R.id.editUser)?.text.toString()
        val email = view?.findViewById<EditText>(R.id.editemail)?.text.toString()
        val password = view?.findViewById<EditText>(R.id.editPassword)?.text.toString()

        val imagenBase64 = obtenerImagenBase64()

        if(password.isBlank()) {
            val requestParams = RequestParams(
                model = "res.users",
                modelo = "ir.attachment",
                id = userUid?.toInt() ?: 0,
                vals = Vals(
                    name = nombre,
                    login = loginUser,
                    email = email

                ),
                va = Va(
                    image1024 = imagenBase64 ?: ""
                ),
                db = "odoo",
                login = "odoo",
                password = "odoo"
            )
            val jsonRequestParams = JsonRequestParams(params = requestParams)
            enviarDatos(jsonRequestParams)

        }

        else {
            val requestParams = RequestParams(
                model = "res.users",
                modelo = "ir.attachment",
                id = userUid?.toInt() ?: 0,
                vals = Vals(
                    name = nombre,
                    login = loginUser,
                    email = email,
                    password = password
                ),
                va = Va(
                    image1024 = imagenBase64 ?: ""
                ),
                db = "odoo",
                login = "odoo",
                password = "odoo"
            )
            val jsonRequestParams = JsonRequestParams(params = requestParams)
            enviarDatos(jsonRequestParams)
        }


    }


    private fun enviarDatos(jsonRequestParams: JsonRequestParams) {
        val call = apiService.writeToOdoo(jsonRequestParams)
        call.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "¡Sus datos han sido modificados correctamente!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Toast.makeText(context, "Han ocurrido un error.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun obtenerImagenBase64(): String? {
        val drawable = imageView.drawable
        val bitmap = (drawable as BitmapDrawable).bitmap

        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream) // Puedes cambiar el formato y la calidad según tus necesidades
        val imageBytes = outputStream.toByteArray()
        outputStream.close()

        return Base64.encodeToString(imageBytes, Base64.DEFAULT)
    }


    private fun obtenerDatosUser(id: String) {
        Toast.makeText(requireContext(), "entrando", Toast.LENGTH_SHORT).show()
        val request = ObtenerUser(model, db, login, password)
        val call = apiService.obtenerUser(id, request)
        call?.enqueue(object : Callback<UserData?> {
            override fun onResponse(call: Call<UserData?>, response: Response<UserData?>) {
                if (response.isSuccessful) {
                    val userData = response.body()
                    if (userData != null) {
                        updateUI(userData)
                    }
                } else {
                    Toast.makeText(context, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {
                Toast.makeText(context, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun updateUI(userData: UserData) {
        val nameTextView = view?.findViewById<TextView>(R.id.editTextNombre)
        val loginTextView = view?.findViewById<TextView>(R.id.editUser)
        val emailTextView = view?.findViewById<TextView>(R.id.editemail)
        val imageView = view?.findViewById<ImageView>(R.id.imagenUser)

        nameTextView?.text = userData.result?.name
        loginTextView?.text = userData.result?.login
        emailTextView?.text = userData.result?.email

        imageView?.let {
            Glide.with(requireContext())
                .load(userData.result?.image_url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_launcher_foreground) // Placeholder opcional mientras se carga la imagen
                .into(imageView)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(userUid: String) =
            PerfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, userUid)
                }
            }
    }
}

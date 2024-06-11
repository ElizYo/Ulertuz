package org.tensorflow.lite.examples.objectdetection
import PalabraDetalles
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.navigation.NavigationView
import org.tensorflow.lite.examples.objectdetection.fragments.PerfilFragment
import org.tensorflow.lite.examples.objectdetection.fragments.PortadaFragment
import org.tensorflow.lite.examples.objectdetection.fragments.TutorialFragment
import org.tensorflow.lite.examples.objectdetection.login.Palabra
import org.tensorflow.lite.examples.objectdetection.login.PalabrasResponse
import org.tensorflow.lite.examples.objectdetection.login.UserData
import org.tensorflow.lite.examples.objectdetection.adapater.SearchAdapter
import org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabras
import org.tensorflow.lite.examples.objectdetection.login.ObtenerUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        private const val REQUEST_CODE_SPEECH_INPUT = 100
    }
    private lateinit var fragmentContainer: FrameLayout
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var searchView: SearchView
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var recyclerView: RecyclerView
    private var userUid = "";
    private lateinit var items: MutableList<Palabra>


    val db = "odoo"
    val login = "odoo"
    val password = "odoo"
    val model = "res.users"
    private val apiService = RetrofitClient.getApiService()
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        val filters = emptyArray<Array<Any>>()
        val obtenerPalabrasRequest = ObtenerPalabras(filters)

        obtenerPalabras(obtenerPalabrasRequest)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        items = mutableListOf()

        fragmentContainer = findViewById(R.id.fragment_container)
        searchView = findViewById(R.id.searchView)


        val btnVoiceSearch = findViewById<ImageButton>(R.id.btnVoiceSearch)
        btnVoiceSearch.setOnClickListener {
            startVoiceInput()
        }



        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        sharedPreferences = getSharedPreferences("mi_app_pref", Context.MODE_PRIVATE)


        if(savedInstanceState == null){
            replaceFragment(PortadaFragment())
            navigationView.setCheckedItem(R.id.nav_portada)
        }

        userUid = sharedPreferences.getString(getString(R.string.user_uid_key), "").toString()
       obtenerDatosUser(userUid)
        //Toast.makeText(this@HomeActivity, "User UID: $userUid", Toast.LENGTH_SHORT).show()

    }



    private fun obtenerPalabras(request: ObtenerPalabras) {
        apiService.obtenerpalabras(request)?.enqueue(object : Callback<PalabrasResponse?> {
            override fun onResponse(call: Call<PalabrasResponse?>, response: Response<PalabrasResponse?>) {
                if (response.isSuccessful) {
                    val palabrasResponse = response.body()
                    val palabras = palabrasResponse?.result


                    palabras?.forEach { palabraResponse ->
                        palabraResponse.nombre?.let { nombre ->
                            palabraResponse.id.let { id ->
                                val palabra = Palabra(nombre, id)
                                items.add(palabra)
                            }
                        }
                    }

                    searchAdapter = SearchAdapter(items, object : SearchAdapter.OnItemClickListener {
                        override fun onItemClick(palabra: Palabra) {
                            val perfilDetallesFragment = PalabraDetalles.newInstance(palabra.id.toString())
                            replaceFragment(perfilDetallesFragment)
                            searchView.setQuery("", false)
                            searchView.clearFocus()
                            recyclerView.visibility = View.GONE
                            fragmentContainer.visibility = View.VISIBLE
                           // Toast.makeText(this@HomeActivity, "Clicked: ${palabra.id}", Toast.LENGTH_SHORT).show()
                        }
                    })
                    recyclerView.adapter = searchAdapter
                    searchAdapter.notifyDataSetChanged()
                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            if (newText.isNullOrEmpty()) {
                                recyclerView.visibility = View.GONE
                                fragmentContainer.visibility = View.VISIBLE
                            } else {
                                recyclerView.visibility = View.VISIBLE
                                fragmentContainer.visibility = View.GONE
                                searchAdapter.filter(newText)
                            }
                            return false
                        }
                    })



                    // Now the items list contains all the nombres
                    // Do whatever you need with the items list here
                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<PalabrasResponse?>, t: Throwable) {
                // Handle failure
            }


        })
    }




    private fun startVoiceInput() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Diga algo para buscar")
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT)
        } catch (e: Exception) {
            Toast.makeText(this, "Su dispositivo no soporta entrada de voz", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_portada -> replaceFragment(PortadaFragment())
            R.id.nav_editar -> {
               // Toast.makeText(this@HomeActivity, "el id es: $userUid", Toast.LENGTH_SHORT).show()
                val perfilFragment = userUid.let { PerfilFragment.newInstance(it) }
                replaceFragment(perfilFragment)
            }
            R.id.nav_tutorial -> replaceFragment(TutorialFragment())
            R.id.nav_traducir -> {
                // Iniciar IA desde menu lateral
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_logout -> {
                sharedPreferences.edit().remove(getString(R.string.user_uid_key)).apply()
                startActivity(Intent(this@HomeActivity, InicioActivity::class.java))
                finish()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == Activity.RESULT_OK) {
            data?.let {
                val result = it.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                if (!result.isNullOrEmpty()) {
                    val recognizedText = result[0]
                    searchView.setQuery(recognizedText, true)
                }
            }
        }
    }

    private fun obtenerDatosUser(id: String) {
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
                    Toast.makeText(this@HomeActivity, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {
                Toast.makeText(this@HomeActivity, "Error en la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }



    private fun updateUI(userData: UserData) {

        val imageView = findViewById<ImageView>(R.id.fotoPerfil)


        imageView?.let {
            Glide.with(this@HomeActivity)
                .load(userData.result?.image_url)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_launcher_foreground) // Placeholder opcional mientras se carga la imagen
                .into(imageView)

        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)

        fragmentTransaction.commit()
    }




    override fun onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
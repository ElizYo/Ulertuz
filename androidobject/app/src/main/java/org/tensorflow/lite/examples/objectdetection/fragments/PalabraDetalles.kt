import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.tensorflow.lite.examples.objectdetection.R
import org.tensorflow.lite.examples.objectdetection.RetroFit.ConsumirApi
import org.tensorflow.lite.examples.objectdetection.adapater.PalabraAdapter
import org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabra
import org.tensorflow.lite.examples.objectdetection.login.PalabraRespuesta
import org.tensorflow.lite.examples.objectdetection.login.Resultado
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class PalabraDetalles : Fragment() {
    private var palabraId: String? = null
    val db = "odoo"
    val login = "odoo"
    val password = "odoo"
    private lateinit var apiService: ConsumirApi
    private lateinit var recyclerView: RecyclerView
    private lateinit var palabraAdapter: PalabraAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            palabraId = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_palabra_detalles, container, false)

        apiService = RetrofitClient.getApiService()

        palabraId?.let { obtenerDatosDelGesto(it) }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_palabra)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)


        val emptyResult = Resultado()

        palabraAdapter = PalabraAdapter(emptyResult, requireContext())
        recyclerView.adapter = palabraAdapter

    }

    private fun obtenerDatosDelGesto(id: String) {
        val request = ObtenerPalabra(db, login, password)
        val call = apiService.obtenerpalabra(id, request)
        call?.enqueue(object : Callback<PalabraRespuesta?> {
            override fun onResponse(
                call: Call<PalabraRespuesta?>,
                response: Response<PalabraRespuesta?>
            ) {
                if (response.isSuccessful) {
                    val palabrasResponse = response.body()
                    val palabras = palabrasResponse?.result
                            // Toast.makeText(context, "Si", Toast.LENGTH_SHORT).show()
                    palabras?.let {
                        palabraAdapter = PalabraAdapter(it, requireContext())
                        recyclerView.adapter = palabraAdapter
                    }
                } else {
                    Toast.makeText(context, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<PalabraRespuesta?>, t: Throwable) {

                Toast.makeText(context, "Error al procesar la solicitud", Toast.LENGTH_SHORT).show()
            }
        })
    }
    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val TAG = "PalabraDetalles"

        @JvmStatic
        fun newInstance(palabraId: String): PalabraDetalles {
            val fragment = PalabraDetalles()
            val args = Bundle()
            args.putString(ARG_PARAM1, palabraId)
            fragment.arguments = args
            return fragment
        }
    }
}

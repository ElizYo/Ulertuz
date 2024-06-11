package org.tensorflow.lite.examples.objectdetection.fragments

import RetrofitClient
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import org.tensorflow.lite.examples.objectdetection.login.PalabrasResponse
import org.tensorflow.lite.examples.objectdetection.R
import org.tensorflow.lite.examples.objectdetection.adapater.PalabrasAdapater
import org.tensorflow.lite.examples.objectdetection.login.ObtenerPalabras
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ColoresFragment : Fragment(), PalabrasAdapater.OnItemClickListener {
    private val apiService = RetrofitClient.getApiService()
    private lateinit var recyclerView: RecyclerView
    private lateinit var palabrasAdapter: PalabrasAdapater

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comida, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rv_palabras)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        palabrasAdapter = PalabrasAdapater(emptyList(), requireContext(), this)
        recyclerView.adapter = palabrasAdapter

        val categoria = "colores"
        val filters = arrayOf(arrayOf("category", "=", categoria))
        val obtenerPalabrasRequest = ObtenerPalabras(filters)
        obtenerPalabras(obtenerPalabrasRequest)

    }

    override fun onItemClick(itemId: String) {
        val detalleFragment = PalabraDetalles.newInstance(itemId)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detalleFragment)
            .addToBackStack(null)
            .commit()
    }


    private fun obtenerPalabras(request: ObtenerPalabras) {
        apiService.obtenerpalabras(request)?.enqueue(object : Callback<PalabrasResponse?> {
            override fun onResponse(call: Call<PalabrasResponse?>, response: Response<PalabrasResponse?>) {
                if (response.isSuccessful) {
                    val palabrasResponse = response.body()
                    val palabras = palabrasResponse?.result
                    palabras?.let {
                        palabrasAdapter = PalabrasAdapater(it, requireContext(), this@ColoresFragment)
                        recyclerView.adapter = palabrasAdapter
                    }
                } else {
                }
            }
            override fun onFailure(call: Call<PalabrasResponse?>, t: Throwable) {

            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComidaFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}

package org.tensorflow.lite.examples.objectdetection.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import org.tensorflow.lite.examples.objectdetection.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PortadaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PortadaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_portada, container, false)

        // Encuentra tus CardView por ID
        val cardAbecedario = view.findViewById<CardView>(R.id.card_abecedario)
        val cardNumeros = view.findViewById<CardView>(R.id.card_numeros)
        val cardColores = view.findViewById<CardView>(R.id.card_colores)
        val cardAnimales = view.findViewById<CardView>(R.id.card_animales)
        val cardFamilia = view.findViewById<CardView>(R.id.card_familia)
        val cardSaludo = view.findViewById<CardView>(R.id.card_saludos)
        val cardFecha = view.findViewById<CardView>(R.id.card_fechas)
        val cardComida = view.findViewById<CardView>(R.id.card_comida)

// Agrega OnClickListener a cada CardView
        cardAbecedario.setOnClickListener {
            navigateToFragment(AbecedarioFragment())
        }

        cardNumeros.setOnClickListener {
            navigateToFragment(NumerosFragment())
        }

        cardColores.setOnClickListener {
            navigateToFragment(ColoresFragment())
        }

        cardAnimales.setOnClickListener {
            navigateToFragment(AnimalesFragment())
        }

        cardFamilia.setOnClickListener {
            navigateToFragment(FamiliaFragment())
        }

        cardSaludo.setOnClickListener {
            navigateToFragment(SaludosFragment())
        }

        cardFecha.setOnClickListener {
            navigateToFragment(FechasFragment())
        }

        cardComida.setOnClickListener {
            navigateToFragment(ComidaFragment())
        }

        return view
    }

    private fun navigateToFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PortadaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
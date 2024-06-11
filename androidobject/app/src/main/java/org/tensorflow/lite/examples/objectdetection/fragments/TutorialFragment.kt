package org.tensorflow.lite.examples.objectdetection.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.tensorflow.lite.examples.objectdetection.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TutorialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TutorialFragment : Fragment() {
    private val tutorialImages = listOf(
        R.drawable.a1,
        R.drawable.a2,
        R.drawable.a3
    )

    private val tutorialTexts = listOf(
        "Para usar Ulertuz y empezar a traducir debes escanear a la persona donde se vea la mitad de su cuerpo y su mano.",
        "Debajo saldrá un recuadro negro donde iran saliendo la letra, la palabra donde poco a poco podrás formar una oración.",
        "Puedes usar el botón de abajo para borrar tu oración y comenzar a traducir de nuevo. "
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura la imagen y el texto inicial
        updateTutorialContent()

        // Configura los listeners de los botones
        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            onNextClicked()
        }

        view.findViewById<Button>(R.id.btnBack).setOnClickListener {
            onBackClicked()
        }
    }

    private fun onNextClicked() {
        if (currentIndex < tutorialImages.size - 1) {
            currentIndex++
            updateTutorialContent()
        }
    }

    private fun onBackClicked() {
        if (currentIndex > 0) {
            currentIndex--
            updateTutorialContent()
        }
    }

    private fun updateTutorialContent() {
        view?.findViewById<TextView>(R.id.tutorialTextView)?.text = tutorialTexts[currentIndex]
        view?.findViewById<TextView>(R.id.tutorialTextView)?.text = tutorialTexts[currentIndex]
        view?.findViewById<TextView>(R.id.tutorialTextView)?.text = tutorialTexts[currentIndex]
        view?.findViewById<ImageView>(R.id.tutorialImageView)?.setImageResource(tutorialImages[currentIndex])
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PuntuacionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TutorialFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
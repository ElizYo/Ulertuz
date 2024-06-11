package org.tensorflow.lite.examples.objectdetection.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.tensorflow.lite.examples.objectdetection.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PalabraFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PalabraFragment : Fragment() {
    // Simula una lista de imágenes
    private val imageList = listOf(
        R.drawable.loginbkg,
        R.drawable.loginbkg2,
        R.drawable.segnalmini
    )

    class ImageAdapter(private val imageList: List<Int>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val imageResource = imageList[position]
            holder.imageView.setImageResource(imageResource)
        }

        override fun getItemCount(): Int {
            return imageList.size
        }

        inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imageView)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_palabra, container, false)

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.recyclerView)

        // Configura Horizontal o Vertical
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Adapter
        val adapter = ImageAdapter(imageList)
        recyclerView.adapter = adapter

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(letter: String, s: String) = PalabraFragment()
    }
}
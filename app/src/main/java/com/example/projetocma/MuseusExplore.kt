package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.navigation.fragment.findNavController
import models.Museu


class MuseusExplore : Fragment(), Museu.OnItemClickListener {

    val names = arrayOf("Museu da Sé", "Museu do Pio", "Museu do Prado", "Museu De La Plata", "Museu da Marinha")
    val img = arrayOf(R.drawable.museu, R.drawable.museupio,R.drawable.museudoprado, R.drawable.museudelaplata, R.drawable.museudamarinha).toIntArray()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_museus_explore, container, false)



        val museuAdapter = Museu(requireContext(), names, img, this)

        val gridView: GridView = view.findViewById(R.id.gridView)
        gridView.adapter = museuAdapter


        return view
    }

    override fun onItemClick(position: Int) {
        val selectedName = names[position]
        val selectedImage = img[position]

        val bundle = Bundle()
        bundle.putString("name", selectedName)
        bundle.putInt("image", selectedImage)

        findNavController().navigate(R.id.museuDetail, bundle)


    }
}
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_museus_explore, container, false)

        val names = arrayOf("asdasdas", "asdasdasdas")
        val img = arrayOf(R.drawable.imageplaceholder, R.drawable.imageplaceholder).toIntArray()

        val museuAdapter = Museu(requireContext(), names, img, this)

        val gridView: GridView = view.findViewById(R.id.gridView)
        gridView.adapter = museuAdapter

        return view
    }

    override fun onItemClick(position: Int) {
        // Handle item click, for example, navigate to a new fragment with details
        findNavController().navigate(R.id.museuDetail)
    }
}
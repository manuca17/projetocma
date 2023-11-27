package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import models.GridAdapter


class museusExplore : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_museus_explore, container, false)

        val names = arrayOf("asdasdas", "asdasdasdas")
        val img = arrayOf(R.drawable.imageplaceholder, R.drawable.imageplaceholder).toIntArray()

        val gridAdapter = GridAdapter(requireContext(), names, img)

        // Find the GridView in the layout
        val gridView: GridView = view.findViewById(R.id.gridView)

        // Set the adapter for the GridView
        gridView.adapter = gridAdapter

        return view
    }
}
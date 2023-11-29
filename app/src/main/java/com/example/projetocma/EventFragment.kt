package com.example.projetocma

import android.media.metrics.Event
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.projetocma.databinding.FragmentEventBinding
import models.Eventos
import models.Museu


class EventFragment : Fragment() {

    private val title = arrayOf("JOAN MIRÓ / ALEXANDER CALDER: ESPAÇO EM MOVIMENTO","JOAN MIRÓ / ALEXANDER CALDER: ESPAÇO EM MOVIMENTO","JOAN MIRÓ / ALEXANDER CALDER: ESPAÇO EM MOVIMENTO")
    private val date = arrayOf("22 JUN 2023 - 27 JAN 2024","22 JUN 2023 - 27 JAN 2024","22 JUN 2023 - 27 JAN 2024")
    private val img = arrayOf(R.drawable.joanmiro,R.drawable.joanmiro,R.drawable.joanmiro).toIntArray()

    private lateinit var binding: FragmentEventBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEventBinding.inflate(inflater, container, false)

        val eventAdapter = Eventos(requireContext(), title, img, date)
        val gridView: GridView = binding.gridViewEventos
        gridView.adapter = eventAdapter
        return binding.root
    }

}
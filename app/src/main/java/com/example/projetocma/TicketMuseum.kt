package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentTicketBasiccBinding
import com.example.projetocma.databinding.FragmentTicketMuseumBinding


class TicketMuseum : Fragment() {

    private lateinit var binding: FragmentTicketMuseumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketMuseumBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.buttonNextMuseum.setOnClickListener {
            findNavController().navigate(R.id.reservePage)
        }
        return binding.root
    }


}
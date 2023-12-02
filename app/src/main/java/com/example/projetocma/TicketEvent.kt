package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentTicketBasiccBinding
import com.example.projetocma.databinding.FragmentTicketEventtBinding


class TicketEvent : Fragment() {

    private lateinit var binding: FragmentTicketEventtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketEventtBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.buttonNextEvent.setOnClickListener {
            findNavController().navigate(R.id.reservePage)
        }
        return binding.root
    }


}
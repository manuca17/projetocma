package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentTicketBasiccBinding


class TicketBasic : Fragment() {
    private lateinit var binding: FragmentTicketBasiccBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketBasiccBinding.inflate(inflater, container, false)

        val name = arguments?.getString("name")
        val description = arguments?.getString("description")
        val imageResId = arguments?.getInt("image")
        val price = arguments?.getString("price")

        binding.ticketPrice.text = price
        binding.ticketName.text = name
        binding.description.text = description
        imageResId?.let { binding.ticketImg.setImageResource(it) }


        binding.buttonNextBasic.setOnClickListener {
            findNavController().navigate(R.id.reservePage)
        }


        return binding.root
    }

}
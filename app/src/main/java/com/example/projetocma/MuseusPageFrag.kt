package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentMuseusPageBinding


class MuseusPageFrag : Fragment() {
    private var _binding: FragmentMuseusPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMuseusPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up click listener for the button
        binding.exploreButton.setOnClickListener {
            // Navigate to the destination fragment
            findNavController().navigate(R.id.museusExplore)
        }
        binding.qrCodeButton.setOnClickListener {
            // Navigate to the destination fragment
            findNavController().navigate(R.id.qrCode)
        }
        binding.reserveButton.setOnClickListener {
            // Navigate to the destination fragment
            findNavController().navigate(R.id.calendario)
        }

    }

}
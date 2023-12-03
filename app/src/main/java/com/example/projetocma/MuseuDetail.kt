package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentMuseuDetailBinding

class MuseuDetail : Fragment() {

    private lateinit var binding: FragmentMuseuDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMuseuDetailBinding.inflate(inflater, container, false)

        binding.eventosButton.setOnClickListener{
            findNavController().navigate(R.id.eventFragment)
        }

        binding.reserveMuseumCodeButton.setOnClickListener {
            findNavController().navigate(R.id.fragmentTickets)
        }

        // Retrieve arguments
        val name = arguments?.getString("name")
        val description = arguments?.getString("description")
        val imageResId = arguments?.getInt("image")
        binding.textViewMuseumName.text = name

        binding.historiaButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putInt("image", imageResId?:0)
            bundle.putString("description", description)

            findNavController().navigate(R.id.historiaMuseu, bundle)
        }
        binding.obrasButton.setOnClickListener {
            findNavController().navigate(R.id.obrasExplore)
        }
        imageResId?.let { binding.museumImage.setImageResource(it) }

        return binding.root

    }



}
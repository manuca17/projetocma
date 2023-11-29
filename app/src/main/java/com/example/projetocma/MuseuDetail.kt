package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentMuseuDetailBinding

class MuseuDetail : Fragment() {

    private var _binding: FragmentMuseuDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMuseuDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.eventosButton.setOnClickListener{
            findNavController().navigate(R.id.eventFragment)
        }

        // Retrieve arguments
        val name = arguments?.getString("name")
        val imageResId = arguments?.getInt("image")

        // Now you can use 'name' and 'imageResId' in your fragment

        // Example: Set the name in a TextView
        binding.textViewMuseumName.text = name

        // Example: Set the image in an ImageView
        imageResId?.let { binding.museumImage.setImageResource(it) }
    }


}
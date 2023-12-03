package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentTimePickerBinding

class TimePicker : Fragment() {
    private var _binding: FragmentTimePickerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentTimePickerBinding.inflate(inflater, container, false)
        val view = binding.root

        val picker = view.findViewById<TimePicker>(R.id.timePicker2)
        picker.setIs24HourView(true)

        binding.buttonNextEvent3.setOnClickListener {
            // Navegar para o fragmento de destino
            findNavController().navigate(R.id.reservePage)
        }

        binding.buttonBackEvent3.setOnClickListener {
            // Faça qualquer coisa que desejar ao clicar no botão "Anterior"
            findNavController().navigate(R.id.calendario)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentTimePickerBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TimePicker : Fragment() {
    private var _binding: FragmentTimePickerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTimePickerBinding.inflate(inflater, container, false)
        val view = binding.root

        // Obtenha a data selecionada do Bundle
        val selectedDate: Date? = arguments?.getSerializable("selectedDate") as? Date

        val picker = view.findViewById<TimePicker>(R.id.timePicker2)
        picker.setIs24HourView(true)

        // Verifique se a data foi selecionada
        if (selectedDate != null) {
            val locale = Locale("pt")
            val dateFormat = SimpleDateFormat("dd, MMMM ,yyyy", locale)
            val formattedDate = dateFormat.format(selectedDate)
            binding.datePicked.text = formattedDate
        } else {
            binding.datePicked.text = "Nenhuma data selecionada"
        }

       binding.buttonNextEvent3.setOnClickListener {
            val selectedHour = picker.currentHour
            val selectedMinute = picker.currentMinute

            val bundle = Bundle()
            bundle.putInt("selectedHour", selectedHour)
            bundle.putInt("selectedMinute", selectedMinute)
           val selectedDate: Date? = arguments?.getSerializable("selectedDate") as? Date
           bundle.putSerializable("selectedDate", selectedDate)

            val quantityReserveFragment = QuantityReserve()
            quantityReserveFragment.arguments = bundle

            // Navegar para o fragmento de destino e passar os dados via Bundle
            findNavController().navigate(R.id.quantittyReserve, bundle)
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

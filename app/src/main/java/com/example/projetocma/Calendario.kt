package com.example.projetocma
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentCalendarioBinding
import java.util.*

class Calendario : Fragment() {
    private var _binding: FragmentCalendarioBinding? = null
    private val binding get() = _binding!!

    private var selectedDate: Date? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            val locale = Locale("pt")
            val dateFormat = java.text.SimpleDateFormat("dd MMMM yyyy", locale)
            selectedDate = calendar.time
            val date = dateFormat.format(calendar.time)

            // Você pode realizar qualquer ação com a data selecionada aqui
        }

        binding.buttonNextEvent.setOnClickListener {
            // Navegar para o fragmento de destino
            findNavController().navigate(R.id.timePicker)
        }

        binding.buttonBackEvent.setOnClickListener {
            // Faça qualquer coisa que desejar ao clicar no botão "Anterior"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getSelectedDate(): Date? {
        return selectedDate
    }
}

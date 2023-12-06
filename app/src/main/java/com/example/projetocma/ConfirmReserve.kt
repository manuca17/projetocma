package com.example.projetocma
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ConfirmReserve : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirm_reserve, container, false)

        // Obtendo os argumentos passados pelo Bundle
        val selectedDate: Date? = arguments?.getSerializable("selectedDate") as? Date
        val selectedHour: Int? = arguments?.getInt("selectedHour")
        val selectedMinute: Int? = arguments?.getInt("selectedMinute")

        // Formatando a data e hora para exibição nos botões
        val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDate)
        val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)

        // Configurando a data no botão "DATA"
        val buttonChangeDate: Button = view.findViewById(R.id.button_change_date2)
        buttonChangeDate.text = formattedDate ?: "DATA"

        // Configurando as horas no botão "HORA"
        val buttonChangeHour: Button = view.findViewById(R.id.change_hour2)
        buttonChangeHour.text = formattedTime ?: "HORA"

        // Restante do seu código


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val confirmar: Button = view.findViewById(R.id.button_next_event4)
        val changeData: Button = view.findViewById(R.id.button_change_date2)
        val changeHour: Button = view.findViewById(R.id.change_hour2)

        changeData.setOnClickListener {
            findNavController().navigate(R.id.calendario)
        }

        changeHour.setOnClickListener {
            findNavController().navigate(R.id.timePicker)
        }
        confirmar.setOnClickListener{
            findNavController().navigate(R.id.paymentAcknowledgment)
        }


    }

}

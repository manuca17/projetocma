package com.example.projetocma
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class QuantityReservePage : Fragment() {
    private var adultsCount = 0
    private var childCount = 0
    private lateinit var adultsCountTextView: TextView
    private lateinit var childCountTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quantity_reserve, container, false)

        val changeHourButton: Button = view.findViewById(R.id.change_hour)

        val selectedHour: Int? = arguments?.getInt("selectedHour")
        val selectedMinute: Int? = arguments?.getInt("selectedMinute")
        val selectedDate: Date? = arguments?.getSerializable("selectedDate") as? Date

        if (selectedHour != null && selectedMinute != null) {
            // Formate a hora e defina o texto do botão
            val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
            changeHourButton.text = formattedTime
        } else {
            // Se a hora não foi selecionada, defina um texto padrão ou vazio para o botão
            changeHourButton.text = "Selecione a hora"
        }

        if (selectedDate != null) {
            // Faça o que deseja com a data selecionada
            // Por exemplo, exiba-a em um TextView
            val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDate)
            val textViewDate = view.findViewById<TextView>(R.id.button_change_date)
            textViewDate.text = formattedDate
        }
        adultsCountTextView = view.findViewById(R.id.adultsCount)
        childCountTextView = view.findViewById(R.id.childCount)


        val addAdultButton: Button = view.findViewById(R.id.addAdultButton)
        addAdultButton.setOnClickListener {
            addAdult()
        }

        val removeAdultButton: Button = view.findViewById(R.id.removeAdultButton)
        removeAdultButton.setOnClickListener {
            removeAdult()
        }

        val addChildButton: Button = view.findViewById(R.id.addChildButton)
        addChildButton.setOnClickListener {
            addChild()
        }

        val removeChildButton: Button = view.findViewById(R.id.removeChildButton)
        removeChildButton.setOnClickListener {
            removeChild()
        }

        return view
    }

    private fun addAdult() {
        adultsCount++
        displayAdultsCount()
    }

    private fun removeAdult() {
        if (adultsCount > 0) {
            adultsCount--
            displayAdultsCount()
        }
    }
    private fun addChild() {
        childCount++
        displayChildCount()
    }

    private fun removeChild() {
        if (childCount > 0) {
            childCount--
            displayChildCount()
        }
    }

    private fun displayAdultsCount() {
        adultsCountTextView.text = adultsCount.toString()
    }
    private fun displayChildCount() {
        childCountTextView.text = childCount.toString()
    }


}


package com.example.projetocma
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*

class Calendario : Fragment() {
    // Variáveis para TextView e CalendarView
    private lateinit var dateTV: TextView
    private lateinit var calendarView: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_calendario, container, false)
        // ver data dateTV = view.findViewById(R.id.idTVDate)
        calendarView = view.findViewById(R.id.calendarView)



        // Definir o idioma desejado para o calendário (por exemplo, francês)
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            val locale = Locale("pt") // Definir o idioma para portugues

            val dateFormat = java.text.SimpleDateFormat("dd MMMM yyyy", locale)
            val date = dateFormat.format(calendar.time)

            // Definir a data formatada no TextView para exibição
            //dateTV.text = date
        }


        return view
    }
}

package com.example.projetocma

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class Tickets : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tickets, container, false)

        val ticketBasicIcon = view.findViewById<ImageView>(R.id.ticket_basic_icone)
        val ticketEventIcon = view.findViewById<ImageView>(R.id.ticket_event_icone)
        val ticketMuseumIcon = view.findViewById<ImageView>(R.id.ticket_museum_icone)

        ticketBasicIcon.setOnClickListener {
            val intent = Intent(requireActivity(), TicketsBasic::class.java)
            startActivity(intent)
        }

        ticketEventIcon.setOnClickListener {
            val intent = Intent(requireActivity(), TicketsEvent::class.java)
            startActivity(intent)
        }

        ticketMuseumIcon.setOnClickListener {
            val intent = Intent(requireActivity(), TicketsMuseum::class.java)
            startActivity(intent)
        }

        return view
    }
}

package com.example.projetocma

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

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
            findNavController().navigate(R.id.ticketBasicc)
        }

        ticketEventIcon.setOnClickListener {
            findNavController().navigate(R.id.ticketEventt)
        }

        ticketMuseumIcon.setOnClickListener {
            findNavController().navigate(R.id.ticketMuseum)
        }

        return view
    }
}

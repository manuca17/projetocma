package com.example.projetocma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Tickets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tickets)

        val ticketBasicIcon = findViewById<ImageView>(R.id.ticket_basic_icone)
        val ticketEventIcon = findViewById<ImageView>(R.id.ticket_event_icone)
        val ticketMuseumIcon = findViewById<ImageView>(R.id.ticket_museum_icone)

        ticketBasicIcon.setOnClickListener {
            val intent = Intent(this, TicketsBasic::class.java)
            startActivity(intent)
        }

        ticketEventIcon.setOnClickListener {
            val intent = Intent(this, TicketsEvent::class.java)
            startActivity(intent)
        }

        ticketMuseumIcon.setOnClickListener {
            val intent = Intent(this, TicketsMuseum::class.java)
            startActivity(intent)
        }
    }
}
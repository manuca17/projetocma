package com.example.projetocma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TicketsEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tickets_event)

        val accessInfo = "Acesso ao Museu de Arte Contemporânea, Parque de Serralves, Treetop Walk, Casa de Serralves, Casa do Cinema Manuel de Oliveira."

        val acessoATextView = findViewById<TextView>(R.id.acesso_event)
        acessoATextView.text = "Acesso a:"

        val museuArteTextView = findViewById<TextView>(R.id.museu_arte_event)
        museuArteTextView.text = "Museu de Arte Contemporânea"

        val parqueSerralvesTextView = findViewById<TextView>(R.id.parque_serralves_event)
        parqueSerralvesTextView.text = "Parque de Serralves"

        val treetopWalkTextView = findViewById<TextView>(R.id.treetop_walk_event)
        treetopWalkTextView.text = "Treetop Walk"

        val casaSerralvesTextView = findViewById<TextView>(R.id.casa_serralves_event)
        casaSerralvesTextView.text = "Casa de Serralves"

        val casaCinemaTextView = findViewById<TextView>(R.id.casa_cinema_event)
        casaCinemaTextView.text = "Casa do Cinema Manuel de Oliveira"

        val backButton = findViewById<Button>(R.id.button_back_event)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val nextButton = findViewById<Button>(R.id.button_next_event)
        nextButton.setOnClickListener {
            val intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }


    }
}
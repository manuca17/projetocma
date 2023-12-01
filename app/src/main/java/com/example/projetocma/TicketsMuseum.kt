package com.example.projetocma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TicketsMuseum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tickets_museum)

        val accessInfo = "Acesso ao Museu de Arte Contemporânea, Parque de Serralves, Treetop Walk, Casa de Serralves, Casa do Cinema Manuel de Oliveira."

        val acessoATextView = findViewById<TextView>(R.id.acesso_museum)
        acessoATextView.text = "Acesso a:"

        val museuArteTextView = findViewById<TextView>(R.id.museu_arte_museum)
        museuArteTextView.text = "Museu de Arte Contemporânea"

        val parqueSerralvesTextView = findViewById<TextView>(R.id.parque_serralves_museum)
        parqueSerralvesTextView.text = "Parque de Serralves"

        val treetopWalkTextView = findViewById<TextView>(R.id.treetop_walk_museum)
        treetopWalkTextView.text = "Treetop Walk"

        val casaSerralvesTextView = findViewById<TextView>(R.id.casa_serralves_museum)
        casaSerralvesTextView.text = "Casa de Serralves"

        val casaCinemaTextView = findViewById<TextView>(R.id.casa_cinema_museum)
        casaCinemaTextView.text = "Casa do Cinema Manuel de Oliveira"


        val backButton = findViewById<Button>(R.id.button_back_museum)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val nextButton = findViewById<Button>(R.id.button_next_museum)
        nextButton.setOnClickListener {
            val intent = Intent(this, Calendario::class.java)
            startActivity(intent)
        }

    }
}
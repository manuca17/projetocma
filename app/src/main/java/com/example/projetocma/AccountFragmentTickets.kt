package com.example.projetocma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class AccountFragmentTickets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_account_tickets)


        val editTextBilheteBasico = findViewById<EditText>(R.id.editTextBilheteBasico)
        val editTextBilheteMuseu = findViewById<EditText>(R.id.editTextBilheteMuseu)
        val editTextBilheteEvento = findViewById<EditText>(R.id.editTextBilheteEvento)


        val bilheteBasico = "Ticket Básico: 1234"
        val bilheteMuseu = "Ticket Museu: 5678"
        val bilheteEvento = "Ticket Evento: 9012"

        // Define os valores nos EditTexts para exibir os tickets
        editTextBilheteBasico.setText(bilheteBasico)
        editTextBilheteMuseu.setText(bilheteMuseu)
        editTextBilheteEvento.setText(bilheteEvento)
    }
}
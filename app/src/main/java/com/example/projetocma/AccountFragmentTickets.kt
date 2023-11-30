package com.example.projetocma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

class AccountFragmentTickets : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout para este fragmento
        return inflater.inflate(R.layout.fragment_account_tickets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextBilheteBasico = view.findViewById<EditText>(R.id.editTextBilheteBasico)
        val editTextBilheteMuseu = view.findViewById<EditText>(R.id.editTextBilheteMuseu)
        val editTextBilheteEvento = view.findViewById<EditText>(R.id.editTextBilheteEvento)

        val bilheteBasico = "Ticket Básico: 1234"
        val bilheteMuseu = "Ticket Museu: 5678"
        val bilheteEvento = "Ticket Evento: 9012"

        // Define os valores nos EditTexts para exibir os tickets
        editTextBilheteBasico.setText(bilheteBasico)
        editTextBilheteMuseu.setText(bilheteMuseu)
        editTextBilheteEvento.setText(bilheteEvento)
    }
}
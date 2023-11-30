package com.example.projetocma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

class AccountFragmentContact : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout para este fragmento
        return inflater.inflate(R.layout.fragment_account_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextNomeContact = view.findViewById<EditText>(R.id.editTextNomeContact)
        val editTextSobrenomeContact = view.findViewById<EditText>(R.id.editTextSobrenomeContact)
        val editTextEmailContact = view.findViewById<EditText>(R.id.editTextEmailContact)
        val editTextTelefoneContact = view.findViewById<EditText>(R.id.editTextTelefoneContact)

        val nome = "João"
        val sobrenome = "Silva"
        val email = "joao@example.com"
        val telefone = "123456789"

        // Definir os valores nos editTexts
        editTextNomeContact.setText(nome)
        editTextSobrenomeContact.setText(sobrenome)
        editTextEmailContact.setText(email)
        editTextTelefoneContact.setText(telefone)
    }
}
package com.example.projetocma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class AccountFragmentContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_account_contact)

        val editTextNomeContact = findViewById<EditText>(R.id.editTextNomeContact)
        val editTextSobrenomeContact = findViewById<EditText>(R.id.editTextSobrenomeContact)
        val editTextEmailContact = findViewById<EditText>(R.id.editTextEmailContact)
        val editTextTelefoneContact = findViewById<EditText>(R.id.editTextTelefoneContact)

        val nome = "João"
        val sobrenome = "Silva"
        val email = "joao@example.com"
        val telefone = "123456789"

        // Definir os valores no editText
        editTextNomeContact.setText(nome)
        editTextSobrenomeContact.setText(sobrenome)
        editTextEmailContact.setText(email)
        editTextTelefoneContact.setText(telefone)
    }
}

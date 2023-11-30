package com.example.projetocma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AlterarNomeActivity : AppCompatActivity() {

    private lateinit var editTextNome : EditText
    private lateinit var editTextSobreNome: EditText
    private lateinit var guardarTextView: TextView
    private lateinit var cancelarTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_account_username)

        editTextNome = findViewById(R.id.editTextNome)
        editTextSobreNome = findViewById(R.id.editTextSobreNome)
        guardarTextView = findViewById(R.id.guardar)
        cancelarTextView = findViewById(R.id.cancelar)

        guardarTextView.setOnClickListener { salvarAlteracoes() }

        cancelarTextView.setOnClickListener { cancelarEdicao() }
    }


    private fun salvarAlteracoes() {
        val novoNome = editTextNome.text.toString().trim()
        val novoSobrenome = editTextSobreNome.text.toString().trim()

        println("Novo Nome: $novoNome")
        println("Novo Sobrenome: $novoSobrenome")
    }

    private fun cancelarEdicao() {
        finish()
    }
}

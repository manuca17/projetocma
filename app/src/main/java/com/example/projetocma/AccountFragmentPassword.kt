package com.example.projetocma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AccountFragmentPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_account_password)

        val editTextPalavraPasseAtual = findViewById<EditText>(R.id.editTextPalavraPasseAtual)
        val editTextPalavraPasseNova = findViewById<EditText>(R.id.editTextPalavraPasseNova)
        val editTextVerificarPalavraPasse = findViewById<EditText>(R.id.editTextVerificarPalavraPasse)
        val alterarPasse = findViewById<TextView>(R.id.alterar_passe)

        alterarPasse.setOnClickListener {
            val senhaAtual = editTextPalavraPasseAtual.text.toString()
            val novaSenha = editTextPalavraPasseNova.text.toString()
            val verificarSenha = editTextVerificarPalavraPasse.text.toString()


            if (novaSenha == verificarSenha) {
                Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "As senhas não correspondem", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
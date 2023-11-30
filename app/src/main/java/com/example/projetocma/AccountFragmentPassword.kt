package com.example.projetocma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class AccountFragmentPassword : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout para este fragmento
        return inflater.inflate(R.layout.fragment_account_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextPalavraPasseAtual = view.findViewById<EditText>(R.id.editTextPalavraPasseAtual)
        val editTextPalavraPasseNova = view.findViewById<EditText>(R.id.editTextPalavraPasseNova)
        val editTextVerificarPalavraPasse = view.findViewById<EditText>(R.id.editTextVerificarPalavraPasse)
        val alterarPasse = view.findViewById<TextView>(R.id.alterar_passe)

        alterarPasse.setOnClickListener {
            val senhaAtual = editTextPalavraPasseAtual.text.toString()
            val novaSenha = editTextPalavraPasseNova.text.toString()
            val verificarSenha = editTextVerificarPalavraPasse.text.toString()

            if (novaSenha == verificarSenha) {
                Toast.makeText(requireContext(), "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "As senhas não correspondem", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
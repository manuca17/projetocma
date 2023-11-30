package com.example.projetocma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class AccountFragmentUsername : Fragment() {

    private lateinit var editTextNome: EditText
    private lateinit var editTextSobreNome: EditText
    private lateinit var guardarTextView: TextView
    private lateinit var cancelarTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout para este fragmento
        return inflater.inflate(R.layout.fragment_account_username, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextNome = view.findViewById(R.id.editTextNome)
        editTextSobreNome = view.findViewById(R.id.editTextSobreNome)
        guardarTextView = view.findViewById(R.id.guardar)
        cancelarTextView = view.findViewById(R.id.cancelar)

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
        requireActivity().finish()
    }
}
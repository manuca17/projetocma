package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

        private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.ButtonLogin.setOnClickListener {
            findNavController().navigate(R.id.museusPageFrag)
        }

        binding.notRegiste.setOnClickListener{
            findNavController().navigate(R.id.register_fragment)
        }
        return binding.root

    }


}
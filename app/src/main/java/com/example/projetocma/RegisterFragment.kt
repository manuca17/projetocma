package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentRegisterFragmentBinding


class RegisterFragment : Fragment() {

        private lateinit var binding: FragmentRegisterFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterFragmentBinding.inflate(inflater, container, false)
        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        return binding.root
    }


}
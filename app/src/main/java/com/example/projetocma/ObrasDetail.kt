package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projetocma.databinding.FragmentObrasDetailBinding
import com.example.projetocma.databinding.FragmentObrasExploreBinding


class ObrasDetail : Fragment() {

    private lateinit var binding: FragmentObrasDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val title = arguments?.getString("name")
        val imageResId = arguments?.getInt("image")
        val description = arguments?.getString("description")
        val imgDescription = arguments?.getString("imgDescription")

        imageResId?.let { binding.obrasImg.setImageResource(it) }
        binding.obrasImg.setOnClickListener {
            showDialog(imgDescription, imageResId, description)
        }
        binding = FragmentObrasDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun showDialog(imgDescription: String?,  imgResId: Int?, description: String?) {

    }


}
package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentObrasExploreBinding
import models.Museu
import models.Obras


class ObrasExplore : Fragment(), Obras.OnItemClickListener {

    private lateinit var binding: FragmentObrasExploreBinding

    private val names = arrayOf("A noite estrelada", "O grito", "Abaporu")
    private val img = arrayOf(R.drawable.obra1, R.drawable.obra2, R.drawable.obra3).toIntArray()
    private val description = arrayOf("asdasdasdasdasd", "asdasdasdasdasd", "asdasdasdasd")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentObrasExploreBinding.inflate(inflater, container, false)
        val obrasAdapter = Obras(requireContext(), names, img, description, this)
        val gridView: GridView = binding.gridView
        gridView.adapter = obrasAdapter


        return binding.root
    }

    override fun onItemClick(position: Int) {
        val selectedName = names[position]
        val selectedImage = img[position]
        val selectedDescription = description[position]

        val bundle = Bundle()
        bundle.putString("name", selectedName)
        bundle.putInt("image", selectedImage)
        bundle.putString("description", selectedDescription)

        findNavController().navigate(R.id.obrasDetail, bundle)
    }


}
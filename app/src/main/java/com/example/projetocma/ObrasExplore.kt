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
    private val description = arrayOf("A Noite Estrelada é uma pintura de Vincent van Gogh de 1889. A obra retrata a vista da janela de um quarto do hospício de Saint-Rémy-de-Provence, pouco antes do nascer do sol, com a adição de um vilarejo idealizado pelo artista. A tela faz parte da coleção permanente do Museu de Arte Moderna de Nova Iorque desde 1941", "asdasdasdasdasd", "asdasdasdasd")
    private val imgDescription = arrayOf("Van Gogh|1889|Oleo sobre a tela|73.7 x 92.1|", "asdasdasdasdasd", "asdasdasdasd")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentObrasExploreBinding.inflate(inflater, container, false)
        val obrasAdapter = Obras(requireContext(), names, img, description, this, imgDescription)
        val gridView: GridView = binding.gridView
        gridView.adapter = obrasAdapter


        return binding.root
    }

    override fun onItemClick(position: Int) {
        val selectedName = names[position]
        val selectedImage = img[position]
        val selectedDescription = description[position]
        val selectedImgDescription = imgDescription[position]

        val bundle = Bundle()
        bundle.putString("name", selectedName)
        bundle.putInt("image", selectedImage)
        bundle.putString("description", selectedDescription)
        bundle.putString("imgDescription", selectedImgDescription)

        findNavController().navigate(R.id.obrasDetail, bundle)
    }


}
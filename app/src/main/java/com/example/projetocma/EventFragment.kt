package com.example.projetocma

import android.media.metrics.Event
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ListView
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentEventBinding
import com.google.android.play.core.assetpacks.n
import models.Eventos


class EventFragment : Fragment(), Eventos.OnItemClickListener  {

    private val titles = arrayOf("JOAN MIRÓ / ALEXANDER CALDER: ESPAÇO EM MOVIMENTO")
    private val dates = arrayOf("22 JUN 2023 - 27 JAN 2024")
    private val imgDescription = arrayOf("Joan Miró, Homage to Alexander Calder, 1977. Photo © Successió Miró / SPA, Lisboa 2023")
    private val description = arrayOf("O encontro entre Joan Miró e Alexander Calder representou uma das mais férteis amizades artísticas e diálogos visuais continuados do século XX. Os dois artistas conheceram-se em Paris no final de 1928 e permaneceram em contacto próximo até à morte de Calder, em 1976. Já em 1936, o jornal The New York World-Telegram descrevia os móbiles de Calder como “abstrações de Miró vivas”. Esta descrição é particularmente pertinente para as Constelações de mesa e de parede que Calder produziu em 1943 e que apresentam uma forte afinidade com a série homónima de Miró de 1940–41, embora tenham sido concebidas de forma completamente independente. Um imaginário em constelação era um princípio formal do trabalho de ambos. Em vez de construírem as suas imagens em torno de um núcleo central, como acontece nas abordagens tradicionais à pintura e à escultura, Joan Miró e Alexander Calder concebiam as suas obras como estruturas abertas, em que as formas flutuam livremente no espaço ou estão distribuídas uniformemente pela superfície da tela.")
    private val img = arrayOf(R.drawable.joanmiro).toIntArray()

    private lateinit var binding: FragmentEventBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEventBinding.inflate(inflater, container, false)

        val eventAdapter = Eventos(requireContext(), titles, img, dates, this, description, imgDescription)
        val gridView: GridView = binding.gridViewEventos
        gridView.adapter = eventAdapter

        return binding.root
    }

    override fun onItemClick(position: Int) {
        Log.d("EventFragment", "Item clicked at position: $position")

        // Handle item click (you can navigate to the detail fragment here)
        val selectedTitle = titles[position]
        val selectedImage = img[position]
        val selectedDate = dates[position]
        val selectedDescription = description[position]
        val selectedImgDescription = imgDescription[position]

        val bundle = Bundle()
        bundle.putString("title", selectedTitle)
        bundle.putInt("image", selectedImage)
        bundle.putString("date", selectedDate)
        bundle.putString("description", selectedDescription)
        bundle.putString("imgDescription", selectedImgDescription)

        findNavController().navigate(R.id.eventDetail, bundle)

    }



}
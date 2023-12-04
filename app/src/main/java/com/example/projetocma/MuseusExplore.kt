package com.example.projetocma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentMuseusExploreBinding
import models.Museu


class MuseusExplore : Fragment(), Museu.OnItemClickListener {

    private lateinit var binding: FragmentMuseusExploreBinding

    private val names = arrayOf("Museu da Sé", "Museu do Pio", "Museu do Prado", "Museu De La Plata", "Museu da Marinha")
    private val img = arrayOf(R.drawable.museu, R.drawable.museupio, R.drawable.museudoprado, R.drawable.museudelaplata, R.drawable.museudamarinha).toIntArray()
    private val description = arrayOf("Tutelado pela Associação Portuguesa de Pais e Amigos do Cidadão Deficiente Mental (APPACDM) de Castelo Branco, o Museu da Seda foi criado para dar a conhecer ao grande público a História da produção de Seda em Portugal, o ciclo de vida do Bicho da Seda, as aplicações convencionais e de tecnologia de ponta - nomeadamente ao nível da Biologia e da Medicina - que se podem fazer a partir da utilização deste produto mal conhecido e, ainda assim, de inestimável valor.", "asdas", "asdsa", "asdasdd", "asdasdd")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMuseusExploreBinding.inflate(inflater, container, false)
        val view = binding.root

        val museuAdapter = Museu(requireContext(), names, img, this, description)
        val gridView: GridView = binding.gridView
        gridView.adapter = museuAdapter

        return view
    }

    override fun onItemClick(position: Int) {
        val selectedName = names[position]
        val selectedImage = img[position]
        val selectedDescription = description[position]

        val bundle = Bundle()
        bundle.putString("name", selectedName)
        bundle.putInt("image", selectedImage)
        bundle.putString("description", selectedDescription)

        findNavController().navigate(R.id.museuDetail, bundle)
    }
}
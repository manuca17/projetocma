package com.example.projetocma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentTicketsBinding
import models.Museu
import models.Tickets

class TicketsFragment : Fragment(), Tickets.OnItemClickListener {

    private lateinit var binding: FragmentTicketsBinding

    private val names = arrayOf("Ticket Básico", "Ticket Evento", "Ticket Museu")
    private val price = arrayOf("9.50€", "10€", "12.50€")
    private val description = arrayOf("adasdas", "asdadasdas", "asdasdasdas")
    private val image = arrayOf(R.drawable.ticket_basic, R.drawable.ticket_museum, R.drawable.ticket_event).toIntArray()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val ticketAdapter = Tickets(requireContext(), names, image,price, description, this)
        val listView: ListView = binding.listView
        listView.adapter = ticketAdapter

        return binding.root
    }

    override fun onItemClick(position: Int) {
        val selectedName = names[position]
        val selectedImage = image[position]
        val price = price[position]
        val selectedDescription = description[position]

        val bundle = Bundle()
        bundle.putString("name", selectedName)
        bundle.putInt("image", selectedImage)
        bundle.putString("description", selectedDescription)
        bundle.putString("price", price)

        findNavController().navigate(R.id.ticketBasicc, bundle)
    }
}
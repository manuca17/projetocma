package com.example.projetocma
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ReservePage : Fragment() {
    private var adultsCount = 0
    private var childCount = 0
    private lateinit var adultsCountTextView: TextView
    private lateinit var childCountTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reserve_page, container, false)

        adultsCountTextView = view.findViewById(R.id.adultsCount)

        childCountTextView = view.findViewById(R.id.childCount)



        val addAdultButton: Button = view.findViewById(R.id.addAdultButton)
        addAdultButton.setOnClickListener {
            addAdult()
        }

        val removeAdultButton: Button = view.findViewById(R.id.removeAdultButton)
        removeAdultButton.setOnClickListener {
            removeAdult()
        }

        val addChildButton: Button = view.findViewById(R.id.addChildButton)
        addAdultButton.setOnClickListener {
            addAdult()
        }

        val removeChildButton: Button = view.findViewById(R.id.removeChildButton)
        removeAdultButton.setOnClickListener {
            removeAdult()
        }

        return view
    }

    private fun addAdult() {
        adultsCount++
        displayAdultsCount()
    }

    private fun removeAdult() {
        if (adultsCount > 0) {
            adultsCount--
            displayAdultsCount()
        }
    }
    private fun addChild() {
        childCount++
        displayChildCount()
    }

    private fun removeChild() {
        if (childCount > 0) {
            childCount--
            displayChildCount()
        }
    }

    private fun displayAdultsCount() {
        adultsCountTextView.text = adultsCount.toString()
    }
    private fun displayChildCount() {
        childCountTextView.text = childCount.toString()
    }
}

package com.example.projetocma

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentReservePageBinding

class QuantityReservePage() : Fragment(), Parcelable {
    private lateinit var binding: FragmentReservePageBinding
    private var adultsCount = 0
    private var childCount = 0

    constructor(parcel: Parcel) : this() {
        adultsCount = parcel.readInt()
        childCount = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(adultsCount)
        parcel.writeInt(childCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuantityReservePage> {
        override fun createFromParcel(parcel: Parcel): QuantityReservePage {
            return QuantityReservePage(parcel)
        }

        override fun newArray(size: Int): Array<QuantityReservePage?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReservePageBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.addAdultButton.setOnClickListener {
            adultsCount++
            binding.adultsCount.text = adultsCount.toString()
        }

        binding.addChildButton.setOnClickListener {
            childCount++
            binding.childCount.text = childCount.toString()
        }

        binding.removeAdultButton.setOnClickListener {
            if (adultsCount > 0) {
                adultsCount--
                binding.adultsCount.text = adultsCount.toString()
            }
        }

        binding.removeChildButton.setOnClickListener {
            if (childCount > 0) {
                childCount--
                binding.childCount.text = childCount.toString()
            }
        }

        binding.materialCardView2.setOnClickListener {
            findNavController().navigate(R.id.calendario)
        }
        return view
    }
}










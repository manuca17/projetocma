package com.example.projetocma

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.projetocma.databinding.FragmentEventBinding
import com.example.projetocma.databinding.FragmentEventDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class EventDetail : Fragment() {

    private lateinit var binding: FragmentEventDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEventDetailBinding.inflate(inflater, container, false)
        val title = arguments?.getString("title")
        val imageResId = arguments?.getInt("image")
        val date = arguments?.getString("date")
        val description = arguments?.getString("description")
        val imgDescription = arguments?.getString("imgDescription")

        imageResId?.let { binding.tecxt123.setImageResource(it) }

        binding.tecxt123.setOnClickListener{
            showDialog(imgDescription, imageResId, description)
        }

        return binding.root
    }

    private fun showDialog(imgDescription: String?,  imgResId: Int?, description: String?) {
        val dialog: Dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.fragment_event_bottom_sheet)


        val bottomSheetImageView: ImageView = dialog.findViewById(R.id.bottomSheetImg)
        val bottomSheetImgDescription: TextView =  dialog.findViewById(R.id.textViewImgDescription)
        val bottomSheetDescription: TextView =  dialog.findViewById(R.id.textViewDescription)

        imgResId?.let {
            bottomSheetImageView.setImageResource(it)
        }
        bottomSheetDescription.text = description
        bottomSheetImgDescription.text = imgDescription

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
    }



}
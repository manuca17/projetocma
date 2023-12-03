package com.example.projetocma

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.example.projetocma.databinding.FragmentHistoriaMuseuBinding
import com.example.projetocma.databinding.FragmentMuseuDetailBinding


class HistoriaMuseu : Fragment() {

    private lateinit var binding: FragmentHistoriaMuseuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoriaMuseuBinding.inflate(inflater, container, false)
        val name = arguments?.getString("name")
        val imageResId = arguments?.getInt("image")
        val description = arguments?.getString("description")
        imageResId?.let { binding.historiaImage.setImageResource(it) }

        binding.historiaImage.setOnClickListener{
            showDialog(name, imageResId, description)
        }
        return binding.root
    }

    private fun showDialog(name: String?,  imgResId: Int?, description: String?) {
        val dialog: Dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.fragment_historia_bottom_sheet)


        val bottomSheetImageView: ImageView = dialog.findViewById(R.id.bottomSheetHistoriaImg)
        val bottomSheetName: TextView =  dialog.findViewById(R.id.textViewImgTitle)
        val bottomSheetDescription: TextView =  dialog.findViewById(R.id.textViewDescriptionHistoria)

        imgResId?.let {
            bottomSheetImageView.setImageResource(it)
        }
        bottomSheetDescription.text = description
        bottomSheetName.text = name

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
    }

}
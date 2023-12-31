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
        binding = FragmentObrasDetailBinding.inflate(inflater, container, false)

        val title = arguments?.getString("name")
        val imageResId = arguments?.getInt("image")
        val description = arguments?.getString("description")
        val imgDescription = arguments?.getString("imgDescription")

        imageResId?.let { binding.obrasImg.setImageResource(it) }
        binding.obrasImg.setOnClickListener {
            showDialog(imgDescription, imageResId, description, title)
        }

        return binding.root
    }

    private fun showDialog(imgDescription: String?,  imgResId: Int?, description: String?, name: String?) {
        val dialog: Dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.fragment_obras_bottom_sheet)


        val bottomSheetImageView: ImageView = dialog.findViewById(R.id.bottomSheetObrasImg)
        val bottomSheetImgDescription: TextView =  dialog.findViewById(R.id.textViewImgObrasDescription)
        val bottomSheetDescription: TextView =  dialog.findViewById(R.id.textViewObrasDescription)
        val bottomSheetName : TextView = dialog.findViewById(R.id.textViewImgObrasName)

        imgResId?.let {
            bottomSheetImageView.setImageResource(it)
        }
        bottomSheetDescription.text = description
        bottomSheetImgDescription.text = imgDescription
        bottomSheetName.text = name

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)

    }


}
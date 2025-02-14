package com.alfsuace.expmdmfebrero.presentation.adaptersticker

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alfsuace.expmdmfebrero.databinding.ViewStickerItemBinding
import com.alfsuace.expmdmfebrero.domain.Mushroom

class MushroomViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var binding: ViewStickerItemBinding

    fun bind(mushroom: Mushroom){
        binding= ViewStickerItemBinding.bind(itemView)
        binding.apply {
            name.text=mushroom.name
            description.text=mushroom.image
        }
    }

}
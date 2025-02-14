package com.alfsuace.expmdmfebrero.presentation.adaptersticker

import androidx.recyclerview.widget.DiffUtil
import com.alfsuace.expmdmfebrero.domain.Mushroom

class MushroomDiffUtil:DiffUtil.ItemCallback<Mushroom>() {
    override fun areItemsTheSame(oldItem: Mushroom, newItem: Mushroom): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Mushroom, newItem: Mushroom): Boolean {
        return oldItem==newItem
    }
}
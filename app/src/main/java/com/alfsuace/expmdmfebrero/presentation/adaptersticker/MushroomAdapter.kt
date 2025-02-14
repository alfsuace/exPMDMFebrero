package com.alfsuace.expmdmfebrero.presentation.adaptersticker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.alfsuace.expmdmfebrero.R
import com.alfsuace.expmdmfebrero.domain.Mushroom

class MushroomAdapter():ListAdapter<Mushroom, MushroomViewHolder>(MushroomDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MushroomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_sticker_item, parent, false)
        return MushroomViewHolder(view)
    }

    override fun onBindViewHolder(holder: MushroomViewHolder, position: Int) {
        val mushroom = getItem(position)
        holder.bind(mushroom)
    }

}
package com.alfsuace.expmdmfebrero.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.alfsuace.expmdmfebrero.R
import com.alfsuace.expmdmfebrero.domain.Album

class AlbumAdapter(
    private val onClick: (Album) -> Unit,
    private val onFavoriteClick: (Album) -> Unit
) : ListAdapter<Album, AlbumViewHolder>(AlbumDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_album_item, parent, false)
        return AlbumViewHolder(view, onClick, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)
    }
}


package com.alfsuace.expmdmfebrero.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alfsuace.expmdmfebrero.R
import com.alfsuace.expmdmfebrero.databinding.ViewAlbumItemBinding
import com.alfsuace.expmdmfebrero.domain.Album

class AlbumViewHolder(
    itemView: View,
    private val onClick: (Album) -> Unit,
    private val onFavoriteClick: (Album) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private lateinit var binding: ViewAlbumItemBinding

    fun bind(album: Album) {
        binding = ViewAlbumItemBinding.bind(itemView)
        binding.apply {
            name.text = album.name
            description.text = album.description

            updateFavoriteIcon(album.favorite)

            root.setOnClickListener { onClick(album) }
            bookmark.setOnClickListener {
                onFavoriteClick(album)
            }
        }
    }

    private fun updateFavoriteIcon(isFavorite: Boolean) {
        val iconRes = if (isFavorite) R.drawable.ic_bookmark_filled else R.drawable.ic_bookmark_empty
        binding.bookmark.setImageResource(iconRes)
    }
}


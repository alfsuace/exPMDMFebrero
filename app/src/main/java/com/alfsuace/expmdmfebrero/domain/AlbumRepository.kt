package com.alfsuace.expmdmfebrero.domain

interface AlbumRepository {

    fun getAlbums():List<Album>
    fun getAlbumById(id: String): Album?

}
package com.alfsuace.expmdmfebrero.data

import com.alfsuace.expmdmfebrero.data.local.AlbumLocalDataRepository
import com.alfsuace.expmdmfebrero.domain.Album
import com.alfsuace.expmdmfebrero.domain.AlbumRepository
import org.koin.core.annotation.Single

@Single
class AlbumDataRepository(private val local: AlbumLocalDataRepository):AlbumRepository {
    override fun getAlbums(): List<Album> {
        return local.getAllAlbums()
    }

    override fun getAlbumById(id: String): Album? {
        return local.getAlbumById(id)
    }

}
package com.alfsuace.expmdmfebrero.domain

import org.koin.core.annotation.Single

@Single
class GetAlbumsUseCase(private val albumRepository: AlbumRepository) {
    operator fun invoke():List<Album>{
        return albumRepository.getAlbums()
    }
}
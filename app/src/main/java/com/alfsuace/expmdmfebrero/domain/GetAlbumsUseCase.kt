package com.alfsuace.expmdmfebrero.domain

class GetAlbumsUseCase(private val albumRepository: AlbumRepository) {

    operator fun invoke():List<Album>{
        return albumRepository.getAlbums()
    }
}
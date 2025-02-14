package com.alfsuace.expmdmfebrero.domain

class GetAlbumByIdUseCase(private val albumRepository: AlbumRepository) {

    operator fun invoke(id: String): Album? {
        return albumRepository.getAlbumById(id)
    }

}

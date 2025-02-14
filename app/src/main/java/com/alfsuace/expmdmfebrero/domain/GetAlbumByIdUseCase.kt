package com.alfsuace.expmdmfebrero.domain

import org.koin.core.annotation.Single

@Single
class GetAlbumByIdUseCase(private val albumRepository: AlbumRepository) {
    operator fun invoke(id: String): Album? {
        return albumRepository.getAlbumById(id)
    }

}

package com.alfsuace.expmdmfebrero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alfsuace.expmdmfebrero.domain.Album
import com.alfsuace.expmdmfebrero.domain.GetAlbumByIdUseCase

class StickerListViewModel(
    private val getAlbumByIdUseCase: GetAlbumByIdUseCase
): ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun loadAlbum(id: String){
        _uiState.value = UiState(loading = true)
        try {
            val album = getAlbumByIdUseCase(id)
            _uiState.postValue(UiState(album = album))
        } catch (e: Exception) {
            _uiState.postValue(UiState(error = true))
        }
    }

    data class UiState(
        val loading: Boolean= false,
        val error: Boolean= false,
        val album: Album? = null
    )
}
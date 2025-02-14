package com.alfsuace.expmdmfebrero.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alfsuace.expmdmfebrero.domain.Album
import com.alfsuace.expmdmfebrero.domain.GetAlbumsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumListViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    private var allAlbums: List<Album> = emptyList()
    private var showOnlyFavorites = false

    fun loadAlbums() {
        _uiState.value = UiState(loading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                allAlbums = getAlbumsUseCase()
                _uiState.postValue(UiState(albums = allAlbums))
            } catch (e: Exception) {
                _uiState.postValue(UiState(error = true))
            }
        }
    }

    fun clickedFavorite(album: Album) {
        viewModelScope.launch {
            allAlbums = allAlbums.map {
                if (it.id == album.id) it.copy(favorite = !it.favorite) else it
            }
            updateAlbumList()
        }
    }

    fun toggleShowFavorites() {
        showOnlyFavorites = !showOnlyFavorites
        updateAlbumList()
    }

    private fun updateAlbumList() {
        val filteredAlbums = if (showOnlyFavorites) {
            allAlbums.filter { it.favorite }
        } else {
            allAlbums
        }
        _uiState.postValue(UiState(albums = filteredAlbums))
    }

    data class UiState(
        val loading: Boolean = false,
        val error: Boolean = false,
        val albums: List<Album> = emptyList()
    )
}

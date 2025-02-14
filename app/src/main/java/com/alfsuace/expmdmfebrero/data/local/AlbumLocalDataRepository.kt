package com.alfsuace.expmdmfebrero.data.local

import android.content.Context
import com.google.gson.Gson
import com.alfsuace.expmdmfebrero.domain.Album
import org.koin.core.annotation.Single

@Single
class AlbumLocalDataRepository(private val context: Context, private val gson: Gson, private val mock: AlbumMock) {
    private val prefs = context.getSharedPreferences("album_prefs", Context.MODE_PRIVATE)

    fun getAlbumById(id: String): Album? {
        val albumJson = prefs.getString(id, null)
        return gson.fromJson(albumJson, Album::class.java)
    }

    fun saveAlbums(albums: List<Album>) {
        val editor = prefs.edit()
        albums.forEach { album ->
            val albumJson = gson.toJson(album)
            editor.putString(album.id, albumJson)
        }
        editor.apply()
    }

    fun getAllAlbums(): List<Album> {
        val albums = mutableListOf<Album>()
        prefs.all.forEach { (_, value) ->
            val albumJson = value as? String ?: return@forEach
            try {
                val album = gson.fromJson(albumJson, Album::class.java)
                albums.add(album)
            } catch (e: Exception) {
                // Manejar error si es necesario.
            }
        }
        return if (albums.isEmpty()){
            saveAlbums(mock.getAlbums())
            mock.getAlbums()
        }else{
            albums
        }
    }
}

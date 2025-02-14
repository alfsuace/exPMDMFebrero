package com.alfsuace.expmdmfebrero.data.local

import com.alfsuace.expmdmfebrero.domain.Album
import com.alfsuace.expmdmfebrero.domain.Mushroom

class AlbumMock {
    val mushrooms = listOf(
        Mushroom("1", "Amanita Muscaria", "https://example.com/amanita.jpg"),
        Mushroom("2", "Boletus Edulis", "https://example.com/boletus.jpg"),
        Mushroom("3", "Cantharellus Cibarius", "https://example.com/cantharellus.jpg"),
        Mushroom("4", "Coprinus Comatus", "https://example.com/coprinus.jpg"),
        Mushroom("5", "Lactarius Deliciosus", "https://example.com/lactarius.jpg")
    )

    private val albums = listOf(
        Album(
            "101",
            "Bosque Encantado",
            "2024-01-15",
            "Explorando setas en el bosque",
            "https://example.com/album1.jpg",
            false,
            listOf(mushrooms[0], mushrooms[1])
        ),
        Album(
            "102",
            "Amanecer Micológico",
            "2024-02-20",
            "Recolección de hongos al amanecer",
            "https://example.com/album2.jpg",
            false,
            listOf(mushrooms[2], mushrooms[3])
        ),
        Album(
            "103",
            "Senderos Fungícos",
            "2024-03-10",
            "Un recorrido lleno de vida y setas",
            "https://example.com/album3.jpg",
            false,
            listOf(mushrooms[4], mushrooms[0])
        ),
        Album(
            "104",
            "Misterios del Bosque",
            "2024-04-05",
            "Setas poco comunes en la naturaleza",
            "https://example.com/album4.jpg",
            false,
            listOf(mushrooms[1], mushrooms[3])
        ),
        Album(
            "105",
            "Tesoros del Otoño",
            "2024-05-25",
            "Las mejores setas de la temporada",
            "https://example.com/album5.jpg",
            false,
            listOf(mushrooms[2], mushrooms[4])
        ),
        Album(
            "106",
            "Cosecha Micológica",
            "2024-06-12",
            "Descubriendo nuevos sabores",
            "https://example.com/album6.jpg",
            false,
            listOf(mushrooms[3], mushrooms[0])
        ),
        Album(
            "107",
            "Exploradores de Setas",
            "2024-07-18",
            "Un viaje educativo en la micología",
            "https://example.com/album7.jpg",
            false,
            listOf(mushrooms[1], mushrooms[4])
        ),
        Album(
            "108",
            "Bajo la Lluvia",
            "2024-08-30",
            "Setas encontradas después de la lluvia",
            "https://example.com/album8.jpg",
            false,
            listOf(mushrooms[0], mushrooms[2])
        ),
        Album(
            "109",
            "Colores y Sabores",
            "2024-09-22",
            "Una colección de setas vibrantes",
            "https://example.com/album9.jpg",
            false,
            listOf(mushrooms[3], mushrooms[4])
        ),
        Album(
            "110",
            "El Reino Fungi",
            "2024-10-05",
            "Un tributo a la diversidad de hongos",
            "https://example.com/album10.jpg",
            false,
            listOf(mushrooms[1], mushrooms[2])
        )
    )

    fun getAlbums(): List<Album> = albums

    fun getAlbumById(id: String): Album? = albums.find { it.id == id }
}

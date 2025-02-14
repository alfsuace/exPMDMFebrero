package com.alfsuace.expmdmfebrero.domain

data class Album(
    val id: String,
    val name: String,
    val dateCreated: String,
    val description: String,
    val image: String,
    val favorite: Boolean,
    val mushrooms: List<Mushroom>
)

data class Mushroom(
    val id: String,
    val name: String,
    val image: String
)

package ru.spiridonov.amusic.domain.entity

data class ArtistItem(
    val id: Long,
    val name: String,
    val link: String,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String,
    val radio: Boolean,
    val trackList: String,
    val type: String
)
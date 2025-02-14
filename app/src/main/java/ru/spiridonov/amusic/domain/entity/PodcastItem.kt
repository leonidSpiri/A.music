package ru.spiridonov.amusic.domain.entity

data class PodcastItem(
    val id: Long,
    val title: String,
    val description: String,
    val available: Boolean,
    val fans: Int,
    val link: String,
    val share: String,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String,
    val type: String
)
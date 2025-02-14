package ru.spiridonov.amusic.domain.entity

data class PlaylistItem(
    val id: Long,
    val title: String,
    val public: Boolean,
    val nbTracks: Int,
    val link: String,
    val picture: String,
    val pictureSmall: String,
    val pictureMedium: String,
    val pictureBig: String,
    val pictureXl: String,
    val checksum: String,
    val trackList: String,
    val creationDate: String,
    val md5Image: String,
    val pictureType: String,
    val type: String
)
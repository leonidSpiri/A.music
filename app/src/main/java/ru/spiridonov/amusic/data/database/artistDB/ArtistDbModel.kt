package ru.spiridonov.amusic.data.database.artistDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
data class ArtistDbModel(
    @PrimaryKey val id: Long,
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
package ru.spiridonov.amusic.data.database.trackDB

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.spiridonov.amusic.domain.entity.AlbumItem
import ru.spiridonov.amusic.domain.entity.ArtistItem

@Entity(tableName = "tracks")
data class TrackDbModel(
    @PrimaryKey val id: Long,
    val title: String,
    val titleShort: String,
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicitLyrics: Boolean,
    val explicitContentLyrics: Int,
    val explicitContentCover: Int,
    val preview: String,
    val md5Image: String,
    val position: Int,
    val artistId: Long,
    val albumId: Long,
    val type: String
)
package ru.spiridonov.amusic.domain.entity

data class TrackItem(
    val id: Long,
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
    val artist: ArtistItem,
    val album: AlbumItem,
    val type: String
)
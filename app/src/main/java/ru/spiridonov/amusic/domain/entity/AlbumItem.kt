package ru.spiridonov.amusic.domain.entity

data class AlbumItem(
    val id: Long,
    val title: String,
    val cover: String,
    val coverSmall: String,
    val coverMedium: String,
    val coverBig: String,
    val coverXl: String,
    val md5Image: String,
    val trackList: String,
    val type: String,
    val isInChart: Boolean = false
)
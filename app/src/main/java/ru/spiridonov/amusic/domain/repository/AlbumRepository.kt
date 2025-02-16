package ru.spiridonov.amusic.domain.repository

import ru.spiridonov.amusic.domain.entity.AlbumItem

interface AlbumRepository {
    suspend fun getAlbumList(): List<AlbumItem>
}
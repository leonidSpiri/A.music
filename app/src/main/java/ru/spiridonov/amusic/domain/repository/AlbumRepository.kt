package ru.spiridonov.amusic.domain.repository

import androidx.lifecycle.LiveData
import ru.spiridonov.amusic.domain.entity.AlbumItem

interface AlbumRepository {
    suspend fun getAlbumList(): LiveData<List<AlbumItem>>
}
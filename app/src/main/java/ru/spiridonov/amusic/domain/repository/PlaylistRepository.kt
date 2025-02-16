package ru.spiridonov.amusic.domain.repository

import androidx.lifecycle.LiveData
import ru.spiridonov.amusic.domain.entity.PlaylistItem

interface PlaylistRepository {
    suspend fun getPlaylistList(): LiveData<List<PlaylistItem>>
}
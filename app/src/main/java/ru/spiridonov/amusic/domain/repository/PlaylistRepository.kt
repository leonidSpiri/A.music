package ru.spiridonov.amusic.domain.repository

import ru.spiridonov.amusic.domain.entity.PlaylistItem

interface PlaylistRepository {
    suspend fun getPlaylistList(): List<PlaylistItem>
}
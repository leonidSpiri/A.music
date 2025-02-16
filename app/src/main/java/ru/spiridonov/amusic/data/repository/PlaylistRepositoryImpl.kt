package ru.spiridonov.amusic.data.repository

import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDao
import ru.spiridonov.amusic.domain.entity.PlaylistItem
import ru.spiridonov.amusic.domain.repository.PlaylistRepository
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val playlistDao: PlaylistDao
) : PlaylistRepository {

    override suspend fun getPlaylistList(): List<PlaylistItem> {

        return emptyList()
    }
}
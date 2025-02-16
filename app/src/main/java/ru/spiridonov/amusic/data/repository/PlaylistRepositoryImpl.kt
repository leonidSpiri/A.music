package ru.spiridonov.amusic.data.repository

import androidx.lifecycle.map
import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDao
import ru.spiridonov.amusic.data.mapper.PlaylistMapper
import ru.spiridonov.amusic.domain.repository.PlaylistRepository
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val playlistDao: PlaylistDao,
    private val playlistMapper: PlaylistMapper
) : PlaylistRepository {

    override suspend fun getPlaylistList() =
        playlistDao.getAllPlaylist().map { playlistList ->
            playlistList.map { playlistMapper.mapPlaylistDbModelToPlaylistItem(it) }
        }
}
package ru.spiridonov.amusic.data.repository

import androidx.lifecycle.map
import ru.spiridonov.amusic.data.database.albumDB.AlbumDao
import ru.spiridonov.amusic.data.mapper.AlbumMapper
import ru.spiridonov.amusic.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumDao: AlbumDao,
    private val albumMapper: AlbumMapper
) : AlbumRepository {

    override suspend fun getAlbumList() =
        albumDao.getAllAlbums().map { albumList ->
            albumList.map { albumMapper.mapAlbumDbModelToAlbumItem(it) }
        }
}
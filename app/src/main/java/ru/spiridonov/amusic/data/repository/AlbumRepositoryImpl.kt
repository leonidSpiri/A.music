package ru.spiridonov.amusic.data.repository

import ru.spiridonov.amusic.data.database.albumDB.AlbumDao
import ru.spiridonov.amusic.data.mapper.AlbumMapper
import ru.spiridonov.amusic.domain.entity.AlbumItem
import ru.spiridonov.amusic.domain.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumDao: AlbumDao,
    private val albumMapper: AlbumMapper
) : AlbumRepository {

    override suspend fun getAlbumList(): List<AlbumItem> {
       TODO("return livedata")
        return emptyList()
    }
}
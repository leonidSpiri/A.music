package ru.spiridonov.amusic.data.repository

import androidx.lifecycle.map
import ru.spiridonov.amusic.data.database.artistDB.ArtistDao
import ru.spiridonov.amusic.data.mapper.ArtistMapper
import ru.spiridonov.amusic.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val artistDao: ArtistDao,
    private val artistMapper: ArtistMapper
) : ArtistRepository {

    override suspend fun getArtistList() =
        artistDao.getAllArtist().map { artistList ->
            artistList.map { artistMapper.mapArtistDbModelToArtistItem(it) }
        }
}
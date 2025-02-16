package ru.spiridonov.amusic.data.repository

import ru.spiridonov.amusic.data.database.artistDB.ArtistDao
import ru.spiridonov.amusic.domain.entity.ArtistItem
import ru.spiridonov.amusic.domain.repository.ArtistRepository
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val artistDao: ArtistDao
) : ArtistRepository {

    override suspend fun getArtistList(): List<ArtistItem> {

        return emptyList()
    }
}
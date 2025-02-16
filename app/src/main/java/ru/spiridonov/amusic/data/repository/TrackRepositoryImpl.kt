package ru.spiridonov.amusic.data.repository

import ru.spiridonov.amusic.data.database.trackDB.TrackDao
import ru.spiridonov.amusic.domain.entity.TrackItem
import ru.spiridonov.amusic.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val trackDao: TrackDao
) : TrackRepository {

    override suspend fun getTrackList(): List<TrackItem> {

        return emptyList()
    }
}
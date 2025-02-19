package ru.spiridonov.amusic.data.repository

import androidx.lifecycle.map
import ru.spiridonov.amusic.data.database.trackDB.TrackDao
import ru.spiridonov.amusic.data.mapper.TrackMapper
import ru.spiridonov.amusic.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val trackDao: TrackDao,
    private val trackMapper: TrackMapper
) : TrackRepository {

    override fun getTrackList() =
        trackDao.getAllTrack().map { trackList ->
            trackList.map { trackMapper.mapTrackDbModelToTrackItem(it) }
        }

    override fun getChartTrackList() =
        trackDao.getChartTracks().map { trackList ->
            trackList.map { trackMapper.mapTrackDbModelToTrackItem(it) }
        }
}
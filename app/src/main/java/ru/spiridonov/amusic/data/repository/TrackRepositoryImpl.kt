package ru.spiridonov.amusic.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import ru.spiridonov.amusic.data.database.chartDB.ChartDao
import ru.spiridonov.amusic.data.database.trackDB.TrackDao
import ru.spiridonov.amusic.data.mapper.TrackMapper
import ru.spiridonov.amusic.domain.entity.TrackItem
import ru.spiridonov.amusic.domain.repository.TrackRepository
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val trackDao: TrackDao,
    private val chartDao: ChartDao,
    private val trackMapper: TrackMapper
) : TrackRepository {

    override suspend fun getTrackList() =
        trackDao.getAllTrack().map { trackList ->
            trackList.map { trackMapper.mapTrackDbModelToTrackItem(it) }
        }

    override suspend fun getChartTrackList(): LiveData<List<TrackItem>>? {
        chartDao.getAllChartTracksId().map { chartTrackList ->
            return trackDao.getTrackById(chartTrackList).map { trackList ->
                trackList.map { trackMapper.mapTrackDbModelToTrackItem(it) }
            }
        }
        return null
    }
}
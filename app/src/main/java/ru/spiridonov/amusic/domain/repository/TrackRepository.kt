package ru.spiridonov.amusic.domain.repository

import androidx.lifecycle.LiveData
import ru.spiridonov.amusic.domain.entity.TrackItem

interface TrackRepository {
    suspend fun getTrackList(): LiveData<List<TrackItem>>
}
package ru.spiridonov.amusic.domain.repository

import ru.spiridonov.amusic.domain.entity.TrackItem

interface TrackRepository {
    suspend fun getTrackList(): List<TrackItem>
}
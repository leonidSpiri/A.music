package ru.spiridonov.amusic.domain.repository

import androidx.lifecycle.LiveData
import ru.spiridonov.amusic.domain.entity.PodcastItem

interface PodcastRepository {
    suspend fun getPodcastList(): LiveData<List<PodcastItem>>
}
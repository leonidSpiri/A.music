package ru.spiridonov.amusic.data.repository

import ru.spiridonov.amusic.data.database.podcastDB.PodcastDao
import ru.spiridonov.amusic.domain.entity.PodcastItem
import ru.spiridonov.amusic.domain.repository.PodcastRepository
import javax.inject.Inject

class PodcastRepositoryImpl @Inject constructor(
    private val podcastDao: PodcastDao
) : PodcastRepository {

    override suspend fun getPodcastList(): List<PodcastItem> {

        return emptyList()
    }
}
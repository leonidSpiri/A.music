package ru.spiridonov.amusic.data.repository

import androidx.lifecycle.map
import ru.spiridonov.amusic.data.database.podcastDB.PodcastDao
import ru.spiridonov.amusic.data.mapper.PodcastMapper
import ru.spiridonov.amusic.domain.repository.PodcastRepository
import javax.inject.Inject

class PodcastRepositoryImpl @Inject constructor(
    private val podcastDao: PodcastDao,
    private val podcastMapper: PodcastMapper
) : PodcastRepository {

    override suspend fun getPodcastList()=
        podcastDao.getAllPodcast().map { podcastList ->
            podcastList.map { podcastMapper.mapPodcastDbModelToPodcastItem(it) }
        }
}
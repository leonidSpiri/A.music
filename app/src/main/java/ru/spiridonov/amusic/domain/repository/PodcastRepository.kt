package ru.spiridonov.amusic.domain.repository

import ru.spiridonov.amusic.domain.entity.PodcastItem

interface PodcastRepository {
    suspend fun getPodcastList(): List<PodcastItem>
}
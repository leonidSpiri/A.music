package ru.spiridonov.amusic.domain.usecases.podcast

import ru.spiridonov.amusic.domain.repository.PodcastRepository
import javax.inject.Inject

class GetPodcastListUseCase @Inject constructor(
    private val repository: PodcastRepository
) {
    suspend operator fun invoke() = repository.getPodcastList()
}
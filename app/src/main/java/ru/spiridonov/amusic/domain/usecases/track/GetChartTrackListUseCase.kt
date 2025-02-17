package ru.spiridonov.amusic.domain.usecases.track

import ru.spiridonov.amusic.domain.repository.TrackRepository
import javax.inject.Inject

class GetChartTrackListUseCase @Inject constructor(
    private val repository: TrackRepository
) {
    suspend operator fun invoke() = repository.getChartTrackList()
}
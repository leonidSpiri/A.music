package ru.spiridonov.amusic.domain.usecases.track

import ru.spiridonov.amusic.domain.repository.TrackRepository
import javax.inject.Inject

class GetTrackListUseCase @Inject constructor(
    private val repository: TrackRepository
) {
    operator fun invoke() = repository.getTrackList()
}
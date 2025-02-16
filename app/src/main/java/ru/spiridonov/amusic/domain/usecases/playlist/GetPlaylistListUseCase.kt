package ru.spiridonov.amusic.domain.usecases.playlist

import ru.spiridonov.amusic.domain.repository.PlaylistRepository
import javax.inject.Inject

class GetPlaylistListUseCase @Inject constructor(
    private val repository: PlaylistRepository
) {
    suspend operator fun invoke() = repository.getPlaylistList()
}
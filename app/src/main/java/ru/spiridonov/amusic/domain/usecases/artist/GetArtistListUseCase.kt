package ru.spiridonov.amusic.domain.usecases.artist

import ru.spiridonov.amusic.domain.repository.ArtistRepository
import javax.inject.Inject

class GetArtistListUseCase @Inject constructor(
    private val repository: ArtistRepository
) {
    suspend operator fun invoke() = repository.getArtistList()
}
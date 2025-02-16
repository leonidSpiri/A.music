package ru.spiridonov.amusic.domain.usecases.album

import ru.spiridonov.amusic.domain.repository.AlbumRepository
import javax.inject.Inject

class GetAlbumListUseCase @Inject constructor(
    private val repository: AlbumRepository
) {
    suspend operator fun invoke() = repository.getAlbumList()
}
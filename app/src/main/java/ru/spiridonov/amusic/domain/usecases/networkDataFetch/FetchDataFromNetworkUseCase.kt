package ru.spiridonov.amusic.domain.usecases.networkDataFetch

import ru.spiridonov.amusic.domain.repository.NetworkDataFetchRepository
import javax.inject.Inject

class FetchDataFromNetworkUseCase @Inject constructor(
    private val repository: NetworkDataFetchRepository
) {
    suspend operator fun invoke() = repository.fetchDataFromNetwork()
}
package ru.spiridonov.amusic.domain.usecases.networkDataFetch

import ru.spiridonov.amusic.domain.repository.NetworkDataFetchRepository
import javax.inject.Inject

class FetchChartDataFromNetworkUseCase @Inject constructor(
    private val repository: NetworkDataFetchRepository
) {
    suspend operator fun invoke() = repository.fetchChartDataFromNetwork()
}
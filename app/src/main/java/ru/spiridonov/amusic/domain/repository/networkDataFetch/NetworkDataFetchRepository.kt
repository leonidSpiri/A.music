package ru.spiridonov.amusic.domain.repository.networkDataFetch

interface NetworkDataFetchRepository {
    suspend fun fetchDataFromNetwork()
}
package ru.spiridonov.amusic.domain.repository

interface NetworkDataFetchRepository {
    suspend fun fetchDataFromNetwork()
}
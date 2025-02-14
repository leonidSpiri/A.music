package ru.spiridonov.amusic.data.repository

import android.util.Log
import ru.spiridonov.amusic.data.network.ApiService
import ru.spiridonov.amusic.domain.repository.networkDataFetch.NetworkDataFetchRepository
import javax.inject.Inject

class NetworkDataFetchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : NetworkDataFetchRepository {

    override suspend fun fetchDataFromNetwork() {
        apiService.getChart().body().let { body ->
            Log.d("chart", body.toString())
        }
    }
}
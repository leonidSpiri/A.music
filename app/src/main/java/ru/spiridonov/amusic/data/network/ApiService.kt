package ru.spiridonov.amusic.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.spiridonov.amusic.data.network.model.DeezerResponseDto

interface ApiService {

    @GET("chart")
    suspend fun getChart(): Response<DeezerResponseDto>
}
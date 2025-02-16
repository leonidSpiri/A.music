package ru.spiridonov.amusic.domain.repository

import androidx.lifecycle.LiveData
import ru.spiridonov.amusic.domain.entity.ArtistItem

interface ArtistRepository {
    suspend fun getArtistList(): LiveData<List<ArtistItem>>
}
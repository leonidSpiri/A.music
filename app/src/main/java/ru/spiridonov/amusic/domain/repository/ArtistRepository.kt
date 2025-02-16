package ru.spiridonov.amusic.domain.repository

import ru.spiridonov.amusic.domain.entity.ArtistItem

interface ArtistRepository {
    suspend fun getArtistList(): List<ArtistItem>
}
package ru.spiridonov.amusic.data.database.artistDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArtist(artistDbModel: ArtistDbModel)
}
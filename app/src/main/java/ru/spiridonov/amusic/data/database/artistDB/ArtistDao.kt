package ru.spiridonov.amusic.data.database.artistDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArtist(artistDbModel: ArtistDbModel)

    @Query("SELECT * FROM artists")
    fun getAllArtist(): LiveData<List<ArtistDbModel>>
}
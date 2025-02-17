package ru.spiridonov.amusic.data.database.trackDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrack(trackDbModel: TrackDbModel)

    @Query("SELECT * FROM tracks")
    fun getAllTrack(): LiveData<List<TrackDbModel>>

    @Query("SELECT * FROM tracks WHERE id = :trackId")
    fun getTrackById(trackId: Long): LiveData<List<TrackDbModel>>
}
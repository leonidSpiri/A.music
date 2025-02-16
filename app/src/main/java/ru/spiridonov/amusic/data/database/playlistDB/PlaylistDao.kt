package ru.spiridonov.amusic.data.database.playlistDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlaylistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlaylist(playlistDbModel: PlaylistDbModel)

    @Query("SELECT * FROM playlists")
    fun getAllPlaylist(): LiveData<List<PlaylistDbModel>>
}
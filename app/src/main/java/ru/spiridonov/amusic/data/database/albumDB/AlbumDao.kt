package ru.spiridonov.amusic.data.database.albumDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAlbum(albumDbModel: AlbumDbModel)

    @Query("SELECT * FROM albums")
    suspend fun getAllAlbums(): List<AlbumDbModel>
}
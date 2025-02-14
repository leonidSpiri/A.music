package ru.spiridonov.amusic.data.database.playlistDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.spiridonov.amusic.data.database.artistDB.ArtistDbModel

@Dao
interface PlaylistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlaylist(playlistDbModel: PlaylistDbModel)
}
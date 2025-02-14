package ru.spiridonov.amusic.data.database.trackDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.spiridonov.amusic.data.database.artistDB.ArtistDbModel
import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDbModel
import ru.spiridonov.amusic.data.database.podcastDB.PodcastDbModel

@Dao
interface TrackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrack(trackDbModel: TrackDbModel)
}
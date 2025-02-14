package ru.spiridonov.amusic.data.database.podcastDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.spiridonov.amusic.data.database.artistDB.ArtistDbModel
import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDbModel

@Dao
interface PodcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPodcast(podcastDbModel: PodcastDbModel)
}
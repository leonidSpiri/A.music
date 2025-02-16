package ru.spiridonov.amusic.data.database.podcastDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PodcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPodcast(podcastDbModel: PodcastDbModel)

    @Query("SELECT * FROM podcasts")
    fun getAllPodcast(): LiveData<List<PodcastDbModel>>
}
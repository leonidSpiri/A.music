package ru.spiridonov.amusic.data.database.chartDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharts(chartDbModel: ChartDbModel)

    @Query("SELECT chartTrackId FROM chart WHERE chartTrackId is not null")
    suspend fun getAllChartTracksId(): List<Long>

    @Query("DELETE FROM chart")
    suspend fun deleteAll()
}
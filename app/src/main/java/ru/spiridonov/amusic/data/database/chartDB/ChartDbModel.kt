package ru.spiridonov.amusic.data.database.chartDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chart")
data class ChartDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chartTrackId: Long?,
    val chartAlbumId: Long?,
)
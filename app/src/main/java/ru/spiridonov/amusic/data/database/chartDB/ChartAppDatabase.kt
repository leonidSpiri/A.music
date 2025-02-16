package ru.spiridonov.amusic.data.database.chartDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ChartDbModel::class], version = 1, exportSchema = false)
abstract class ChartAppDatabase : RoomDatabase() {
    abstract fun chartDao(): ChartDao

    companion object {
        private var INSTANCE: ChartAppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "chart.db"

        fun getInstance(context: Context): ChartAppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    ChartAppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}
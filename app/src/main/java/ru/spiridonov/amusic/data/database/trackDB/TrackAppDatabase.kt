package ru.spiridonov.amusic.data.database.trackDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TrackDbModel::class], version = 1, exportSchema = false)
abstract class TrackAppDatabase : RoomDatabase() {
    abstract fun trackDao(): TrackDao

    companion object {
        private var INSTANCE: TrackAppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "tracks.db"

        fun getInstance(context: Context): TrackAppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    TrackAppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}
package ru.spiridonov.amusic.data.database.podcastDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PodcastDbModel::class], version = 1, exportSchema = false)
abstract class PodcastAppDatabase : RoomDatabase() {
    abstract fun podcastDao(): PodcastDao

    companion object {
        private var INSTANCE: PodcastAppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "podcasts.db"

        fun getInstance(context: Context): PodcastAppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    PodcastAppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}
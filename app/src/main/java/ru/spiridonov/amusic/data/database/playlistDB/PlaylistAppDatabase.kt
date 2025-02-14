package ru.spiridonov.amusic.data.database.playlistDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PlaylistDbModel::class], version = 1, exportSchema = false)
abstract class PlaylistAppDatabase : RoomDatabase() {
    abstract fun playlistDao(): PlaylistDao

    companion object {
        private var INSTANCE: PlaylistAppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "playlists.db"

        fun getInstance(context: Context): PlaylistAppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    PlaylistAppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}
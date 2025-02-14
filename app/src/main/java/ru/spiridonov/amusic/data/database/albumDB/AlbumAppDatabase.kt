package ru.spiridonov.amusic.data.database.albumDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AlbumDbModel::class], version = 1, exportSchema = false)
abstract class AlbumAppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao

    companion object {
        private var INSTANCE: AlbumAppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "albums.db"

        fun getInstance(context: Context): AlbumAppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    AlbumAppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}
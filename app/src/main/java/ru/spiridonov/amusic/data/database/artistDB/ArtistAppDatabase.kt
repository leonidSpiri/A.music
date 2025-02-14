package ru.spiridonov.amusic.data.database.artistDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ArtistDbModel::class], version = 1, exportSchema = false)
abstract class ArtistAppDatabase : RoomDatabase() {
    abstract fun artistDao(): ArtistDao

    companion object {
        private var INSTANCE: ArtistAppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "artists.db"

        fun getInstance(context: Context): ArtistAppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    ArtistAppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}
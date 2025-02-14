package ru.spiridonov.amusic.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.spiridonov.amusic.data.database.albumDB.AlbumAppDatabase
import ru.spiridonov.amusic.data.database.albumDB.AlbumDao
import ru.spiridonov.amusic.data.database.artistDB.ArtistAppDatabase
import ru.spiridonov.amusic.data.database.artistDB.ArtistDao
import ru.spiridonov.amusic.data.database.playlistDB.PlaylistAppDatabase
import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDao
import ru.spiridonov.amusic.data.database.podcastDB.PodcastAppDatabase
import ru.spiridonov.amusic.data.database.podcastDB.PodcastDao
import ru.spiridonov.amusic.data.database.trackDB.TrackAppDatabase
import ru.spiridonov.amusic.data.database.trackDB.TrackDao
import ru.spiridonov.amusic.data.network.ApiFactory
import ru.spiridonov.amusic.data.network.ApiService
import ru.spiridonov.amusic.data.repository.NetworkDataFetchRepositoryImpl
import ru.spiridonov.amusic.domain.repository.networkDataFetch.NetworkDataFetchRepository

@Module
interface DataModule {
    @Binds
    @ApplicationScope
    fun bindNetworkDataFetchRepository(impl: NetworkDataFetchRepositoryImpl): NetworkDataFetchRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }

        @Provides
        @ApplicationScope
        fun provideAlbumDao(
            application: Application
        ): AlbumDao {
            return AlbumAppDatabase.getInstance(application).albumDao()
        }

        @Provides
        @ApplicationScope
        fun provideArtistDao(
            application: Application
        ): ArtistDao {
            return ArtistAppDatabase.getInstance(application).artistDao()
        }

        @Provides
        @ApplicationScope
        fun providePlaylistDao(
            application: Application
        ): PlaylistDao {
            return PlaylistAppDatabase.getInstance(application).playlistDao()
        }

        @Provides
        @ApplicationScope
        fun providePodcastDao(
            application: Application
        ): PodcastDao {
            return PodcastAppDatabase.getInstance(application).podcastDao()
        }

        @Provides
        @ApplicationScope
        fun provideTrackDao(
            application: Application
        ): TrackDao {
            return TrackAppDatabase.getInstance(application).trackDao()
        }
    }
}
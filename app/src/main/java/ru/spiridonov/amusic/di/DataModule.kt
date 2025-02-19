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
import ru.spiridonov.amusic.data.repository.AlbumRepositoryImpl
import ru.spiridonov.amusic.data.repository.ArtistRepositoryImpl
import ru.spiridonov.amusic.data.repository.NetworkDataFetchRepositoryImpl
import ru.spiridonov.amusic.data.repository.PlaylistRepositoryImpl
import ru.spiridonov.amusic.data.repository.PodcastRepositoryImpl
import ru.spiridonov.amusic.data.repository.TrackRepositoryImpl
import ru.spiridonov.amusic.domain.repository.AlbumRepository
import ru.spiridonov.amusic.domain.repository.ArtistRepository
import ru.spiridonov.amusic.domain.repository.NetworkDataFetchRepository
import ru.spiridonov.amusic.domain.repository.PlaylistRepository
import ru.spiridonov.amusic.domain.repository.PodcastRepository
import ru.spiridonov.amusic.domain.repository.TrackRepository

@Module
interface DataModule {
    @Binds
    @ApplicationScope
    fun bindNetworkDataFetchRepository(impl: NetworkDataFetchRepositoryImpl): NetworkDataFetchRepository

    @Binds
    @ApplicationScope
    fun bindAlbumRepository(impl: AlbumRepositoryImpl): AlbumRepository

    @Binds
    @ApplicationScope
    fun bindArtistRepository(impl: ArtistRepositoryImpl): ArtistRepository

    @Binds
    @ApplicationScope
    fun bindPlaylistRepository(impl: PlaylistRepositoryImpl): PlaylistRepository

    @Binds
    @ApplicationScope
    fun bindPodcastRepository(impl: PodcastRepositoryImpl): PodcastRepository

    @Binds
    @ApplicationScope
    fun bindTrackRepository(impl: TrackRepositoryImpl): TrackRepository

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
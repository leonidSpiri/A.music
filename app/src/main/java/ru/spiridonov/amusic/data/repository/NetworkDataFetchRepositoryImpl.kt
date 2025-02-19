package ru.spiridonov.amusic.data.repository

import ru.spiridonov.amusic.data.database.albumDB.AlbumDao
import ru.spiridonov.amusic.data.database.artistDB.ArtistDao
import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDao
import ru.spiridonov.amusic.data.database.podcastDB.PodcastDao
import ru.spiridonov.amusic.data.database.trackDB.TrackDao
import ru.spiridonov.amusic.data.mapper.DtoMapper
import ru.spiridonov.amusic.data.network.ApiService
import ru.spiridonov.amusic.domain.repository.NetworkDataFetchRepository
import javax.inject.Inject

class NetworkDataFetchRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dtoMapper: DtoMapper,
    private val albumDao: AlbumDao,
    private val artistDao: ArtistDao,
    private val playlistDao: PlaylistDao,
    private val podcastDao: PodcastDao,
    private val trackDao: TrackDao
) : NetworkDataFetchRepository {

    override suspend fun fetchChartDataFromNetwork() {
        apiService.getChart().body().let { body ->
            body?.albums?.data?.forEach {
                albumDao.addAlbum(dtoMapper.mapAlbumDtoToAlbumDbModel(it).copy(isInChart = true))
            }
            body?.artists?.data?.forEach {
                artistDao.addArtist(
                    dtoMapper.mapArtistDtoToArtistDbModel(it).copy(isInChart = true)
                )
            }
            body?.playlists?.data?.forEach {
                playlistDao.addPlaylist(
                    dtoMapper.mapPlaylistDtoToPlaylistDbModel(it).copy(isInChart = true)
                )
            }
            body?.podcasts?.data?.forEach {
                podcastDao.addPodcast(
                    dtoMapper.mapPodcastDtoToPodcastDbModel(it).copy(isInChart = true)
                )
            }
            body?.tracks?.data?.forEach {
                trackDao.addTrack(dtoMapper.mapTrackDtoToTrackDbModel(it).copy(isInChart = true))
            }
        }
    }
}
package ru.spiridonov.amusic.data.repository

import ru.spiridonov.amusic.data.database.albumDB.AlbumDao
import ru.spiridonov.amusic.data.database.artistDB.ArtistDao
import ru.spiridonov.amusic.data.database.chartDB.ChartDao
import ru.spiridonov.amusic.data.database.chartDB.ChartDbModel
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
    private val trackDao: TrackDao,
    private val chartDao: ChartDao
) : NetworkDataFetchRepository {

    override suspend fun fetchChartDataFromNetwork() {
        apiService.getChart().body().let { body ->
            chartDao.deleteAll()
            body?.albums?.data?.forEach {
                albumDao.addAlbum(dtoMapper.mapAlbumDtoToAlbumDbModel(it))
                chartDao.addCharts(ChartDbModel(chartTrackId = null, chartAlbumId = it.id))
            }
            body?.artists?.data?.forEach {
                artistDao.addArtist(dtoMapper.mapArtistDtoToArtistDbModel(it))
            }
            body?.playlists?.data?.forEach {
                playlistDao.addPlaylist(dtoMapper.mapPlaylistDtoToPlaylistDbModel(it))
            }
            body?.podcasts?.data?.forEach {
                podcastDao.addPodcast(dtoMapper.mapPodcastDtoToPodcastDbModel(it))
            }
            body?.tracks?.data?.forEach {
                trackDao.addTrack(dtoMapper.mapTrackDtoToTrackDbModel(it))
                chartDao.addCharts(ChartDbModel(chartTrackId = it.id, chartAlbumId = null))
            }
        }
    }
}
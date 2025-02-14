package ru.spiridonov.amusic.domain.entity

data class NetworkDataFetchItem(
    val albumItem: AlbumItem,
    val artistItem: ArtistItem,
    val playlistItem: PlaylistItem,
    val podcastItem: PodcastItem,
    val trackItem: TrackItem
)

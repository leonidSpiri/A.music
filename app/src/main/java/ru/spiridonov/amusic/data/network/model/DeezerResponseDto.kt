package ru.spiridonov.amusic.data.network.model

data class DeezerResponseDto(
    val tracks: TrackDataDto,
    val albums: AlbumDataDto,
    val artists: ArtistDataDto,
    val playlists: PlaylistDataDto,
    val podcasts: PodcastDataDto
)

data class TrackDataDto(
    val data: List<TrackDto>,
    val total: Int
)

data class AlbumDataDto(
    val data: List<AlbumDto>,
    val total: Int
)

data class ArtistDataDto(
    val data: List<ArtistDto>,
    val total: Int
)

data class PlaylistDataDto(
    val data: List<PlaylistDto>,
    val total: Int
)

data class PodcastDataDto(
    val data: List<PodcastDto>,
    val total: Int
)

data class TrackDto(
    val id: Long,
    val title: String,
    val title_short: String,
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: String,
    val md5_image: String,
    val position: Int,
    val artist: ArtistDto,
    val album: AlbumDto,
    val type: String
)

data class ArtistDto(
    val id: Long,
    val name: String,
    val link: String,
    val picture: String,
    val picture_small: String,
    val picture_medium: String,
    val picture_big: String,
    val picture_xl: String,
    val radio: Boolean,
    val tracklist: String,
    val type: String
)

data class AlbumDto(
    val id: Long,
    val title: String,
    val cover: String,
    val cover_small: String,
    val cover_medium: String,
    val cover_big: String,
    val cover_xl: String,
    val md5_image: String,
    val tracklist: String,
    val type: String
)

data class PlaylistDto(
    val id: Long,
    val title: String,
    val public: Boolean,
    val nb_tracks: Int,
    val link: String,
    val picture: String,
    val picture_small: String,
    val picture_medium: String,
    val picture_big: String,
    val picture_xl: String,
    val checksum: String,
    val tracklist: String,
    val creation_date: String,
    val md5_image: String,
    val picture_type: String,
    val type: String
)

data class PodcastDto(
    val id: Long,
    val title: String,
    val description: String,
    val available: Boolean,
    val fans: Int,
    val link: String,
    val share: String,
    val picture: String,
    val picture_small: String,
    val picture_medium: String,
    val picture_big: String,
    val picture_xl: String,
    val type: String
)

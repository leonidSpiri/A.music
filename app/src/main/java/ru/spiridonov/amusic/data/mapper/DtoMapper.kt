package ru.spiridonov.amusic.data.mapper

import ru.spiridonov.amusic.data.database.albumDB.AlbumDbModel
import ru.spiridonov.amusic.data.database.artistDB.ArtistDbModel
import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDbModel
import ru.spiridonov.amusic.data.database.podcastDB.PodcastDbModel
import ru.spiridonov.amusic.data.database.trackDB.TrackDbModel
import ru.spiridonov.amusic.data.network.model.AlbumDto
import ru.spiridonov.amusic.data.network.model.ArtistDto
import ru.spiridonov.amusic.data.network.model.PlaylistDto
import ru.spiridonov.amusic.data.network.model.PodcastDto
import ru.spiridonov.amusic.data.network.model.TrackDto
import javax.inject.Inject

class DtoMapper @Inject constructor(
) {
    fun mapAlbumDtoToAlbumDbModel(albumDto: AlbumDto) =
        AlbumDbModel(
            id = albumDto.id,
            title = albumDto.title,
            cover = albumDto.cover,
            coverSmall = albumDto.cover_small,
            coverMedium = albumDto.cover_medium,
            coverBig = albumDto.cover_big,
            coverXl = albumDto.cover_xl,
            md5Image = albumDto.md5_image,
            trackList = albumDto.tracklist,
            type = albumDto.type
        )

    fun mapArtistDtoToArtistDbModel(artistDto: ArtistDto) =
        ArtistDbModel(
            id = artistDto.id,
            name = artistDto.name,
            link = artistDto.link,
            picture = artistDto.picture,
            pictureSmall = artistDto.picture_small,
            pictureMedium = artistDto.picture_medium,
            pictureBig = artistDto.picture_big,
            pictureXl = artistDto.picture_xl,
            radio = artistDto.radio,
            trackList = artistDto.tracklist,
            type = artistDto.type
        )

    fun mapPlaylistDtoToPlaylistDbModel(playlistDto: PlaylistDto) =
        PlaylistDbModel(
            id = playlistDto.id,
            title = playlistDto.title,
            public = playlistDto.public,
            nbTracks = playlistDto.nb_tracks,
            link = playlistDto.link,
            picture = playlistDto.picture,
            pictureSmall = playlistDto.picture_small,
            pictureMedium = playlistDto.picture_medium,
            pictureBig = playlistDto.picture_big,
            pictureXl = playlistDto.picture_xl,
            checksum = playlistDto.checksum,
            trackList = playlistDto.tracklist,
            creationDate = playlistDto.creation_date,
            md5Image = playlistDto.md5_image,
            pictureType = playlistDto.picture_type,
            type = playlistDto.type
        )

    fun mapPodcastDtoToPodcastDbModel(podcastDto: PodcastDto) =
        PodcastDbModel(
            id = podcastDto.id,
            title = podcastDto.title,
            description = podcastDto.description,
            available = podcastDto.available,
            fans = podcastDto.fans,
            link = podcastDto.link,
            share = podcastDto.share,
            picture = podcastDto.picture,
            pictureSmall = podcastDto.picture_small,
            pictureMedium = podcastDto.picture_medium,
            type = podcastDto.type,
            pictureBig = podcastDto.picture_big,
            pictureXl = podcastDto.picture_xl
        )

    fun mapTrackDtoToTrackDbModel(trackDto: TrackDto) =
        TrackDbModel(
            id = trackDto.id,
            title = trackDto.title,
            titleShort = trackDto.title_short,
            link = trackDto.link,
            duration = trackDto.duration,
            rank = trackDto.rank,
            explicitLyrics = trackDto.explicit_lyrics,
            explicitContentLyrics = trackDto.explicit_content_lyrics,
            explicitContentCover = trackDto.explicit_content_cover,
            preview = trackDto.preview,
            md5Image = trackDto.md5_image,
            position = trackDto.position,
            artistId = trackDto.artist.id,
            albumId = trackDto.album.id,
            type = trackDto.type
        )
}
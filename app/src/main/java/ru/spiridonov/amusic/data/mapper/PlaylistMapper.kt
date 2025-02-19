package ru.spiridonov.amusic.data.mapper

import ru.spiridonov.amusic.data.database.playlistDB.PlaylistDbModel
import ru.spiridonov.amusic.domain.entity.PlaylistItem
import javax.inject.Inject

class PlaylistMapper @Inject constructor() {

    fun mapPlaylistDbModelToPlaylistItem(playlistDbModel: PlaylistDbModel) =
        PlaylistItem(
            id = playlistDbModel.id,
            title = playlistDbModel.title,
            public = playlistDbModel.public,
            nbTracks = playlistDbModel.nbTracks,
            link = playlistDbModel.link,
            picture = playlistDbModel.picture,
            pictureSmall = playlistDbModel.pictureSmall,
            pictureMedium = playlistDbModel.pictureMedium,
            pictureBig = playlistDbModel.pictureBig,
            pictureXl = playlistDbModel.pictureXl,
            checksum = playlistDbModel.checksum,
            trackList = playlistDbModel.trackList,
            creationDate = playlistDbModel.creationDate,
            md5Image = playlistDbModel.md5Image,
            pictureType = playlistDbModel.pictureType,
            type = playlistDbModel.type,
            isInChart = playlistDbModel.isInChart,
        )
}
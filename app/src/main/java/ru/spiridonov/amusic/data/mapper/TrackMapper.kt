package ru.spiridonov.amusic.data.mapper

import ru.spiridonov.amusic.data.database.trackDB.TrackDbModel
import ru.spiridonov.amusic.domain.entity.TrackItem
import javax.inject.Inject

class TrackMapper@Inject constructor() {

    fun mapTrackDbModelToTrackItem(trackDbModel: TrackDbModel) =
        TrackItem(
            id = trackDbModel.id,
            title = trackDbModel.title,
            titleShort = trackDbModel.titleShort,
            link = trackDbModel.link,
            duration = trackDbModel.duration,
            rank = trackDbModel.rank,
            explicitContentLyrics = trackDbModel.explicitContentLyrics,
            explicitLyrics = trackDbModel.explicitLyrics,
            explicitContentCover = trackDbModel.explicitContentCover,
            preview = trackDbModel.preview,
            md5Image = trackDbModel.md5Image,
            position = trackDbModel.position,
            artist = null, //TODO(get artist from db by id)
            album = null,  //TODO(get album from db by id)
            type = trackDbModel.type
        )
}
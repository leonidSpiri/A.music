package ru.spiridonov.amusic.data.mapper

import ru.spiridonov.amusic.data.database.albumDB.AlbumDbModel
import ru.spiridonov.amusic.domain.entity.AlbumItem
import javax.inject.Inject

class AlbumMapper @Inject constructor() {
    fun mapAlbumDbModelToAlbumItem(albumDbModel: AlbumDbModel) =
        AlbumItem(
            id = albumDbModel.id,
            title = albumDbModel.title,
            cover = albumDbModel.cover,
            coverSmall = albumDbModel.coverSmall,
            coverMedium = albumDbModel.coverMedium,
            coverBig = albumDbModel.coverBig,
            coverXl = albumDbModel.coverXl,
            md5Image = albumDbModel.md5Image,
            trackList = albumDbModel.trackList,
            type = albumDbModel.type,
            isInChart = albumDbModel.isInChart
        )
}
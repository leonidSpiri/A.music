package ru.spiridonov.amusic.data.mapper

import ru.spiridonov.amusic.data.database.artistDB.ArtistDbModel
import ru.spiridonov.amusic.domain.entity.ArtistItem
import javax.inject.Inject

class ArtistMapper @Inject constructor() {

    fun mapArtistDbModelToArtistItem(artistDbModel: ArtistDbModel) =
        ArtistItem(
            id = artistDbModel.id,
            name = artistDbModel.name,
            link = artistDbModel.link,
            picture = artistDbModel.picture,
            pictureSmall = artistDbModel.pictureSmall,
            pictureMedium = artistDbModel.pictureMedium,
            pictureBig = artistDbModel.pictureBig,
            pictureXl = artistDbModel.pictureXl,
            radio = artistDbModel.radio,
            trackList = artistDbModel.trackList,
            type = artistDbModel.type
        )
}
package ru.spiridonov.amusic.data.mapper

import ru.spiridonov.amusic.data.database.podcastDB.PodcastDbModel
import ru.spiridonov.amusic.domain.entity.PodcastItem
import javax.inject.Inject

class PodcastMapper @Inject constructor() {
    fun mapPodcastDbModelToPodcastItem(podcastDbModel: PodcastDbModel) =
        PodcastItem(
            id = podcastDbModel.id,
            title = podcastDbModel.title,
            description = podcastDbModel.description,
            available = podcastDbModel.available,
            fans = podcastDbModel.fans,
            link = podcastDbModel.link,
            share = podcastDbModel.share,
            picture = podcastDbModel.picture,
            pictureSmall = podcastDbModel.pictureSmall,
            pictureMedium = podcastDbModel.pictureMedium,
            pictureBig = podcastDbModel.pictureBig,
            pictureXl = podcastDbModel.pictureXl,
            type = podcastDbModel.type,
        )
}
package ru.spiridonov.amusic.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.spiridonov.amusic.domain.entity.TrackItem

class TrackDiffCallback : DiffUtil.ItemCallback<TrackItem>() {
    override fun areItemsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean =
        oldItem == newItem
}
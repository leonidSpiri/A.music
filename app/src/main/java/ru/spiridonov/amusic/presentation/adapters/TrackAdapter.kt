package ru.spiridonov.amusic.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import ru.spiridonov.amusic.R
import ru.spiridonov.amusic.databinding.EachTrackItemBinding
import ru.spiridonov.amusic.domain.entity.TrackItem

class TrackAdapter : ListAdapter<TrackItem, TrackViewHolder>(TrackDiffCallback()) {
    var onItemClickListener: ((TrackItem) -> Unit)? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrackViewHolder {
        val layoutID =
            when (viewType) {
                TRACK -> R.layout.each_track_item
                else -> throw RuntimeException("Unknown view type: $viewType")
            }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutID,
            parent,
            false
        )
        return TrackViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int =
        TRACK

    override fun onBindViewHolder(
        holder: TrackViewHolder,
        position: Int
    ) {
        val track = getItem(position)
        val binding = holder.binding
        when (binding) {
            is EachTrackItemBinding -> {
                binding.trackItem = track
            }
        }
        binding.root.setOnClickListener {
            onItemClickListener?.invoke(track)
        }
    }


    companion object {
        const val TRACK = 0
        const val EX_TRACK = 1
    }
}
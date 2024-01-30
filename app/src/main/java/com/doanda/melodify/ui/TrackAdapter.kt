package com.doanda.easymeal.ui.track

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doanda.melodify.R
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.databinding.ItemTrackBinding

class TrackAdapter : ListAdapter<Track, TrackAdapter.ViewHolder>(DIFF_CALLBACK)
{
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(track: Track)
//        fun onFavoriteClicked(track: Track)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(val binding: ItemTrackBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(track: Track) {
            with(binding) {
                tvItemTrackTitle.text = track.title
                tvItemTrackArtist.text = track.artistName
                tvItemTrackDuration.text = track.duration.toString()

                Glide.with(itemView.context)
                    .load(track.albumCover)
                    .into(binding.ivItemTrackCover)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track)

        holder.binding.cardTrack.setOnClickListener {
            onItemClickCallback.onItemClicked(track)
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Track> = object : DiffUtil.ItemCallback<Track>() {
            override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
                return oldItem == newItem
            }
        }
    }

}
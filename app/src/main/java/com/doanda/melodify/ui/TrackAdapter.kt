package com.doanda.easymeal.ui.track

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doanda.melodify.R
import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.databinding.ItemTrackBinding

class TrackAdapter : ListAdapter<TrackEntity, TrackAdapter.ViewHolder>(DIFF_CALLBACK)
{
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(track: TrackEntity)
//        fun onFavoriteClicked(track: TrackEntity)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(val binding: ItemTrackBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(track: TrackEntity) {
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
        val DIFF_CALLBACK: DiffUtil.ItemCallback<TrackEntity> = object : DiffUtil.ItemCallback<TrackEntity>() {
            override fun areItemsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: TrackEntity, newItem: TrackEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}
package com.doanda.melodify.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doanda.melodify.core.databinding.ItemFavoriteBinding
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.utils.DataMapper.formatDuration

class FavoriteAdapter : androidx.recyclerview.widget.ListAdapter<Track, FavoriteAdapter.ViewHolder>(DIFF_CALLBACK)
{
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(track: Track)
//        fun onFavoriteClicked(track: Track)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(track: Track) {
            with(binding) {
                tvItemFavoriteTitle.text = track.title
                tvItemFavoriteArtist.text = track.artistName
                tvItemFavoriteDuration.text = formatDuration(track.duration)

                Glide.with(itemView.context)
                    .load(track.albumCover)
                    .into(binding.ivItemFavoriteCover)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track)

        holder.binding.cardFavorite.setOnClickListener {
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
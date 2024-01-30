package com.doanda.melodify.ui.track

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.doanda.melodify.R
import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.databinding.ActivityTrackBinding
import com.doanda.melodify.ui.ViewModelFactory

class TrackActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTrackBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<TrackViewModel> { ViewModelFactory.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val track = intent.getParcelableExtra<TrackEntity>(EXTRA_TRACK)

        if (track != null) displayTrackDetail(track)
    }

    private fun displayTrackDetail(track: TrackEntity) {
        binding.tvTrackTitle.text = track.title
        binding.tvTrackArtist.text = track.artistName
        binding.tvTrackLink.text = track.link

        Glide.with(this).load(track.albumCover).into(binding.ivTrackCover)

        var statusFavorite = track.isFavorite
        setStatusFavorite(statusFavorite)
        binding.btnFavorite.setOnClickListener {
            statusFavorite = !statusFavorite
            viewModel.setFavoriteTrack(track, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(isFavorite: Boolean) {
        val imageDrawable = if (isFavorite) ContextCompat.getDrawable(this, R.drawable.ic_round_favorite_selected ) else ContextCompat.getDrawable(this, R.drawable.ic_round_favorite)
        val iconColor = if (isFavorite) ContextCompat.getColor(this, R.color.theme_dark_red) else ContextCompat.getColor(this, com.google.android.material.R.color.material_grey_600)
        val iconColorStateList = ColorStateList.valueOf(iconColor)

        binding.btnFavorite.setImageDrawable(imageDrawable)
        binding.btnFavorite.imageTintList = iconColorStateList
    }

    companion object {
        const val EXTRA_TRACK = "extra_track"
    }
}
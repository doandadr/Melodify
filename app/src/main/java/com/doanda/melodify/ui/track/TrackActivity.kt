package com.doanda.melodify.ui.track

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.doanda.melodify.R
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.databinding.ActivityTrackBinding
import org.koin.android.viewmodel.ext.android.viewModel

class TrackActivity : AppCompatActivity() {

//    private val binding by lazy { ActivityTrackBinding.inflate(layoutInflater) }
    private lateinit var binding: ActivityTrackBinding

    private val trackViewModel: TrackViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val track: Track?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            track = intent.getParcelableExtra(EXTRA_TRACK, Track::class.java)
        } else {
            @Suppress("DEPRECATION")
            track = intent.getParcelableExtra(EXTRA_TRACK)
        }

        if (track != null) displayTrackDetail(track)
    }

    private fun displayTrackDetail(track: Track) {
        binding.tvTrackTitle.text = track.title
        binding.tvTrackArtist.text = track.artistName
        binding.tvTrackLink.text = track.link

        Glide.with(this).load(track.albumCover).into(binding.ivTrackCover)

        var statusFavorite = track.isFavorite
        setStatusFavorite(statusFavorite)
        binding.btnFavorite.setOnClickListener {
            statusFavorite = !statusFavorite
            trackViewModel.setFavoriteTrack(track, statusFavorite)
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
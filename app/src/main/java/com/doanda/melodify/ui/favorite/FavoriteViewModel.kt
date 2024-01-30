package com.doanda.melodify.ui.favorite

import androidx.lifecycle.ViewModel
import com.doanda.melodify.core.data.TrackRepository

class FavoriteViewModel(private val trackRepository: TrackRepository) : ViewModel() {
    val favoriteTracks = trackRepository.getFavoriteTrack()
}
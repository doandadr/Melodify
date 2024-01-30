package com.doanda.melodify.ui.track

import androidx.lifecycle.ViewModel
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.domain.model.Track

class TrackViewModel(private val trackRepository: TrackRepository) : ViewModel() {
    fun setFavoriteTrack(track: Track, newStatus: Boolean) = trackRepository.setFavoriteTrack(track, newStatus)
}
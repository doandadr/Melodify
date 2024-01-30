package com.doanda.melodify.ui.track

import androidx.lifecycle.ViewModel
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.data.source.local.entity.TrackEntity

class TrackViewModel(private val trackRepository: TrackRepository) : ViewModel() {
    fun setFavoriteTrack(track: TrackEntity, newStatus: Boolean) = trackRepository.setFavoriteTrack(track, newStatus)
}
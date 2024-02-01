package com.doanda.melodify.ui.track

import androidx.lifecycle.ViewModel
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.domain.usecase.TrackUseCase

class TrackViewModel (private val trackUseCase: TrackUseCase) : ViewModel() {
    fun setFavoriteTrack(track: Track, newStatus: Boolean) = trackUseCase.setFavoriteTrack(track, newStatus)
}
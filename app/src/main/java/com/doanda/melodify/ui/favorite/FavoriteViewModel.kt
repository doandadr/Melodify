package com.doanda.melodify.ui.favorite

import androidx.lifecycle.ViewModel
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.domain.usecase.TrackUseCase

class FavoriteViewModel(trackUseCase: TrackUseCase) : ViewModel() {
    val favoriteTracks = trackUseCase.getFavoriteTracks()
}
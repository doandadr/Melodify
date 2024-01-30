package com.doanda.melodify.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doanda.melodify.core.domain.usecase.TrackUseCase

class FavoriteViewModel(trackUseCase: TrackUseCase) : ViewModel() {
    val favoriteTracks = trackUseCase.getFavoriteTracks().asLiveData()
}
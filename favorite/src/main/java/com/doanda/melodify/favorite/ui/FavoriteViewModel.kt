package com.doanda.melodify.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FavoriteViewModel(trackUseCase: TrackUseCase) : ViewModel() {
    val favoriteTracks = trackUseCase.getFavoriteTracks().asLiveData()
}
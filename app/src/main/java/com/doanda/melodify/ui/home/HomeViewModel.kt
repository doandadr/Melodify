package com.doanda.melodify.ui.home

import androidx.lifecycle.ViewModel
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.domain.usecase.TrackUseCase

class HomeViewModel(trackUseCase: TrackUseCase) : ViewModel() {

    val tracks = trackUseCase.getAllTracks()
}
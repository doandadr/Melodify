package com.doanda.melodify.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(trackUseCase: TrackUseCase) : ViewModel() {

    val tracks = trackUseCase.getAllTracks().asLiveData()
}
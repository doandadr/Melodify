package com.doanda.melodify.ui.home

import androidx.lifecycle.ViewModel
import com.doanda.melodify.core.data.TrackRepository

class HomeViewModel(private val trackRepository: TrackRepository) : ViewModel() {

    val tracks = trackRepository.getAllTracks()
}
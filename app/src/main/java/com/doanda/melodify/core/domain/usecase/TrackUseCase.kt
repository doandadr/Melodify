package com.doanda.melodify.core.domain.usecase

import androidx.lifecycle.LiveData
import com.doanda.melodify.core.data.Resource
import com.doanda.melodify.core.domain.model.Track

interface TrackUseCase {
    fun getAllTracks(): LiveData<Resource<List<Track>>>

    fun getFavoriteTracks(): LiveData<List<Track>>

    fun setFavoriteTrack(track: Track, state: Boolean)
}
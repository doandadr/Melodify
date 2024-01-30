package com.doanda.melodify.core.domain.repository

import androidx.lifecycle.LiveData
import com.doanda.melodify.core.data.Resource
import com.doanda.melodify.core.domain.model.Track

interface ITrackRepository {
    fun getAllTracks(): LiveData<Resource<List<Track>>>

    fun getFavoriteTracks(): LiveData<List<Track>>

    fun setFavoriteTrack(track: Track, state: Boolean)
}
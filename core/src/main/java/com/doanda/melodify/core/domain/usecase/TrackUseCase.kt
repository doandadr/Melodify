package com.doanda.melodify.core.domain.usecase

import com.doanda.melodify.core.domain.model.Track
import kotlinx.coroutines.flow.Flow

interface TrackUseCase {
    fun getAllTracks(): Flow<com.doanda.melodify.core.data.Resource<List<Track>>>

    fun getFavoriteTracks(): Flow<List<Track>>

    fun setFavoriteTrack(track: Track, state: Boolean)
}
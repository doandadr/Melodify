package com.doanda.melodify.core.domain.usecase

import com.doanda.melodify.core.data.Resource
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.domain.repository.ITrackRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrackInteractor @Inject constructor(private val trackRepository: ITrackRepository ): TrackUseCase {

    override fun getAllTracks(): Flow<com.doanda.melodify.core.data.Resource<List<Track>>> = trackRepository.getAllTracks()

    override fun getFavoriteTracks(): Flow<List<Track>> = trackRepository.getFavoriteTracks()

    override fun setFavoriteTrack(track: Track, state: Boolean) = trackRepository.setFavoriteTrack(track, state)
}
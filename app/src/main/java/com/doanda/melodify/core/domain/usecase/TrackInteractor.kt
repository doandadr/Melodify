package com.doanda.melodify.core.domain.usecase

import com.doanda.melodify.core.data.Resource
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.domain.repository.ITrackRepository
import kotlinx.coroutines.flow.Flow

class TrackInteractor(private val trackRepository: ITrackRepository ): TrackUseCase {

    override fun getAllTracks(): Flow<Resource<List<Track>>> = trackRepository.getAllTracks()

    override fun getFavoriteTracks(): Flow<List<Track>> = trackRepository.getFavoriteTracks()

    override fun setFavoriteTrack(track: Track, state: Boolean) = trackRepository.setFavoriteTrack(track, state)


}
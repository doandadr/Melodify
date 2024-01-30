package com.doanda.melodify.core.domain.usecase

import androidx.lifecycle.LiveData
import com.doanda.melodify.core.data.Resource
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.domain.repository.ITrackRepository

class TrackInteractor(private val trackRepository: ITrackRepository ): TrackUseCase {

    override fun getAllTracks(): LiveData<Resource<List<Track>>> = trackRepository.getAllTracks()

    override fun getFavoriteTracks(): LiveData<List<Track>> = trackRepository.getFavoriteTracks()

    override fun setFavoriteTrack(track: Track, state: Boolean) = trackRepository.setFavoriteTrack(track, state)


}
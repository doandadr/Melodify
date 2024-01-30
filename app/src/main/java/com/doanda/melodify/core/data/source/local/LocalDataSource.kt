package com.doanda.melodify.core.data.source.local

import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.core.data.source.local.room.TrackDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val trackDao: TrackDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(trackDao: TrackDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(trackDao)
            }
    }

    fun getAllTracks(): Flow<List<TrackEntity>> = trackDao.getAllTracks()

    fun getFavoriteTracks(): Flow<List<TrackEntity>> = trackDao.getFavoriteTracks()

    suspend fun insertTrack(trackList: List<TrackEntity>) = trackDao.insertTrack(trackList)

    fun setFavoriteTrack(track: TrackEntity, newState: Boolean) {
        track.isFavorite = newState
        trackDao.updateFavoriteTrack(track)
    }
}
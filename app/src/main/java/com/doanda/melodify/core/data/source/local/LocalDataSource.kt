package com.doanda.melodify.core.data.source.local

import androidx.lifecycle.LiveData
import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.core.data.source.local.room.TrackDao

class LocalDataSource private constructor(private val trackDao: TrackDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(trackDao: TrackDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(trackDao)
            }
    }

    fun getAllTracks(): LiveData<List<TrackEntity>> = trackDao.getAllTracks()

    fun getFavoriteTracks(): LiveData<List<TrackEntity>> = trackDao.getFavoriteTracks()

    fun insertTrack(trackList: List<TrackEntity>) = trackDao.insertTrack(trackList)

    fun setFavoriteTrack(track: TrackEntity, newState: Boolean) {
        track.isFavorite = newState
        trackDao.updateFavoriteTrack(track)
    }
}
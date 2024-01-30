package com.doanda.melodify.core.data

import androidx.lifecycle.LiveData
import com.doanda.melodify.core.data.source.local.LocalDataSource
import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.core.data.source.remote.RemoteDataSource
import com.doanda.melodify.core.data.source.remote.network.ApiResponse
import com.doanda.melodify.core.data.source.remote.response.TrackResponse
import com.doanda.melodify.core.utils.AppExecutors
import com.doanda.melodify.core.utils.DataMapper

class TrackRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) {

    companion object {
        @Volatile
        private var instance: TrackRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TrackRepository =
            instance ?: synchronized(this) {
                instance ?: TrackRepository(remoteData, localData, appExecutors)
            }
    }

    fun getAllTrack(): LiveData<Resource<List<TrackEntity>>> =
        object : NetworkBoundResource<List<TrackEntity>, List<TrackResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TrackEntity>> {
                return localDataSource.getAllTrack()
            }

            override fun shouldFetch(data: List<TrackEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TrackResponse>>> =
                remoteDataSource.getAllTracks()

            override fun saveCallResult(data: List<TrackResponse>) {
                val trackList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTrack(trackList)
            }
        }.asLiveData()

    fun getFavoriteTrack(): LiveData<List<TrackEntity>> {
        return localDataSource.getFavoriteTrack()
    }

    fun setFavoriteTrack(track: TrackEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTrack(track, state) }
    }
}


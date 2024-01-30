package com.doanda.melodify.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.doanda.melodify.core.data.source.local.LocalDataSource
import com.doanda.melodify.core.data.source.remote.RemoteDataSource
import com.doanda.melodify.core.data.source.remote.network.ApiResponse
import com.doanda.melodify.core.data.source.remote.response.TrackResponse
import com.doanda.melodify.core.domain.model.Track
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

    fun getAllTrack(): LiveData<Resource<List<Track>>> =
        object : NetworkBoundResource<List<Track>, List<TrackResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Track>> {
                return localDataSource.getAllTrack().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Track>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TrackResponse>>> =
                remoteDataSource.getAllTracks()

            override fun saveCallResult(data: List<TrackResponse>) {
                val trackList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTrack(trackList)
            }
        }.asLiveData()

    fun getFavoriteTrack(): LiveData<List<Track>> {
        return localDataSource.getFavoriteTrack().map { DataMapper.mapEntitiesToDomain(it) }
    }

    fun setFavoriteTrack(track: Track, state: Boolean) {
        val trackEntity = DataMapper.mapDomainToEntity(track)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTrack(trackEntity, state) }
    }
}


package com.doanda.melodify.core.data

import com.doanda.melodify.core.data.source.local.LocalDataSource
import com.doanda.melodify.core.data.source.remote.RemoteDataSource
import com.doanda.melodify.core.data.source.remote.network.ApiResponse
import com.doanda.melodify.core.data.source.remote.response.TrackResponse
import com.doanda.melodify.core.domain.model.Track
import com.doanda.melodify.core.domain.repository.ITrackRepository
import com.doanda.melodify.core.utils.AppExecutors
import com.doanda.melodify.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrackRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITrackRepository{

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

    override fun getAllTracks(): Flow<Resource<List<Track>>> =
        object : NetworkBoundResource<List<Track>, List<TrackResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Track>> {
                return localDataSource.getAllTracks().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Track>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TrackResponse>>> =
                remoteDataSource.getAllTracks()

            override suspend fun saveCallResult(data: List<TrackResponse>) {
                val trackList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTrack(trackList)
            }
        }.asFlow()

    override fun getFavoriteTracks(): Flow<List<Track>> {
        return localDataSource.getFavoriteTracks().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTrack(track: Track, state: Boolean) {
        val trackEntity = DataMapper.mapDomainToEntity(track)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTrack(trackEntity, state) }
    }
}


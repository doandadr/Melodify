package com.doanda.melodify.core.data.source.remote

import android.util.Log
import com.doanda.melodify.core.data.source.remote.network.ApiResponse
import com.doanda.melodify.core.data.source.remote.network.ApiService
import com.doanda.melodify.core.data.source.remote.response.TrackResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllTracks(): Flow<ApiResponse<List<TrackResponse>>> {
        return flow {
            try {
                val response = apiService.getTracks()
                val dataArray = response.tracks.data
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.tracks.data))

                } else {
                    emit(ApiResponse.Empty)
                }
            } catch( e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}


package com.doanda.melodify.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doanda.melodify.core.data.source.remote.network.ApiResponse
import com.doanda.melodify.core.data.source.remote.network.ApiService
import com.doanda.melodify.core.data.source.remote.response.TrackResponse
import com.doanda.melodify.core.data.source.remote.response.TracksResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllTracks(): LiveData<ApiResponse<List<TrackResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<TrackResponse>>>()

        //get data from remote api
        val client = apiService.getTracks()

        client.enqueue(object : Callback<TracksResponse> {
            override fun onResponse(
                call: Call<TracksResponse>,
                response: Response<TracksResponse>
            ) {
                val dataArray = response.body()?.tracks?.data
                resultData.value = if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<TracksResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}


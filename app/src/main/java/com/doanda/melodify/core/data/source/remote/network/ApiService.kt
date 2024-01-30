package com.doanda.melodify.core.data.source.remote.network

import com.doanda.melodify.core.data.source.remote.response.TracksResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("chart")
    fun getTracks(): Call<TracksResponse>
}
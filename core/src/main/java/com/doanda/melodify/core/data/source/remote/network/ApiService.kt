package com.doanda.melodify.core.data.source.remote.network

import com.doanda.melodify.core.data.source.remote.response.TracksResponse
import retrofit2.http.GET

interface ApiService {
    @GET("chart")
    suspend fun getTracks(): TracksResponse
}
package com.doanda.melodify.core.di

import android.content.Context
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.data.source.local.LocalDataSource
import com.doanda.melodify.core.data.source.local.room.TrackDatabase
import com.doanda.melodify.core.data.source.remote.RemoteDataSource
import com.doanda.melodify.core.data.source.remote.network.ApiConfig
import com.doanda.melodify.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): TrackRepository {
        val database = TrackDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.trackDao())
        val appExecutors = AppExecutors()

        return TrackRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}

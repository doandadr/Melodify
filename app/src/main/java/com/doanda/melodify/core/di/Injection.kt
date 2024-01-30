package com.doanda.melodify.core.di

import android.content.Context
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.data.source.local.LocalDataSource
import com.doanda.melodify.core.data.source.local.room.TrackDatabase
import com.doanda.melodify.core.data.source.remote.RemoteDataSource
import com.doanda.melodify.core.data.source.remote.network.ApiConfig
import com.doanda.melodify.core.domain.repository.ITrackRepository
import com.doanda.melodify.core.domain.usecase.TrackInteractor
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import com.doanda.melodify.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ITrackRepository {
        val database = TrackDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.trackDao())
        val appExecutors = AppExecutors()

        return TrackRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTrackUseCase(context: Context): TrackUseCase {
        val repository = provideRepository(context)
        return TrackInteractor(repository)
    }
}


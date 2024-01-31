package com.doanda.melodify.core.di

import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.domain.repository.ITrackRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(trackRepository: TrackRepository): ITrackRepository
}
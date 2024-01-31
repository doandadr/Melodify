package com.doanda.melodify.di

import com.doanda.melodify.core.domain.usecase.TrackInteractor
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTrackUseCase(trackInteractor: TrackInteractor): TrackUseCase
}
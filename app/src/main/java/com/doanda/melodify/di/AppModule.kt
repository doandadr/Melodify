package com.doanda.melodify.di

import com.doanda.melodify.core.domain.usecase.TrackInteractor
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideTrackUseCase(trackInteractor: TrackInteractor): TrackUseCase
}
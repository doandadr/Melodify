package com.doanda.melodify.favorite.di

import com.doanda.melodify.core.domain.usecase.TrackInteractor
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class FavoriteModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTrackUseCase(trackInteractor: TrackInteractor): TrackUseCase
}
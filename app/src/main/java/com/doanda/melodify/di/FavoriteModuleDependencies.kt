package com.doanda.melodify.di

import com.doanda.melodify.core.domain.usecase.TrackUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun trackUseCase(): TrackUseCase
}
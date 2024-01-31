package com.doanda.melodify.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doanda.melodify.ui.ViewModelFactory
import com.doanda.melodify.ui.favorite.FavoriteViewModel
import com.doanda.melodify.ui.home.HomeViewModel
import com.doanda.melodify.ui.track.TrackViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract  fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrackViewModel::class)
    abstract fun bindTrackViewModel(viewModel: TrackViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
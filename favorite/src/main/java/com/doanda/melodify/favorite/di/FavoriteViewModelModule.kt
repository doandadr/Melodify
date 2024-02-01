package com.doanda.melodify.favorite.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doanda.melodify.di.ViewModelKey
import com.doanda.melodify.favorite.ViewModelFactory
import com.doanda.melodify.favorite.ui.FavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class FavoriteViewModelModule {

    @Binds
    abstract  fun bindFavoriteViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

}
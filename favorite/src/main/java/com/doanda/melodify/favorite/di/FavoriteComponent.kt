package com.doanda.melodify.favorite.di

import com.doanda.melodify.core.di.CoreComponent
import com.doanda.melodify.di.AppModule
import com.doanda.melodify.favorite.ui.FavoriteFragment
import dagger.Component

@FavoriteAppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, FavoriteViewModelModule::class]
)
interface FavoriteComponent {
    fun inject(fragment: FavoriteFragment)
}
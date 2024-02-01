package com.doanda.melodify.favorite.di

import android.content.Context
import com.doanda.melodify.di.FavoriteModuleDependencies
import com.doanda.melodify.favorite.ui.FavoriteFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context) :Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}
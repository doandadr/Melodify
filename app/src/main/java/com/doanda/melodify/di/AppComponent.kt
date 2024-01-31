package com.doanda.melodify.di

import com.doanda.melodify.core.di.CoreComponent
import com.doanda.melodify.ui.favorite.FavoriteFragment
import com.doanda.melodify.ui.home.HomeFragment
import com.doanda.melodify.ui.track.TrackActivity
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: TrackActivity)
}
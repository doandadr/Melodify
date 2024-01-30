package com.doanda.melodify.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.di.Injection
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import com.doanda.melodify.ui.favorite.FavoriteViewModel
import com.doanda.melodify.ui.home.HomeViewModel
import com.doanda.melodify.ui.track.TrackViewModel

class ViewModelFactory private constructor(private val trackUseCase: TrackUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                    instance
                        ?: ViewModelFactory(
                            Injection.provideTrackUseCase(context)
                        )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(trackUseCase) as T
            }

            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(trackUseCase) as T
            }

            modelClass.isAssignableFrom(TrackViewModel::class.java) -> {
                TrackViewModel(trackUseCase) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}
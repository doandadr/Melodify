package com.doanda.melodify.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.di.Injection
import com.doanda.melodify.ui.favorite.FavoriteViewModel
import com.doanda.melodify.ui.home.HomeViewModel
import com.doanda.melodify.ui.track.TrackViewModel

class ViewModelFactory private constructor(private val trackRepository: TrackRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                instance
                    ?: ViewModelFactory(
                        Injection.provideRepository(
                            context
                        )
                    )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(trackRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(trackRepository) as T
            }
            modelClass.isAssignableFrom(TrackViewModel::class.java) -> {
                TrackViewModel(trackRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}
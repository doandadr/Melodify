package com.doanda.melodify.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import com.doanda.melodify.favorite.ui.FavoriteViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val trackUseCase: TrackUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(trackUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}
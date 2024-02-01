package com.doanda.melodify.koin

import com.doanda.melodify.core.domain.usecase.TrackInteractor
import com.doanda.melodify.core.domain.usecase.TrackUseCase
import com.doanda.melodify.ui.home.HomeViewModel
import com.doanda.melodify.ui.track.TrackViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TrackUseCase> { TrackInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { TrackViewModel(get()) }
}
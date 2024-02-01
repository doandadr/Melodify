package com.doanda.melodify

import android.app.Application
import com.doanda.melodify.core.koin.databaseModule
import com.doanda.melodify.core.koin.networkModule
import com.doanda.melodify.core.koin.repositoryModule
import com.doanda.melodify.koin.useCaseModule
import com.doanda.melodify.koin.viewModelModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )


            )
        }
    }
}

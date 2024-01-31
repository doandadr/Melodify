package com.doanda.melodify.core.di

import android.content.Context
import androidx.room.Room
import com.doanda.melodify.core.data.source.local.room.TrackDao
import com.doanda.melodify.core.data.source.local.room.TrackDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) : TrackDatabase = Room.databaseBuilder(
        context,
        TrackDatabase::class.java,
        "track.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTrackDao(database: TrackDatabase) : TrackDao = database.trackDao()


}
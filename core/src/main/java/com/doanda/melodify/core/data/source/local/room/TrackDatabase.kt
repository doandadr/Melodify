package com.doanda.melodify.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.doanda.melodify.core.data.source.local.entity.TrackEntity

@Database(entities = [TrackEntity::class], version = 1, exportSchema = false)
abstract class TrackDatabase : RoomDatabase() {

    abstract fun trackDao(): TrackDao
}
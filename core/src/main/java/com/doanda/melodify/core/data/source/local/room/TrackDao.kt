package com.doanda.melodify.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {
    @Query("SELECT * FROM track")
    fun getAllTracks(): Flow<List<TrackEntity>>

    @Query("SELECT * FROM track WHERE id = :id")
    fun getTrackById(id: Int): Flow<TrackEntity>

    @Query("SELECT * FROM track where is_favorite = 1")
    fun getFavoriteTracks(): Flow<List<TrackEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrack(track: List<TrackEntity>)

    @Update
    fun updateFavoriteTrack(track: TrackEntity)
}
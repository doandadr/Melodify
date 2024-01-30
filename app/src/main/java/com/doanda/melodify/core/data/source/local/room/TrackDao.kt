package com.doanda.melodify.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.doanda.melodify.core.data.source.local.entity.TrackEntity

@Dao
interface TrackDao {
    @Query("SELECT * FROM track")
    fun getAllTracks(): LiveData<List<TrackEntity>>

    @Query("SELECT * FROM track WHERE id = :id")
    fun getTrackById(id: Int): LiveData<TrackEntity>

    @Query("SELECT * FROM track where is_favorite = 1")
    fun getFavoriteTracks(): LiveData<List<TrackEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(track: List<TrackEntity>)

    @Update
    fun updateFavoriteTrack(track: TrackEntity)
}
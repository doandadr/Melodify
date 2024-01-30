package com.doanda.melodify.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "track")
data class TrackEntity(
    @PrimaryKey
    @ColumnInfo("id"             ) val id            : Int,
    @ColumnInfo("title"          ) val title         : String,
    @ColumnInfo("description"    ) val description   : String,
    @ColumnInfo("available"      ) val available     : Boolean,
    @ColumnInfo("fans"           ) val fans          : Int,
    @ColumnInfo("link"           ) val link          : String,
    @ColumnInfo("share"          ) val share         : String,
    @ColumnInfo("picture"        ) val picture       : String,
    @ColumnInfo("picture_small"  ) val pictureSmall  : String,
    @ColumnInfo("picture_medium" ) val pictureMedium : String,
    @ColumnInfo("picture_big"    ) val pictureBig    : String,
    @ColumnInfo("picture_xl"     ) val pictureXl     : String,
    @ColumnInfo("type"           ) val type          : String,
    @ColumnInfo("is_favorite"    ) var isFavorite    : Boolean = false,
) : Parcelable

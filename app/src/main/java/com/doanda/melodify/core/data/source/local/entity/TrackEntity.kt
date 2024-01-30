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
    @ColumnInfo("id"                      ) val id                    : Int,
    @ColumnInfo("title"                   ) val title                 : String,
    @ColumnInfo("title_short"             ) val titleShort            : String,
    @ColumnInfo("title_version"           ) val titleVersion          : String,
    @ColumnInfo("link"                    ) val link                  : String,
    @ColumnInfo("duration"                ) val duration              : Int,
    @ColumnInfo("rank"                    ) val rank                  : Int,
    @ColumnInfo("explicit_lyrics"         ) val explicitLyrics        : Boolean,
    @ColumnInfo("explicit_content_lyrics" ) val explicitContentLyrics : Int,
    @ColumnInfo("explicit_content_cover"  ) val explicitContentCover  : Int,
    @ColumnInfo("preview"                 ) val preview               : String,
    @ColumnInfo("md5_image"               ) val md5Image              : String,
    @ColumnInfo("position"                ) val position              : Int,
    @ColumnInfo("artist_id"               ) val artistId              : Int,
    @ColumnInfo("artist_name"             ) val artistName            : String,
    @ColumnInfo("artist_picture"          ) val artistPicture         : String,
    @ColumnInfo("album_id"                ) val albumId               : Int,
    @ColumnInfo("album_name"              ) val albumTitle            : String,
    @ColumnInfo("album_cover"             ) val albumCover            : String,
    @ColumnInfo("type"                    ) val type                  : String,
    @ColumnInfo("is_favorite"             ) var isFavorite            : Boolean  = false,

) : Parcelable






















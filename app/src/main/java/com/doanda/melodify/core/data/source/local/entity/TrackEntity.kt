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
    @ColumnInfo("id"                      ) var id                    : Int,
    @ColumnInfo("title"                   ) var title                 : String,
    @ColumnInfo("title_short"             ) var titleShort            : String,
    @ColumnInfo("title_version"           ) var titleVersion          : String,
    @ColumnInfo("link"                    ) var link                  : String,
    @ColumnInfo("duration"                ) var duration              : Int,
    @ColumnInfo("rank"                    ) var rank                  : Int,
    @ColumnInfo("explicit_lyrics"         ) var explicitLyrics        : Boolean,
    @ColumnInfo("explicit_content_lyrics" ) var explicitContentLyrics : Int,
    @ColumnInfo("explicit_content_cover"  ) var explicitContentCover  : Int,
    @ColumnInfo("preview"                 ) var preview               : String,
    @ColumnInfo("md5_image"               ) var md5Image              : String,
    @ColumnInfo("position"                ) var position              : Int,
    @ColumnInfo("artist_id"               ) var artistId              : String,
    @ColumnInfo("artist_name"             ) var artistName            : String,
    @ColumnInfo("artist_picture"          ) var artistPicture         : Int,
    @ColumnInfo("album_id"                ) var albumId               : Int,
    @ColumnInfo("album_name"              ) var albumTitle            : String,
    @ColumnInfo("album_cover"             ) var albumCover            : String,
    @ColumnInfo("type"                    ) var type                  : String,
    @ColumnInfo("is_favorite"             ) var isFavorite            : Boolean  = false,

) : Parcelable

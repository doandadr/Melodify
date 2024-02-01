package com.doanda.melodify.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Track (
    val id                    : Long,
    val title                 : String,
    val titleShort            : String,
    val titleVersion          : String,
    val link                  : String,
    val duration              : Int,
    val rank                  : Int,
    val explicitLyrics        : Boolean,
    val explicitContentLyrics : Int,
    val explicitContentCover  : Int,
    val preview               : String,
    val md5Image              : String,
    val position              : Int,
    val artistId              : Int,
    val artistName            : String,
    val artistPicture         : String,
    val albumId               : Int,
    val albumTitle            : String,
    val albumCover            : String,
    val type                  : String,
    var isFavorite            : Boolean,
) : Parcelable
package com.doanda.melodify.core.data.source.remote.response.track

import com.google.gson.annotations.SerializedName

data class TrackAlbum(

    @field:SerializedName("cover")
    val cover: String,

    @field:SerializedName("md5_image")
    val md5Image: String,

    @field:SerializedName("tracklist")
    val tracklist: String,

    @field:SerializedName("cover_xl")
    val coverXl: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("cover_medium")
    val coverMedium: String,

    @field:SerializedName("link")
    val link: String,

    @field:SerializedName("cover_small")
    val coverSmall: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("cover_big")
    val coverBig: String
)
package com.doanda.melodify.core.data.source.remote.response.chart

import com.google.gson.annotations.SerializedName

data class ChartAlbum(

    @field:SerializedName("cover")
    val cover: String,

    @field:SerializedName("md5_image")
    val md5Image: String,

    @field:SerializedName("tracklist")
    val tracklist: String,

    @field:SerializedName("cover_xl")
    val coverXl: String,

    @field:SerializedName("cover_medium")
    val coverMedium: String,

    @field:SerializedName("cover_small")
    val coverSmall: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("cover_big")
    val coverBig: String
)
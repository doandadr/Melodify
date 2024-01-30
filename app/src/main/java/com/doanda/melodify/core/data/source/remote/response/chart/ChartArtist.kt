package com.doanda.melodify.core.data.source.remote.response.chart

import com.google.gson.annotations.SerializedName

data class ChartArtist(

    @field:SerializedName("picture_xl")
    val pictureXl: String,

    @field:SerializedName("tracklist")
    val tracklist: String,

    @field:SerializedName("picture_big")
    val pictureBig: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("link")
    val link: String,

    @field:SerializedName("picture_small")
    val pictureSmall: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("picture")
    val picture: String,

    @field:SerializedName("picture_medium")
    val pictureMedium: String,

    @field:SerializedName("radio")
    val radio: Boolean
)
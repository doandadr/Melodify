package com.doanda.melodify.core.data.source.remote.response.chart

import com.google.gson.annotations.SerializedName

data class TrackData(

    @field:SerializedName("preview")
    val preview: String,

    @field:SerializedName("md5_image")
    val md5Image: String,

    @field:SerializedName("artist")
    val artist: ChartArtist,

    @field:SerializedName("album")
    val album: ChartAlbum,

    @field:SerializedName("link")
    val link: String,

    @field:SerializedName("explicit_content_cover")
    val explicitContentCover: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("title_version")
    val titleVersion: String,

    @field:SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("title_short")
    val titleShort: String,

    @field:SerializedName("duration")
    val duration: Int,

    @field:SerializedName("rank")
    val rank: Int,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int,

    @field:SerializedName("position")
    val position: Int
)
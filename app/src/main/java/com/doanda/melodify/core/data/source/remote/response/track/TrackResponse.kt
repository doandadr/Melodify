package com.doanda.melodify.core.data.source.remote.response.track

import com.google.gson.annotations.SerializedName

data class TrackResponse(

    @field:SerializedName("preview")
    val preview: String,

    @field:SerializedName("md5_image")
    val md5Image: String,

    @field:SerializedName("artist")
    val artist: TrackArtist,

    @field:SerializedName("link")
    val link: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("type")
    val type: String,

    @field:SerializedName("gain")
    val gain: Double,

    @field:SerializedName("duration")
    val duration: String,

    @field:SerializedName("rank")
    val rank: String,

    @field:SerializedName("share")
    val share: String,

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int,

    @field:SerializedName("track_position")
    val trackPosition: Int,

    @field:SerializedName("bpm")
    val bpm: Double,

    @field:SerializedName("readable")
    val readable: Boolean,

    @field:SerializedName("album")
    val album: TrackAlbum,

    @field:SerializedName("explicit_content_cover")
    val explicitContentCover: Int,

    @field:SerializedName("isrc")
    val isrc: String,

    @field:SerializedName("title_version")
    val titleVersion: String,

    @field:SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean,

    @field:SerializedName("title_short")
    val titleShort: String,

    @field:SerializedName("disk_number")
    val diskNumber: Int,

    @field:SerializedName("available_countries")
    val availableCountries: List<String>,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("contributors")
    val contributors: List<Contributor>
)
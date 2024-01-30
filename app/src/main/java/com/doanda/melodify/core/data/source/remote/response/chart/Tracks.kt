package com.doanda.melodify.core.data.source.remote.response.chart

import com.google.gson.annotations.SerializedName

data class Tracks(

    @field:SerializedName("total")
    val total: Int,

    @field:SerializedName("data")
    val data: List<TrackData>
)
package com.doanda.melodify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TracksData (

    @SerializedName("data"  ) var data  : List<TrackResponse>,
    @SerializedName("total" ) var total : Int
)
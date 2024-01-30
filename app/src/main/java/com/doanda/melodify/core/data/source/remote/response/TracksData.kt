package com.doanda.melodify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TracksData (

    @SerializedName("data"  ) var data  : ArrayList<TrackResponse> = arrayListOf(),
    @SerializedName("total" ) var total : Int?            = null

)
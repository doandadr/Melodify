package com.doanda.melodify.core.data.source.remote.response.chart

import com.google.gson.annotations.SerializedName


data class Tracks (

  @SerializedName("data"  ) var data  : ArrayList<TrackData> = arrayListOf(),
  @SerializedName("total" ) var total : Int?            = null

)
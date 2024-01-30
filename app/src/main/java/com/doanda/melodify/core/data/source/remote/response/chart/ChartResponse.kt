package com.doanda.melodify.core.data.source.remote.response.chart

import com.google.gson.annotations.SerializedName


data class ChartResponse (

  @SerializedName("tracks"    ) var tracks    : Tracks?    = Tracks(),
)
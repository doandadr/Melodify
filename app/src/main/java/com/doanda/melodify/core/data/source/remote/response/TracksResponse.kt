package com.doanda.melodify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TracksResponse (

  @SerializedName("tracks"    ) var tracks    : TracksData?    = TracksData(),
)
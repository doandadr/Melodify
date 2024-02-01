package com.doanda.melodify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class Album (

  @SerializedName("id"           ) var id          : Int,
  @SerializedName("title"        ) var title       : String,
  @SerializedName("cover"        ) var cover       : String,
  @SerializedName("cover_small"  ) var coverSmall  : String,
  @SerializedName("cover_medium" ) var coverMedium : String,
  @SerializedName("cover_big"    ) var coverBig    : String,
  @SerializedName("cover_xl"     ) var coverXl     : String,
  @SerializedName("md5_image"    ) var md5Image    : String,
  @SerializedName("tracklist"    ) var tracklist   : String,
  @SerializedName("type"         ) var type        : String

)
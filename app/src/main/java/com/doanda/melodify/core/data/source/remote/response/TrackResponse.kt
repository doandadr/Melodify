package com.doanda.melodify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TrackResponse (

  @SerializedName("id"             ) var id            : Int,
  @SerializedName("title"          ) var title         : String?  = null,
  @SerializedName("description"    ) var description   : String?  = null,
  @SerializedName("available"      ) var available     : Boolean? = null,
  @SerializedName("fans"           ) var fans          : Int?     = null,
  @SerializedName("link"           ) var link          : String?  = null,
  @SerializedName("share"          ) var share         : String?  = null,
  @SerializedName("picture"        ) var picture       : String?  = null,
  @SerializedName("picture_small"  ) var pictureSmall  : String?  = null,
  @SerializedName("picture_medium" ) var pictureMedium : String?  = null,
  @SerializedName("picture_big"    ) var pictureBig    : String?  = null,
  @SerializedName("picture_xl"     ) var pictureXl     : String?  = null,
  @SerializedName("type"           ) var type          : String?  = null

)
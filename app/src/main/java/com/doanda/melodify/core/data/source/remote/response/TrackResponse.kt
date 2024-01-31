package com.doanda.melodify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TrackResponse (


  @SerializedName("id"                      ) var id                    : Long,
  @SerializedName("title"                   ) var title                 : String,
  @SerializedName("title_short"             ) var titleShort            : String,
  @SerializedName("title_version"           ) var titleVersion          : String,
  @SerializedName("link"                    ) var link                  : String,
  @SerializedName("duration"                ) var duration              : Int,
  @SerializedName("rank"                    ) var rank                  : Int,
  @SerializedName("explicit_lyrics"         ) var explicitLyrics        : Boolean,
  @SerializedName("explicit_content_lyrics" ) var explicitContentLyrics : Int,
  @SerializedName("explicit_content_cover"  ) var explicitContentCover  : Int,
  @SerializedName("preview"                 ) var preview               : String,
  @SerializedName("md5_image"               ) var md5Image              : String,
  @SerializedName("position"                ) var position              : Int,
  @SerializedName("artist"                  ) var artist                : Artist,
  @SerializedName("album"                   ) var album                 : Album,
  @SerializedName("type"                    ) var type                  : String

)
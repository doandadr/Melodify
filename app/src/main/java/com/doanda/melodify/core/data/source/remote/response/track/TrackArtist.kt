package com.doanda.melodify.core.data.source.remote.response.track

import com.google.gson.annotations.SerializedName


data class TrackArtist (

    @SerializedName("id"             ) var id            : String?  = null,
    @SerializedName("name"           ) var name          : String?  = null,
    @SerializedName("link"           ) var link          : String?  = null,
    @SerializedName("share"          ) var share         : String?  = null,
    @SerializedName("picture"        ) var picture       : String?  = null,
    @SerializedName("picture_small"  ) var pictureSmall  : String?  = null,
    @SerializedName("picture_medium" ) var pictureMedium : String?  = null,
    @SerializedName("picture_big"    ) var pictureBig    : String?  = null,
    @SerializedName("picture_xl"     ) var pictureXl     : String?  = null,
    @SerializedName("radio"          ) var radio         : Boolean? = null,
    @SerializedName("tracklist"      ) var tracklist     : String?  = null,
    @SerializedName("type"           ) var type          : String?  = null

)
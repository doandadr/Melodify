package com.doanda.melodify.core.data.source.remote.response.track

import com.google.gson.annotations.SerializedName


data class TrackResponse (

    @SerializedName("id"                      ) var id                    : String?                 = null,
    @SerializedName("readable"                ) var readable              : Boolean?                = null,
    @SerializedName("title"                   ) var title                 : String?                 = null,
    @SerializedName("title_short"             ) var titleShort            : String?                 = null,
    @SerializedName("title_version"           ) var titleVersion          : String?                 = null,
    @SerializedName("isrc"                    ) var isrc                  : String?                 = null,
    @SerializedName("link"                    ) var link                  : String?                 = null,
    @SerializedName("share"                   ) var share                 : String?                 = null,
    @SerializedName("duration"                ) var duration              : String?                 = null,
    @SerializedName("track_position"          ) var trackPosition         : Int?                    = null,
    @SerializedName("disk_number"             ) var diskNumber            : Int?                    = null,
    @SerializedName("rank"                    ) var rank                  : String?                 = null,
    @SerializedName("release_date"            ) var releaseDate           : String?                 = null,
    @SerializedName("explicit_lyrics"         ) var explicitLyrics        : Boolean?                = null,
    @SerializedName("explicit_content_lyrics" ) var explicitContentLyrics : Int?                    = null,
    @SerializedName("explicit_content_cover"  ) var explicitContentCover  : Int?                    = null,
    @SerializedName("preview"                 ) var preview               : String?                 = null,
    @SerializedName("bpm"                     ) var bpm                   : Double?                 = null,
    @SerializedName("gain"                    ) var gain                  : Double?                 = null,
    @SerializedName("available_countries"     ) var availableCountries    : ArrayList<String>       = arrayListOf(),
    @SerializedName("md5_image"               ) var md5Image              : String?                 = null,
    @SerializedName("artist"                  ) var artist                : TrackArtist?            = TrackArtist(),
    @SerializedName("album"                   ) var album                 : TrackAlbum?             = TrackAlbum(),
    @SerializedName("type"                    ) var type                  : String?                 = null

)
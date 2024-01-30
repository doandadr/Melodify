package com.doanda.melodify.core.utils

import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.core.data.source.remote.response.TrackResponse


object DataMapper {
    fun mapResponsesToEntities(input: List<TrackResponse>): List<TrackEntity> {
        val trackList = ArrayList<TrackEntity>()
        input.map {
            val track = TrackEntity(
                id                    = it.id                   ,
                title                 = it.title                ,
                titleShort            = it.titleShort           ,
                titleVersion          = it.titleVersion         ,
                link                  = it.link                 ,
                duration              = it.duration             ,
                rank                  = it.rank                 ,
                explicitLyrics        = it.explicitLyrics       ,
                explicitContentLyrics = it.explicitContentLyrics,
                explicitContentCover  = it.explicitContentCover ,
                preview               = it.preview              ,
                md5Image              = it.md5Image             ,
                position              = it.position             ,
                artistId              = it.artist.id            ,
                artistName            = it.artist.name          ,
                artistPicture         = it.artist.pictureMedium ,
                albumId               = it.album.id             ,
                albumTitle            = it.album.title          ,
                albumCover            = it.album.coverMedium    ,
                type                  = it.type                 ,
                isFavorite            = false
            )
            trackList.add(track)
        }
        return trackList
    }
}
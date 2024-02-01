package com.doanda.melodify.core.utils

import android.text.format.DateUtils
import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.core.data.source.remote.response.TrackResponse
import com.doanda.melodify.core.domain.model.Track


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

    fun mapEntitiesToDomain(input: List<TrackEntity>): List<Track> =
        input.map {
            Track(
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
                artistId              = it.artistId             ,
                artistName            = it.artistName           ,
                artistPicture         = it.artistPicture        ,
                albumId               = it.albumId              ,
                albumTitle            = it.albumTitle           ,
                albumCover            = it.albumCover           ,
                type                  = it.type                 ,
                isFavorite            = it.isFavorite           ,
            )
        }
    fun mapDomainToEntity(input: Track) = TrackEntity(
        id                    = input.id                   ,
        title                 = input.title                ,
        titleShort            = input.titleShort           ,
        titleVersion          = input.titleVersion         ,
        link                  = input.link                 ,
        duration              = input.duration             ,
        rank                  = input.rank                 ,
        explicitLyrics        = input.explicitLyrics       ,
        explicitContentLyrics = input.explicitContentLyrics,
        explicitContentCover  = input.explicitContentCover ,
        preview               = input.preview              ,
        md5Image              = input.md5Image             ,
        position              = input.position             ,
        artistId              = input.artistId             ,
        artistName            = input.artistName           ,
        artistPicture         = input.artistPicture        ,
        albumId               = input.albumId              ,
        albumTitle            = input.albumTitle           ,
        albumCover            = input.albumCover           ,
        type                  = input.type                 ,
        isFavorite            = input.isFavorite           ,
    )

    fun formatDuration(seconds: Int) : String {
        return DateUtils.formatElapsedTime(seconds.toLong())
    }
}
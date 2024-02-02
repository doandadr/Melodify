package com.doanda.melodify.core.dummy_data

import com.doanda.melodify.core.data.source.local.entity.TrackEntity
import com.doanda.melodify.core.data.source.remote.response.Album
import com.doanda.melodify.core.data.source.remote.response.Artist
import com.doanda.melodify.core.data.source.remote.response.TrackResponse
import com.doanda.melodify.core.domain.model.Track

val testArtist: Artist = Artist(
    id = 190314217,
    name = "British Squad",
    link = "https://www.deezer.com/artist/190314217",
    picture = "https://api.deezer.com/artist/190314217/image",
    pictureSmall = "https://e-cdns-images.dzcdn.net/images/artist/c0077b47ecb593b7d3639ca57fce28a8/56x56-000000-80-0-0.jpg",
    pictureMedium = "https://e-cdns-images.dzcdn.net/images/artist/c0077b47ecb593b7d3639ca57fce28a8/250x250-000000-80-0-0.jpg",
    pictureBig = "https://e-cdns-images.dzcdn.net/images/artist/c0077b47ecb593b7d3639ca57fce28a8/500x500-000000-80-0-0.jpg",
    pictureXl = "https://e-cdns-images.dzcdn.net/images/artist/c0077b47ecb593b7d3639ca57fce28a8/1000x1000-000000-80-0-0.jpg",
    radio = true,
    tracklist = "https://api.deezer.com/artist/190314217/top?limit=50",
    type = "artist",
)

val testAlbum: Album = Album(
    id = 377036017,
    title = "Ain't No Liar",
    cover = "https://api.deezer.com/album/377036017/image",
    coverSmall = "https://e-cdns-images.dzcdn.net/images/cover/c0077b47ecb593b7d3639ca57fce28a8/56x56-000000-80-0-0.jpg",
    coverMedium = "https://e-cdns-images.dzcdn.net/images/cover/c0077b47ecb593b7d3639ca57fce28a8/250x250-000000-80-0-0.jpg",
    coverBig = "https://e-cdns-images.dzcdn.net/images/cover/c0077b47ecb593b7d3639ca57fce28a8/500x500-000000-80-0-0.jpg",
    coverXl = "https://e-cdns-images.dzcdn.net/images/cover/c0077b47ecb593b7d3639ca57fce28a8/1000x1000-000000-80-0-0.jpg",
    md5Image = "c0077b47ecb593b7d3639ca57fce28a8",
    tracklist = "https://api.deezer.com/album/377036017/tracks",
    type = "album",
)

val testTrackResponse: TrackResponse = TrackResponse(
    id = 2023385527,
    title = "Ain't No Liar",
    titleShort = "Ain't No Liar",
    titleVersion = "1",
    link = "https://www.deezer.com/track/2023385527",
    duration = 127,
    rank = 527087,
    explicitLyrics = false,
    explicitContentLyrics = 0,
    explicitContentCover = 0,
    preview = "https://cdns-preview-8.dzcdn.net/stream/c-8ae384fecf6383cfa878b89a0229f122-3.mp3",
    md5Image = "c0077b47ecb593b7d3639ca57fce28a8",
    position = 1,
    artist = testArtist,
    album = testAlbum,
    type = "track",
)

val testTrackEntity: TrackEntity = TrackEntity(
    id = 2023385527,
    title = "Ain't No Liar",
    titleShort = "Ain't No Liar",
    titleVersion = "1",
    link = "https://www.deezer.com/track/2023385527",
    duration = 127,
    rank = 527087,
    explicitLyrics = false,
    explicitContentLyrics = 0,
    explicitContentCover = 0,
    preview = "https://cdns-preview-8.dzcdn.net/stream/c-8ae384fecf6383cfa878b89a0229f122-3.mp3",
    md5Image = "c0077b47ecb593b7d3639ca57fce28a8",
    position = 1,
    artistId = 190314217,
    artistName = "British Squad",
    artistPicture = "https://e-cdns-images.dzcdn.net/images/artist/c0077b47ecb593b7d3639ca57fce28a8/250x250-000000-80-0-0.jpg",
    albumId = 377036017,
    albumTitle = "Ain't No Liar",
    albumCover = "https://e-cdns-images.dzcdn.net/images/cover/c0077b47ecb593b7d3639ca57fce28a8/250x250-000000-80-0-0.jpg",
    type = "track",
    isFavorite = false
)

val testTrack: Track = Track(
    id = 2023385527,
    title = "Ain't No Liar",
    titleShort = "Ain't No Liar",
    titleVersion = "1",
    link = "https://www.deezer.com/track/2023385527",
    duration = 127,
    rank = 527087,
    explicitLyrics = false,
    explicitContentLyrics = 0,
    explicitContentCover = 0,
    preview = "https://cdns-preview-8.dzcdn.net/stream/c-8ae384fecf6383cfa878b89a0229f122-3.mp3",
    md5Image = "c0077b47ecb593b7d3639ca57fce28a8",
    position = 1,
    artistId = 190314217,
    artistName = "British Squad",
    artistPicture = "https://e-cdns-images.dzcdn.net/images/artist/c0077b47ecb593b7d3639ca57fce28a8/250x250-000000-80-0-0.jpg",
    albumId = 377036017,
    albumTitle = "Ain't No Liar",
    albumCover = "https://e-cdns-images.dzcdn.net/images/cover/c0077b47ecb593b7d3639ca57fce28a8/250x250-000000-80-0-0.jpg",
    type = "track",
    isFavorite = false,
)

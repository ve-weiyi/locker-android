package com.ve.lib_api.model.playlist

import androidx.room.Entity

/**
 * 用来存储 日推 的greendao bean
 */
@Entity
class DRGreenDaoBean {
    var songId: String? = null
    var duration: Long = 0
    var songCover: String? = null
    var artist: String? = null
    var songName: String? = null
    var songUrl: String? = null
    var artistId: String? = null
    var artistAvatar: String? = null

    constructor(
        songId: String?, duration: Long, songCover: String?,
        artist: String?, songName: String?, songUrl: String?, artistId: String?,
        artistAvatar: String?
    ) {
        this.songId = songId
        this.duration = duration
        this.songCover = songCover
        this.artist = artist
        this.songName = songName
        this.songUrl = songUrl
        this.artistId = artistId
        this.artistAvatar = artistAvatar
    }

    constructor() {}
}
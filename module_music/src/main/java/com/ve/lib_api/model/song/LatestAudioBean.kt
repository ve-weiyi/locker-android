package com.ve.lib_api.model.song

import androidx.room.*

/**
 * 最近播放的歌曲实体
 */
@Entity
class LatestAudioBean {
    @Ignore
    constructor(
        id: String?, url: String?, name: String?, author: String?,
        album: String?, albumInfo: String?, albumPic: String?,
        totalTime: String?
    ) {
        this.id = id
        mUrl = url
        this.name = name
        this.author = author
        this.album = album
        this.albumInfo = albumInfo
        this.albumPic = albumPic
        this.totalTime = totalTime
    }

    constructor() {}

    @PrimaryKey(autoGenerate = true)
    var uid = 0

    //歌曲Id
    @ColumnInfo(name = "song_id")
    var id: String? = null

    //地址
    @ColumnInfo(name = "song_url")
    var mUrl: String? = null
        get() = field
        set(mUrl) {
            field = mUrl
        }

    //歌名
    @ColumnInfo(name = "song_name")
    var name: String? = null

    //作者
    @ColumnInfo(name = "song_author")
    var author: String? = null

    //所属专辑
    @ColumnInfo(name = "song_album")
    var album: String? = null

    @ColumnInfo(name = "song_albumInfo")
    var albumInfo: String? = null

    //专辑封面
    @ColumnInfo(name = "song_albumPic")
    var albumPic: String? = null

    //时长
    @ColumnInfo(name = "song_totaltime")
    var totalTime: String? = null

    // 最近播放的类型 歌曲 视频 电台 备用 TODO
    @ColumnInfo(name = "audio_type")
    var type = 0
    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
        return if (other !is AudioBean) {
            false
        } else (other as LatestAudioBean).id == id
    }

    override fun toString(): String {
        return "AudioBean{" +
                "id='" + id + '\'' +
                ", Url='" + mUrl + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", album='" + album + '\'' +
                ", albumInfo='" + albumInfo + '\'' +
                ", albumPic='" + albumPic + '\'' +
                ", totalTime='" + totalTime + '\'' +
                '}'
    }

    companion object {
        @JvmStatic
        //将LatestAudioBean转化成AudioBean
        fun convertToAudioBean(item: LatestAudioBean): AudioBean {
            return AudioBean(item.id,
                item.mUrl!!,
                item.name!!,
                item.author!!,
                item.album!!,
                item.albumInfo!!,
                item.albumPic!!,
                item.totalTime!!)
        }
        @JvmStatic
        fun convertAudioToLatestBean(item: AudioBean): LatestAudioBean {
            return LatestAudioBean(item.id,
                item.url,
                item.name,
                item.author,
                item.album,
                item.albumInfo,
                item.albumPic,
                item.totalTime)
        }
        @JvmStatic
        private fun getSongPlayUrl(id: Long): String {
            return "https://music.163.com/song/media/outer/url?id=$id.mp3"
        }
    }
}
package com.ve.lib_api.model.song

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.ve.lib_api.model.playlist.DailyRecommendBean
import java.text.SimpleDateFormat
import java.util.*

/**
 * 歌曲实体
 */
@Entity
class AudioBean {
    @Ignore
    constructor(
        id: String?, url: String?, name: String?, author: String?,
        album: String?, albumInfo: String?, albumPic: String?,
        totalTime: String?,
    ) {
        this.id = id
        this.url = url
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
    var url: String? = null

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
    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
        return if (other !is AudioBean) {
            false
        } else other.id == id
    }

    override fun toString(): String {
        return "AudioBean{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", album='" + album + '\'' +
                ", albumInfo='" + albumInfo + '\'' +
                ", albumPic='" + albumPic + '\'' +
                ", totalTime='" + totalTime + '\'' +
                '}'
    }


    companion object {
        //将歌单中的SongsBean转化成AudioBean
        fun convertSongToAudioBean(item: DailyRecommendSongsBean): AudioBean? {
            return AudioBean(item.id.toString(),
                getSongPlayUrl(item.id),
                item.name,
                item.ar!![0]!!.name,
                item.al!!.name,
                item.al!!.name,
                item.al!!.picUrl,
                SimpleDateFormat("mm:ss", Locale.getDefault()).format(item.dt))
        }

        //将动态中的RecommendBean转化成AudioBean
        fun convertSongToAudioBean(item: DailyRecommendBean.RecommendBean): AudioBean? {
            return AudioBean(item.id.toString(),
                getSongPlayUrl(item.id),
                item.name,
                item.artists!![0].name,
                item.album!!.name,
                item.album!!.name,
                item.album!!.picUrl,
                SimpleDateFormat("mm:ss", Locale.getDefault()).format(item.duration))
        }

        private fun getSongPlayUrl(id: Long): String {
            return "https://music.163.com/song/media/outer/url?id=$id.mp3"
        }
    }
}
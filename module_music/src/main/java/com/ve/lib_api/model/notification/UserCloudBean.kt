package com.ve.lib_api.model.notification

import com.ve.lib_api.model.song.DailyRecommendSongsBean

class UserCloudBean {
    private var count = 0
    var upgradeSign = 0
    var size: Long = 0
    var maxSize: Long = 0
    var isHasMore = false
    var code = 0
    var data: ArrayList<CloudSong>? = null
    fun getCount(): String {
        return "共" + count + "首"
    }

    fun setCount(count: Int) {
        this.count = count
    }

    class CloudSong {
        var album: String? = null
        var artist: String? = null
        var bitrate: String? = null
        var coverId: String? = null
        var songName: String? = null
        var songId: Long = 0
        var addTime: Long = 0
        var fileSize: Long = 0
        var fileName: String? = null
        var simpleSong: DailyRecommendSongsBean? = null
    }

    override fun toString(): String {
        return "UserCloudBean{" +
                "count=" + count +
                ", upgradeSign=" + upgradeSign +
                ", size=" + size +
                ", maxSize=" + maxSize +
                ", hasMore=" + isHasMore +
                ", code=" + code +
                ", data=" + data +
                '}'
    }
}
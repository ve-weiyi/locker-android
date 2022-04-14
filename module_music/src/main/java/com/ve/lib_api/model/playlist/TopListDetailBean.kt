package com.ve.lib_api.model.playlist

import com.ve.lib_api.model.user.UserEventBean

class TopListDetailBean {
    var code = 0
    var list: List<ListBean>? = null
    var artistToplist: ArtistToplist? = null
    var rewardToplist: RewardToplist? = null

    inner class ListBean {
        var subscribers: List<String>? = null
        var subscribed: String? = null
        var creator: String? = null
        var artists: String? = null
        var tracks: List<Tracks>? = null
        var updateFrequency: String? = null
        var backgroundCoverId = 0
        var backgroundCoverUrl: String? = null
        var titleImage = 0
        var titleImageUrl: String? = null
        var englishTitle: String? = null
        var opRecommend = false
        var recommendInfo: String? = null
        var adType = 0
        var trackNumberUpdateTime: Long = 0
        var createTime: Long = 0
        var highQuality = false
        var userId = 0
        var updateTime: Long = 0
        var coverImgId: Long = 0
        var newImported = false
        var anonimous = false
        var specialType = 0
        var totalDuration = 0
        var coverImgUrl: String? = null
        var trackCount = 0
        var commentThreadId: String? = null
        var privacy = 0
        var trackUpdateTime: Long = 0
        var playCount: Long = 0
        var subscribedCount: Long = 0
        var cloudTrackCount = 0
        var ordered = false
        var tags: List<String>? = null
        var description: String? = null
        var status = 0
        var name: String? = null
        var id: Long = 0
        var coverImgId_str: String? = null
        var toplistType: String? = null
    }

    class Tracks {
        var first: String? = null
        var second: String? = null
    }

    class Artists {
        var first: String? = null
        var second: String? = null
        var third: Long = 0
    }

    inner class ArtistToplist {
        var coverUrl: String? = null
        var artists: List<Artists>? = null
        var name: String? = null
        var upateFrequency: String? = null
        var position = 0
        var updateFrequency: String? = null
    }

    class Artist {
        var name: String? = null
        var id = 0
        var isFollowed = false
        var picId: String? = null
        var img1v1Id: String? = null
        var briefDesc: String? = null
        var picUrl: String? = null
        var img1v1Url: String? = null
        var albumSize = 0
        var alias: List<String>? = null
        var trans: String? = null
        var musicSize = 0
        var topicPerson = 0
    }

    inner class Album {
        var name: String? = null
        var id: Long = 0
        var type: String? = null
        var size = 0
        var picId: String? = null
        var blurPicUrl: String? = null
        var companyId = 0
        var pic: Long = 0
        var picUrl: String? = null
        var publishTime: Long = 0
        var description: String? = null
        var tags: String? = null
        var company: String? = null
        var briefDesc: String? = null
        var artist: Artist? = null
        var songs: List<String>? = null
        var alias: List<String>? = null
        var status = 0
        var copyrightId = 0
        var commentThreadId: String? = null
        var artists: List<Artists>? = null
        var subType: String? = null
        var transName: String? = null
        var mark = 0
        var picId_str: String? = null
        var info: UserEventBean.EventsBean.InfoBean? = null
    }

    class BMusic {
        var name: String? = null
        var id: Long = 0
        var size: Long = 0
        var extension: String? = null
        var sr = 0
        var dfsId = 0
        var bitrate: Long = 0
        var playTime: Long = 0
        var volumeDelta = 0
    }

    class RewardToplist {
        var coverUrl: String? = null
        var songs: List<DailyRecommendBean.RecommendBean>? = null
        var name: String? = null
        var position = 0
    }

    class HMusicBean {
        /**
         * name : null
         * id : 95291315
         * size : 8983164
         * extension : mp3
         * sr : 44100
         * dfsId : 0
         * bitrate : 320000
         * playTime : 224000
         * volumeDelta : -0.38
         */
        var name: Any? = null
        var id: Long = 0
        var size = 0
        var extension: String? = null
        var sr = 0
        var dfsId = 0
        var bitrate = 0
        var playTime = 0
        var volumeDelta = 0.0
    }

    class MMusic {
        var name: String? = null
        var id: Long = 0
        var size: Long = 0
        var extension: String? = null
        var sr = 0
        var dfsId = 0
        var bitrate: Long = 0
        var playTime: Long = 0
        var volumeDelta = 0
    }

    class LMusic {
        var name: String? = null
        var id: Long = 0
        var size: Long = 0
        var extension: String? = null
        var sr = 0
        var dfsId = 0
        var bitrate: Long = 0
        var playTime: Long = 0
        var volumeDelta = 0
    }
}
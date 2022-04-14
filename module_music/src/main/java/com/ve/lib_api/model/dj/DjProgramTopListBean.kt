package com.ve.lib_api.model.dj

import com.ve.lib_api.model.playlist.TopListDetailBean

class DjProgramTopListBean {
    var code = 0
    var updateTime: String? = null
    var list: ArrayList<List>? = null
    var toplist: ArrayList<List>? = null

    inner class List {
        var program: Program? = null
        var rank = 0
        var lastRank = 0
        var score: Long = 0
        var programFeeType = 0
    }

    inner class Program {
        var mainSong: MainSong? = null
        var songs: String? = null
        var dj: DjSubListBean.Dj? = null
        var blurCoverUrl: String? = null
        var radio: DjProgramBean.ProgramsBean.RadioBean? = null
        var duration: Long = 0
        var buyed = false
        var programDesc: String? = null
        var h5Links: String? = null
        var canReward = false
        var auditStatus = 0
        var videoInfo: String? = null
        var score = 0
        var liveInfo: String? = null
        var alg: String? = null
        var description: String? = null
        var commentThreadId: String? = null
        var smallLanguageAuditStatus = 0
        var createTime: Long = 0
        var serialNum = 0
        var feeScope = 0
        var pubStatus = 0
        var coverUrl: String? = null
        var bdAuditStatus = 0
        var channels: ArrayList<String>? = null
        var listenerCount: Long = 0
        var reward = false
        var subscribedCount = 0
        var titbits: String? = null
        var programFeeType = 0
        var mainTrackId: Long = 0
        var titbitImages: String? = null
        var isPublish = false
        var trackCount = 0
        var name: String? = null
        var id: Long = 0
        var subscribed = false
        var shareCount = 0
        var likedCount = 0
        var commentCount = 0
    }

    class MainSong {
        var name: String? = null
        var id: Long = 0
        var position = 0
        var alias: ArrayList<String>? = null
        var status = 0
        var fee = 0
        var copyrightId = 0
        var disc: String? = null
        var no = 0
        var artists: ArrayList<TopListDetailBean.Artists>? = null
        var album: TopListDetailBean.Album? = null
        var starred = false
        var popularity = 0
        var score = 0
        var starredNum = 0
        var duration: Long = 0
        var playedNum = 0
        var dayPlays = 0
        var hearTime = 0
        var ringtone: String? = null
        var crbt: String? = null
        var audition: String? = null
        var copyFrom: String? = null
        var commentThreadId: String? = null
        var rtUrl: String? = null
        var ftype = 0
        var rtUrls: ArrayList<String>? = null
        var hMusic: TopListDetailBean.HMusicBean? = null
        var mMusic: TopListDetailBean.MMusic? = null
        var lMusic: TopListDetailBean.LMusic? = null
        var bMusic: TopListDetailBean.BMusic? = null
        var mp3Url: String? = null
        var rtype = 0
        var rurl: String? = null
        var mvid = 0
    }
}
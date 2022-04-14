package com.ve.lib_api.model.album

import com.ve.lib_api.model.search.AlbumSearchBean
import com.ve.lib_api.model.song.DailyRecommendSongsBean

class AlbumDetailBean {
    var code = 0
    var isOnSale = false
    var isSub = false
    var subTime: Long = 0
    var albumGameInfo: Any? = null
    private var commentCount = 0
    var likedCount = 0
    private var shareCount = 0
    private var subCount = 0
    var album: AlbumSearchBean.ResultBean.AlbumsBean? = null
    var songs: ArrayList<DailyRecommendSongsBean>? = null
    fun getCommentCount(): String {
        return commentCount.toString()
    }

    fun setCommentCount(commentCount: Int) {
        this.commentCount = commentCount
    }

    fun getShareCount(): String {
        return shareCount.toString()
    }

    fun setShareCount(shareCount: Int) {
        this.shareCount = shareCount
    }

    fun getSubCount(): String {
        return subCount.toString()
    }

    fun setSubCount(subCount: Int) {
        this.subCount = subCount
    }
}
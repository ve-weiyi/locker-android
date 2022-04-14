package com.ve.lib_api.model.mv

class MvBean {
    var count = 0
    var code = 0
    var isHasMore = false
    var data: ArrayList<MvDetailBean>? = null

    class MvDetailBean {
        private var id: Long = 0
        var name: String? = null
        private var artistId = 0
        var artistName: String? = null
        var briefDesc: String? = null
        var desc: String? = null
        var cover: String? = null
        var coverId: Long = 0
        var playCount: Long = 0
        private var subCount = 0
        private var shareCount = 0
        private var likeCount = 0
        private var commentCount = 0
        var duration: Long = 0
        private var nType = 0
        var publishTime: String? = null
        var isReward = false
        var commentThreadId: String? = null
        var artists: List<MvTopBean.Artists>? = null
        fun setId(id: Long) {
            this.id = id
        }

        fun getId(): String {
            return id.toString()
        }

        fun getArtistId(): String {
            return artistId.toString()
        }

        fun setArtistId(artistId: Int) {
            this.artistId = artistId
        }

        fun getSubCount(): String {
            return subCount.toString()
        }

        fun setSubCount(subCount: Int) {
            this.subCount = subCount
        }

        fun getShareCount(): String {
            return shareCount.toString()
        }

        fun setShareCount(shareCount: Int) {
            this.shareCount = shareCount
        }

        fun getLikeCount(): String {
            return likeCount.toString()
        }

        fun setLikeCount(likeCount: Int) {
            this.likeCount = likeCount
        }

        fun getCommentCount(): String {
            return commentCount.toString()
        }

        fun setCommentCount(commentCount: Int) {
            this.commentCount = commentCount
        }

        fun getnType(): Int {
            return nType
        }

        fun setnType(nType: Int) {
            this.nType = nType
        }
    }
}
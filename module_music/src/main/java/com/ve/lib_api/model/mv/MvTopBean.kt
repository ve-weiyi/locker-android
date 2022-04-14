package com.ve.lib_api.model.mv

class MvTopBean {
    var updateTime: Long = 0
    var isHasMore = false
    var code = 0
    var data: ArrayList<MvTopDetailBean>? = null

    class MvTopDetailBean {
        private var id: Long = 0
        var cover: String? = null
        var name: String? = null
        var playCount: Long = 0
        var briefDesc: String? = null
        var desc: String? = null
        var artistName: String? = null
        var artistId = 0
        var duration = 0
        var mark = 0
        var lastRank = 0
        var score: Long = 0
        var isSubed = false
        var artists: List<Artists>? = null
        fun getId(): String {
            return id.toString()
        }

        fun setId(id: Long) {
            this.id = id
        }
    }

    class Artists {
        var id = 0
        var name: String? = null
    }
}
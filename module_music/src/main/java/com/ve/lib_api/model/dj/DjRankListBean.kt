package com.ve.lib_api.model.dj

class DjRankListBean {
    var code = 0
    var msg: String? = null
    var data: Data? = null

    class Data {
        var total = 0
        var updateTime: Long = 0
        var list: kotlin.collections.List<List>? = null
    }

    class List {
        private var id: Long = 0
        var rank = 0
        var lastRank = 0
        var score: Long = 0
        var nickName: String? = null
        var avatarUrl: String? = null
        var userType = 0
        fun setId(id: Long) {
            this.id = id
        }

        fun getId(): String {
            return id.toString()
        }
    }
}
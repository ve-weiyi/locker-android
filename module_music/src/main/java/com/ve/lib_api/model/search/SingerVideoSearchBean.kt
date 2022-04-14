package com.ve.lib_api.model.search

class SingerVideoSearchBean {
    var mvs: List<Mvs>? = null
    var time: Long = 0
    var isHasMore = false
    var code = 0

    inner class Mvs {
        private var id: Long = 0
        var name: String? = null
        var status = 0
        var artistName: String? = null
        var imgurl: String? = null
        var imgurl16v9: String? = null
        var artist: Artist? = null
        var duration: Long = 0
        var playCount: Long = 0
        var publishTime: String? = null
        var subed = false
        fun setId(id: Long) {
            this.id = id
        }

        fun getId(): String {
            return id.toString()
        }
    }

    class Artist {
        var img1v1Id: Long = 0
        var topicPerson = 0
        var alias: List<String>? = null
        var img1v1Url: String? = null
        var albumSize = 0
        var trans: String? = null
        var musicSize = 0
        var picUrl: String? = null
        var briefDesc: String? = null
        var picId = 0
        var name: String? = null
        var id = 0
        var img1v1Id_str: String? = null
    }
}
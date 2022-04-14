package com.ve.lib_api.model.mv

class VideoGroupBean {
    var code = 0
    var message: String? = null
    var data: List<Data>? = null

    class Data {
        var id: Long = 0
        var name: String? = null
        var url: String? = null
        var relatedVideoType: String? = null
        var selectTab = false
        var abExtInfo: String? = null
    }
}
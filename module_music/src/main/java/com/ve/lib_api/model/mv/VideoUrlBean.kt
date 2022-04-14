package com.ve.lib_api.model.mv

class VideoUrlBean {
    //普通视频
    var urls: List<Urls>? = null

    //MV
    var data: Urls? = null
    var code = 0

    class Urls {
        var id: String? = null
        var url: String? = null
        var size: Long = 0
        var validityTime = 0
        var needPay = false
        var payInfo: String? = null
        var r = 0
    }
}
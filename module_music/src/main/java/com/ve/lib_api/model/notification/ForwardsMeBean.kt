package com.ve.lib_api.model.notification

class ForwardsMeBean {
    var code = 0
    var newCount = 0
    var lasttime: Long = 0
    var isMore = false
    var forwards: ArrayList<ForwardsMeData>? = null

    class ForwardsMeData {
        // UserEventBean.EventsBean
        var json: String? = null
        var time: Long = 0
        var userId: Long = 0
        var id: Long = 0
        var type = 0
    }
}
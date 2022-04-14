package com.ve.lib_api.model.mv

import com.ve.lib_api.model.search.FeedSearchBean

class VideoRelatedBean {
    var code = 0
    var message: String? = null
    var data: ArrayList<FeedSearchBean.ResultBean.VideosBean>? = null
}
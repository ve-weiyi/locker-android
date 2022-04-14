package com.ve.lib_api.model.song

import com.ve.lib_api.model.playlist.DailyRecommendBean

class NewSongBean {
    var code = 0
    var data: List<DailyRecommendBean.RecommendBean>? = null
}
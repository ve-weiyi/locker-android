package com.ve.lib_api.model.user

import com.ve.lib_api.model.song.DailyRecommendSongsBean

class UserRecordBean {
    var code = 0
    var allData: ArrayList<UserRecord>? = null
    var weekData: ArrayList<UserRecord>? = null

    class UserRecord {
        var score = 0
        var playCount = 0
        var song: DailyRecommendSongsBean? = null
    }
}
package com.ve.lib_api.model.search

/**
 * 用来适配视频Adapter的Bean
 */
class MvBean {
    var coverUrl: String? = null
    var title: String? = null
    var duration: Long = 0
    var type = 0
    var creator: List<CreatorBean>? = null
    var vid: String? = null
    var playTime: Long = 0

    class CreatorBean {
        /**
         * userId : 11562
         * userName : F.I.R
         */
        var userId: Long = 0
        var userName: String? = null
    }

    override fun toString(): String {
        return "MvBean{" +
                "coverUrl='" + coverUrl + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", type=" + type +
                ", creator=" + creator +
                ", vid='" + vid + '\'' +
                ", playTime=" + playTime +
                '}'
    }
}
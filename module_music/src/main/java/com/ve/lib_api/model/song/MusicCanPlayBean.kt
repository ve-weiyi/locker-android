package com.ve.lib_api.model.song

/**
 * 歌曲是否可以听
 */
class MusicCanPlayBean {
    /**
     * success : true
     * message : ok
     */
    var isSuccess = false
    var message: String? = null
    override fun toString(): String {
        return "MusicCanPlayBean{" +
                "success=" + isSuccess +
                ", message='" + message + '\'' +
                '}'
    }
}
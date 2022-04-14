package com.ve.lib_api.model.album

class AlbumDynamicBean {
    /**
     * "onSale": false,
     * "albumGameInfo": null,
     * "commentCount": 1766,
     * "likedCount": 0,
     * "shareCount": 1870,
     * "isSub": false,
     * "subTime": 0,
     * "subCount": 20431,
     * "code": 200
     */
    var code = 0
    var isOnSale = false
    var isSub = false
    var subTime: Long = 0
    var albumGameInfo: Any? = null
    var commentCount = 0
    var likedCount = 0
    var shareCount = 0
    var subCount = 0
}
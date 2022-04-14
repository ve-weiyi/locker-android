package com.ve.lib_api.model.dj

/**
 * 付费精选
 */
class DjPaygiftBean {
    /**
     * code : 200
     * msg : null
     * data : {"hasMore":true,"list":[{"id":791646415,"name":"情绪紧急救助冥想","rcmdText":"心情急救箱 适用于你的每次不安","radioFeeType":2,"feeScope":0,"picUrl":"https://p1.music.126.net/oMC7XFuENtvMBZP-WGxvEg==/109951163546248655.jpg","programCount":6,"playCount":null,"alg":"featured","originalPrice":1200,"discountPrice":null,"lastProgramName":"【发刊词】控制好情绪的人，眼中的世界都自带光芒"}]}
     */
    var code = 0
    var msg: Any? = null
    var data: DataBean? = null

    class DataBean {
        /**
         * hasMore : true
         * list : [{"id":791646415,"name":"情绪紧急救助冥想","rcmdText":"心情急救箱 适用于你的每次不安","radioFeeType":2,"feeScope":0,"picUrl":"https://p1.music.126.net/oMC7XFuENtvMBZP-WGxvEg==/109951163546248655.jpg","programCount":6,"playCount":null,"alg":"featured","originalPrice":1200,"discountPrice":null,"lastProgramName":"【发刊词】控制好情绪的人，眼中的世界都自带光芒"}]
         */
        var isHasMore = false
        var list: List<ListBean>? = null

        class ListBean {
            /**
             * id : 791646415
             * name : 情绪紧急救助冥想
             * rcmdText : 心情急救箱 适用于你的每次不安
             * radioFeeType : 2
             * feeScope : 0
             * picUrl : https://p1.music.126.net/oMC7XFuENtvMBZP-WGxvEg==/109951163546248655.jpg
             * programCount : 6
             * playCount : null
             * alg : featured
             * originalPrice : 1200
             * discountPrice : null
             * lastProgramName : 【发刊词】控制好情绪的人，眼中的世界都自带光芒
             */
            var id: Long = 0
            var name: String? = null
            var rcmdText: String? = null
            var radioFeeType = 0
            var feeScope = 0
            var picUrl: String? = null
            var programCount = 0
            var playCount: Any? = null
            var alg: String? = null
            var originalPrice = 0.0
            var discountPrice: Any? = null
            var lastProgramName: String? = null
        }
    }
}
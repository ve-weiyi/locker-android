package com.ve.lib_api.model.dj

import java.io.Serializable

class DjDetailBean : Serializable {
    /**
     * djRadio : {"id":336355127,"dj":{"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg","accountStatus":0,"gender":1,"city":1002400,"birthday":-2209017600000,"userId":289680033,"userType":0,"nickname":"代码时间","signature":"代码时间是一个面向程序员的中文播客节目, 致力于通过语音的方式传播程序员的正能量. 节目的网站是: http://codetimecn.com | 新浪微博 ID: 代码时间 | 微信公众号 ID: 代码时间","description":"","detailDescription":"","avatarImgId":3442570909917251,"backgroundImgId":2002210674180199,"backgroundUrl":"http://p1.music.126.net/VTW4vsN08vwL3uSQqPyHqg==/2002210674180199.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":0,"remarkName":null,"avatarImgIdStr":"3442570909917251","backgroundImgIdStr":"2002210674180199","rewardCount":0,"canReward":false},"name":"代码时间","picUrl":"https://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg","desc":"","subCount":15111,"programCount":36,"createTime":1465726085482,"categoryId":453052,"category":"科技科学","radioFeeType":0,"feeScope":0,"buyed":false,"videos":null,"finished":false,"underShelf":false,"purchaseCount":0,"price":0,"originalPrice":0,"discountPrice":null,"lastProgramCreateTime":1515962230660,"lastProgramName":null,"lastProgramId":1367665101,"picId":3442570909917251,"rcmdText":"程序员的中文播客节目","hightQuality":false,"whiteList":false,"liveInfo":null,"composeVideo":false,"shareCount":131,"subed":true,"likedCount":0,"commentDatas":[{"userProfile":{"defaultAvatar":false,"province":410000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg","accountStatus":0,"gender":1,"city":410100,"birthday":935252436559,"userId":303576830,"userType":0,"nickname":"Dear-Canon","signature":"alone.","description":"","detailDescription":"","avatarImgId":109951164105614420,"backgroundImgId":109951164216453310,"backgroundUrl":"http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164105614418","backgroundImgIdStr":"109951164216453318","avatarImgId_str":"109951164105614418"},"content":"声音太小，程序员都近视，听不清。","programName":"Visual Studio Code - 吕鹏","programId":1367665101,"commentId":1256331303}],"commentCount":0}
     * picId : 3442570909917251
     * code : 200
     */
    var data: DjRadioBean? = null
    var picId: String? = null
    var code = 0

    class DjRadioBean : Serializable {
        /**
         * id : 336355127
         * dj : {"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg","accountStatus":0,"gender":1,"city":1002400,"birthday":-2209017600000,"userId":289680033,"userType":0,"nickname":"代码时间","signature":"代码时间是一个面向程序员的中文播客节目, 致力于通过语音的方式传播程序员的正能量. 节目的网站是: http://codetimecn.com | 新浪微博 ID: 代码时间 | 微信公众号 ID: 代码时间","description":"","detailDescription":"","avatarImgId":3442570909917251,"backgroundImgId":2002210674180199,"backgroundUrl":"http://p1.music.126.net/VTW4vsN08vwL3uSQqPyHqg==/2002210674180199.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":0,"remarkName":null,"avatarImgIdStr":"3442570909917251","backgroundImgIdStr":"2002210674180199","rewardCount":0,"canReward":false}
         * name : 代码时间
         * picUrl : https://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg
         * desc :
         * subCount : 15111
         * programCount : 36
         * createTime : 1465726085482
         * categoryId : 453052
         * category : 科技科学
         * radioFeeType : 0
         * feeScope : 0
         * buyed : false
         * videos : null
         * finished : false
         * underShelf : false
         * purchaseCount : 0
         * price : 0
         * originalPrice : 0
         * discountPrice : null
         * lastProgramCreateTime : 1515962230660
         * lastProgramName : null
         * lastProgramId : 1367665101
         * picId : 3442570909917251
         * rcmdText : 程序员的中文播客节目
         * hightQuality : false
         * whiteList : false
         * liveInfo : null
         * composeVideo : false
         * shareCount : 131
         * subed : true
         * likedCount : 0
         * commentDatas : [{"userProfile":{"defaultAvatar":false,"province":410000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg","accountStatus":0,"gender":1,"city":410100,"birthday":935252436559,"userId":303576830,"userType":0,"nickname":"Dear-Canon","signature":"alone.","description":"","detailDescription":"","avatarImgId":109951164105614420,"backgroundImgId":109951164216453310,"backgroundUrl":"http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164105614418","backgroundImgIdStr":"109951164216453318","avatarImgId_str":"109951164105614418"},"content":"声音太小，程序员都近视，听不清。","programName":"Visual Studio Code - 吕鹏","programId":1367665101,"commentId":1256331303}]
         * commentCount : 0
         */
        var id: Long = 0
        var dj: DjBean? = null
        var name: String? = null
        var picUrl: String? = null
        var desc: String? = null
        var subCount = 0
        var programCount = 0
        var createTime: Long = 0
        var categoryId = 0
        var category: String? = null
        var radioFeeType = 0
        var feeScope = 0
        var isBuyed = false
        var videos: Any? = null
        var isFinished = false
        var isUnderShelf = false
        var purchaseCount = 0
        var price = 0
        var originalPrice = 0
        var discountPrice: Any? = null
        var lastProgramCreateTime: Long = 0
        var lastProgramName: Any? = null
        var lastProgramId = 0
        var picId: Long = 0
        var rcmdText: String? = null
        var isHightQuality = false
        var isWhiteList = false
        var liveInfo: Any? = null
        var isComposeVideo = false
        var shareCount = 0
        var isSubed = false
        var likedCount = 0
        var commentCount = 0

        //热门评论
        var commentDatas: List<CommentDatasBean>? = null

        class DjBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/BBK9kY31geOOdnkaxiwCdw==/3442570909917251.jpg
             * accountStatus : 0
             * gender : 1
             * city : 1002400
             * birthday : -2209017600000
             * userId : 289680033
             * userType : 0
             * nickname : 代码时间
             * signature : 代码时间是一个面向程序员的中文播客节目, 致力于通过语音的方式传播程序员的正能量. 节目的网站是: http://codetimecn.com | 新浪微博 ID: 代码时间 | 微信公众号 ID: 代码时间
             * description :
             * detailDescription :
             * avatarImgId : 3442570909917251
             * backgroundImgId : 2002210674180199
             * backgroundUrl : http://p1.music.126.net/VTW4vsN08vwL3uSQqPyHqg==/2002210674180199.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 10
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 3442570909917251
             * backgroundImgIdStr : 2002210674180199
             * rewardCount : 0
             * canReward : false
             */
            var isDefaultAvatar = false
            var province = 0
            var authStatus = 0
            var isFollowed = false
            var avatarUrl: String? = null
            var accountStatus = 0
            var gender = 0
            var city = 0
            var birthday: Long = 0
            private var userId = 0
            var userType = 0
            var nickname: String? = null
            var signature: String? = null
            var description: String? = null
            var detailDescription: String? = null
            var avatarImgId: Long = 0
            var backgroundImgId: Long = 0
            var backgroundUrl: String? = null
            var authority = 0
            var isMutual = false
            var expertTags: Any? = null
            var experts: Any? = null
            var djStatus = 0
            var vipType = 0
            var remarkName: Any? = null
            var avatarImgIdStr: String? = null
            var backgroundImgIdStr: String? = null
            var rewardCount = 0
            var isCanReward = false
            fun getUserId(): Long {
                return userId.toLong()
            }

            fun setUserId(userId: Int) {
                this.userId = userId
            }
        }

        class CommentDatasBean : Serializable {
            /**
             * userProfile : {"defaultAvatar":false,"province":410000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg","accountStatus":0,"gender":1,"city":410100,"birthday":935252436559,"userId":303576830,"userType":0,"nickname":"Dear-Canon","signature":"alone.","description":"","detailDescription":"","avatarImgId":109951164105614420,"backgroundImgId":109951164216453310,"backgroundUrl":"http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164105614418","backgroundImgIdStr":"109951164216453318","avatarImgId_str":"109951164105614418"}
             * content : 声音太小，程序员都近视，听不清。
             * programName : Visual Studio Code - 吕鹏
             * programId : 1367665101
             * commentId : 1256331303
             */
            var userProfile: UserProfileBean? = null
            var content: String? = null
            var programName: String? = null
            var programId: Long = 0
            var commentId: Long = 0

            class UserProfileBean {
                /**
                 * defaultAvatar : false
                 * province : 410000
                 * authStatus : 0
                 * followed : false
                 * avatarUrl : http://p1.music.126.net/wSyjF5iTrgSMESDGQOln7Q==/109951164105614418.jpg
                 * accountStatus : 0
                 * gender : 1
                 * city : 410100
                 * birthday : 935252436559
                 * userId : 303576830
                 * userType : 0
                 * nickname : Dear-Canon
                 * signature : alone.
                 * description :
                 * detailDescription :
                 * avatarImgId : 109951164105614420
                 * backgroundImgId : 109951164216453310
                 * backgroundUrl : http://p1.music.126.net/n1DsZrMnOv9aHIvMn313Kw==/109951164216453318.jpg
                 * authority : 0
                 * mutual : false
                 * expertTags : null
                 * experts : null
                 * djStatus : 0
                 * vipType : 0
                 * remarkName : null
                 * avatarImgIdStr : 109951164105614418
                 * backgroundImgIdStr : 109951164216453318
                 * avatarImgId_str : 109951164105614418
                 */
                var isDefaultAvatar = false
                var province = 0
                var authStatus = 0
                var isFollowed = false
                var avatarUrl: String? = null
                var accountStatus = 0
                var gender = 0
                var city = 0
                var birthday: Long = 0
                private var userId: Long = 0
                var userType = 0
                var nickname: String? = null
                var signature: String? = null
                var description: String? = null
                var detailDescription: String? = null
                var avatarImgId: Long = 0
                var backgroundImgId: Long = 0
                var backgroundUrl: String? = null
                var authority = 0
                var isMutual = false
                var expertTags: Any? = null
                var experts: Any? = null
                var djStatus = 0
                var vipType = 0
                var remarkName: Any? = null
                var avatarImgIdStr: String? = null
                var backgroundImgIdStr: String? = null
                var avatarImgId_str: String? = null
                fun getUserId(): String {
                    return userId.toString()
                }

                fun setUserId(userId: Long) {
                    this.userId = userId
                }
            }
        }
    }
}
package com.ve.lib_api.model.dj

class DjSubListBean {
    var count = 0
    var djRadios: List<DjRadios>? = null
    var time: Long = 0
    var hasMore = false
    var code = 0

    class DjRadios {
        var dj: Dj? = null
        var category: String? = null
        var isBuyed = false
        var price = 0
        var originalPrice = 0
        var discountPrice: String? = null
        var purchaseCount = 0
        var lastProgramName: String? = null
        var videos: String? = null
        var isFinished = false
        var isUnderShelf = false
        var liveInfo: String? = null
        var programCount = 0
        var radioFeeType = 0
        var categoryId = 0
        var createTime: Long = 0
        var picId: Long = 0
        var subCount: Long = 0
        var lastProgramCreateTime: Long = 0
        var lastProgramId: Long = 0
        var feeScope = 0
        var picUrl: String? = null
        var desc: String? = null
        var name: String? = null
        var id: Long = 0
        var rcmdtext: String? = null
        var newProgramCount = 0
        var rank = 0
        var lastRank = 0
        var score: String? = null
        fun getBuyed(): Boolean {
            return isBuyed
        }

        fun getFinished(): Boolean {
            return isFinished
        }

        fun getUnderShelf(): Boolean {
            return isUnderShelf
        }
    }

    class Dj {
        var defaultAvatar = false
        var province: Long = 0
        var authStatus = 0
        var followed = false
        var avatarUrl: String? = null
        var accountStatus = 0
        var gender = 0
        var city: Long = 0
        var birthday: Long = 0
        var userId: Long = 0
        var userType = 0
        var nickname: String? = null
        var signature: String? = null
        var description: String? = null
        var detailDescription: String? = null
        var avatarImgId: Long = 0
        var backgroundImgId: Long = 0
        var backgroundUrl: String? = null
        var authority = 0
        var mutual = false
        var expertTags: String? = null

        //{"1":"音乐原创视频达人"}
        var experts: Any? = null
        var djStatus = 0
        var vipType = 0
        var remarkName: String? = null
        var avatarImgIdStr: String? = null
        var backgroundImgIdStr: String? = null
        var avatarImgId_str: String? = null
    }
}
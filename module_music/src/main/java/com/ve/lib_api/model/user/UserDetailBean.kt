package com.ve.lib_api.model.user

import java.io.Serializable

/**
 * 通过接口获取的用户个人信息Bean
 */
class UserDetailBean : Serializable {
    /**
     * level : 9
     * listenSongs : 12720
     * userPoint : {"userId":415560926,"balance":106,"updateTime":1564106670906,"version":10,"status":0,"blockBalance":0}
     * mobileSign : false
     * pcSign : false
     * profile : {"userId":415560926,"accountStatus":0,"djStatus":0,"province":440000,"vipType":0,"avatarImgId":18787355185828650,"birthday":887904000000,"gender":0,"nickname":"rikkatheworld","userType":0,"description":"","mutual":false,"followed":false,"remarkName":null,"authStatus":0,"detailDescription":"","experts":{},"expertTags":null,"city":440300,"defaultAvatar":false,"avatarUrl":"http://p1.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg","backgroundImgId":109951163710677230,"backgroundUrl":"http://p1.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg","avatarImgIdStr":"18787355185828647","backgroundImgIdStr":"109951163710677237","signature":"","authority":0,"avatarImgId_str":"18787355185828647","artistIdentity":[],"followeds":3,"follows":1,"cCount":0,"blacklist":false,"eventCount":0,"sDJPCount":0,"allSubscribedCount":0,"playlistCount":3,"playlistBeSubscribedCount":1,"sCount":0}
     * peopleCanSeeMyPlayRecord : true
     * bindings : [{"userId":415560926,"url":"","bindingTime":1486309535025,"tokenJsonStr":null,"expired":false,"expiresIn":2147483647,"refreshTime":1486309535,"id":2973312066,"type":1},{"userId":415560926,"url":"","bindingTime":1486309512369,"tokenJsonStr":null,"expired":false,"expiresIn":7776000,"refreshTime":1558957256,"id":2973299013,"type":5}]
     * adValid : true
     * code : 200
     * createTime : 1486309512362
     * createDays : 901
     */
    //等级LV.8
    var level = 0
    var listenSongs = 0
    var userPoint: UserPointBean? = null
    var isMobileSign = false
    var isPcSign = false

    //个人资料
    var profile: ProfileBean? = null
    var isPeopleCanSeeMyPlayRecord = false
    var isAdValid = false
    var code = 0

    //村龄  时间戳
    var createTime: Long = 0
    var createDays = 0

    //绑定的账号
    var bindings: List<BindingsBean>? = null

    class UserPointBean : Serializable {
        /**
         * userId : 415560926
         * balance : 106
         * updateTime : 1564106670906
         * version : 10
         * status : 0
         * blockBalance : 0
         */
        var userId: Long = 0
        var balance = 0
        var updateTime: Long = 0
        var version = 0
        var status = 0
        var blockBalance = 0
    }

    class ProfileBean : Serializable {
        /**
         * userId : 415560926
         * accountStatus : 0
         * djStatus : 0
         * province : 440000
         * vipType : 0
         * avatarImgId : 18787355185828650
         * birthday : 887904000000
         * gender : 0
         * nickname : rikkatheworld
         * userType : 0
         * description :
         * mutual : false
         * followed : false
         * remarkName : null
         * authStatus : 0
         * detailDescription :
         * experts : {}
         * expertTags : null
         * city : 440300
         * defaultAvatar : false
         * avatarUrl : http://p1.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg
         * backgroundImgId : 109951163710677230
         * backgroundUrl : http://p1.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg
         * avatarImgIdStr : 18787355185828647
         * backgroundImgIdStr : 109951163710677237
         * signature :
         * authority : 0
         * avatarImgId_str : 18787355185828647
         * artistIdentity : []
         * followeds : 3
         * follows : 1
         * cCount : 0
         * blacklist : false
         * eventCount : 0
         * sDJPCount : 0
         * allSubscribedCount : 0
         * playlistCount : 3
         * playlistBeSubscribedCount : 1
         * sCount : 0
         */
        var userId = 0
        var accountStatus = 0
        var djStatus = 0
        var province = 0
        var vipType = 0
        var avatarImgId: Long = 0
        var birthday: Long = 0
        var gender = 0
        var nickname: String? = null
        var userType = 0
        var description: String? = null
        var isMutual = false
        var isFollowed = false
        var remarkName: Any? = null
        var authStatus = 0
        var detailDescription: String? = null
        var experts: ExpertsBean? = null
        var expertTags: Any? = null
        var city = 0
        var isDefaultAvatar = false
        var avatarUrl: String? = null
        var backgroundImgId: Long = 0
        var backgroundUrl: String? = null
        var avatarImgIdStr: String? = null
        var backgroundImgIdStr: String? = null
        var signature: String? = null
        var authority = 0
        var avatarImgId_str: String? = null
        var followeds = 0
        var follows = 0
        var cCount = 0
        var isBlacklist = false
        var eventCount = 0
        var sDJPCount = 0
        var allSubscribedCount = 0
        var playlistCount = 0
        var playlistBeSubscribedCount = 0
        var sCount = 0
        var artistIdentity: List<*>? = null

        class ExpertsBean
    }

    class BindingsBean : Serializable {
        override fun toString(): String {
            return "BindingsBean{" +
                    "userId=" + userId +
                    ", url='" + url + '\'' +
                    ", bindingTime=" + bindingTime +
                    ", tokenJsonStr=" + tokenJsonStr +
                    ", expired=" + isExpired +
                    ", expiresIn=" + expiresIn +
                    ", refreshTime=" + refreshTime +
                    ", id=" + id +
                    ", type=" + type +
                    '}'
        }

        /**
         * userId : 415560926
         * url :
         * bindingTime : 1486309535025
         * tokenJsonStr : null
         * expired : false
         * expiresIn : 2147483647
         * refreshTime : 1486309535
         * id : 2973312066
         * type : 1
         */
        var userId: Long = 0
        var url: String? = null
        var bindingTime: Long = 0
        var tokenJsonStr: Any? = null
        var isExpired = false
        var expiresIn: Long = 0
        var refreshTime: Long = 0
        var id: Long = 0
        var type = 0
    }
}
package com.ve.lib_api.model.user

/**
 * 通过接口获取的用户收藏歌单
 */
class UserPlaylistBean {
    var isMore = false
    var code = 0
    var playlist: List<PlaylistBean>? = null

    class PlaylistBean {
        var isSubscribed = false
        var creator: CreatorBean? = null
        var artists: Any? = null
        var tracks: Any? = null
        var updateFrequency: Any? = null
        var backgroundCoverId: Long = 0
        var backgroundCoverUrl: Any? = null
        var privacy = 0
        var isNewImported = false
        var createTime: Long = 0
        var isHighQuality = false
        var userId: Long = 0
        var coverImgId: Long = 0
        var updateTime: Long = 0
        var specialType = 0
        var isAnonimous = false
        var trackUpdateTime: Long = 0
        var trackCount = 0
        var commentThreadId: String? = null
        var coverImgUrl: String? = null
        var totalDuration = 0
        var adType = 0
        var trackNumberUpdateTime: Long = 0
        var description: Any? = null
        var isOrdered = false
        var status = 0
        var subscribedCount = 0
        var cloudTrackCount = 0
        var playCount: Long = 0
        var name: String? = null
        var id: Long = 0
        var coverImgId_str: String? = null
        var subscribers: List<*>? = null
        var tags: List<*>? = null

        class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 440000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg
             * accountStatus : 0
             * gender : 0
             * city : 440300
             * birthday : 887904000000
             * userId : 415560926
             * userType : 0
             * nickname : rikkatheworld
             * signature :
             * description :
             * detailDescription :
             * avatarImgId : 18787355185828650
             * backgroundImgId : 109951163710677230
             * backgroundUrl : http://p1.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 18787355185828647
             * backgroundImgIdStr : 109951163710677237
             * avatarImgId_str : 18787355185828647
             */
            var isDefaultAvatar = false
            var province: Long = 0
            var authStatus = 0
            var isFollowed = false
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
            var isMutual = false
            var expertTags: Any? = null
            var experts: Any? = null
            var djStatus = 0
            var vipType = 0
            var remarkName: Any? = null
            var avatarImgIdStr: String? = null
            var backgroundImgIdStr: String? = null
            var avatarImgId_str: String? = null
        }

        companion object {
            /**
             * subscribers : []
             * subscribed : false
             * creator : {"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg","accountStatus":0,"gender":0,"city":440300,"birthday":887904000000,"userId":415560926,"userType":0,"nickname":"rikkatheworld","signature":"","description":"","detailDescription":"","avatarImgId":18787355185828650,"backgroundImgId":109951163710677230,"backgroundUrl":"http://p1.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"18787355185828647","backgroundImgIdStr":"109951163710677237","avatarImgId_str":"18787355185828647"}
             * artists : null
             * tracks : null
             * updateFrequency : null
             * backgroundCoverId : 0
             * backgroundCoverUrl : null
             * tags : []
             * privacy : 0
             * newImported : false
             * createTime : 1486309590927
             * highQuality : false
             * userId : 415560926
             * coverImgId : 3396391419161736
             * updateTime : 1560565805649
             * specialType : 5
             * anonimous : false
             * trackUpdateTime : 1561873546275
             * trackCount : 13
             * commentThreadId : A_PL_0_592471964
             * coverImgUrl : https://p1.music.126.net/2iKIawovtkcBjAzz-DTKBA==/3396391419161736.jpg
             * totalDuration : 0
             * adType : 0
             * trackNumberUpdateTime : 1560565805649
             * description : null
             * ordered : false
             * status : 0
             * subscribedCount : 0
             * cloudTrackCount : 0
             * playCount : 26
             * name : rikkatheworld喜欢的音乐
             * id : 592471964
             * coverImgId_str : 109951163920229500
             */
            const val TYPE_CREATE = 0
            const val TYPE_COLLECT = 1
        }
    }
}
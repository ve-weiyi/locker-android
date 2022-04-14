package com.ve.lib_api.model.user

/**
 * 通过login接口返回来的bean
 */
class LoginBean(
    /**
     * loginType : 1
     * code : 200
     * account : {"id":415560926,"userName":"1_13272136221","type":1,"status":0,"whitelistAuthority":0,"createTime":1486309512362,"salt":"[B@3c3d6a89","tokenVersion":0,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false}
     * profile : {"detailDescription":"","followed":false,"userId":415560926,"defaultAvatar":false,"avatarUrl":"https://p3.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg","nickname":"rikkatheworld","birthday":887904000000,"avatarImgId":18787355185828650,"province":440000,"accountStatus":0,"vipType":0,"gender":0,"djStatus":0,"avatarImgIdStr":"18787355185828647","backgroundImgIdStr":"109951163710677237","experts":{},"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"backgroundImgId":109951163710677230,"userType":0,"city":440300,"signature":"","authority":0,"description":"","backgroundUrl":"https://p4.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg","avatarImgId_str":"18787355185828647","followeds":3,"follows":1,"eventCount":0,"playlistCount":3,"playlistBeSubscribedCount":1}
     * bindings : [{"refreshTime":1486309535,"url":"","userId":415560926,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"13272136221\",\"hasPassword\":true}","id":2973312066,"type":1,"expiresIn":2147483647,"bindingTime":1486309535025,"expired":false},{"refreshTime":1558957256,"url":"","userId":415560926,"tokenJsonStr":"{\"access_token\":\"A73ACD9A247F38479247AD3BA69488BB\",\"refresh_token\":\"3DDEE9EA1955B12F72682A71CC2E95C8\",\"openid\":\"CFA63F441F4BA6BF4999A0182698EC62\",\"nickname\":\"RikkaTheWorld\",\"expires_in\":7776000}","id":2973299013,"type":5,"expiresIn":7776000,"bindingTime":1486309512369,"expired":false}]
     */
    var msg: String
) {
    var loginType = 0
    var code = 0
    var account: AccountBean? = null
    var profile: ProfileBean? = null
    var bindings: List<BindingsBean>? = null
    val isSuccess: Boolean
        get() = code == 200

    class AccountBean {
        /**
         * id : 415560926
         * userName : 1_13272136221
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 1486309512362
         * salt : [B@3c3d6a89
         * tokenVersion : 0
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         */
        var id: Long = 0
        var userName: String? = null
        var type = 0
        var status = 0
        var whitelistAuthority = 0
        var createTime: Long = 0
        var salt: String? = null
        var tokenVersion = 0
        var ban = 0
        var baoyueVersion = 0
        var donateVersion = 0
        var vipType = 0
        var viptypeVersion = 0.0
            private set
        var isAnonimousUser = false
        fun setViptypeVersion(viptypeVersion: Int) {
            this.viptypeVersion = viptypeVersion.toDouble()
        }

        override fun toString(): String {
            return "AccountBean{" +
                    "id=" + id +
                    ", userName='" + userName + '\'' +
                    ", type=" + type +
                    ", status=" + status +
                    ", whitelistAuthority=" + whitelistAuthority +
                    ", createTime=" + createTime +
                    ", salt='" + salt + '\'' +
                    ", tokenVersion=" + tokenVersion +
                    ", ban=" + ban +
                    ", baoyueVersion=" + baoyueVersion +
                    ", donateVersion=" + donateVersion +
                    ", vipType=" + vipType +
                    ", viptypeVersion=" + viptypeVersion +
                    ", anonimousUser=" + isAnonimousUser +
                    '}'
        }
    }

    class ProfileBean {
        /**
         * detailDescription :
         * followed : false
         * userId : 415560926
         * defaultAvatar : false
         * avatarUrl : https://p3.music.126.net/ULOn30612l-96hKgIy18tA==/18787355185828647.jpg
         * nickname : rikkatheworld
         * birthday : 887904000000
         * avatarImgId : 18787355185828650
         * province : 440000
         * accountStatus : 0
         * vipType : 0
         * gender : 0
         * djStatus : 0
         * avatarImgIdStr : 18787355185828647
         * backgroundImgIdStr : 109951163710677237
         * experts : {}
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * backgroundImgId : 109951163710677230
         * userType : 0
         * city : 440300
         * signature :
         * authority : 0
         * description :
         * backgroundUrl : https://p4.music.126.net/r4Ej-BqYiX-Al8AqRFeAUA==/109951163710677237.jpg
         * avatarImgId_str : 18787355185828647
         * followeds : 3
         * follows : 1
         * eventCount : 0
         * playlistCount : 3
         * playlistBeSubscribedCount : 1
         */
        var detailDescription: String? = null
        var isFollowed = false
        var userId = 0
        var isDefaultAvatar = false
        var avatarUrl: String? = null
        var nickname: String? = null
        var birthday: Long = 0
        var avatarImgId: Long = 0
        var province = 0
        var accountStatus = 0
        var vipType = 0
        var gender = 0
        var djStatus = 0
        var avatarImgIdStr: String? = null
        var backgroundImgIdStr: String? = null
        var experts: ExpertsBean? = null
        var isMutual = false
        var remarkName: Any? = null
        var expertTags: Any? = null
        var authStatus = 0
        var backgroundImgId: Long = 0
        var userType = 0
        var city = 0
        var signature: String? = null
        var authority = 0
        var description: String? = null
        var backgroundUrl: String? = null
        var avatarImgId_str: String? = null
        var followeds = 0
        var follows = 0
        var eventCount = 0
        var playlistCount = 0
        var playlistBeSubscribedCount = 0

        class ExpertsBean

        override fun toString(): String {
            return "ProfileBean{" +
                    "detailDescription='" + detailDescription + '\'' +
                    ", followed=" + isFollowed +
                    ", userId=" + userId +
                    ", defaultAvatar=" + isDefaultAvatar +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", birthday=" + birthday +
                    ", avatarImgId=" + avatarImgId +
                    ", province=" + province +
                    ", accountStatus=" + accountStatus +
                    ", vipType=" + vipType +
                    ", gender=" + gender +
                    ", djStatus=" + djStatus +
                    ", avatarImgIdStr='" + avatarImgIdStr + '\'' +
                    ", backgroundImgIdStr='" + backgroundImgIdStr + '\'' +
                    ", experts=" + experts +
                    ", mutual=" + isMutual +
                    ", remarkName=" + remarkName +
                    ", expertTags=" + expertTags +
                    ", authStatus=" + authStatus +
                    ", backgroundImgId=" + backgroundImgId +
                    ", userType=" + userType +
                    ", city=" + city +
                    ", signature='" + signature + '\'' +
                    ", authority=" + authority +
                    ", description='" + description + '\'' +
                    ", backgroundUrl='" + backgroundUrl + '\'' +
                    ", avatarImgId_str='" + avatarImgId_str + '\'' +
                    ", followeds=" + followeds +
                    ", follows=" + follows +
                    ", eventCount=" + eventCount +
                    ", playlistCount=" + playlistCount +
                    ", playlistBeSubscribedCount=" + playlistBeSubscribedCount +
                    '}'
        }
    }

    class BindingsBean {
        /**
         * refreshTime : 1486309535
         * url :
         * userId : 415560926
         * tokenJsonStr : {"countrycode":"","cellphone":"13272136221","hasPassword":true}
         * id : 2973312066
         * type : 1
         * expiresIn : 2147483647
         * bindingTime : 1486309535025
         * expired : false
         */
        var refreshTime = 0
        var url: String? = null
        var userId = 0
        var tokenJsonStr: String? = null
        var id: Long = 0
        var type = 0
        var expiresIn = 0
        var bindingTime: Long = 0
        var isExpired = false
        override fun toString(): String {
            return "BindingsBean{" +
                    "refreshTime=" + refreshTime +
                    ", url='" + url + '\'' +
                    ", userId=" + userId +
                    ", tokenJsonStr='" + tokenJsonStr + '\'' +
                    ", id=" + id +
                    ", type=" + type +
                    ", expiresIn=" + expiresIn +
                    ", bindingTime=" + bindingTime +
                    ", expired=" + isExpired +
                    '}'
        }
    }

    override fun toString(): String {
        return "LoginBean{" +
                "loginType=" + loginType +
                ", code=" + code +
                ", account=" + account +
                ", profile=" + profile +
                ", bindings=" + bindings +
                '}'
    }
}
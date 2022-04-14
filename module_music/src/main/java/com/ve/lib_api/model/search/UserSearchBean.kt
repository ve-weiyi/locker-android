package com.ve.lib_api.model.search

/**
 * 通过api返回的搜索用户的bean
 */
class UserSearchBean {
    /**
     * result : {"userprofiles":[{"defaultAvatar":false,"province":310000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/MlJ9Pnz7iFi7n8Dqw4aezg==/3308430489754999.jpg","accountStatus":0,"gender":1,"city":310108,"birthday":1374508800000,"userId":3701993,"userType":0,"nickname":"___JoJo","signature":"uoye voli","description":"","detailDescription":"","avatarImgId":3308430489754999,"backgroundImgId":109951162868126480,"backgroundUrl":"http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"3308430489754999","backgroundImgIdStr":"109951162868126486","alg":"alg_user_basic","avatarImgId_str":"109951163417777007"},{"defaultAvatar":false,"province":520000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/nqWDvxz9U7snuRh7Zqm11A==/109951163417777007.jpg","accountStatus":0,"gender":1,"city":520100,"birthday":945446400000,"userId":131050600,"userType":0,"nickname":"jojo-_-_-_","signature":"","description":"","detailDescription":"","avatarImgId":109951163417777010,"backgroundImgId":109951163417817860,"backgroundUrl":"http://p1.music.126.net/mgm9dWGhMT3iZUBZRy7LlQ==/109951163417817855.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163417777007","backgroundImgIdStr":"109951163417817855","avatarImgId_str":"109951163417777007","alg":"alg_user_basic"}],"userprofileCount":300}
     * code : 200
     */
    var result: ResultBean? = null
    var code = 0

    class ResultBean {
        /**
         * userprofiles : [{"defaultAvatar":false,"province":310000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/MlJ9Pnz7iFi7n8Dqw4aezg==/3308430489754999.jpg","accountStatus":0,"gender":1,"city":310108,"birthday":1374508800000,"userId":3701993,"userType":0,"nickname":"___JoJo","signature":"uoye voli","description":"","detailDescription":"","avatarImgId":3308430489754999,"backgroundImgId":109951162868126480,"backgroundUrl":"http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"3308430489754999","backgroundImgIdStr":"109951162868126486","alg":"alg_user_basic"},{"defaultAvatar":false,"province":520000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/nqWDvxz9U7snuRh7Zqm11A==/109951163417777007.jpg","accountStatus":0,"gender":1,"city":520100,"birthday":945446400000,"userId":131050600,"userType":0,"nickname":"jojo-_-_-_","signature":"","description":"","detailDescription":"","avatarImgId":109951163417777010,"backgroundImgId":109951163417817860,"backgroundUrl":"http://p1.music.126.net/mgm9dWGhMT3iZUBZRy7LlQ==/109951163417817855.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163417777007","backgroundImgIdStr":"109951163417817855","avatarImgId_str":"109951163417777007","alg":"alg_user_basic"}]
         * userprofileCount : 300
         */
        var userprofileCount = 0
        var userprofiles: List<UserprofilesBean>? = null

        class UserprofilesBean {
            /**
             * defaultAvatar : false
             * province : 310000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/MlJ9Pnz7iFi7n8Dqw4aezg==/3308430489754999.jpg
             * accountStatus : 0
             * gender : 1
             * city : 310108
             * birthday : 1374508800000
             * userId : 3701993
             * userType : 0
             * nickname : ___JoJo
             * signature : uoye voli
             * description :
             * detailDescription :
             * avatarImgId : 3308430489754999
             * backgroundImgId : 109951162868126480
             * backgroundUrl : http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 3308430489754999
             * backgroundImgIdStr : 109951162868126486
             * alg : alg_user_basic
             * avatarImgId_str : 109951163417777007
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
            var alg: String? = null
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
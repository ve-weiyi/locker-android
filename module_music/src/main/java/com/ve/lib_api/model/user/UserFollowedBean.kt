package com.ve.lib_api.model.user

import com.ve.lib_api.model.search.UserSearchBean

class UserFollowedBean {
    var code = 0
    var isMore = false
    var followeds: ArrayList<UserSearchBean.ResultBean.UserprofilesBean>? = null
}
package com.ve.lib_api.model.notification

import com.ve.lib_api.model.search.UserSearchBean

class PrivateCommentBean {
    var code = 0
    var total = 0
    var isMore = false
    var comments: ArrayList<Comment>? = null

    class Comment {
        var user: UserSearchBean.ResultBean.UserprofilesBean? = null
        var beRepliedUser: UserSearchBean.ResultBean.UserprofilesBean? = null
        var beRepliedContent: String? = null
        var time: Long = 0
        var content: String? = null
        var combindId: String? = null
        var expressionUrl: Any? = null
        var beRepliedExpressionUrl: Any? = null
        var commentLocationType = 0
        var parentCommentId = 0
        var resourceType = 0
    }
}
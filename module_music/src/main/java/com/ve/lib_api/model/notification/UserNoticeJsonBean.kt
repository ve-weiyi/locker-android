package com.ve.lib_api.model.notification

import com.ve.lib_api.model.search.SynthesisSearchBean
import com.ve.lib_api.model.search.UserSearchBean
import com.ve.lib_api.model.song.MusicCommentBean

class UserNoticeJsonBean {
    var type = 0
    var user: UserSearchBean.ResultBean.UserprofilesBean? = null

    //评论的通知
    var comment: MusicCommentBean.CommentsBean? = null

    //歌单的通知
    var playlist: SynthesisSearchBean.ResultBean.PlayListBean.PlayListsBean? = null

    // 常规通知
    var generalNotice: GeneralNotice? = null

    class GeneralNotice {
        var actionDesc: String? = null
        var content: String? = null
        var webUrl: String? = null
        var nativeUrl: String? = null
        var type = 0
        var resourceId = 0
        var specialResourceType: Any? = null
    }
}
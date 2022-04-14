package com.ve.lib_api.model.playlist

import com.chad.library.adapter.base.entity.JSectionEntity
import com.ve.lib_api.model.song.MusicCommentBean

class PlayListCommentEntity : JSectionEntity {
    override var isHeader = false

    //评论数量
    var count = ""
        private set
    private var header: String? = null
    private var comment: MusicCommentBean.CommentsBean? = null

    //头布局数据  头布局标题 评论数量
    constructor(header: String?, count: String) {
        isHeader = true
        this.header = header
        this.count = count
    }

    constructor(header: String?) {
        isHeader = true
        this.header = header
    }

    //非头布局数据
    constructor(`object`: MusicCommentBean.CommentsBean?) {
        comment = `object`
    }

    fun getComment(): MusicCommentBean.CommentsBean? {
        return comment
    }

    fun getHeader(): String? {
        return header
    }

    /**
     * 重写此方法，返回 boolen 值，告知是否是header
     */
}
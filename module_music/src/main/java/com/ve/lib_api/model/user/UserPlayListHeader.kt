package com.ve.lib_api.model.user

import com.chad.library.adapter.base.entity.node.BaseExpandNode
import com.chad.library.adapter.base.entity.node.BaseNode

class UserPlayListHeader(header: String, playNum: Int, bean:MutableList<BaseNode>) : BaseExpandNode() {
    var header: String
    private var playNum: Int
    var bean: MutableList<BaseNode>?
    fun getPlayNum(): String {
        return "($playNum)"
    }

    fun setPlayNum(playNum: Int) {
        this.playNum = playNum
    }

    override val childNode: MutableList<BaseNode>?
        get() = bean

    class UserPlayListContext(val playlist: UserPlaylistBean.PlaylistBean) : BaseExpandNode() {
        override val childNode: MutableList<BaseNode>?=null
    }

    init {
        //默认展开
        isExpanded = true
        this.header = header
        this.playNum = playNum
        this.bean = bean
    }
}
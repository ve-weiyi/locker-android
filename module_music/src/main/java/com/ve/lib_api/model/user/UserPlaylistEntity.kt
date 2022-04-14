package com.ve.lib_api.model.user

import com.chad.library.adapter.base.entity.MultiItemEntity

class UserPlaylistEntity : MultiItemEntity {
    //头布局数据
    private var playListSize = -1
    var headerText: String? = null
        private set

    //子布局
    var playlistBean: UserPlaylistBean.PlaylistBean? = null
    var type: TYPE? = null
        private set

    //尾布局
    var footerText: String? = null

    constructor(text: String?, playListSize: Int) {
        this.playListSize = playListSize
        headerText = text
    }

    constructor(type: TYPE?, playlistBean: UserPlaylistBean.PlaylistBean?) {
        this.playlistBean = playlistBean
        this.type = type
    }

    constructor(footerText: String?) {
        this.footerText = footerText
    }

    fun getPlayListSize(): String {
        return "($playListSize)"
    }

    fun setPlayListSize(playListSize: Int) {
        this.playListSize = playListSize
    }

    override val itemType: Int
        get() = if (playListSize != -1) {
            TYPE_HEADER
        } else if (playlistBean != null) {
            TYPE_CONTENT
        } else {
            TYPE_FOOTER
        }

    enum class TYPE {
        TYPE_CREATE, TYPE_SUBSCRIBE
    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_CONTENT = 1
        const val TYPE_FOOTER = 2
    }
}
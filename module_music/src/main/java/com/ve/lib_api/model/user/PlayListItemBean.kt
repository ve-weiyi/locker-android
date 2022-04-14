package com.ve.lib_api.model.user

/**
 * 用来适配UserPlaylistAdapter、解耦的Bean
 */
class PlayListItemBean {
    var playlistId: Long = 0
    var coverUrl: String? = null
    var playListName: String? = null

    //播放次数
    var playCount: Long = 0
    var playlistCreator: String? = null
    var songNumber = 0
}
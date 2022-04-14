package com.ve.lib_api.model.notification

import com.ve.lib_api.model.playlist.DailyRecommendBean
import com.ve.lib_api.model.playlist.PlaylistDetailBean
import com.ve.lib_api.model.search.AlbumSearchBean
import com.ve.lib_api.model.user.UserEventBean
import com.ve.lib_api.model.user.UserEventJsonBean

class ForwardsEventBean {
    var msg: String? = null

    //歌曲
    var song: DailyRecommendBean.RecommendBean? = null

    //动态
    var event: UserEventBean.EventsBean? = null

    //歌单
    var playlist: PlaylistDetailBean.PlaylistBean? = null

    //专辑
    var album: AlbumSearchBean.ResultBean.AlbumsBean? = null

    //视频
    var video: UserEventJsonBean.VideoBean? = null

    //电台节目
    var program: UserEventJsonBean.ProgramBean? = null
}
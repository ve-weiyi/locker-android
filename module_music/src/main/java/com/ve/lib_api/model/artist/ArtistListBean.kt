package com.ve.lib_api.model.artist

import com.ve.lib_api.model.playlist.TopListDetailBean

class ArtistListBean {
    var code = 0
    var isMore = false
    var artists: ArrayList<TopListDetailBean.Artist>? = null
}
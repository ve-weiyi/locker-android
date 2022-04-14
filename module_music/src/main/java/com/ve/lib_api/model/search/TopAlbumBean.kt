package com.ve.lib_api.model.search

class TopAlbumBean {
    var code = 0
    var isHasMore = false
    var weekData: ArrayList<AlbumSearchBean.ResultBean.AlbumsBean>? = null
    var monthData: ArrayList<AlbumSearchBean.ResultBean.AlbumsBean>? = null
}
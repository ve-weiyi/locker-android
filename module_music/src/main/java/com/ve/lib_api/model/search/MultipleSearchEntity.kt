package com.ve.lib_api.model.search

class MultipleSearchEntity {
    var header: String? = null
    var footer: String? = null

    constructor(song: SynthesisSearchBean.ResultBean.SongBean?) {
        this.song = song
    }

    constructor(djRadio: SynthesisSearchBean.ResultBean.DjRadioBean?) {
        this.djRadio = djRadio
    }

    constructor(artist: SynthesisSearchBean.ResultBean.ArtistBean?) {
        this.artist = artist
    }

    constructor(playList: SynthesisSearchBean.ResultBean.PlayListBean?) {
        this.playList = playList
    }

    constructor(album: SynthesisSearchBean.ResultBean.AlbumBeanX?) {
        this.album = album
    }

    constructor(video: SynthesisSearchBean.ResultBean.VideoBean?) {
        this.video = video
    }

    constructor(user: SynthesisSearchBean.ResultBean.UserBean?) {
        this.user = user
    }

    //单曲
    var song: SynthesisSearchBean.ResultBean.SongBean? = null

    //电台
    var djRadio: SynthesisSearchBean.ResultBean.DjRadioBean? = null

    //歌手
    var artist: SynthesisSearchBean.ResultBean.ArtistBean? = null

    //歌单
    var playList: SynthesisSearchBean.ResultBean.PlayListBean? = null

    //专辑
    var album: SynthesisSearchBean.ResultBean.AlbumBeanX? = null

    //视频
    var video: SynthesisSearchBean.ResultBean.VideoBean? = null

    //相关搜索
    var sim_query: SynthesisSearchBean.ResultBean.SimQueryBean? = null

    //用户
    var user: SynthesisSearchBean.ResultBean.UserBean? = null
    var rec_type: Any? = null
    var rec_query: List<String>? = null
    var order: List<String>? = null
}
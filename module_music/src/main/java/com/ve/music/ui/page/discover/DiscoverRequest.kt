package com.ve.music.ui.page.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ve.lib_api.model.album.AlbumOrSongBean
import com.ve.lib_api.model.banner.BannerBean
import com.ve.lib_api.model.playlist.MainRecommendPlayListBean
import com.ve.lib_api.model.song.DailyRecommendSongsBean

class DiscoverRequest {
    //Banner数据
    private var mBannerLiveData: MutableLiveData<BannerBean>? = null

    //推荐歌曲数据
    private var mRecommendPlayListLiveData: MutableLiveData<List<MainRecommendPlayListBean.RecommendBean>>? =
        null

    //歌曲详情
    private var mSongDetailLiveData: MutableLiveData<DailyRecommendSongsBean>? = null

    //新歌和新碟数据
    private var mAlbumOrSongLiveData: MutableLiveData<List<AlbumOrSongBean>>? = null

    val albumOrSongLiveData: MutableLiveData<List<AlbumOrSongBean>>
        get() {
            if (mAlbumOrSongLiveData == null) {
                mAlbumOrSongLiveData = MutableLiveData()
            }
            return mAlbumOrSongLiveData!!
        }
    val bannerLiveData: LiveData<BannerBean>
        get() {
            if (mBannerLiveData == null) {
                mBannerLiveData = MutableLiveData()
            }
            return mBannerLiveData!!
        }
    val recommendPlaylistLiveData: LiveData<List<MainRecommendPlayListBean.RecommendBean>>
        get() {
            if (mRecommendPlayListLiveData == null) {
                mRecommendPlayListLiveData = MutableLiveData()
            }
            return mRecommendPlayListLiveData!!
        }
    val songDetailLiveData: MutableLiveData<DailyRecommendSongsBean>
        get() {
            if (mSongDetailLiveData == null) {
                mSongDetailLiveData = MutableLiveData()
            }
            return mSongDetailLiveData!!
        }


}
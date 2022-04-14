package com.ve.music.ui.page.discover

import androidx.databinding.ObservableField
import com.ve.lib.common.base.viewmodel.BaseViewModel
import com.ve.lib_api.model.album.AlbumOrSongBean
import com.ve.lib_api.model.banner.BannerBean
import com.ve.music.data.config.TypeEnum

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/3/25
 */
class DiscoverViewModel: BaseViewModel() {

    //banner数据
    val banners = ObservableField<List<BannerBean.BannersBean>>()

    //banner中的Pic
    val bannersPic = ObservableField<List<String>>()

    //推荐歌单的Adapter
//    val playListAdapter: ObservableField<SimpleDataBindingAdapter<MainRecommendPlayListBean.RecommendBean, ItemDiscoverGedanBinding>> =
//        ObservableField<SimpleDataBindingAdapter<MainRecommendPlayListBean.RecommendBean, ItemDiscoverGedanBinding>>()

    //所有的新歌和新碟数据
    val albumOrSongLiveData = ObservableField<List<AlbumOrSongBean>>()

    //当前显示的数据
    var currentAlbumOrSongLiveData = ObservableField<List<AlbumOrSongBean>>()

    //当前选中的是新歌还是新碟
    val type: ObservableField<TypeEnum> = ObservableField<TypeEnum>()

    //数据访问
    var discoverRequest = DiscoverRequest()

    init{
        //默认初始选中的是专辑
        type.set(TypeEnum.ALBUM)
    }
}
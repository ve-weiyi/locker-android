package com.ve.lib_api.model.artist

import com.ve.lib_api.model.search.SingerSearchBean

class ArtistSublistBean {
    /**
     * data : [{"info":"新碟《戦姫絶唱シンフォギアXV キャラクターソング6》抢鲜上架","id":17028,"name":"水樹奈々","trans":"水树奈奈","alias":["Mizuki Nana"],"albumSize":89,"mvSize":3,"picId":109951164158292080,"picUrl":"https://p1.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg","img1v1Url":"https://p2.music.126.net/kblHQZmf3IXDp67GVQD7bA==/109951164158292078.jpg"},{"info":"","id":768306,"name":"网易云音乐","trans":null,"alias":[],"albumSize":11,"mvSize":41,"picId":2274889557915240,"picUrl":"https://p1.music.126.net/0R_1imPfGwoeT199iPa5dA==/2274889557915240.jpg","img1v1Url":"https://p2.music.126.net/0R_1imPfGwoeT199iPa5dA==/2274889557915240.jpg"}]
     * hasMore : false
     * count : 2
     * code : 200
     */
    var isHasMore = false
    var count = 0
    var code = 0
    var data: List<SingerSearchBean.ResultBean.ArtistsBean>? = null
}
package com.ve.lib_api.model.dj

class DjRecommendTypeBean {
    /**
     * hasMore : true
     * code : 200
     */
    var isHasMore = false
    var code = 0
    var djRadios: List<DjRecommendBean.DjRadiosBean>? = null
    override fun toString(): String {
        return "DjRecommendTypeBean{" +
                "hasMore=" + isHasMore +
                ", code=" + code +
                ", djRadios=" + djRadios +
                '}'
    }
}
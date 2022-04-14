package com.ve.lib_api.model.user

class LikeListBean {
    /**
     * ids : [297845,354601]
     * checkPoint : 1568605495978
     * code : 200
     */
    var checkPoint: Long = 0
    var code = 0
    var ids: List<String>? = null
    override fun toString(): String {
        return "LikeListBean{" +
                "checkPoint=" + checkPoint +
                ", code=" + code +
                ", ids=" + ids +
                '}'
    }
}
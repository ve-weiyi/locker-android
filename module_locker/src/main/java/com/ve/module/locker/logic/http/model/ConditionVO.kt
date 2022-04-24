package com.ve.module.locker.logic.http.model


/**
 * 查询条件
 *
 * @author weiyi
 * @date 2021/07/29
 */

data class ConditionVO(
    var id: Int? = null,
    var folderName:String ="",
    var tagName:String="",
    var privacyDesc:String="",
    val privacyName:String="",
    var keyWords:String=""
) {
}
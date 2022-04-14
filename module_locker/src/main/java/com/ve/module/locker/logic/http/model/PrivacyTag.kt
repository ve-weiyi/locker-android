package com.ve.module.locker.logic.http.model

import java.io.Serializable


/**
 * @Description hello word!
 * @Author weiyi
 * @Date 2022/4/9
 */

data class PrivacyTag(
    var id: Int? = null,

    var tagName: String? = null,

    var tagCover: String? = null,

    var tagDesc: String? = null,

    var ownerId: Int? = null,
) :Serializable{
    companion object {
        const val serialVersionUID = 1L
    }
}
package com.ve.module.locker.logic.http.model

import java.io.Serializable

/**
 * @author weiyi
 * @since 2022-03-07
 */
data class PrivacyInfo(
    val id: Int? = null,
    val account: String? = null,
    val password: String? = null,
    val number: String? = null,
    val phone: String? = null,
    val address: String? = null,
    val url: String? = null,
    val signDate: String? = null,
    val validDate: String? = null,
    val remark: String? = null,
    val enable_encrypt: Int? = null,

) : Serializable {

}
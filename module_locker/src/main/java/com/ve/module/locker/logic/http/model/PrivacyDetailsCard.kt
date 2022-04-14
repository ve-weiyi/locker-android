package com.ve.module.locker.logic.http.model

import java.io.Serializable

/**
 * @author weiyi
 * @since 2022-04-10
 */
class PrivacyDetailsCard : Serializable {
    //(value = "id")
     val id: Int? = null

    //(value = "拥有人")
     val owner: String? = null

    //(value = "卡号")
     val number: String? = null

    //(value = "密码")
     val password: String? = null

    //(value = "绑定手机号")
     val phone: String? = null

    //(value = "绑定地址")
     val address: String? = null

    //(value = "链接")
     val url: String? = null

    //(value = "签发时间")
     val signDate: String? = null

    //(value = "有效时间")
     val validDate: String? = null

    //(value = "备注")
     val remark: String? = null

    //(value = "是否加密")
     val enableEncrypt: Int? = null

    companion object {
         const val serialVersionUID = 1L
    }
}
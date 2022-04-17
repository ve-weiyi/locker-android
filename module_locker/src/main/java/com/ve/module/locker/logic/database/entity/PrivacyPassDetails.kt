package com.ve.module.locker.logic.database.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import org.litepal.crud.LitePalSupport
import java.io.Serializable

/**
 *
 *
 *
 *
 *
 * @author weiyi
 * @since 2022-04-10
 */
data class PrivacyPassDetails(

    var id: Long = 0,

    //(value = "登录账号")
    var account: String,

    //(value = "登录密码")
    var password: String,

    //(value = "链接")
    var url: String? = null,

    //(value = "绑定手机号")
    var phone: String? = null,

    //(value = "所属app名")
    var app: String? = null,

    //(value = "备注")
    var remark: String? =  "未设置备注",

    //(value = "是否加密")
    var enableEncrypt: Int=0,
) : LitePalSupport(), Serializable {


    companion object {
        const val serialVersionUID = 1L
    }
}
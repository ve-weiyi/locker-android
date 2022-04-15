package com.ve.module.locker.logic.database.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import org.litepal.crud.LitePalSupport
import java.io.Serializable

/**
 * @author weiyi
 * @since 2022-04-10
 */
data class DetailsCard(
    val id: Long = 0,

    //(value = "拥有人")
    val owner: String,

    //(value = "卡号")
    val number: String,

    //(value = "密码")
    val password: String? = null,

    //(value = "绑定手机号")
    val phone: String? = null,

    //(value = "绑定地址")
    val address: String? = null,

    //(value = "备注")
    val remark: String? = null,

    //(value = "是否加密")
    val enableEncrypt: Int = 0
) : LitePalSupport(), Serializable {

    companion object {
        const val serialVersionUID = 1L
    }
}
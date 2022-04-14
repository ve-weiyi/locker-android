package com.ve.module.locker.logic.http.model


import java.io.Serializable

/**
 *
 *
 *
 *
 *
 * @author weiyi
 * @since 2022-04-11
 */

data class PrivacyType(
    //(value = "id")

    val id: Int? = null,

    //(value = "类型名称")

    val typeName: String? = null,

    //(value = "英文名称")

    val typeNameEn: String? = null,

    //(value = "图标")

    val typeCover: String? = null,

    //(value = "颜色")

    val typeColor: String? = null,

    //(value = "描述")

    val typeDesc: String? = null,

    var ownerId: Int? = null,
) : Serializable {

    companion object {
         const val serialVersionUID = 1L
    }
}
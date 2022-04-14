package com.ve.module.locker.logic.http.model


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
data class PrivacyFolder(

    val id: Int? = null,

    val folderName: String? = null,

    val folderCover: String? = null,

    val folderDesc: String? = null,

    val folderEnable: Int=0,
) : Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }
}
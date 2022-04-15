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
data class PrivacyFolder(

    val id: Long=0,

    val folderName: String? = null,

    val folderCover: String? = null,

    val folderDesc: String? = null,

    val folderEnable: Int=0,
) : LitePalSupport(),Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }
}
package com.ve.module.locker.logic.database.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.chad.library.adapter.base.entity.SectionEntity
import org.litepal.annotation.Column
import org.litepal.annotation.Encrypt
import org.litepal.crud.LitePalSupport
import java.io.Serializable

/**
 * @author weiyi
 * @since 2022-04-10
 */
data class PrivacyFriends(
    var id: Long = 0,

    @Encrypt(algorithm = AES)
    var nickname: String,

    @Encrypt(algorithm = AES)
    var name: String,

    @Encrypt(algorithm = AES)
    var phone: String? = null,

    @Encrypt(algorithm = AES)
    var address: String? = null,

    @Encrypt(algorithm = AES)
    var department: String? = null,

    @Encrypt(algorithm = AES)
    var qq: String? = null,

    @Encrypt(algorithm = AES)
    var email: String? = null,

    @Encrypt(algorithm = AES)
    var remark: String? = "未设置备注",

    @Column(ignore = true)
    var headerName: String = "",

//    var enableEncrypt: Int = 0
) : LitePalSupport(), Serializable, SectionEntity {
    override val isHeader: Boolean
        get() = headerName.isNotEmpty()

    companion object {
        const val serialVersionUID = 1L
    }

}
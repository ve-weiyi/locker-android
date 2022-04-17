package com.ve.module.locker.logic.database.entity


import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import org.litepal.LitePal
import org.litepal.annotation.Column
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

    var id: Long=0,

    @Column(index = true, unique = true)
    val folderName: String,

    val folderCover: String? = null,

    val folderDesc: String? = null,

    val folderEnable: Int=0,
) : LitePalSupport(),Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }

    override fun save(): Boolean {
        val folder=LitePal.where("folderName=?", folderName).findFirst(PrivacyFolder::class.java)
        if(folder!=null){
            this.id=folder.id
            return this.saveOrUpdate()
        }
        return super.save()
    }
}
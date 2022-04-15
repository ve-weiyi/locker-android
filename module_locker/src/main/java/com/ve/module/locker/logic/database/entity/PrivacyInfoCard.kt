package com.ve.module.locker.logic.database.entity

import com.chad.library.adapter.base.entity.SectionEntity
import org.litepal.LitePal
import org.litepal.annotation.Column
import org.litepal.crud.LitePalSupport
import java.io.Serializable

/**
 * @Author  weiyi
 * @Date 2022/4/15
 * @Description  current project locker-android
 */
data class PrivacyInfoCard(
    @Column(unique = true, defaultValue = "unknown")
    var id: Long=0,

    //(varue = "隐私名", notes = "标签的备注名", example = "XX的QQ邮箱账号", position = 4)
    public var privacyName: String? = null,

    //( varue = "隐私图标", notes = "标签的覆盖图标", example = "https://ve77.cn/blog/favicon.ico", position = 5 )
    public var privacyCover: String? = null,

    //(varue = "隐私描述", notes = "标签描述", example = "床前明月光", position = 6)
    public var privacyDesc: String? = null,

    //(varue = "文件夹id")
    public var privacyFolderId: Long=1,

    //(varue = "隐私id")
    public var privacyDetailsId: Long=1,

    //(varue = "创建时间", notes = "标签创建时间,不用填", position = 7)
    public var createTime: String? = null,

    //(varue = "更新时间", notes = "标签更新时间,不用填", position = 8)
    public var updateTime: String? = null,
    @Column(ignore = true)
    var headerName: String = "",

//    /**
//     * 文件夹id
//     * 多对一,外键存id
//     */
//    @Column(ignore = true)
//    public var privacyFolder: PrivacyFolder? = null,
//
//    /**
//     * 隐私标签列表
//     * 多对多,额外表存映射
//     */
//    @Column(ignore = true)
//    public var privacyTags: List<PrivacyTag>? = null,
//
//    /**
//     * 一对一，主键关联
//     */
//    @Column(ignore = true)
//    public var privacyDetails: DetailsCard?=null,
) : LitePalSupport(),SectionEntity, Serializable {

    override val isHeader: Boolean
        get() = headerName.isNotEmpty()

    companion object {
        private const val serialVersionUID = 1L
    }



    /**
     * 文件夹id
     * 多对一,外键存id
     */
    fun getPrivacyFolder():PrivacyFolder{
        return LitePal.find(PrivacyFolder::class.java,privacyFolderId)
    }

    /**
     * 隐私标签列表
     * 多对多,额外表存映射
     */
    fun getPrivacyTags(): List<PrivacyTag>{
        val tagAndCards=LitePal.where("privacyId=?","$id").find(TagAndCard::class.java)
        val tags= mutableListOf<PrivacyTag>()
        tagAndCards.forEach {
            it->
            tags.add(LitePal.find(PrivacyTag::class.java,it.tagId))
        }
        return tags
    }

    /**
     * 一对一，主键关联
     */
    public fun  getPrivacyDetails(): DetailsCard{
        return LitePal.find(DetailsCard::class.java,privacyDetailsId)
    }


    /**
     * 文件夹id
     * 多对一,外键存id
     */
    fun setPrivacyFolder(privacyFolder: PrivacyFolder):Boolean{
        val res=LitePal.find(PrivacyFolder::class.java,privacyFolder.id)
        if(res==null){
            return false
        }else{
            privacyFolderId=privacyFolder.id
            return true
        }
    }

    /**
     * 隐私标签列表
     * 多对多,额外表存映射
     */
    fun setPrivacyTags(tags:List<PrivacyTag>): Boolean{
        LitePal.deleteAll(TagAndCard::class.java,"privacyId=?","$id")
        tags.forEach {
            tag->
            TagAndCard(tagId = tag.id, privacyId = id).save()
        }
        return true
    }

    /**
     * 一对一，主键关联
     */
    public fun  setPrivacyDetails(detailsCard: DetailsCard): Boolean{
        val res=LitePal.find(DetailsCard::class.java,detailsCard.id)
        if(res==null){
            return false
        }else{
            privacyDetailsId=detailsCard.id
            return true
        }
    }
}
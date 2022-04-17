package com.ve.module.locker.logic.database.vo

import com.ve.module.locker.logic.database.entity.*
import org.litepal.LitePal

/**
 * @Author  weiyi
 * @Date 2022/4/16
 * @Description  current project locker-android
 */
data class PrivacyCard(

    public val privacyInfo: PrivacyCardInfo,

    /**
     * 一对一，主键关联
     */

    public val privacyDetails: PrivacyCardDetails,

    /**
     * 文件夹id
     * 多对一,外键存id
     */

    public val privacyFolder: PrivacyFolder = LitePal.findFirst(PrivacyFolder::class.java),
    /**
     * 隐私标签列表
     * 多对多,额外表存映射
     */
    public var privacyTags: List<PrivacyTag>? = null,
) {

    @Synchronized
    fun saveOrUpdate(): Boolean {
//        LitePal.beginTransaction()
//        LogUtil.msg(privacyDetails.toString())
//        LogUtil.msg(LitePal.findAll(CardDetails::class.java).toString())
        val res1=privacyFolder.saveOrUpdate()
        val res2=privacyDetails.saveOrUpdate()

        privacyInfo.privacyFolderId=privacyFolder.id
        privacyInfo.privacyDetailsId=privacyDetails.id
        val res3=privacyInfo.saveOrUpdate()

        val res4=LitePal.deleteAll(TagAndCard::class.java, "privacyId=?", "${privacyInfo.id}")
        privacyTags?.forEach { privacyTag
            ->
            val result = LitePal.where("tagName=?", privacyTag.tagName).findFirst(PrivacyTag::class.java)
            if (result != null) {
                //标签名不能重复
                val tagAndCard = TagAndCard(tagId = result.id, privacyId = privacyInfo.id)
                tagAndCard.saveOrUpdate()
            } else {
                privacyTag.saveOrUpdate()
                val tagAndCard = TagAndCard(tagId = privacyTag.id, privacyId = privacyInfo.id)
                tagAndCard.saveOrUpdate()
            }
        }
        return res1&&res2&&res3
//        LogUtil.msg(privacyDetails.toString())
//        LogUtil.msg(LitePal.findAll(CardDetails::class.java).toString())
//        LitePal.endTransaction()
//        LitePal.setTransactionSuccessful()
    }

    @Synchronized
    fun delete():Boolean{
        val res1=privacyFolder.delete()
        val res2=privacyDetails.delete()
        val res3=privacyInfo.delete()
        val res4=LitePal.deleteAll(TagAndCard::class.java, "privacyId=?", "${privacyInfo.id}")

        return true
    }
}
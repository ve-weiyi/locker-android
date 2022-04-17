package com.ve.module.locker.logic.database.vo

import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.logic.database.entity.*
import org.litepal.LitePal
import org.litepal.annotation.Column

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
    fun save(): Boolean {
        val res1 = privacyFolder.saveOrUpdate("folderName=?",privacyFolder.folderName)
        val res2 = privacyDetails.saveOrUpdate("id=?",privacyDetails.id.toString())

        privacyInfo.privacyFolderId = privacyFolder.id
        privacyInfo.privacyDetailsId = privacyDetails.id

        val res3 = privacyInfo.saveOrUpdate("id=?",privacyInfo.id.toString())

        //先删除这条隐私下的所有的标签，再添加
        val res4 = LitePal.deleteAll(TagAndCard::class.java, "privacyId=?", "${privacyInfo.id}")
        privacyTags?.forEach { privacyTag
            ->
            privacyTag.saveOrUpdate("tagName=?",privacyTag.tagName)
            val tagAndCard = TagAndCard(tagId = privacyTag.id, privacyId = privacyInfo.id)
            tagAndCard.save()
//            val result = LitePal.where("tagName=?", privacyTag.tagName).findFirst(PrivacyTag::class.java)
//            if (result != null) {
//                //标签名不能重复
//                val tagAndCard = TagAndCard(tagId = result.id, privacyId = privacyInfo.id)
//                tagAndCard.save()
//            } else {
//                privacyTag.save()
//                val tagAndCard = TagAndCard(tagId = privacyTag.id, privacyId = privacyInfo.id)
//                tagAndCard.save()
//            }
        }

        return res1 && res2 && res3
    }

    /**
     * tag 和 folder 不需要修改
     * tagAndCard 和 details info 需要删除
     */
    @Synchronized
    fun delete(): Boolean {
        val res4 = LitePal.deleteAll(TagAndCard::class.java, "privacyId=?", "${privacyInfo.id}")
        val res2 = privacyDetails.delete()
        val res3 = privacyInfo.delete()
        return true
    }

    companion object{
        fun getAll():List<PrivacyCard>{
            val privacyCardInfos=LitePal.findAll(PrivacyCardInfo::class.java)
            val cards= mutableListOf<PrivacyCard>()
            privacyCardInfos.forEach {
                card->
                cards.add(
                    PrivacyCard(card,card.getPrivacyDetails(),card.getPrivacyFolder(),card.getPrivacyTags())
                )
            }
            return cards
        }
    }
}
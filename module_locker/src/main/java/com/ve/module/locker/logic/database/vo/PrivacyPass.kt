package com.ve.module.locker.logic.database.vo

import com.ve.module.locker.logic.database.entity.*
import org.litepal.LitePal
import org.litepal.annotation.Column

/**
 * @Author  weiyi
 * @Date 2022/4/16
 * @Description  current project locker-android
 */
data class PrivacyPass(

    public val privacyInfo: PrivacyPassInfo,

    /**
     * 一对一，主键关联
     */

    public val privacyDetails: PrivacyPassDetails,

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
        val res1 = privacyFolder.save()
        val res2 = privacyDetails.save()

        privacyInfo.privacyFolderId = privacyFolder.id
        privacyInfo.privacyDetailsId = privacyDetails.id
        val res3 = privacyInfo.save()
        //先删除这条隐私下的所有的标签，再添加
        val res4 = LitePal.deleteAll(TagAndPass::class.java, "privacyId=?", "${privacyInfo.id}")
        privacyTags?.forEach { privacyTag
            ->
            val result = LitePal.where("tagName=?", privacyTag.tagName).findFirst(PrivacyTag::class.java)
            if (result != null) {
                //标签名不能重复
                val tagAndPass = TagAndPass(tagId = result.id, privacyId = privacyInfo.id)
                tagAndPass.save()
            } else {
                privacyTag.save()
                val tagAndPass = TagAndPass(tagId = privacyTag.id, privacyId = privacyInfo.id)
                tagAndPass.save()
            }
        }

        return res1 && res2 && res3
    }

    @Synchronized
    fun delete(): Boolean {
        val res1 = privacyFolder.delete()
        val res2 = privacyDetails.delete()
        val res3 = privacyInfo.delete()
        val res4 = LitePal.deleteAll(TagAndPass::class.java, "privacyId=?", "${privacyInfo.id}")

        return true
    }
}
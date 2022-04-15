package com.ve.module.locker.logic.database

import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.logic.database.dao.PrivacyInfoDao
import com.ve.module.locker.logic.database.entity.*
import org.litepal.LitePal
import org.litepal.extension.saveAll

/**
 * @Author  weiyi
 * @Date 2022/4/15
 * @Description  current project locker-android
 */
object AppDataBase {

    val dao = PrivacyInfoDao
    fun initDataBase() {
        LitePal.deleteDatabase("locker")

        val tagList = mutableListOf<PrivacyTag>(
            PrivacyTag(tagName = "我的银行卡", tagCover = "#AABBCC"),
            PrivacyTag(tagName = "我的QQ号", tagCover = "#AABBCC"),
            PrivacyTag(tagName = "我的QQ号2", tagCover = "#AABBCC"),
        )

        val folderList = mutableListOf<PrivacyFolder>(
            PrivacyFolder(folderName = "默认", folderCover = "#AABBCC"),
            PrivacyFolder(folderName = "娱乐", folderCover = "#AABBCC"),
            PrivacyFolder(folderName = "办公", folderCover = "#AABBCC"),
            PrivacyFolder(folderName = "论坛", folderCover = "#AABBCC"),
            PrivacyFolder(folderName = "教育", folderCover = "#AABBCC"),
        )

        val detailsCard = DetailsCard(owner = "www", number = "123123")
        detailsCard.save()

        val cardList = mutableListOf<PrivacyInfoCard>(
            PrivacyInfoCard(privacyName = "银行卡1", privacyFolderId = 1).apply {
                setPrivacyTags(tagList)
            },
            PrivacyInfoCard(privacyName = "银行卡2", privacyFolderId = 1).apply {
                setPrivacyTags(tagList)
            },
            PrivacyInfoCard(privacyName = "银行卡3", privacyFolderId = 1).apply {
                setPrivacyTags(tagList)
            }

        )

        val detailsPass = DetailsPass(account = "791422171", password = "asfafasdfs")
        detailsPass.save()
        val passList = mutableListOf<PrivacyInfoPass>(
            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
                // privacyTags=tagList
            },
            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
                //  privacyTags=tagList
            },
            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
                //  privacyTags=tagList
            },
            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
                //  privacyTags=tagList
            }
        )

        tagList.saveAll()
        folderList.saveAll()
        cardList.saveAll()
        passList.saveAll()

        val tags=LitePal.findAll(PrivacyTag::class.java)
        val cards=LitePal.findAll(PrivacyInfoCard::class.java)
        cards.forEach {
                it->it.setPrivacyTags(tags)
        }

        LogUtil.msg(LitePal.findAll(TagAndCard::class.java).toString())
    }
}
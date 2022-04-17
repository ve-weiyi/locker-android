package com.ve.module.locker.logic.database

import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.logic.database.dao.PrivacyInfoDao
import com.ve.module.locker.logic.database.entity.*
import com.ve.module.locker.logic.database.vo.PrivacyCard
import com.ve.module.locker.logic.database.vo.PrivacyPass
import org.litepal.LitePal

/**
 * @Author  weiyi
 * @Date 2022/4/15
 * @Description  current project locker-android
 */
object AppDataBase {

    val dao = PrivacyInfoDao
    fun initDataBase() {
        LitePal.deleteDatabase("locker")

        val privacyPassList = mutableListOf<PrivacyPass>(
            PrivacyPass(
                PrivacyPassInfo(privacyName = "qq账号", privacyDesc = "这是开发者的QQ账号哦，遇到问题可以反馈。"),
                PrivacyPassDetails(account = "791422171", password = "123456789"),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "QQ账号"), PrivacyTag(tagName = "测试标签"))
            ),
            PrivacyPass(
                PrivacyPassInfo(privacyName = "邮箱账号", privacyDesc = "这是我的的个人邮箱，遇到问题可以反馈。"),
                PrivacyPassDetails(account = "791422171@qq.com", password = "123456789"),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "邮箱账号"), PrivacyTag(tagName = "测试标签"))
            ),
            PrivacyPass(
                PrivacyPassInfo(
                    privacyName = "https://ve77.com/blog",
                    privacyDesc = "这是我的的个人博客网站，遇到问题可以反馈。"
                ),
                PrivacyPassDetails(account = "test@qq.com", password = "1234567"),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "博客"), PrivacyTag(tagName = "测试标签"))
            ),
            PrivacyPass(
                PrivacyPassInfo(
                    privacyName = "https://github.com/7914-ve/locker-android",
                    privacyDesc = "项目源码。"
                ),
                PrivacyPassDetails(account = "test@qq.com", password = "1234567"),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "源码"), PrivacyTag(tagName = "测试标签"))
            ),
        )

        val privacyCardList = mutableListOf<PrivacyCard>(
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试校园卡", privacyDesc = "华中科技大学校园卡。"),
                PrivacyCardDetails(owner = "weiyi", number = "U201814550", password = "1234567"),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "校园卡"), PrivacyTag(tagName = "测试标签"))
            ),
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试身份证", privacyDesc = "个人身份证"),
                PrivacyCardDetails(
                    owner = "weiyi1",
                    number = "452724***********1",
                    password = "1234567"
                ),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "身份证"), PrivacyTag(tagName = "测试标签"))
            ),
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试驾驶证", privacyDesc = "desc"),
                PrivacyCardDetails(owner = "weiyi1", number = "U201814550", password = "1234567"),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "驾驶证"), PrivacyTag(tagName = "测试标签"))
            ),
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试银行卡", privacyDesc = "desc"),
                PrivacyCardDetails(owner = "weiyi1", number = "U201814550", password = "1234567"),
                PrivacyFolder(folderName = "默认"),
                mutableListOf(PrivacyTag(tagName = "银行卡"), PrivacyTag(tagName = "测试标签"))
            )
        )

        privacyPassList.forEach { pass ->
            pass.save()
        }
        privacyCardList.forEach { card ->
            card.saveOrUpdate()
        }
        LogUtil.msg(privacyPassList.toString())
        LogUtil.msg(privacyCardList.toString())




        LogUtil.msg(privacyCardList.toString())
//        val tagList = mutableListOf<PrivacyTag>(
//            PrivacyTag(tagName = "我的银行卡", tagCover = "#AABBCC"),
//            PrivacyTag(tagName = "我的QQ号", tagCover = "#AABBCC"),
//            PrivacyTag(tagName = "我的QQ号2", tagCover = "#AABBCC"),
//        )
//
//        val folderList = mutableListOf<PrivacyFolder>(
//            PrivacyFolder(folderName = "默认", folderCover = "#AABBCC"),
//            PrivacyFolder(folderName = "娱乐", folderCover = "#AABBCC"),
//            PrivacyFolder(folderName = "办公", folderCover = "#AABBCC"),
//            PrivacyFolder(folderName = "论坛", folderCover = "#AABBCC"),
//            PrivacyFolder(folderName = "教育", folderCover = "#AABBCC"),
//        )
//
//        val detailsCard = CardDetails(owner = "www", number = "123123")
//        detailsCard.save()
//
//        val cardList = mutableListOf<PrivacyInfoCard>(
//            PrivacyInfoCard(privacyName = "银行卡1", privacyFolderId = 1).apply {
//                setPrivacyTags(tagList)
//            },
//            PrivacyInfoCard(privacyName = "银行卡2", privacyFolderId = 1).apply {
//                setPrivacyTags(tagList)
//            },
//            PrivacyInfoCard(privacyName = "银行卡3", privacyFolderId = 1).apply {
//                setPrivacyTags(tagList)
//            }
//
//        )
//
//        val detailsPass = PassDetails(account = "791422171", password = "asfafasdfs")
//        detailsPass.save()
//        val passList = mutableListOf<PrivacyInfoPass>(
//            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
//                // privacyTags=tagList
//            },
//            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
//                //  privacyTags=tagList
//            },
//            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
//                //  privacyTags=tagList
//            },
//            PrivacyInfoPass(privacyName = "qq", privacyFolderId = 1).apply {
//                //  privacyTags=tagList
//            }
//        )
//
//        tagList.saveAll()
//        folderList.saveAll()
//        cardList.saveAll()
//        passList.saveAll()
//
//
//        val tags = LitePal.findAll(PrivacyTag::class.java)
//        val cards = LitePal.findAll(PrivacyInfoCard::class.java)
//        cards.forEach { it ->
//            it.setPrivacyTags(tags)
//        }
//
//        LogUtil.msg(tagList.toString())
//        LogUtil.msg(LitePal.findAll(TagAndCard::class.java).toString())
    }
}
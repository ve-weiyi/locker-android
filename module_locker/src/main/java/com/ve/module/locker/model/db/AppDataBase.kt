package com.ve.module.locker.model.db

import com.ve.lib.utils.CommonUtil
import com.ve.lib.vutils.LogUtil
import com.ve.lib.vutils.SpUtil
import com.ve.module.locker.common.config.SettingConstant
import com.ve.module.locker.model.db.dao.PrivacyInfoDao
import com.ve.module.locker.model.db.entity.*
import com.ve.module.locker.model.db.vo.PrivacyCard
import com.ve.module.locker.model.db.vo.PrivacyPass
import org.litepal.LitePal

/**
 * @Author  weiyi
 * @Date 2022/4/15
 * @Description  current project locker-android
 */
object AppDataBase {

    val dao = PrivacyInfoDao
    fun initDataBase() {
        LitePal.aesKey("1234567890123456");
//        LogUtil.msg(SpUtil.setValue(SettingConstant.SP_KEY_DATABASE_INIT,true))
//        LogUtil.msg(SpUtil.getBoolean(SettingConstant.SP_KEY_DATABASE_INIT))

        if(SpUtil.getValue(SettingConstant.SP_KEY_DATABASE_INIT,true)){
            LogUtil.msg("data already init");
            return
        }

        LitePal.deleteDatabase("locker")

        val privacyPassList = mutableListOf<PrivacyPass>(
            PrivacyPass(
                PrivacyPassInfo(privacyName = "qq账号", privacyDesc = "应用开发者的QQ账号。"),
                PrivacyPassDetails(
                    account = "791422171", password = "123456789",
                    appPackageName = "com.tencent.mobileqq", url = "https://im.qq.com/index",
                    phone = "15623356029", remark = "开发者QQ账号，遇到问题可以反馈"
                ),
                PrivacyFolder(folderName = "默认", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "QQ账号"))
            ),
            PrivacyPass(
                PrivacyPassInfo(privacyName = "邮箱账号", privacyDesc = "这是我的的个人邮箱，遇到问题可以反馈。"),
                PrivacyPassDetails(
                    account = "791422171@qq.com",
                    password = "123456789",
                    appPackageName = "com.tencent.androidqqmail"
                ),
                PrivacyFolder(folderName = "社交", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "邮箱账号"))
            ),
            PrivacyPass(
                PrivacyPassInfo(
                    privacyName = "我的博客",
                    privacyDesc = "这是我的的个人博客网站，遇到问题可以反馈。"
                ),
                PrivacyPassDetails(
                    account = "https://ve77.com/blog",
                    url = "https://ve77.com/blog",
                    password = "1234567"
                ),
                PrivacyFolder(folderName = "娱乐", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "博客"))
            ),
            PrivacyPass(
                PrivacyPassInfo(
                    privacyName = "项目源码。",
                    privacyDesc = "GitHub项目源码地址。"
                ),
                PrivacyPassDetails(
                    account = "https://github.com/7914-ve/locker-android",
                    url = "https://github.com/7914-ve/locker-android",
                    password = "1234567"
                ),
                PrivacyFolder(folderName = "教育", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "源码"))
            ),
        )

        val privacyCardList = mutableListOf<PrivacyCard>(
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试校园卡", privacyDesc = "华中科技大学校园卡。"),
                PrivacyCardDetails(owner = "weiyi", number = "U201814550", password = "1234567"),
                PrivacyFolder(folderName = "默认", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "校园卡"))
            ),
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试身份证", privacyDesc = "个人身份证"),
                PrivacyCardDetails(
                    owner = "weiyi1",
                    number = "452724***********1",
                    password = "1234567"
                ),
                PrivacyFolder(folderName = "论坛", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "身份证"))
            ),
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试驾驶证", privacyDesc = "desc"),
                PrivacyCardDetails(owner = "weiyi1", number = "U201814550", password = "1234567"),
                PrivacyFolder(folderName = "办公", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "驾驶证"))
            ),
            PrivacyCard(
                PrivacyCardInfo(privacyName = "测试银行卡", privacyDesc = "desc"),
                PrivacyCardDetails(owner = "weiyi1", number = "U201814550", password = "1234567"),
                PrivacyFolder(folderName = "默认", folderCover = CommonUtil.randomColor().toString()),
                mutableListOf(PrivacyTag(tagName = "测试标签"), PrivacyTag(tagName = "银行卡"))
            )
        )

        val privacyFriendsList = mutableListOf<PrivacyFriendsInfo>(
            PrivacyFriendsInfo(
                nickname = "甘老师",
                name = "甘早斌",
                sex = 1,
                birthday = "2000-05-01",
                phone = "15623356029",
                qq = "791422171",
                email = "791422171@qq.com",
                wechat = "wy791422171",
                address = "华中科技大学",
                department = "计算机科学与技术学院",
                remark = "毕设老师"
            ),
            PrivacyFriendsInfo(
                nickname = "谭老师",
                name = "谭志虎",
                sex = 0,
                birthday = "2000-05-01",
                phone = "15623356029",
                qq = "791422171",
                email = "791422171@qq.com",
                wechat = "wy791422171",
                address = "华中科技大学",
                department = "计算机科学与技术学院",
                remark = "计算机学院副院长"
            ),
            PrivacyFriendsInfo(
                nickname = "韦同学",
                name = "韦XX",
                sex = 1,
                birthday = "2000-05-01",
                phone = "15623356029",
                qq = "791422171",
                email = "791422171@qq.com",
                wechat = "wy791422171",
                address = "华中科技大学",
                department = "计算机科学与技术学院",
                remark = "学生"
            ),
        )
        privacyPassList.forEach { pass ->
            pass.save()
        }
        privacyCardList.forEach { card ->
            card.save()
        }
        privacyFriendsList.forEach { friends ->
            friends.save()
        }

        LogUtil.msg(LitePal.findAll(PrivacyTag::class.java).toString())
        LogUtil.msg(LitePal.findAll(PrivacyFolder::class.java).toString())
        LogUtil.msg(LitePal.findAll(PrivacyCardDetails::class.java).toString())
        LogUtil.msg(LitePal.findAll(PrivacyCardInfo::class.java).toString())
//        LogUtil.msg(LitePal.findAll(PrivacyPassDetails::class.java).toString())
//        LogUtil.msg(LitePal.findAll(PrivacyPassInfo::class.java).toString())

//        privacyPassList.forEach { pass ->
//            pass.delete()
//        }
//        privacyCardList.forEach { card ->
//            card.delete()
//        }
//
//        LogUtil.msg(LitePal.findAll(PrivacyTag::class.java).toString())
//        LogUtil.msg(LitePal.findAll(PrivacyFolder::class.java).toString())
//        LogUtil.msg(LitePal.findAll(PrivacyCardDetails::class.java).toString())
//        LogUtil.msg(LitePal.findAll(PrivacyCardInfo::class.java).toString())
//        LogUtil.msg(LitePal.findAll(PrivacyPassDetails::class.java).toString())
//        LogUtil.msg(LitePal.findAll(PrivacyPassInfo::class.java).toString())


        val cards = PrivacyCard.getAll()
        LogUtil.msg(cards.toString())

        val passwords = PrivacyPass.getAll()
        LogUtil.msg(passwords.toString())

        SpUtil.setValue(SettingConstant.SP_KEY_DATABASE_INIT,false);
    }
}
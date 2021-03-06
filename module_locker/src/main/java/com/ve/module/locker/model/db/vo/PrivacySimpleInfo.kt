package com.ve.module.locker.model.db.vo

import com.ve.lib.utils.CommonUtil
import com.ve.lib.vutils.DateTimeUtil

/**
 * @Author  weiyi
 * @Date 2022/5/7
 * @Description  current project locker-android
 */
data class PrivacySimpleInfo(
    //(varue = "隐私名", notes = "标签的备注名", example = "XX的QQ邮箱账号", position = 4)
    public var privacyName: String = "",

    //( varue = "隐私图标", notes = "标签的覆盖图标", example = "https://ve77.cn/blog/favicon.ico", position = 5 )
    public var privacyCover: String = CommonUtil.randomColor().toString(),

    //(varue = "隐私描述", notes = "标签描述", example = "床前明月光", position = 6)
    public var privacyDesc: String = "",

    //(varue = "创建时间", notes = "标签创建时间,不用填", position = 7)
    public var createTime: String = DateTimeUtil.dateAndTime,

    //(varue = "更新时间", notes = "标签更新时间,不用填", position = 8)
    public var updateTime: String = DateTimeUtil.dateAndTime,
) {


}
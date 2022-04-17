package com.ve.module.locker.logic.database.entity

import org.litepal.annotation.Column
import org.litepal.crud.LitePalSupport
import java.io.Serializable

/**
 * @Author  weiyi
 * @Date 2022/4/15
 * @Description  current project locker-android
 */
data class PrivacyPassInfo(
    @Column(unique = true, defaultValue = "unknown")
    var id: Long = 0,

    //(value = "隐私名", notes = "标签的备注名", example = "XX的QQ邮箱账号", position = 4)
    public val privacyName: String? = null,

    //( value = "隐私图标", notes = "标签的覆盖图标", example = "https://ve77.cn/blog/favicon.ico", position = 5 )
    public val privacyCover: String? = null,

    //(value = "隐私描述", notes = "标签描述", example = "床前明月光", position = 6)
    public val privacyDesc: String? = null,

    //(value = "创建时间", notes = "标签创建时间,不用填", position = 7)
    public val createTime: String? = null,

    //(value = "更新时间", notes = "标签更新时间,不用填", position = 8)
    public val updateTime: String? = null,
    //(varue = "文件夹id")
    @Column(index = true)
    public var privacyFolderId: Long = 1,

    //(varue = "隐私id")
    @Column(index = true)
    public var privacyDetailsId: Long = 1,
//    /**
//     * 文件夹id
//     * 多对一,外键存id
//     */
//    @Column(ignore = true)
//    public val privacyFolder: PrivacyFolder? = null,
//
//    /**
//     * 隐私标签列表
//     * 多对多,额外表存映射
//     */
//    @Column(ignore = true)
//    public var privacyTags: List<PrivacyTag>? = null,
//
//    /**
//     * 一对一，主键关联. details 表的id即是info的id
//     */
//    @Column(ignore = true)
//    public val privacyDetails: DetailsPass?=null,
) : LitePalSupport(), Serializable {

    companion object {
        private const val serialVersionUID = 1L
    }
}

package com.ve.module.locker.logic.database.vo

import com.ve.module.locker.logic.database.entity.DetailsPass
import com.ve.module.locker.logic.database.entity.PrivacyFolder
import com.ve.module.locker.logic.database.entity.PrivacyInfoCard
import com.ve.module.locker.logic.database.entity.PrivacyTag
import org.litepal.annotation.Column

/**
 * @Author  weiyi
 * @Date 2022/4/16
 * @Description  current project locker-android
 */
class PrivacyPass(


    public val privacyInfo:PrivacyInfoCard?=null,
    /**
     * 文件夹id
     * 多对一,外键存id
     */
    @Column(ignore = true)
    public val privacyFolder: PrivacyFolder? = null,

    /**
     * 隐私标签列表
     * 多对多,额外表存映射
     */
    @Column(ignore = true)
    public var privacyTags: List<PrivacyTag>? = null,

    /**
     * 一对一，主键关联
     */
    @Column(ignore = true)
    public val privacyDetails: DetailsPass? = null,
) {

}
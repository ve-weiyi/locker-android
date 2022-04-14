package com.ve.module.locker.ui.adapter

import com.ve.lib.common.base.adapter.BaseSlideBindingAdapter
import com.ve.lib.common.base.adapter.VBViewHolder
import com.ve.module.locker.databinding.LockerItemPrivacyAccountBinding
import com.ve.module.locker.logic.http.model.UserPrivacyInfoCardResponse

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/10
 */
class UserPrivacyInfoCardAdapter:
    BaseSlideBindingAdapter<UserPrivacyInfoCardResponse, LockerItemPrivacyAccountBinding>() {

    override fun convert(holder: VBViewHolder<LockerItemPrivacyAccountBinding>, item: UserPrivacyInfoCardResponse) {
        val privacyInfo=item.privacyDetails

        mBinding.itemPrivacyInfoType.text=item.privacyType.toString()
        mBinding.itemPrivacyInfoName.text=item.privacyName
        mBinding.itemPrivacyInfoDesc.text=item.privacyDesc
        mBinding.itemPrivacyInfoUpdateTime.text=item.updateTime.toString()
        mBinding.itemPrivacyInfoCreateTime.text=item.createTime.toString()
    }


}
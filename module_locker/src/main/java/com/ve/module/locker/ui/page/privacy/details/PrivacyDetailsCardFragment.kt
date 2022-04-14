package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentDetailsPassBinding
import com.ve.module.locker.logic.http.model.PrivacyDetailsCard
import com.ve.module.locker.ui.state.LockerPrivacyCardViewModel

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class PrivacyDetailsCardFragment:BaseVmFragment<LockerFragmentDetailsPassBinding,LockerPrivacyCardViewModel>() {

    companion object{
        const val PRIVACY_CARD_KEY="PrivacyDetailsCard"

    }
    override fun attachViewBinding(): LockerFragmentDetailsPassBinding {
        return LockerFragmentDetailsPassBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCardViewModel> {
        return LockerPrivacyCardViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {
        val privacyDetails =arguments?.getSerializable(PRIVACY_CARD_KEY) as PrivacyDetailsCard
        LogUtil.e(privacyDetails.toString())

        showPrivacyDetails(privacyDetails)
    }

    private fun showPrivacyDetails(privacyDetails : PrivacyDetailsCard){
        mBinding.apply {
            etDetailAccount.setText(privacyDetails.owner)
            etDetailPassword.setText(privacyDetails.password)
            etDetailPasswordTag.setText(privacyDetails.password)
            etDetailApp.setText(privacyDetails.address)
            etDetailPhone.setText(privacyDetails.phone)
            etDetailUrl.setText(privacyDetails.url)
            etDetailRemark.setText(privacyDetails.remark)
        }
    }
}
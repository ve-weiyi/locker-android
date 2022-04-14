package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentDetailsPassBinding
import com.ve.module.locker.logic.http.model.PrivacyDetailsPass
import com.ve.module.locker.ui.state.LockerPrivacyPassViewModel

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class PrivacyDetailsPassFragment:BaseVmFragment<LockerFragmentDetailsPassBinding,LockerPrivacyPassViewModel>() {

    companion object{
        const val PRIVACY_PASS_KEY="PrivacyDetailsPass"

    }
    override fun attachViewBinding(): LockerFragmentDetailsPassBinding {
        return LockerFragmentDetailsPassBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyPassViewModel> {
        return LockerPrivacyPassViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {
        val privacyDetails =arguments?.getSerializable(PRIVACY_PASS_KEY) as PrivacyDetailsPass
        LogUtil.e(privacyDetails.toString())

        showPrivacyDetails(privacyDetails)
    }

    private fun showPrivacyDetails(privacyDetails :PrivacyDetailsPass){
        mBinding.apply {
            etDetailAccount.setText(privacyDetails.account)
            etDetailPassword.setText(privacyDetails.password)
            etDetailPasswordTag.setText(privacyDetails.password)
            etDetailApp.setText(privacyDetails.appName)
            etDetailPhone.setText(privacyDetails.phone)
            etDetailUrl.setText(privacyDetails.url)
            etDetailRemark.setText(privacyDetails.remark)
        }
    }
}
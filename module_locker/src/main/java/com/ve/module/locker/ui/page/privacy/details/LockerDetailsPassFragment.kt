package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentPassSeeBinding
import com.ve.module.locker.logic.database.entity.DetailsPass
import com.ve.module.locker.logic.http.model.PrivacyDetailsPass
import com.ve.module.locker.ui.state.LockerPrivacyPassViewModel

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class LockerDetailsPassFragment:BaseVmFragment<LockerFragmentPassSeeBinding,LockerPrivacyPassViewModel>() {

    companion object{
        const val PRIVACY_DATA_KEY="PrivacyDetailsPass"

    }
    override fun attachViewBinding(): LockerFragmentPassSeeBinding {
        return LockerFragmentPassSeeBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyPassViewModel> {
        return LockerPrivacyPassViewModel::class.java
    }
    var privacyDetailsId:Long? = null
    override fun initView(savedInstanceState: Bundle?) {
        privacyDetailsId=arguments?.getLong(PRIVACY_DATA_KEY)
        if(privacyDetailsId!=null){
            mViewModel.queryPrivacyDetails(privacyDetailsId!!)
        }

    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.queryDetailsResult.observe(this){
            LogUtil.e(it.toString())
            showPrivacyDetails(it)
        }
    }
    private fun showPrivacyDetails(privacyDetails : DetailsPass){
        mBinding.apply {
            etDetailAccount.setText(privacyDetails.account)
            etDetailPassword.setText(privacyDetails.password)
            etDetailApp.setText(privacyDetails.appName)
            etDetailPhone.setText(privacyDetails.phone)
            etDetailRemark.setText(privacyDetails.remark)
        }
    }
}
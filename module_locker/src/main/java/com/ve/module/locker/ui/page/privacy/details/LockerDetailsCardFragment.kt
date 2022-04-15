package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentCardSeeBinding
import com.ve.module.locker.logic.database.entity.DetailsCard
import com.ve.module.locker.logic.database.entity.PrivacyInfoCard
import com.ve.module.locker.ui.state.LockerPrivacyCardViewModel

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class LockerDetailsCardFragment:BaseVmFragment<LockerFragmentCardSeeBinding,LockerPrivacyCardViewModel>() {

    companion object{
        const val PRIVACY_DATA_KEY="DetailsCard"

    }
    override fun attachViewBinding(): LockerFragmentCardSeeBinding {
        return LockerFragmentCardSeeBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCardViewModel> {
        return LockerPrivacyCardViewModel::class.java
    }

    var privacyInfoCard:PrivacyInfoCard?=null

    override fun initView(savedInstanceState: Bundle?) {

        privacyInfoCard=arguments?.getSerializable(PRIVACY_DATA_KEY) as PrivacyInfoCard
        LogUtil.msg(privacyInfoCard.toString())
        LogUtil.msg(privacyInfoCard!!.getPrivacyTags().toString())
        LogUtil.msg(privacyInfoCard!!.getPrivacyFolder().toString())
        LogUtil.msg(privacyInfoCard!!.getPrivacyDetails().toString())
        if(privacyInfoCard!=null){
            shoPrivacyInfo(privacyInfoCard!!)

        }

    }


    private fun shoPrivacyInfo(privacyInfoCard:PrivacyInfoCard){
        mBinding.apply {
            tvPrivacyName.text=privacyInfoCard.privacyName
            tvPrivacyDesc.text=privacyInfoCard.privacyDesc
        }
    }


    private fun showPrivacyDetails(privacyDetails : DetailsCard){
        mBinding.apply {
            etDetailAccount.setText(privacyDetails.owner)
            etDetailPassword.setText(privacyDetails.password)
            etDetailApp.setText(privacyDetails.address)
            etDetailPhone.setText(privacyDetails.phone)
            etDetailRemark.setText(privacyDetails.remark)
        }
    }
}
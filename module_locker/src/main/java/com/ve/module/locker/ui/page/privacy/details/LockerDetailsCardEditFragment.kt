package com.ve.module.locker.ui.page.privacy.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.databinding.LockerFragmentCardEditBinding
import com.ve.module.locker.logic.database.entity.DetailsCard
import com.ve.module.locker.logic.database.entity.PrivacyInfoCard
import com.ve.module.locker.ui.state.LockerPrivacyCardViewModel

/**
 * @Author  weiyi
 * @Date 2022/4/11
 * @Description  current project locker-android
 */
class LockerDetailsCardEditFragment:BaseVmFragment<LockerFragmentCardEditBinding,LockerPrivacyCardViewModel>() {
    override fun attachViewBinding(): LockerFragmentCardEditBinding {
        return LockerFragmentCardEditBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCardViewModel> {
        return LockerPrivacyCardViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.locker_privacy_edit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_privacy_check->{
                LogUtil.msg("onOptionsItemSelected")
                mBinding.apply {
                    val name: String = layoutBaseInfo.etPrivacyName.text.toString()
                    val desc = layoutBaseInfo.etPrivacyDesc.text.toString()

                    val owner = layoutDetailsInfo.etDetailOwner.text.toString()
                    val account = layoutDetailsInfo.etDetailAccount.text.toString()
                    val password = layoutDetailsInfo.etDetailPassword.text.toString()
                    val address = layoutDetailsInfo.etDetailAddress.text.toString()
                    val phone = layoutDetailsInfo.etDetailPhone.text.toString()
                    val remark = layoutDetailsInfo.etDetailRemark.text.toString()

                    val detailsCard = DetailsCard(
                        owner = owner,
                        number = account,
                        password = password,
                        phone = phone,
                        address = address,
                        remark = remark
                    )

                    val privacyInfoCard = PrivacyInfoCard(
                        privacyName = name,
                        privacyDesc = desc,
                        privacyCover = "#00AA00"
                    )
                    mViewModel.addPrivacyInfo(detailsCard, privacyInfoCard)
                    return true
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.addPrivacyInfoMsg.observe(this){
            LogUtil.msg("346576798090")
            showMsg(it)
            activity?.finish()
        }
    }
}
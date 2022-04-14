package com.ve.module.locker.ui.page.drawer

import android.os.Bundle
import android.view.View
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.lib.common.utils.ImageLoader
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.common.config.LockerConstant
import com.ve.module.locker.common.config.LockerLifecycle
import com.ve.module.locker.common.config.LockerSharePreference
import com.ve.module.locker.databinding.LockerFragmentDrawerHeaderBinding
import com.ve.module.locker.logic.http.model.LoginVO
import com.ve.module.locker.ui.page.auth.LockerLoginActivity
import com.ve.module.locker.ui.page.setting.LockerSettingActivity
import com.ve.module.locker.ui.page.setting.StyleSettingFragment
import com.ve.module.locker.ui.state.LockerDrawerViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerDrawerHeaderFragment :
    BaseVmFragment<LockerFragmentDrawerHeaderBinding, LockerDrawerViewModel>() {
    override fun attachViewBinding(): LockerFragmentDrawerHeaderBinding {
        return LockerFragmentDrawerHeaderBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerDrawerViewModel> {
        return LockerDrawerViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {
        showHeather(LockerSharePreference.getLoginState())
        showUserInfo(LockerSharePreference.getLoginData())
    }

    //val userInfoAdapter by lazy { UserInfoAdapter() }
    private fun showHeather(isLogin: Boolean) {
        if (isLogin) {
            mBinding.layoutUserinfo.rlMainAvatar.visibility = View.VISIBLE
            mBinding.layoutUnLogin.visibility = View.GONE
        } else {
            mBinding.layoutUserinfo.rlMainAvatar.visibility = View.GONE
            mBinding.layoutUnLogin.visibility = View.VISIBLE
        }
    }

    private fun showUserInfo(it :LoginVO){
        mBinding.layoutUserinfo.apply {
            val item = it.userDetailDTO
            ImageLoader.load(mContext, item.avatar, itemIvAvatarIcon)
            itemTvAvatarNickname.text = item.nickname
            itemTvUserIntro.text = item.intro
        }
    }

    override fun initObserver() {
        super.initObserver()

        LockerLifecycle.loginState.observe(this) {

            LockerSharePreference.setValue(LockerConstant.LOGIN_STATE_KEY,it)
            LogUtil.msg("$mViewName --$it---  "+ LockerSharePreference.getLoginState())
            showHeather(it)
        }

        LockerLifecycle.loginData.observe(this) {
            LockerSharePreference.setValue(LockerConstant.LOGIN_DATA_KEY,it)
            LogUtil.msg("$mViewName --\n$it---  \n"+ LockerSharePreference.getLoginData())
            showUserInfo(it)
        }
    }

    override fun initListener() {
        super.initListener()

        mBinding.lockerLoginNow.setOnClickListener {
            startActivity(mContext, LockerLoginActivity::class.java)
        }
        mBinding.iconStyleSetting.setOnClickListener {
            LockerSettingActivity.start(mContext,StyleSettingFragment::class.java.name,"个性装扮")
        }
    }
}
package com.ve.module.locker.ui.page.user

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseActivity
import com.ve.lib.vutils.LogUtil
import com.ve.lib.vutils.SpUtil
import com.ve.module.locker.common.config.SettingConstant
import com.ve.module.locker.databinding.LockerActivityUserinfoBinding
import com.ve.module.locker.model.http.model.LoginVO

/**
 * @Author  weiyi
 * @Date 2022/5/13
 * @Description  current project locker-android
 */
class LockerUserInfoActivity:BaseActivity<LockerActivityUserinfoBinding>() {
    override fun attachViewBinding(): LockerActivityUserinfoBinding {
        return LockerActivityUserinfoBinding.inflate(layoutInflater)
    }

    override fun initialize(saveInstanceState: Bundle?) {
        initToolbar(mBinding.extToolbar.toolbar,"账号资料")
        val userinfo=SpUtil.getValue(SettingConstant.SP_KEY_LOGIN_DATA_KEY,LoginVO())
        if(userinfo.userDetailDTO!=null){
            showUserInfo(userinfo)
        }else{
            showMsg("您还未登录哦")
        }
    }

    private fun showUserInfo(userinfo: LoginVO) {
        LogUtil.msg(userinfo)
    }
}
package com.ve.module.locker.ui.page.drawer

import android.os.Bundle
import android.view.View
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.view.ext.setOnclickNoRepeatListener
import com.ve.module.locker.R
import com.ve.module.locker.common.config.LockerLifecycle
import com.ve.module.locker.ui.viewmodel.LockerViewModel
import com.ve.module.locker.databinding.LockerFragmentDrawerBinding
import com.ve.module.locker.model.http.model.LoginVO

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerDrawerFragment : BaseVmFragment<LockerFragmentDrawerBinding, LockerViewModel>() , View.OnClickListener {
    override fun attachViewBinding(): LockerFragmentDrawerBinding {
        return LockerFragmentDrawerBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerViewModel> {
        return LockerViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.btnExitLogin.setOnclickNoRepeatListener (this)
        mBinding.exitLayout.setOnclickNoRepeatListener (this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_exit_login->{
                LockerLifecycle.loginState.value=false
                LockerLifecycle.loginData.value= LoginVO()
                showMsg("退出登录成功")
            }
            R.id.exit_layout->{
                LockerLifecycle.loginState.value=false
                LockerLifecycle.loginData.value= LoginVO()
                showMsg("退出登录成功")
            }
        }
    }

}
package com.ve.module.locker.ui.page.auth

import android.os.Bundle
import com.ve.lib.common.base.view.vmview.BaseVmActivity
import com.ve.module.locker.databinding.LockerActivityRegisterBinding
import com.ve.module.locker.ui.state.LockerRegisterViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
class LockerRegisterActivity:
    BaseVmActivity<LockerActivityRegisterBinding, LockerRegisterViewModel>() {
    override fun attachViewBinding(): LockerActivityRegisterBinding {
        return LockerActivityRegisterBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerRegisterViewModel> {
        return LockerRegisterViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}
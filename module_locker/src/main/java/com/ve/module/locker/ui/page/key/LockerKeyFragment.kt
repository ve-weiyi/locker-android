package com.ve.module.locker.ui.page.key

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseFragment
import com.ve.module.locker.databinding.LockerFragmentKeyBinding

/**
 * @Author  weiyi
 * @Date 2022/5/13
 * @Description  current project locker-android
 */
class LockerKeyFragment:BaseFragment<LockerFragmentKeyBinding>() {
    override fun attachViewBinding(): LockerFragmentKeyBinding {
        return LockerFragmentKeyBinding.inflate(layoutInflater)
    }

    override fun initialize(saveInstanceState: Bundle?) {

    }
}
package com.ve.module.main.ui.page.drawer

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.module.main.databinding.FragmentDrawerBinding
import com.ve.module.main.ui.state.DrawerViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/6
 */
class DrawerFragment: BaseVmFragment<FragmentDrawerBinding, DrawerViewModel>() {
    override fun attachViewBinding(): FragmentDrawerBinding {
        return FragmentDrawerBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<DrawerViewModel> {
        return DrawerViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}
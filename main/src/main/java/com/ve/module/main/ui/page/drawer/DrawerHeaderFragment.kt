package com.ve.module.main.ui.page.drawer

import android.os.Bundle
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.module.main.databinding.FragmentDrawerHeaderBinding
import com.ve.module.main.ui.state.DrawerViewModel


/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/6
 */
class DrawerHeaderFragment: BaseVmFragment<FragmentDrawerHeaderBinding, DrawerViewModel>() {
    override fun attachViewBinding(): FragmentDrawerHeaderBinding {
        return FragmentDrawerHeaderBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<DrawerViewModel> {
        return DrawerViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

}
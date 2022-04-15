package com.ve.music.ui.page.discover

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.music.databinding.DelegateDiscoverBinding


class DiscoverFragment : BaseVmFragment<DelegateDiscoverBinding, DiscoverViewModel>(){
    override fun attachViewBinding(): DelegateDiscoverBinding {
        return DelegateDiscoverBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<DiscoverViewModel> {
        return DiscoverViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {
        
    }

}
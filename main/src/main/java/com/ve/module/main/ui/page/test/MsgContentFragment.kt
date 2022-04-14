package com.ve.module.main.ui.page.test

import android.os.Bundle
import com.ve.lib.common.base.view.vmview.BaseFragment
import com.ve.module.main.databinding.FragmentDrawerBinding


/**
 * 消息内容页
 */
class MsgContentFragment : BaseFragment<FragmentDrawerBinding>() {

    override fun attachViewBinding(): FragmentDrawerBinding {
        return FragmentDrawerBinding.inflate(layoutInflater)
    }

    override fun initialize(saveInstanceState: Bundle?) {
        mBinding
    }


}
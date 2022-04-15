package com.ve.module.chat.ui.page.chat

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseFragment
import com.ve.module.chat.databinding.FragmentImchatGroupBinding


/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class ChatGroupFragment: BaseFragment<FragmentImchatGroupBinding>() {
    override fun attachViewBinding(): FragmentImchatGroupBinding {
        return FragmentImchatGroupBinding.inflate(layoutInflater)
    }

    override fun initialize(saveInstanceState: Bundle?) {

    }
}
package com.ve.module.chat.ui.page.chat

import android.os.Bundle
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.module.chat.databinding.FragmentImchatMessageBinding
import com.ve.module.chat.ui.state.ImChatViewModel


/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class ChatMessageFragment: BaseVmFragment<FragmentImchatMessageBinding, ImChatViewModel>() {
    override fun attachViewBinding(): FragmentImchatMessageBinding {
        return FragmentImchatMessageBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<ImChatViewModel> {
        return ImChatViewModel::class.java
    }


    override fun initWebData() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }
}
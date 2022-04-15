package com.ve.module.chat.ui.page.friends

import android.os.Bundle
import com.ve.lib.common.base.view.vm.BaseActivity
import com.ve.module.chat.databinding.ActivityUserImdetailBinding

/**
 * @author: ZXY
 * @date: 2021/9/27
 */
class FriendDetailAcy : BaseActivity<ActivityUserImdetailBinding>() {

    override fun attachViewBinding(): ActivityUserImdetailBinding {
        return ActivityUserImdetailBinding.inflate(layoutInflater)
    }

    override fun initialize(saveInstanceState: Bundle?) {

    }

}
package com.ve.module.locker.ui.adapter

import android.view.View
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.ve.lib.application.BaseApplication
import com.ve.lib.common.base.adapter.BaseBindingAdapter
import com.ve.lib.common.base.adapter.BaseSlideBindingAdapter
import com.ve.lib.common.base.adapter.VBViewHolder
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.LockerApplication
import com.ve.module.locker.databinding.LockerItemAppBinding
import com.ve.module.locker.utils.AndroidUtil

/**
 * @Author  weiyi
 * @Date 2022/5/6
 * @Description  current project locker-android
 */
class AppAdapter : BaseSlideBindingAdapter<AndroidUtil.AppInfo, LockerItemAppBinding>() {


    override fun convert(holder: VBViewHolder<LockerItemAppBinding>, item: AndroidUtil.AppInfo) {
        holder.apply {
            vb.tvAppName.text = item.name
            vb.tvAppPackageName.text = item.packageName
            vb.ivAppIcon.setImageDrawable(item.icon)
        }
    }

}
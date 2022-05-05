package com.ve.module.locker.ui.adapter

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.module.DraggableModule
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.module.UpFetchModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.model.database.entity.PrivacyFriendsInfo

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/10
 */
class PrivacyInfoFriendsAdapter :
    BaseSectionQuickAdapter<PrivacyFriendsInfo, BaseViewHolder>(
        com.ve.lib.common.R.layout.item_sticky_header, R.layout.locker_item_privacy_pass
    ), LoadMoreModule, DraggableModule, UpFetchModule {

//    init {
//        addChildClickViewIds(R.id.check_button)
//    }


    override fun convert(holder: BaseViewHolder, item: PrivacyFriendsInfo) {

        holder.setText(R.id.tv_privacy_info_nickname, item.nickname)
        holder.setText(R.id.tv_privacy_info_name, item.name)
        holder.setText(R.id.tv_privacy_info_phone, item.phone)
        holder.setText(R.id.tv_privacy_info_qq, item.qq)
        holder.setText(R.id.tv_privacy_info_email, item.email)
    }


    override fun convertHeader(helper: BaseViewHolder, item: PrivacyFriendsInfo) {
        LogUtil.msg("head " + item.headerName)
        helper.setText(com.ve.lib.common.R.id.tv_header, item.headerName)
        helper.setEnabled(com.ve.lib.common.R.id.tv_header, false)
    }

}
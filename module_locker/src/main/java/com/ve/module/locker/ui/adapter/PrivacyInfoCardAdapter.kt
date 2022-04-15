package com.ve.module.locker.ui.adapter

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.module.DraggableModule
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.module.UpFetchModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ve.module.locker.R
import com.ve.module.locker.logic.database.entity.PrivacyInfoCard

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/10
 */
class PrivacyInfoCardAdapter:
    BaseSectionQuickAdapter<PrivacyInfoCard, BaseViewHolder>(
        com.ve.lib.common.R.layout.item_sticky_header,R.layout.locker_item_privacy_card)
,LoadMoreModule, DraggableModule, UpFetchModule {

    override fun convert(holder: BaseViewHolder, item: PrivacyInfoCard) {
        holder.setText(R.id.item_privacy_info_name,item.privacyName)
        holder.setText(R.id.item_privacy_info_desc,item.privacyDesc)
    }

    override fun convertHeader(helper: BaseViewHolder, item: PrivacyInfoCard) {
        helper.setText(com.ve.lib.common.R.id.tv_header, item.privacyName)
    }


}
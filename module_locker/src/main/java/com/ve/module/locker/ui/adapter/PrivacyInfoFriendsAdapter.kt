package com.ve.module.locker.ui.adapter

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.module.DraggableModule
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.module.UpFetchModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ve.lib.common.databinding.ItemStickyHeaderBinding
import com.ve.lib.vutils.LogUtil
import com.ve.lib.vutils.ToastUtil
import com.ve.module.locker.R
import com.ve.module.locker.databinding.LockerItemPrivacyFriendsBinding
import com.ve.module.locker.model.database.entity.PrivacyCardInfo
import com.ve.module.locker.model.database.entity.PrivacyFriendsInfo
import com.ve.module.locker.model.database.entity.PrivacyPassInfo
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.privacy.details.LockerCardDetailsSeeFragment
import com.ve.module.locker.utils.StickUtils
import org.jetbrains.anko.layoutInflater

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/10
 */
class PrivacyInfoFriendsAdapter :
    BaseSectionQuickAdapter<PrivacyFriendsInfo, BaseViewHolder>(
        com.ve.lib.common.R.layout.item_sticky_header, R.layout.locker_item_privacy_friends
    ), LoadMoreModule, DraggableModule, UpFetchModule {

    var isCheckMode = false
    private var isAllCheck = false
    private var mSelectList = mutableListOf<PrivacyFriendsInfo>()
    private var keywords = ""

    init {
        addChildClickViewIds(R.id.item_layout_content, R.id.item_btn_edit, R.id.item_btn_delete)
    }

    override fun convert(holder: BaseViewHolder, item: PrivacyFriendsInfo) {
        holder.apply {
            setText(R.id.tv_friends_nickname,item.nickname)
            setText(R.id.tv_friends_name,item.name)
            setText(R.id.tv_friends_phone,item.phone)
            setText(R.id.tv_friends_email,item.email)
            setText(R.id.tv_friends_qq,item.qq)
            setText(R.id.tv_friends_wechat,item.wechat)
            setText(R.id.tv_friends_address,item.address)
            setText(R.id.tv_friends_department,item.department)
            setText(R.id.tv_friends_remark,item.remark)
        }

        val checkBox = holder.getView<CheckBox>(R.id.check_button)
        checkBox.setOnClickListener {
            checkBox.apply {

                if (isChecked) {
                    //选择
                    if (!mSelectList.contains(item)) {
                        LogUtil.msg("add 11 +$item}")
                        mSelectList.add(item)
                    }
                } else {
                    //取消选择
                    if (mSelectList.contains(item)) {
                        LogUtil.msg("remove 1 +${item}")
                        mSelectList.remove(item)
                    }
                }
            }
        }

        if (isCheckMode) {
            checkBox.visibility = View.VISIBLE
            checkBox.isChecked = isAllCheck
        } else {
            checkBox.visibility = View.GONE
        }
    }

    override fun convertHeader(helper: BaseViewHolder, item: PrivacyFriendsInfo) {
        LogUtil.msg("head " + item.headerName)
        helper.setText(com.ve.lib.common.R.id.tv_header, item.headerName)
        helper.setEnabled(com.ve.lib.common.R.id.tv_header, false)
    }

    fun getSelectData(): MutableList<PrivacyFriendsInfo> {
        return mSelectList
    }


    fun changeAllState() {
        isAllCheck = !isAllCheck
        if (isAllCheck) {
            data.forEach { card ->
                if (!card.isHeader&&!mSelectList.contains(card))
                    mSelectList.add(card)
            }
        } else {
            mSelectList.removeAll(mSelectList)
        }
    }

}
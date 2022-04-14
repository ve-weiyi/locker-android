package com.ve.module.locker.ui.page.privacy.card

import android.content.Context
import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.lib.common.base.view.listview.BaseVmListFragment
import com.ve.lib.common.base.view.listview.ListViewManager
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentPrivacyCardBinding
import com.ve.module.locker.logic.http.model.UserPrivacyInfoCardResponse
import com.ve.module.locker.ui.adapter.UserPrivacyInfoCardAdapter
import com.ve.module.locker.ui.page.privacy.details.LockerPrivacyInfoActivity
import com.ve.module.locker.ui.page.privacy.details.PrivacyDetailsCardFragment
import com.ve.module.locker.ui.state.LockerPrivacyCardViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerPrivacyCardFragment:BaseVmListFragment<LockerFragmentPrivacyCardBinding,LockerPrivacyCardViewModel,UserPrivacyInfoCardResponse>(){

    override fun attachViewBinding(): LockerFragmentPrivacyCardBinding {
        return LockerFragmentPrivacyCardBinding.inflate(layoutInflater)
    }


    override fun attachAdapter(): BaseQuickAdapter<UserPrivacyInfoCardResponse, *> {
        return UserPrivacyInfoCardAdapter()
    }

    override fun initListView() {
        mLayoutStatusView = mBinding.multipleStatusView
        mRecyclerView = mBinding.recyclerView
        mSwipeRefreshLayout = mBinding.swipeRefreshLayout
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCardViewModel> {
        return LockerPrivacyCardViewModel::class.java
    }

    override fun initWebData() {
        super.initWebData()
        mViewModel.privacyInfoUser()
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.userPrivacyInfoList.observe(this){
            LogUtil.msg("$mViewName ------ $it")
            showAtAdapter(it)
        }
    }

    override fun onItemClickEvent(
        datas: MutableList<UserPrivacyInfoCardResponse>,
        view: View,
        position: Int
    ) {
        super.onItemClickEvent(datas, view, position)
        val privacyInfo=datas[position]
        val bundle= Bundle()

        bundle.putSerializable(PrivacyDetailsCardFragment.PRIVACY_CARD_KEY,privacyInfo)

        LockerPrivacyInfoActivity.start(mContext, PrivacyDetailsCardFragment::class.java.name,
            privacyInfo.privacyName, bundle)
    }
}
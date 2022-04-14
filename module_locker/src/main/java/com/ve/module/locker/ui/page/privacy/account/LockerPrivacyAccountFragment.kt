package com.ve.module.locker.ui.page.privacy.account

import android.content.Context
import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.lib.common.base.view.listview.BaseVmListFragment
import com.ve.lib.common.base.view.listview.ListViewManager
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentPrivacyAccountBinding
import com.ve.module.locker.logic.http.model.UserPrivacyInfoPassVO
import com.ve.module.locker.ui.adapter.UserPrivacyInfoPassAdapter
import com.ve.module.locker.ui.page.privacy.details.LockerPrivacyInfoActivity
import com.ve.module.locker.ui.page.privacy.details.PrivacyDetailsPassFragment
import com.ve.module.locker.ui.state.LockerPrivacyPassViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerPrivacyAccountFragment:
    BaseVmListFragment<LockerFragmentPrivacyAccountBinding, LockerPrivacyPassViewModel, UserPrivacyInfoPassVO>() {
    override fun attachViewBinding(): LockerFragmentPrivacyAccountBinding {
        return LockerFragmentPrivacyAccountBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyPassViewModel> {
        return LockerPrivacyPassViewModel::class.java
    }

    override fun attachAdapter(): BaseQuickAdapter<UserPrivacyInfoPassVO, *> {
        return UserPrivacyInfoPassAdapter()
    }

    override fun initListView() {
        mLayoutStatusView = mBinding.fragmentRefreshLayout.multipleStatusView
        mRecyclerView = mBinding.fragmentRefreshLayout.recyclerView
        mSwipeRefreshLayout = mBinding.fragmentRefreshLayout.swipeRefreshLayout
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

    override fun onItemClickEvent(datas: MutableList<UserPrivacyInfoPassVO>, view: View, position: Int) {
        super.onItemClickEvent(datas, view, position)
        val privacyInfo=datas[position]
        val bundle=Bundle()

        bundle.putSerializable(PrivacyDetailsPassFragment.PRIVACY_PASS_KEY,privacyInfo)

        LockerPrivacyInfoActivity.start(mContext,
            PrivacyDetailsPassFragment::class.java.name,
            privacyInfo.privacyName,
            bundle)
    }
}
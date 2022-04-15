package com.ve.module.locker.ui.page.privacy.list

import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.lib.common.base.view.list.BaseVmListFragment
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentListPassBinding
import com.ve.module.locker.logic.database.entity.PrivacyInfoPass
import com.ve.module.locker.ui.adapter.PrivacyInfoPassAdapter
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.privacy.details.LockerDetailsPassFragment
import com.ve.module.locker.ui.state.LockerPrivacyPassViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerListPassFragment:BaseVmListFragment<LockerFragmentListPassBinding,LockerPrivacyPassViewModel, PrivacyInfoPass>(){

    override fun attachViewBinding(): LockerFragmentListPassBinding {
        return LockerFragmentListPassBinding.inflate(layoutInflater)
    }


    override fun attachAdapter(): BaseQuickAdapter<PrivacyInfoPass, *> {
        return PrivacyInfoPassAdapter()
    }

    override fun initListView() {
        mLayoutStatusView = mBinding.fragmentRefreshLayout.multipleStatusView
        mRecyclerView = mBinding.fragmentRefreshLayout.recyclerView
        mSwipeRefreshLayout = mBinding.fragmentRefreshLayout.swipeRefreshLayout
    }

    override fun attachViewModelClass(): Class<LockerPrivacyPassViewModel> {
        return LockerPrivacyPassViewModel::class.java
    }

    override fun initWebData() {
        super.initWebData()
        mViewModel.getPrivacyInfoList()
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.allPrivacyInfoList.observe(this){
            LogUtil.msg("$mViewName ------ $it")
            showAtAdapter(it)
        }
    }

    override fun initListener() {
        super.initListener()
        mBinding.floatingActionBtn1.setOnClickListener{

        }
    }
    override fun onItemClickEvent(
        datas: MutableList<PrivacyInfoPass>,
        view: View,
        position: Int
    ) {
        super.onItemClickEvent(datas, view, position)
        val privacyInfo=datas[position]
        val bundle= Bundle()

        bundle.putLong(LockerDetailsPassFragment.PRIVACY_DATA_KEY,privacyInfo.privacyDetailsId)

        LockerContainerActivity.start(mContext, LockerDetailsPassFragment::class.java.name,
            privacyInfo.privacyName, bundle)
    }
}
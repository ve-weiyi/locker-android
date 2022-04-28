package com.ve.module.locker.ui.page.category

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.lib.common.base.view.list.BaseVmListFragment
import com.ve.lib.common.base.view.list.ListViewManager
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.databinding.LockerFragmentTagBinding
import com.ve.module.locker.model.database.entity.PrivacyTag
import com.ve.module.locker.ui.adapter.PrivacyTagAdapter
import com.ve.module.locker.ui.viewmodel.LockerPrivacyCategoryViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerCategoryFragment :
    BaseVmListFragment<LockerFragmentTagBinding, LockerPrivacyCategoryViewModel, PrivacyTag>() {

    override fun attachViewBinding(): LockerFragmentTagBinding {
        return LockerFragmentTagBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCategoryViewModel> {
        return LockerPrivacyCategoryViewModel::class.java
    }

    override fun attachAdapter(): BaseQuickAdapter<PrivacyTag, *> {
        return PrivacyTagAdapter()
    }

    override fun initListView() {
        mLayoutStatusView = mBinding.multipleStatusView
        mRecyclerView = mBinding.recyclerView
        mSwipeRefreshLayout = mBinding.swipeRefreshLayout
    }

    override fun attachListManager(context: Context): ListViewManager<PrivacyTag> {
        return ListViewManager<PrivacyTag>(context).apply {
            mLinearLayoutManager = GridLayoutManager(requireContext(), 3)
            mConfig.enableLoadMore = false
        }
    }

    override fun initWebData() {
        mViewModel.getTagList()
    }

    override fun initObserver() {
        mViewModel.tagList.observe(this) {
            LogUtil.e(it.toString())
            showAtAdapter(it)
            mListAdapter.loadMoreModule.loadMoreEnd(true)
        }
    }
}
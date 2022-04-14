package com.ve.module.locker.ui.page.category.list

import android.content.Context
import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.lib.common.base.view.listview.BaseVmListFragment
import com.ve.lib.common.base.view.listview.ListViewManager
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.common.event.RefreshDataEvent
import com.ve.module.locker.databinding.LockerLayoutListCategoryBinding
import com.ve.module.locker.logic.http.model.PrivacyType
import com.ve.module.locker.ui.adapter.ListTypeAdapter
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.category.details.EditType
import com.ve.module.locker.ui.page.category.details.LockerDetailsTypeFragment
import com.ve.module.locker.ui.state.LockerPrivacyCategoryViewModel
import com.ve.module.locker.ui.view.TagSwipeItemLayout
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerListTypeFragment :
    BaseVmListFragment<LockerLayoutListCategoryBinding, LockerPrivacyCategoryViewModel, PrivacyType>() {

    override fun attachViewBinding(): LockerLayoutListCategoryBinding {
        return LockerLayoutListCategoryBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerPrivacyCategoryViewModel> {
        return LockerPrivacyCategoryViewModel::class.java
    }

    override fun attachAdapter(): BaseQuickAdapter<PrivacyType, *> {
        return ListTypeAdapter()
    }

    override fun initListView() {
        mLayoutStatusView = mBinding.multipleStatusView
        mRecyclerView = mBinding.recyclerView
        mSwipeRefreshLayout = mBinding.swipeRefreshLayout
    }

    override fun initWebData() {
        mViewModel.typeList()
    }

    override fun initObserver() {
        mViewModel.typeList.observe(this) {
            showAtAdapter(it)
        }
        mViewModel.typeDeleteMsg.observe(this) {
            showMsg(it)
            getRefreshData()
        }
    }

    override fun initListener() {
        super.initListener()
        mRecyclerView!!.addOnItemTouchListener(TagSwipeItemLayout.OnSwipeItemTouchListener(activity))
        mBinding.floatingActionBtn.setOnClickListener {
            addPrivacyType()
        }
    }

    override fun onItemChildClickEvent(datas: MutableList<PrivacyType>, view: View, position: Int) {
        itemChildClick(datas[position], view, position)
    }

    /**
     * Item Child Click
     * @param item TodoDataBean
     * @param view View
     * @param position Int
     */
    private fun itemChildClick(item: PrivacyType, view: View, position: Int) {
        when (view.id) {
            R.id.item_layout_content -> {
                val bundle = Bundle()
                bundle.putInt(LockerDetailsTypeFragment.FRAGMENT_TYPE_KEY,EditType.SEE_TAG_TYPE)
                bundle.putSerializable(LockerDetailsTypeFragment.FRAGMENT_DATA_KEY, item)
                LockerContainerActivity.start(mContext, LockerDetailsTypeFragment::class.java.name, "查看标签 "+item.typeName,bundle )

                showMsg("查看")
            }
            R.id.item_btn_edit -> {
                val bundle = Bundle()
                bundle.putInt(LockerDetailsTypeFragment.FRAGMENT_TYPE_KEY,EditType.EDIT_TAG_TYPE)
                bundle.putSerializable(LockerDetailsTypeFragment.FRAGMENT_DATA_KEY, item)
                LockerContainerActivity.start(mContext, LockerDetailsTypeFragment::class.java.name, "编辑标签 "+item.typeName, bundle)
                showMsg("编辑")
            }
            R.id.item_btn_delete -> {
                mViewModel.typeDelete(item.id!!)
                showMsg("删除")
            }
        }
    }

    private fun addPrivacyType() {
        val bundle = Bundle()
        bundle.putInt(LockerDetailsTypeFragment.FRAGMENT_TYPE_KEY,EditType.ADD_TAG_TYPE)
        LockerContainerActivity.start(mContext, LockerDetailsTypeFragment::class.java.name, "添加标签",bundle)
        showMsg("添加")
    }

    /**
     * Refresh Data Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onRefreshDataEvent(event: RefreshDataEvent) {
        if(this::class.java.name==event.className){
            LogUtil.d("$mViewName receiver event "+event.className)
            hasLoadData=false
        }
    }

}
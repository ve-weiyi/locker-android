package com.ve.lib.common.base.view.listview

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ve.lib.common.base.viewmodel.BaseViewModel
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.lib.vutils.LogUtil

/**
 * 视图绑定，ViewModel ,数据类
 */
abstract class BaseVmListFragment<VB : ViewBinding, VM : BaseViewModel, LD : Any>() :
    BaseVmFragment<VB, VM>(), IListView<LD> {

    override var mTotalCount: Int = 0
    override var mPageSize: Int = 0
    override var mCurrentPage: Int = 0
    override var mPosition: Int = 0

    override var mRecyclerView: RecyclerView? = null
    override var mSwipeRefreshLayout: SwipeRefreshLayout? = null
    override var mFloatingActionBtn: FloatingActionButton? = null

    override lateinit var mListViewManager: ListViewManager<LD>
    override lateinit var mListAdapter: BaseQuickAdapter<LD, out BaseViewHolder>

    override fun onDestroy() {
        super.onDestroy()
        mPageSize = 0
        mCurrentPage = 0
    }

    override fun initView(savedInstanceState: Bundle?) {
        initListView()
        defaultListView(requireContext())
    }

    override fun getRefreshData() {
        LogUtil.e("$mViewName getRefreshData ")
        initWebData()
    }

    override fun getMoreData() {
        LogUtil.e("$mViewName getMoreData $mCurrentPage")
        initWebData()
    }


    override fun showError(errorMsg: String) {
        super.showError(errorMsg)
        mLayoutStatusView?.showError()
    }

    override fun showAtAdapter(isSetNewData: Boolean, data: MutableList<LD>?) {
        hideLoading()

        super.showAtAdapter(isSetNewData,data)
        if (mListAdapter.data.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
            mLayoutStatusView?.showContent()
        }
    }

    override fun onItemClickEvent(datas: MutableList<LD>, view: View, position: Int) {

    }

    override fun onItemChildClickEvent(datas: MutableList<LD>, view: View, position: Int) {

    }
}
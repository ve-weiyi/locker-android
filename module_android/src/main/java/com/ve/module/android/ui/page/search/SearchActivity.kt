package com.ve.module.android.ui.page.search

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.module.android.R
import com.ve.module.android.config.Constant
import com.ve.module.android.databinding.ActivitySearchBinding
import com.ve.module.android.repository.database.entity.SearchHistory
import com.ve.module.android.repository.model.Hotkey
import com.ve.module.android.ui.adapter.SearchHistoryAdapter
import com.ve.module.android.ui.page.activity.CommonActivity
import com.ve.module.android.ui.viewmodel.SearchViewModel
import com.ve.lib.common.base.view.list.BaseVmListActivity
import com.ve.lib.utils.CommonUtil
import com.ve.lib.utils.DisplayManager
import com.ve.lib.vutils.LogUtil
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/3/21
 */
class SearchActivity: BaseVmListActivity<ActivitySearchBinding, SearchViewModel, SearchHistory>(){
    override fun attachViewBinding(): ActivitySearchBinding {
        return ActivitySearchBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<SearchViewModel> {
        return SearchViewModel::class.java
    }

    override fun attachAdapter(): BaseQuickAdapter<SearchHistory, *> {
        return SearchHistoryAdapter()
    }


    lateinit var mToolbar: Toolbar
    lateinit var mTitle: String

    override fun initListView() {
        mRecyclerView = mBinding.rvHistorySearch

        mListAdapter.apply {
            setEmptyView(R.layout.search_empty_view)
        }
        initToolbar(mToolbar,mTitle)
    }
    private lateinit var mKey: String
    private lateinit var mEditText: EditText
    lateinit var searchView :SearchView
    /**
     * ????????????
     */
    private var mHotSearchDatas = mutableListOf<Hotkey>()

    override fun initObserver() {
        mViewModel.hotkeyList.observe(this){
            showHotkey(it)
        }

        mViewModel.historyList.observe(this) {
            showHistory(it.toMutableList())
           // showAtAdapter(it.toMutableList())
        }
    }

    override fun initWebData() {
        mViewModel.getHotkey()
        mViewModel.getHistorySearch()
    }


    override fun initListener() {
        mBinding.hotSearchFlowLayout.run {
            setOnTagClickListener { view, position, parent ->
                if (mHotSearchDatas.size > 0) {
                    val Hotkey = mHotSearchDatas[position]
                    goToSearchList(Hotkey.name)
                    true
                }
                false
            }
        }
        mBinding.searchHistoryClearAllTv.setOnClickListener {
            mListAdapter.setList(mutableListOf())
            mViewModel.cleanHistorySearch()
        }
    }
    /**
     * ??????SearchView
     * SearchView???????????????https://blog.csdn.net/yechaoa/article/details/80658940
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //??????menu??????
        menuInflater.inflate(R.menu.menu_search_flow, menu)
        //??????SearchView?????????????????????
        searchView = menu.findItem(R.id.action_search).actionView as SearchView

        searchView.apply {
            //???????????????????????????????????????
            setIconifiedByDefault(true)
            //???????????????????????????????????????????????????????????????
            isSubmitButtonEnabled = true
            //????????????????????????????????????
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            //????????????????????????false????????????
            isIconified = false
            //????????????
            isFocusable = true
            requestFocusFromTouch()
            //???????????????
            queryHint = getString(R.string.search_tint)

            searchView.maxWidth = Integer.MAX_VALUE
            //??????????????????????????????????????????
            searchView.onActionViewExpanded()
            //????????????????????????
            setOnQueryTextListener(queryTextListener)
        }

        //???????????????????????????
        mEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        mEditText.setHintTextColor(ContextCompat.getColor(this, com.ve.lib.application.R.color.white30))
        mEditText.setTextColor(ContextCompat.getColor(this, com.ve.lib.application.R.color.white))

        try {
            val field = searchView.javaClass.getDeclaredField("mGoButton")
            field.isAccessible = true
            val mGoButton = field.get(searchView) as ImageView
            mGoButton.setImageResource(R.drawable.ic_search_white_24dp)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return super.onCreateOptionsMenu(menu)
    }

    fun showHistory(historyBeans: MutableList<SearchHistory>) {
        mListAdapter.setList(historyBeans)
    }

    private fun showHotkey(hotSearchDatas: MutableList<Hotkey>) {
        this.mHotSearchDatas.addAll(hotSearchDatas)
        mBinding.hotSearchFlowLayout
        mBinding.hotSearchFlowLayout.adapter = object : TagAdapter<Hotkey>(hotSearchDatas) {
            override fun getView(parent: FlowLayout?, position: Int, Hotkey: Hotkey?): View {
                val tv: TextView = LayoutInflater.from(parent?.context).inflate(
                    R.layout.flow_layout_tv,
                    mBinding.hotSearchFlowLayout, false
                ) as TextView
                val padding: Int = DisplayManager.dip2px(10F)
                tv.setPadding(padding, padding, padding, padding)
                tv.text = Hotkey?.name
                tv.setTextColor(CommonUtil.randomColor())
                tv.setBackgroundColor(Color.LTGRAY)
                return tv
            }
        }


    }

    override fun onItemClickEvent(datas: MutableList<SearchHistory>, view: View, position: Int) {
        goToSearchList(datas[position].name!!)
    }

    override fun onItemChildClickEvent(datas: MutableList<SearchHistory>, view: View, position: Int) {
        when (view.id) {
            R.id.iv_clear -> {
                mViewModel.deleteHistorySearch(datas[position].name!!)
                mListAdapter.removeAt(position)
            }
        }
    }

    /**
     * OnQueryTextListener ????????????????????????
     */
    private val queryTextListener = object : SearchView.OnQueryTextListener {
        // ???????????????????????????????????????
        override fun onQueryTextSubmit(query: String): Boolean {
            LogUtil.e( "????????????===$query")
            mKey = query
            mCurrentPage = 0 //?????????????????????????????????????????????
            //????????????
            goToSearchList(mKey)
            //???????????????????????????
            searchView.clearFocus()
            return false
        }
        // ???????????????????????????????????????
        override fun onQueryTextChange(newText: String): Boolean {
            //????????????????????????????????????????????????????????????????????????
            return false
        }
    }

    private fun goToSearchList(key: String) {
        //??????????????????
        mViewModel.saveHistorySearch(key)
        //????????????????????????
        val bundle=Bundle()
        bundle.putString(Constant.SEARCH_KEY, key)
        CommonActivity.start(this, key, SearchListFragment::class.java.name, bundle)
    }

}
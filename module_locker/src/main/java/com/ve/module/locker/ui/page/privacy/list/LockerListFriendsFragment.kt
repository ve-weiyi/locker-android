package com.ve.module.locker.ui.page.privacy.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.lib.common.base.view.list.BaseVmListFragment
import com.ve.lib.utils.DialogUtil
import com.ve.lib.view.ext.setOnclickNoRepeatListener
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.common.event.RefreshDataEvent
import com.ve.module.locker.databinding.LockerFragmentListPrivacyBinding
import com.ve.module.locker.model.db.entity.PrivacyFolder
import com.ve.module.locker.model.db.entity.PrivacyFriendsInfo
import com.ve.module.locker.model.http.model.ConditionVO
import com.ve.module.locker.ui.adapter.PrivacyInfoFriendsAdapter
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.privacy.details.LockerFriendsEditFragment
import com.ve.module.locker.ui.view.TagSwipeItemLayout
import com.ve.module.locker.ui.viewmodel.LockerPrivacyFriendsViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerListFriendsFragment :
    BaseVmListFragment<LockerFragmentListPrivacyBinding, LockerPrivacyFriendsViewModel, PrivacyFriendsInfo>(){

    override fun attachViewBinding(): LockerFragmentListPrivacyBinding {
        return LockerFragmentListPrivacyBinding.inflate(layoutInflater)
    }


    override fun attachAdapter(): BaseQuickAdapter<PrivacyFriendsInfo, *> {
        return PrivacyInfoFriendsAdapter()
    }

    val mAdapter by lazy { mListAdapter as PrivacyInfoFriendsAdapter }
    lateinit var mFolderList: MutableList<PrivacyFolder>

    override fun attachViewModelClass(): Class<LockerPrivacyFriendsViewModel> {
        return LockerPrivacyFriendsViewModel::class.java
    }


    override fun initListView() {
        mLayoutStatusView = mBinding.fragmentRefreshLayout.multipleStatusView
        mRecyclerView = mBinding.fragmentRefreshLayout.recyclerView
        mSwipeRefreshLayout = mBinding.fragmentRefreshLayout.swipeRefreshLayout
        setHasOptionsMenu(true)
        mFolderList = LitePal.findAll(PrivacyFolder::class.java)
    }

    override fun initWebData() {
        super.initWebData()
        mViewModel.getPrivacyFriendsList()
    }

    override fun initListener() {
        super.initListener()
        mBinding.tvSearchText.addTextChangedListener(textWatcher)

        mRecyclerView!!.addOnItemTouchListener(TagSwipeItemLayout.OnSwipeItemTouchListener(activity))
        mBinding.floatingActionBtn1.setOnclickNoRepeatListener {
            LockerContainerActivity.start(
                mContext,
                LockerFriendsEditFragment::class.java.name,
                "??????????????????"
            )
        }
    }

    override fun initObserver() {
        super.initObserver()
        mViewModel.privacyFriendsInfoList.observe(this){
            showAtAdapter(true,it)
        }
        mViewModel.deletePrivacyFriendsResult.observe(this){
            showMsg("????????????")
            mViewModel.getPrivacyFriendsList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        if (!isShowMore) {
            inflater.inflate(R.menu.locker_menu_swap, menu)
        } else {
            inflater.inflate(R.menu.locker_menu_edit, menu)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }
    var isShowMore = false
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_swap -> {
                showMenuMore(true)
                return true
            }
            R.id.action_cancel -> {
                showMenuMore(false)
                return true
            }
            R.id.action_move -> {
                val list = mAdapter.getSelectData()
                moveList(list)
            }
            R.id.action_all -> {
                mAdapter.changeAllState()
                mAdapter.notifyDataSetChanged()
                LogUtil.msg(mAdapter.getSelectData().toString())
            }
            R.id.action_delete -> {
                val list = mAdapter.getSelectData()
                deleteList(list)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteList(list: MutableList<PrivacyFriendsInfo>) {
        if (listValid(list)) {
            DialogUtil.getConfirmDialog(
                mContext,
                "?????????????????? ${list.size} ??????????????????????????????????????????",
                onOKClickListener = { _, _ ->
                    mViewModel.deletePrivacyFriends(list)
                },
                onCancelClickListener = { _, _ ->

                },
            ).show()
        }
    }

    private fun moveList(list: MutableList<PrivacyFriendsInfo>) {
        if (listValid(list)) {
            val folderNameList = mFolderList.map { it.folderName }
            DialogUtil.getSelectDialog(
                mContext,
                folderNameList.toTypedArray(),
                onClickListener = { dialog, which ->

                }
            ).show()
        }
    }

    private fun showMenuMore(isShow: Boolean) {
        isShowMore = isShow
        mAdapter.isCheckMode = isShow
        mAdapter.notifyDataSetChanged()
        activity?.invalidateOptionsMenu()
    }

    private fun listValid(list: MutableList<PrivacyFriendsInfo>): Boolean {
        LogUtil.msg(list.toString())
        if (list.size == 0) {
            showMsg("??????????????????????????????")
            showMenuMore(false)
            return false
        }
        return true
    }


    override fun onItemChildClickEvent(
        datas: MutableList<PrivacyFriendsInfo>,
        view: View,
        position: Int
    ) {
        val privacyFriends=datas[position]
        when (view.id) {
            R.id.item_layout_content -> {
                val layout=view.findViewById<LinearLayout>(R.id.layout_details)
                layout.apply {
                    if(visibility==View.GONE){
                        visibility=View.VISIBLE
                    }else{
                        visibility=View.GONE
                    }
                }
            }
            R.id.item_btn_edit -> {
                val privacyInfo=datas[position]
                val bundle = Bundle()
                bundle.putSerializable(LockerFriendsEditFragment.FRAGMENT_DATA_KEY, privacyInfo)
                LockerContainerActivity.start(
                    mContext,
                    LockerFriendsEditFragment::class.java.name,
                    "???????????????" + privacyInfo.name,
                    bundle
                )
                LogUtil.msg("??????")
            }
            R.id.item_btn_delete -> {
                DialogUtil.getConfirmDialog(
                    mContext,
                    "???????????????????????????????????????????????????????????????",
                    onOKClickListener = { _, _ ->
                        mViewModel.deletePrivacyFriends(privacyFriends)
                    },
                    onCancelClickListener = { _, _ ->

                    },
                ).show()
            }
        }
    }

    /**
     * Refresh Data Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onRefreshDataEvent(event: RefreshDataEvent) {
        if (PrivacyFriendsInfo::class.java.name == event.dataClassName) {
            LogUtil.d("$mViewName receiver event " + event.dataClassName)
            hasLoadData = false
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            LogUtil.msg("before " + s.toString())
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            LogUtil.msg("on " + s.toString())
        }

        override fun afterTextChanged(s: Editable?) {
            LogUtil.msg("after " + s.toString())
            mViewModel.getPrivacyFriendsList(ConditionVO().apply {
                keyWords = s.toString()
            })
        }
    }
}
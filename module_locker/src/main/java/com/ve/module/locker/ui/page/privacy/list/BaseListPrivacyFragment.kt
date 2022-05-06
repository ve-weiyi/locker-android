package com.ve.module.locker.ui.page.privacy.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ve.lib.common.base.view.list.BaseVmListFragment
import com.ve.lib.common.base.viewmodel.BaseViewModel
import com.ve.lib.utils.DialogUtil
import com.ve.lib.view.ext.setOnclickNoRepeatListener
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.common.event.RefreshDataEvent
import com.ve.module.locker.databinding.LockerFragmentListPrivacyBinding
import com.ve.module.locker.model.database.entity.PrivacyCardInfo
import com.ve.module.locker.model.database.entity.PrivacyFolder
import com.ve.module.locker.ui.adapter.PrivacyInfoCardAdapter
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.privacy.details.LockerCardDetailsEditFragment
import com.ve.module.locker.ui.page.search.LockerListCardSearchFragment
import com.ve.module.locker.ui.viewmodel.LockerPrivacyCardViewModel
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
abstract class BaseListPrivacyFragment <VB : ViewBinding, VM : BaseViewModel, LD : Any>():
    BaseVmListFragment<VB, VM, LD>(){


    val mAdapter by lazy { mListAdapter as PrivacyInfoCardAdapter }
    lateinit var mFolderList: MutableList<PrivacyFolder>


    override fun initView(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.initView(savedInstanceState)
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
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_swap -> {
//                showMenuMore(true)
//                return true
//            }
//            R.id.action_cancel -> {
//                showMenuMore(false)
//                return true
//            }
//            R.id.action_move -> {
//                val list = mAdapter.getSelectData()
//                moveList(list)
//            }
//            R.id.action_all -> {
//                mAdapter.changeAllState()
//                mAdapter.notifyDataSetChanged()
//                LogUtil.msg(mAdapter.getSelectData().toString())
//            }
//            R.id.action_delete -> {
//                val list = mAdapter.getSelectData()
//                deleteList(list)
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    abstract fun deleteList(list: MutableList<LD>)

    abstract fun moveList(list: MutableList<LD>)

    private fun showMenuMore(isShow: Boolean) {
        isShowMore = isShow
        mAdapter.isCheckMode = isShow
        mAdapter.notifyDataSetChanged()
        activity?.invalidateOptionsMenu()
    }

    private fun listValid(list: MutableList<LD>): Boolean {
        LogUtil.msg(list.toString())
        if (list.size == 0) {
            showMsg("至少选择一条数据哦！")
            showMenuMore(false)
            return false
        }
        return true
    }

    abstract fun showPrivacyList(privacyList: MutableList<LD>)

}
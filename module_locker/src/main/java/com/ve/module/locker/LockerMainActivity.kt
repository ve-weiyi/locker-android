package com.ve.module.locker

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationBarView
import com.ve.lib.common.base.view.vm.BaseVmActivity
import com.ve.lib.common.event.AppRecreateEvent
import com.ve.lib.common.event.DrawerOpenEvent
import com.ve.lib.common.model.FragmentPage
import com.ve.module.locker.databinding.LockerActivityMainBinding
import com.ve.module.locker.ui.page.privacy.list.LockerCategoryFragment
import com.ve.module.locker.ui.page.drawer.LockerDrawerFragment
import com.ve.module.locker.ui.page.privacy.list.LockerListPassFragment
import com.ve.module.locker.ui.page.privacy.list.LockerListCardFragment

import com.ve.module.locker.ui.viewmodel.LockerViewModel

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LockerMainActivity : BaseVmActivity<LockerActivityMainBinding, LockerViewModel>() {


    private var mIndex = 0
    private lateinit var mFragmentPageList :MutableList<FragmentPage>

    private fun initFragment() {
        var pageCount=0
        mFragmentPageList= mutableListOf(
            FragmentPage(pageCount++,"消息", LockerListCardFragment::class.java),
            FragmentPage(pageCount++,"密码", LockerListPassFragment::class.java),
            FragmentPage(pageCount++,"卡片",LockerListCardFragment::class.java),
            FragmentPage(pageCount++,"分类", LockerCategoryFragment::class.java),
            FragmentPage(pageCount++,"设置",LockerDrawerFragment::class.java),
        )
    }

    override fun attachViewBinding(): LockerActivityMainBinding {
        return  LockerActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        initFragment()
        showFragment(mIndex)
        initToolbar(mBinding.extToolbar.toolbar, homeAsUpEnabled = false)
        mBinding.bottomNavigation.run {
            //导航栏文字可见;原因：底部导航栏的类别多于三个了，多于三个就会不显示，解决方案如下~~~
            labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
            //setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            setOnItemSelectedListener (onNavigationItemSelectedListener)
        }
    }

    override fun attachViewModelClass(): Class<LockerViewModel> {
        return LockerViewModel::class.java
    }

    /**
     * 隐藏所有的Fragment
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mFragmentPageList.forEach { mFragmentPage->
            mFragmentPage.mFragment?.let{
                transaction.hide(it)
            }
        }
    }

    /**
     * 展示Fragment
     * @param index
     */
    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        mIndex = index

        val toolbar = mBinding.extToolbar.toolbar
        val mFragmentPage=mFragmentPageList[index]
        toolbar.title = mFragmentPage.mFragmentTitle

        if (mFragmentPage.mFragment == null) {
            mFragmentPage.mFragment=mFragmentPage.getFragment()
            transaction.add(R.id.ext_container, mFragmentPage.mFragment!!, mFragmentPage.mFragmentTitle)
        } else {
            transaction.show(mFragmentPage.mFragment!!)
        }

        transaction.commit()
    }

    /**
     * NavigationItemSelect监听
     */
    private val onNavigationItemSelectedListener =
        NavigationBarView.OnItemSelectedListener { item ->
            return@OnItemSelectedListener when (item.itemId) {
                R.id.action_home_0 -> {
                    showFragment(0);
                    true
                }
                R.id.action_home_1 -> {
                    showFragment(1);
                    true
                }
                R.id.action_home_2 -> {
                    showFragment(2);
                    true
                }
                R.id.action_home_3 -> {
                    showFragment(3);
                    true
                }
                R.id.action_home_4 -> {
                    showFragment(4);
                    true
                }
                else -> {
                    false
                }
            }
        }

    /**
     * 夜间模式刷新
     */
    override fun recreate() {
        try {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            mFragmentPageList.forEach { mFragmentPage->
                mFragmentPage.mFragment?.let{
                    fragmentTransaction.remove(it)
                }
            }
            fragmentTransaction.commitAllowingStateLoss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.recreate()
    }

    override fun initColor() {
        super.initColor()
       // mBinding.drawerNavView.getHeaderView(0).setBackgroundColor(mThemeColor)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun appRecreateEvent(event: AppRecreateEvent) {
        recreate()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun openDrawer(event : DrawerOpenEvent){
        mBinding.drawerLayout.openDrawer(Gravity.LEFT)
    }

}
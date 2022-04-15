package com.ve.module.main

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationBarView
import com.ve.lib.common.base.view.vm.BaseVmActivity
import com.ve.lib.common.event.DrawerOpenEvent
import com.ve.lib.common.model.FragmentPage
import com.ve.module.android.WanAndroidFragment
import com.ve.lib.common.event.AppRecreateEvent
import com.ve.module.android.ui.page.user.UserFragment
import com.ve.module.android.ui.viewmodel.WanAndroidViewModel
import com.ve.module.games.GamesFragment
import com.ve.module.locker.R
import com.ve.module.main.databinding.ActivityMainBinding
import com.ve.module.main.ui.page.test.TestFragment
import com.ve.music.ui.page.MusicFragment
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseVmActivity<ActivityMainBinding, WanAndroidViewModel>() {

    private var mIndex = 0

    private lateinit var mFragmentPageList :MutableList<FragmentPage>

    private fun initFragment() {
        var pageCount=0
        mFragmentPageList= mutableListOf(
            FragmentPage(pageCount++,"首页", WanAndroidFragment::class.java),
            FragmentPage(pageCount++,"音乐", MusicFragment::class.java),
            FragmentPage(pageCount++,"测试", TestFragment::class.java),
            FragmentPage(pageCount++,"游戏", GamesFragment::class.java),
            FragmentPage(pageCount++,"设置", UserFragment::class.java),
        )
    }


    override fun attachViewBinding(): ActivityMainBinding {
        return  ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        initFragment()
        mBinding.bottomNavigation.run {
            //导航栏文字可见;原因：底部导航栏的类别多于三个了，多于三个就会不显示，解决方案如下~~~
            labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
            //setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
            setOnItemSelectedListener (onNavigationItemSelectedListener)
        }
        showFragment(mIndex)
    }

    override fun attachViewModelClass(): Class<WanAndroidViewModel> {
        return WanAndroidViewModel::class.java
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

       // val toolbar = mBinding.extToolbar.toolbar
        val mFragmentPage=mFragmentPageList[index]
        //toolbar.title = mFragmentPage.mFragmentTitle

        if (mFragmentPage.mFragment == null) {
            mFragmentPage.mFragment=mFragmentPage.getFragment()
            transaction.add(com.ve.module.locker.R.id.ext_container, mFragmentPage.mFragment!!, mFragmentPage.mFragmentTitle)
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
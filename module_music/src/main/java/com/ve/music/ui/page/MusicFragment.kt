package com.ve.music.ui.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.common.base.adapter.ViewPager2Adapter
import com.ve.music.databinding.FragmentMainBinding
import com.ve.music.ui.page.discover.DiscoverFragment

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/5
 */
class MusicFragment: BaseVmFragment<FragmentMainBinding, MusicViewModel>() {
    override fun attachViewBinding(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<MusicViewModel> {
        return MusicViewModel::class.java
    }
    var mTitleList: MutableList<String> = mutableListOf<String>()
    var mFragmentList: MutableList<Fragment> = mutableListOf<Fragment>()

    lateinit var mViewPager2Adapter: ViewPager2Adapter
    lateinit var mTabLayout: TabLayout
    lateinit var mViewPager2: ViewPager2

    override fun initView(savedInstanceState: Bundle?) {


        mTitleList.add("首页")
        mFragmentList.add(DiscoverFragment())
        mViewPager2=mBinding.viewPager
        mViewPager2Adapter=ViewPager2Adapter(this.requireActivity(), mTitleList, mFragmentList)
        //禁用预加载
        mViewPager2.offscreenPageLimit = ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT;
        //适配器
        mViewPager2.adapter = mViewPager2Adapter
        //懒加载页面总数，即默认加载左右2个页面
        mViewPager2.offscreenPageLimit = 2
    }


}
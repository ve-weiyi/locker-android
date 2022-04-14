package com.ve.module.main.ui.page.test
import android.os.Bundle
import com.ve.lib.common.base.viewmodel.BaseViewModel
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.module.main.databinding.FragmentTestBinding

class TestFragment : BaseVmFragment<FragmentTestBinding, BaseViewModel>() {

    companion object {
        fun newInstance() = TestFragment()
    }

    override fun attachViewBinding(): FragmentTestBinding {
        return FragmentTestBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {

        mBinding.extToolbar.apply {
            tvTitle.text="资讯"
        }
        names = ArrayList<String>()
        names.add("关注")
        names.add("推荐")
        names.add("热点")
        names.add("视频")
        names.add("小说")
        names.add("娱乐")
        names.add("问答")
        names.add("图片")
        names.add("科技")
        names.add("懂车帝")
        names.add("体育")
        names.add("财经")
        names.add("军事")
        names.add("国际")
        names.add("健康")

        adapter = MsgContentFragmentAdapter(getChildFragmentManager());
        mBinding.viewPager.setAdapter(adapter);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);

        // 更新适配器数据
        adapter.setList(names);
    }
    private lateinit var adapter: MsgContentFragmentAdapter
    private lateinit var names: ArrayList<String>

    override fun initWebData() {

    }

    override fun attachViewModelClass(): Class<BaseViewModel> {
        return BaseViewModel::class.java
    }

    override fun initColor() {
        super.initColor()
        mBinding.tabLayout.setBackgroundColor(mThemeColor)
    }
}
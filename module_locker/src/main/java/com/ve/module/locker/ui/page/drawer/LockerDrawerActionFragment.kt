package com.ve.module.locker.ui.page.drawer

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.ve.lib.common.base.view.vmview.BaseVmFragment
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.common.config.LockerConstant
import com.ve.module.locker.databinding.LockerFragmentDrawerActionBinding
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.about.LockerAboutActivity
import com.ve.module.locker.ui.page.category.list.LockerListFolderFragment
import com.ve.module.locker.ui.page.category.list.LockerListTagFragment
import com.ve.module.locker.ui.page.category.list.LockerListTypeFragment
import com.ve.module.locker.ui.page.container.LockerWebContainerActivity
import com.ve.module.locker.ui.page.setting.LockerSettingActivity
import com.ve.module.locker.ui.state.LockerDrawerViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerDrawerActionFragment :
    BaseVmFragment<LockerFragmentDrawerActionBinding, LockerDrawerViewModel>(), View.OnClickListener{

    override fun attachViewBinding(): LockerFragmentDrawerActionBinding {
        return LockerFragmentDrawerActionBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerDrawerViewModel> {
        return LockerDrawerViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {

        mBinding.actionTag.setOnClickListener(this)
        mBinding.actionType.setOnClickListener(this)
        mBinding.actionFolder.setOnClickListener(this)

        mBinding.actionSystemSetting.setOnClickListener(this)
        mBinding.actionBlog.setOnClickListener(this)
        mBinding.actionGithub.setOnClickListener(this)
        mBinding.actionAbout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        LogUtil.msg("click view ")
        when(v?.id){
            R.id.action_tag->{
                LockerContainerActivity.start(mContext, LockerListTagFragment::class.java.name,"标签管理")
            }
            R.id.action_folder->{
                LockerContainerActivity.start(mContext, LockerListFolderFragment::class.java.name,"文件夹管理")
            }
            R.id.action_type->{
                LockerContainerActivity.start(mContext, LockerListTypeFragment::class.java.name,"类别管理")
            }
            R.id.action_blog->{
                LockerWebContainerActivity.start(mContext,"我的博客", LockerConstant.blog_url)
            }
            R.id.action_github->{
                LockerWebContainerActivity.start(mContext,"我的博客", LockerConstant.github_url)
            }
            R.id.action_about->{
                startActivity(mContext,LockerAboutActivity::class.java)
            }
            R.id.action_system_setting->{
                LockerSettingActivity.start(mContext)
            }
        }
    }
}
package com.ve.module.locker.ui.page.drawer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import com.ve.lib.common.base.view.vm.BaseVmFragment
import com.ve.lib.common.event.AppRecreateEvent
import com.ve.lib.utils.SettingUtil
import com.ve.lib.view.ext.setOnclickNoRepeatListener
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.common.config.LockerConstant
import com.ve.module.locker.databinding.LockerFragmentDrawerActionBinding
import com.ve.module.locker.ui.page.about.LockerAboutActivity
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.container.LockerWebContainerActivity
import com.ve.module.locker.ui.page.feedback.LockerFeedBackActivity
import com.ve.module.locker.ui.page.privacy.list.LockerListFolderFragment
import com.ve.module.locker.ui.page.privacy.list.LockerListTagFragment
import com.ve.module.locker.ui.page.setting.LockerSettingActivity
import com.ve.module.locker.ui.viewmodel.LockerDrawerViewModel
import org.greenrobot.eventbus.EventBus


/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/8
 */
class LockerDrawerActionFragment :
    BaseVmFragment<LockerFragmentDrawerActionBinding, LockerDrawerViewModel>(),
    View.OnClickListener {

    override fun attachViewBinding(): LockerFragmentDrawerActionBinding {
        return LockerFragmentDrawerActionBinding.inflate(layoutInflater)
    }

    override fun attachViewModelClass(): Class<LockerDrawerViewModel> {
        return LockerDrawerViewModel::class.java
    }

    private lateinit var startActivitylaunch: ActivityResultLauncher<Intent>
    override fun initView(savedInstanceState: Bundle?) {

        mBinding.actionTag.setOnclickNoRepeatListener(this)
        mBinding.actionFolder.setOnclickNoRepeatListener(this)

        mBinding.actionSystemSetting.setOnclickNoRepeatListener(this)
        mBinding.actionNightModel.setOnclickNoRepeatListener(this)
        mBinding.actionFeedback.setOnclickNoRepeatListener(this)
        mBinding.actionBlog.setOnclickNoRepeatListener(this)
        mBinding.actionGithub.setOnclickNoRepeatListener(this)
        mBinding.actionAbout.setOnclickNoRepeatListener(this)
        mBinding.actionAutoFill.setOnclickNoRepeatListener(this)
        startActivitylaunch =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                LogUtil.msg(result.toString())
            }
    }

    override fun onClick(v: View?) {
        LogUtil.msg("click view ")
        when (v?.id) {
            R.id.action_tag -> {
                LockerContainerActivity.start(
                    mContext,
                    LockerListTagFragment::class.java.name,
                    "标签管理"
                )
            }
            R.id.action_folder -> {
                LockerContainerActivity.start(
                    mContext,
                    LockerListFolderFragment::class.java.name,
                    "文件夹管理"
                )
            }
            R.id.action_auto_fill -> {
                //打开自动填充服务设置界面
                val intent = Intent(Settings.ACTION_REQUEST_SET_AUTOFILL_SERVICE)
                intent.data = Uri.parse("package:com.android.settings")
                startActivitylaunch.launch(intent)
            }
            R.id.action_blog -> {
                LockerWebContainerActivity.start(mContext, "我的博客", LockerConstant.blog_url)
            }
            R.id.action_github -> {
                LockerWebContainerActivity.start(mContext, "我的博客", LockerConstant.github_url)
            }
            R.id.action_feedback -> {
                startActivity(mContext, LockerFeedBackActivity::class.java)
            }
            R.id.action_about -> {
                startActivity(mContext, LockerAboutActivity::class.java)
            }
            R.id.action_system_setting -> {
                LockerSettingActivity.start(mContext)
            }
            R.id.action_night_model -> {
                if (SettingUtil.getIsNightMode()) {
                    SettingUtil.setIsNightMode(false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                } else {
                    SettingUtil.setIsNightMode(true)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                EventBus.getDefault().post(AppRecreateEvent())
            }
        }
    }
}
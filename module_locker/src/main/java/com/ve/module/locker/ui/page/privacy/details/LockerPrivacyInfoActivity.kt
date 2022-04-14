package com.ve.module.locker.ui.page.privacy.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ve.lib.common.base.view.vmview.BaseVmActivity
import com.ve.module.locker.R
import com.ve.module.locker.databinding.LockerActivityPrivacyInfoBinding
import com.ve.module.locker.ui.state.LockerPrivacyInfoViewModel

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/10
 */
class LockerPrivacyInfoActivity:BaseVmActivity<LockerActivityPrivacyInfoBinding,LockerPrivacyInfoViewModel>() {

    override fun attachViewBinding(): LockerActivityPrivacyInfoBinding {
        return LockerActivityPrivacyInfoBinding.inflate(layoutInflater)
    }
    override fun attachViewModelClass(): Class<LockerPrivacyInfoViewModel> {
        return LockerPrivacyInfoViewModel::class.java
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    companion object {

        const val TITLE: String = "LockerPrivacyInfoActivity.title"
        const val CLASS_NAME: String = "LockerPrivacyInfoActivity.fragment"
        /**
         * className 请使用Fragment::class.java.name，不要使用 Fragment.javaClass.name
         *
         * CommonActivity.start(this,title,Fragment::class.java.name, bundle)
         */
        fun start(context: Context, fragmentClassName: String, title: String?=null, fragmentBundle: Bundle? = null) {
            Intent(context, LockerPrivacyInfoActivity::class.java).run {
                putExtra(TITLE, title)
                putExtra(CLASS_NAME, fragmentClassName)
                if (fragmentBundle != null) {
                    putExtras(fragmentBundle)
                }
                context.startActivity(this,fragmentBundle)
            }
        }
    }

    override fun initialize(saveInstanceState: Bundle?) {
        super.initialize(saveInstanceState)

        val toolbar = mBinding.extToolbar.toolbar
        intent.extras?.let {
            val commonActivityTitle = it.getString(TITLE, "标题")
            val className = it.getString(CLASS_NAME, "class name") ?: return
            val bundle = intent.extras //从bundle中取出数据

            toolbar.run {
                title = commonActivityTitle
                setSupportActionBar(this)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }

            val fragmentClass = Class.forName(className) //完整类名
            val fragment = fragmentClass.newInstance() as Fragment
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.ext_container, fragment, TITLE)
                .commit()
        }
    }
}
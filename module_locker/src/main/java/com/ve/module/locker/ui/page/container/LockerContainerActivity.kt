package com.ve.module.locker.ui.page.container

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ve.lib.common.base.view.vmview.BaseActivity
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.R
import com.ve.module.locker.databinding.LockerActivityContainerBinding

/**
 * @Author  weiyi
 * @Date 2022/4/12
 * @Description  current project locker-android
 */
class LockerContainerActivity :BaseActivity<LockerActivityContainerBinding>(){

    override fun attachViewBinding(): LockerActivityContainerBinding {
        return LockerActivityContainerBinding.inflate(layoutInflater)
    }

    companion object {

        const val FRAGMENT_TITLE_KEY: String = "ContainerActivity.title"
        const val FRAGMENT_CLASS_NAME_KEY: String = "ContainerActivity.fragment"
        const val FRAGMENT_ARGUMENTS_KEY = "ContainerActivity.args"

        /**
         * person.javaClass == person::class.java == Person::class.java
         * person.javaClass != Person::class
         * className 请使用Fragment::class.java.name，不要使用 Fragment.javaClass.name
         * ContainerActivity.start(this,title,Fragment::class.java.name, bundle)
         */
        fun start(context: Context, fragmentClassName: String, title: String? = null, fragmentBundle: Bundle? = null) {
            Intent(context, LockerContainerActivity::class.java).run {
                //启动模式
                flags=Intent.FLAG_ACTIVITY_SINGLE_TOP
                putExtra(FRAGMENT_TITLE_KEY, title)
                putExtra(FRAGMENT_CLASS_NAME_KEY, fragmentClassName)
                putExtra(FRAGMENT_ARGUMENTS_KEY,fragmentBundle)
                //或者
//                if (fragmentBundle != null) {
//                    putExtras(fragmentBundle)
//                }
                context.startActivity(this, fragmentBundle)
            }
        }
        fun <T>start(context: Context, fragmentClass:T, title: String? = null, fragmentBundle: Bundle? = null) {
            val fragmentClassName=fragmentClass!!::class.java
            Intent(context, LockerContainerActivity::class.java).run {
                putExtra(FRAGMENT_TITLE_KEY, title)
                putExtra(FRAGMENT_CLASS_NAME_KEY, fragmentClassName)
                putExtra(FRAGMENT_ARGUMENTS_KEY,fragmentBundle)
                context.startActivity(this, fragmentBundle)
            }
        }
    }

    lateinit var fragmentTitle: String
    lateinit var fragmentClassName: String
    lateinit var fragmentArguments: Bundle

    override fun initialize(saveInstanceState: Bundle?) {

        //从bundle中取出数据
        fragmentTitle  = intent.getStringExtra(FRAGMENT_TITLE_KEY) ?: "标题"
        fragmentClassName = intent.getStringExtra(FRAGMENT_CLASS_NAME_KEY) ?: ""
        fragmentArguments = intent.getBundleExtra(FRAGMENT_ARGUMENTS_KEY) ?: Bundle()

        if(fragmentClassName.isEmpty()){
            LogUtil.msg("fragment class name is null")
        }else{
            transactionFragment(fragmentClassName,fragmentArguments)
        }
        initToolbar(mBinding.extToolbar.toolbar,fragmentTitle)
    }

    /**
     * 如果需要把 title ,className 也传过去，可以transactionFragment(fragmentClassName,saveInstanceState)
     */
    protected fun transactionFragment(fragmentClassName: String, bundle: Bundle? = null) {
        val fragmentClass = Class.forName(fragmentClassName) //完整类名
        val fragment = fragmentClass.newInstance() as Fragment
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.ext_container, fragment, fragmentTitle)
            .commit()
    }
}
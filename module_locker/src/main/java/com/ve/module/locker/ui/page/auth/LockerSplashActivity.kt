package com.ve.module.locker.ui.page.auth

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.ve.lib.common.base.view.vm.BaseActivity
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.LockerMainActivity
import com.ve.module.locker.common.config.LockerSharePreference
import com.ve.module.locker.databinding.LockerActivitySplashBinding


class LockerSplashActivity : BaseActivity<LockerActivitySplashBinding>() {

    private var alphaAnimation: AlphaAnimation? = null

    override fun useEventBus(): Boolean = false

    private val layout_splash by lazy { mBinding.layoutSplash }

    override fun initColor() {
        super.initColor()
//        layout_splash.setBackgroundColor(mThemeColor)
        mBinding.ivLogo.setColorFilter(mThemeColor)


    }

    fun jumpToMain() {
        val intent = Intent(this, LockerMainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    fun jumpToAuth() {
        val intent = Intent(this, LockerAuthActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    private fun jumpToLogin() {
        val intent = Intent(this, LockerLoginActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun attachViewBinding(): LockerActivitySplashBinding {
        return LockerActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initialize(saveInstanceState: Bundle?) {
        val isLogin=LockerSharePreference.getLoginState()
        val data=LockerSharePreference.getLoginData()
        LogUtil.msg("isLogin $isLogin")
        LogUtil.msg(data.toString())
        alphaAnimation = AlphaAnimation(0.3F, 1.0F)
        alphaAnimation?.run {
            duration = 1000
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    jumpToMain()
//                    if(isLogin){
//                        jumpToAuth()
//                    }else{
//                        jumpToLogin()
//                    }

                }

                override fun onAnimationStart(p0: Animation?) {
                }
            })
        }
        layout_splash.startAnimation(alphaAnimation)
    }

}

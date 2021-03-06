package com.ve.module.main.ui.page.splash

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.ve.lib.common.base.view.vm.BaseActivity
import com.ve.module.main.MainActivity
import com.ve.module.main.databinding.ActivitySplashBinding


class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private var alphaAnimation: AlphaAnimation? = null

    override fun useEventBus(): Boolean = false

    private val layout_splash by lazy { mBinding.layoutSplash }

    override fun initColor() {
        super.initColor()
        layout_splash.setBackgroundColor(mThemeColor)
    }

    fun jumpToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun attachViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initialize(saveInstanceState: Bundle?) {
        alphaAnimation = AlphaAnimation(0.3F, 1.0F)
        alphaAnimation?.run {
            duration = 1000
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    jumpToMain()
                }

                override fun onAnimationStart(p0: Animation?) {
                }
            })
        }
        layout_splash.startAnimation(alphaAnimation)
    }

}

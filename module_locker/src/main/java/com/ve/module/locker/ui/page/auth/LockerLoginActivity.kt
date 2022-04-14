package com.ve.module.locker.ui.page.auth

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import com.ve.lib.common.base.view.vmview.BaseVmActivity
import com.ve.lib.view.ext.setOnclickNoRepeat
import com.ve.lib.utils.DialogUtil
import com.ve.lib.utils.PreferenceUtil
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.common.config.LockerConstant
import com.ve.module.locker.common.config.LockerLifecycle
import com.ve.module.locker.common.config.LockerSharePreference
import com.ve.module.locker.databinding.LockerActivityLoginBinding
import com.ve.module.locker.logic.http.model.LoginVO
import com.ve.module.locker.ui.state.LockerLoginViewModel

/**
 * https://www.wanandroid.com/user/login
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/3/20
 */
class LockerLoginActivity: BaseVmActivity<LockerActivityLoginBinding, LockerLoginViewModel>(){

    override fun initView(savedInstanceState: Bundle?) {
        initToolbar(mBinding.extToolbar.toolbar, "登录", true)

        setText()
        et_username.setText(LockerConstant.username)
        et_password.setText(LockerConstant.password)
    }

    override fun attachViewBinding(): LockerActivityLoginBinding {
        return LockerActivityLoginBinding.inflate(layoutInflater)
    }
    override fun attachViewModelClass(): Class<LockerLoginViewModel> {
        return LockerLoginViewModel::class.java
    }
    override fun useEventBus(): Boolean = false

    override fun enableNetworkTip(): Boolean = false
    
    /**
     * local username 从内存中读取
     */
    private var user: String by PreferenceUtil(LockerConstant.USERNAME_KEY, "")
    /**
     * local password
     */
    private var pwd: String by PreferenceUtil(LockerConstant.PASSWORD_KEY, "")
    /**
     * token
     */
    private var token: String by PreferenceUtil(LockerConstant.TOKEN_KEY, "")


    private val et_username by lazy { mBinding.etUsername }
    private val et_password by lazy { mBinding.etPassword }
    private val btn_login by lazy { mBinding.btnLogin }
    private val tv_sign_up by lazy { mBinding.tvSignUp }

    private val mDialog by lazy {
        DialogUtil.getWaitDialog(this, "正在登录...")
    }

    override fun showLoading(msg: String) {
        // mDialog.show()
    }

    override fun hideLoading() {
        // mDialog.dismiss()
    }

    override fun initObserver() {
        mViewModel.loginState.observe(this) {
            LockerLifecycle.loginState.value=it
            showLoading("")
            if (it) {
                showMsg("登录成功")
            } else {
                showMsg("登录失败")
            }
        }

        mViewModel.loginData.observe(this) {
            LockerLifecycle.loginData.value=it
            LockerSharePreference.setValue(LockerConstant.TOKEN_KEY,it.accessToken)
            LogUtil.msg(mViewName+"\n--${it.accessToken}\n--"+ LockerSharePreference.getValue(
                LockerConstant.TOKEN_KEY,"---")!!)
            if(it!=null) {
                loginSuccess(it)
            }else{
                loginFail()
            }
        }
    }

    override fun initListener() {
        super.initListener()
        btn_login.apply {
            setOnclickNoRepeat {
                if (!mBinding.cbServiceAgreement.isChecked) {
                    showMsg("同意服务协议与隐私政策后才能登录")
                    return@setOnclickNoRepeat
                }
                login()
            }
            setBackgroundColor(mThemeColor)
        }

        tv_sign_up.setOnclickNoRepeat {
            val intent = Intent(this, LockerRegisterActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
    /**
     * Login
     */
    private fun login() {
        if (validate()) {
            mViewModel.login(et_username.text.toString(), et_password.text.toString())
        }
    }


    private fun loginSuccess(data: LoginVO) {
        //startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    private fun loginFail() {

    }

    /**
     * Check UserName and PassWord
     */
    private fun validate(): Boolean {
        var valid = true
        val username: String = et_username.text.toString()
        val password: String = et_password.text.toString()

        if (username.isEmpty()) {
            et_username.error = "用户名不能为空"
            valid = false
        }
        if (password.isEmpty()) {
            et_password.error = "密码不能为空"
            valid = false
        }
        return valid
    }

    private fun setText() {
        val spanBuilder = SpannableStringBuilder("同意")
        val color = mThemeColor

        var span = SpannableString("服务协议")
        span.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                showMsg("服务协议")
            }
        }, 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        span.setSpan(ForegroundColorSpan(color), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanBuilder.append(span)

        spanBuilder.append("与")

        span = SpannableString("隐私政策")
        span.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                showMsg("隐私政策")
            }
        }, 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(ForegroundColorSpan(color), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanBuilder.append(span)

        mBinding.tvServiceAgreement.movementMethod = LinkMovementMethod.getInstance()
        mBinding.tvServiceAgreement.text = spanBuilder
        //设置高亮颜色透明，因为点击会变色
        mBinding.tvServiceAgreement.highlightColor = Color.parseColor("#00000000")
        //ContextCompat.getColor(applicationContext, R.color.transparent)
    }
}
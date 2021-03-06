package com.ve.module.locker.ui.page.setting

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.SwitchPreference
import com.ve.lib.common.event.RefreshHomeEvent
import com.ve.lib.common.utils.ImageLoader
import com.ve.lib.utils.DialogUtil
import com.ve.lib.view.widget.preference.IconPreference
import com.ve.lib.vutils.LogUtil
import com.ve.lib.vutils.SpUtil
import com.ve.lib.vutils.ToastUtil
import com.ve.module.locker.R
import com.ve.module.locker.common.config.SettingConstant
import com.ve.module.locker.model.db.AppDataBase
import com.ve.module.locker.model.http.model.LoginVO
import com.ve.module.locker.ui.page.container.LockerContainerActivity
import com.ve.module.locker.ui.page.key.LockerKeyFragment
import com.ve.module.locker.ui.page.user.LockerUserInfoActivity
import com.ve.module.locker.utils.AndroidUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import org.greenrobot.eventbus.EventBus

/**
 * @Author  weiyi
 * @Date 2022/4/13
 * @Description  current project locker-android
 */
class LockerSettingFragment : BaseSettingFragment() {


    override fun attachPreferenceResource(): Int {
        return com.ve.module.locker.R.xml.locker_pref_settings
    }

    val spClickPreferenceKeyList = mutableListOf<String>(
        SettingConstant.SP_KEY_ACCOUNT_SETTING,
        SettingConstant.SP_KEY_STYLE_SETTING,
        SettingConstant.SP_KEY_CACHE_SETTING,
        SettingConstant.SP_KEY_ABOUT_SETTING,
        SettingConstant.SP_KEY_AUTO_FILL,
        SettingConstant.SP_KEY_RECRATE_DATABASE,
        SettingConstant.SP_KEY_KEY_MANAGER
        )

    private lateinit var startActivityLaunch: ActivityResultLauncher<Intent>
    override fun initPreferenceView() {
        startActivityLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            LogUtil.msg(result.toString())
        }
        spClickPreferenceKeyList.forEach { key ->
            run {
                findPreference<Preference>(key)?.onPreferenceClickListener = this
            }
        }
        val userinfo=SpUtil.getValue(SettingConstant.SP_KEY_LOGIN_DATA_KEY, LoginVO())

        findPreference<Preference>(SettingConstant.SP_KEY_ACCOUNT_SETTING)?.apply {

            CoroutineScope(Dispatchers.IO).launch {
                val avatar=ImageLoader.loadPicture(mContext,userinfo.userDetailDTO.avatar)
                withContext(Dispatchers.Main) {
                    icon=avatar
                }
            }

//            lifecycleScope.launch{
//                withContext(Dispatchers.Main){
//                    icon=ImageLoader.loadPicture(mContext,userinfo.userDetailDTO.avatar)
//                }
//            }
            summary=userinfo.userDetailDTO.nickname
        }
    }

    private lateinit var colorPreview: IconPreference

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        LogUtil.msg("sharedPreferences $key")
        when (key) {
            SettingConstant.SP_KEY_SHOW_TOP -> {
                val mainThreadHandler: Handler = Handler(Looper.getMainLooper())
                // ????????????????????????
                // ???????????????????????????????????????????????? SettingUtil.getIsShowTopArticle() ??????????????????
                mainThreadHandler.postDelayed({
                    EventBus.getDefault().post(RefreshHomeEvent(true))
                }, 100)
            }
            SettingConstant.SP_KEY_BIOMETRICS->{
                val switchPreference=findPreference<SwitchPreference>(key)!!
                val executor = ContextCompat.getMainExecutor(mContext)
                val biometricPrompt = BiometricPrompt(this, executor,
                    object : BiometricPrompt.AuthenticationCallback() {
                        override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                            super.onAuthenticationError(errorCode, errString)
                            ToastUtil.showCenter("???????????????\n" + "Authentication error: $errString!")
                            switchPreference.isChecked= SpUtil.getBoolean(key)
                        }

                        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                            super.onAuthenticationSucceeded(result)
                            ToastUtil.showCenter("???????????????\nAuthentication succeeded!")
                            SpUtil.setValue(key,switchPreference.isChecked)
                        }

                        override fun onAuthenticationFailed() {
                            super.onAuthenticationFailed()
                            ToastUtil.showCenter("????????????????????????")
                            switchPreference.isChecked= SpUtil.getBoolean(key)
                        }
                    })

                val promptInfo = BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Authentication required")
                    .setSubtitle("????????????locker")
                    .setNegativeButtonText("??????")
                    .build()

                biometricPrompt.authenticate(promptInfo)
            }

            else -> {
                showMsg("???????????????. key=$key  ")
            }
        }
    }


    override fun onPreferenceClick(preference: Preference?): Boolean {
        LogUtil.msg("sharedPreferences ${preference?.key}")
        when (preference?.key) {
            SettingConstant.SP_KEY_KEY_MANAGER->{
                LockerContainerActivity.start(mContext,LockerKeyFragment::class.java,"????????????")
            }
            SettingConstant.SP_KEY_RECRATE_DATABASE->{
                DialogUtil.getConfirmDialog(
                    mContext,
                    "?????????????????????????????????????????????????????????????????????????????????????????????????????????",
                    onOKClickListener = {
                        d,w->
                        SpUtil.setValue(SettingConstant.SP_KEY_DATABASE_INIT,false)
                        AppDataBase.initDataBase()
                    },
                    onCancelClickListener = null
                ).show()
            }
            SettingConstant.SP_KEY_STYLE_SETTING -> {
                LockerSettingActivity.start(mContext, StyleSettingFragment::class.java.name, "????????????")
            }
            SettingConstant.SP_KEY_CACHE_SETTING -> {
                LockerSettingActivity.start(mContext, CacheSettingFragment::class.java.name, "????????????")
            }
            SettingConstant.SP_KEY_ACCOUNT_SETTING -> {
                startActivity(mContext,LockerUserInfoActivity::class.java)
            }
            SettingConstant.SP_KEY_ABOUT_SETTING -> {
                LockerSettingActivity.start(mContext, AboutSettingFragment::class.java.name, "??????")
            }
            SettingConstant.SP_KEY_AUTO_FILL->{
                //????????????????????????????????????
                val intent = Intent(Settings.ACTION_REQUEST_SET_AUTOFILL_SERVICE)
                intent.data = Uri.parse("package:com.android.settings")
                startActivityLaunch.launch(intent)
            }
            else -> {
                showMsg("${preference?.title} ???????????????.key=${preference?.key}")
            }
        }
        return false
    }
}
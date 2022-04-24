package com.ve.module.locker.ui.page.setting

import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import androidx.preference.Preference
import com.ve.lib.common.event.RefreshHomeEvent
import com.ve.lib.view.widget.preference.IconPreference
import com.ve.lib.vutils.LogUtil
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

    val spPreferenceKeyList = mutableListOf<String>(
        SettingConstant.SP_KEY_ACCOUNT_SETTING,
        SettingConstant.SP_KEY_STYLE_SETTING,
        SettingConstant.SP_KEY_CACHE_SETTING,
        SettingConstant.SP_KEY_ABOUT_SETTING,

        )

    override fun initPreferenceView() {
        spPreferenceKeyList.forEach { key ->
            run {
                findPreference<Preference>(key)?.onPreferenceClickListener = this
            }
        }
    }

    private lateinit var colorPreview: IconPreference


    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        LogUtil.msg("sharedPreferences $key")
        when (key) {
            SettingConstant.SP_KEY_SHOW_TOP -> {
                val mainThreadHandler: Handler = Handler(Looper.getMainLooper())
                // 通知首页刷新数据
                // 延迟发送通知：为了保证刷新数据时 SettingUtil.getIsShowTopArticle() 得到最新的值
                mainThreadHandler.postDelayed({
                    EventBus.getDefault().post(RefreshHomeEvent(true))
                }, 100)
            }
            else -> {
                showMsg("功能未实现. key=$key  ")
            }
        }
    }


    override fun onPreferenceClick(preference: Preference?): Boolean {
        LogUtil.msg("sharedPreferences ${preference?.key}")
        when (preference?.key) {
            SettingConstant.SP_KEY_STYLE_SETTING -> {
                LockerSettingActivity.start(mContext, StyleSettingFragment::class.java.name, "主题设置")
            }
            SettingConstant.SP_KEY_CACHE_SETTING -> {
                LockerSettingActivity.start(mContext, CacheSettingFragment::class.java.name, "缓存设置")
            }
            SettingConstant.SP_KEY_ACCOUNT_SETTING -> {
                LockerSettingActivity.start(mContext, AboutSettingFragment::class.java.name, "关于")
            }
            SettingConstant.SP_KEY_ABOUT_SETTING -> {
                LockerSettingActivity.start(mContext, AboutSettingFragment::class.java.name, "关于")
            }
            else -> {
                showMsg("${preference?.title} 功能未实现.key=${preference?.key}")
            }
        }
        return false
    }
}
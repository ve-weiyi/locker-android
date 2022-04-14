package com.ve.module.locker.ui.page.setting


import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AlertDialog

import androidx.preference.Preference
import com.ve.lib.common.event.RefreshHomeEvent
import com.ve.lib.utils.CacheDataUtil
import com.ve.lib.view.ext.showSnackMsg

import com.ve.module.locker.R
import org.greenrobot.eventbus.EventBus

/**
 * @Author  weiyi
 * @Date 2022/4/13
 * @Description  current project locker-android
 */
class CacheSettingFragment :  BaseSettingFragment(){
    override fun attachPreferenceResource(): Int {
        return R.xml.locker_pref_setting_cache
    }

    override fun initPreferenceView() {
        setDefaultText()

        findPreference<Preference>(SettingConstant.SP_KEY_SHOW_TOP)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_NO_PHOTO)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_CLEAR_CACHE)?.onPreferenceClickListener = this

    }



    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            SettingConstant.SP_KEY_SHOW_TOP-> {
                val mainThreadHandler: Handler =Handler(Looper.getMainLooper())
                // 通知首页刷新数据
                // 延迟发送通知：为了保证刷新数据时 SettingUtil.getIsShowTopArticle() 得到最新的值
                mainThreadHandler.postDelayed({
                    EventBus.getDefault().post(RefreshHomeEvent(true))
                }, 100)
            }
            else -> {
                AlertDialog.Builder(mContext)
                    .setTitle(key)
                    .setMessage("功能未实现")
                    .setCancelable(true)
                    .show()
            }
        }
    }

    override fun onPreferenceClick(preference: Preference?): Boolean {
        when (preference?.key) {
            SettingConstant.SP_KEY_CLEAR_CACHE -> {
                CacheDataUtil.clearAllCache(mContext)
                mContext.showSnackMsg(getString(com.ve.lib.application.R.string.clear_cache_successfully))
                setDefaultText()
            }
            else->{
                AlertDialog.Builder(mContext)
                    .setTitle(preference?.title)
                    .setMessage("${preference?.summary} 功能未实现")
                    .setCancelable(true)
                    .show()
            }
        }
        return false
    }

    private fun setDefaultText() {
        try {
            findPreference<Preference>(SettingConstant.SP_KEY_CLEAR_CACHE)?.summary=
                CacheDataUtil.getTotalCacheSize(requireContext())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
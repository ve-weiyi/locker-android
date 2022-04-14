package com.ve.module.locker.ui.page.setting


import android.content.SharedPreferences
import androidx.appcompat.app.AlertDialog

import androidx.preference.Preference
import com.ve.lib.utils.CacheDataUtil

import com.ve.module.locker.R
import com.ve.module.locker.ui.page.about.LockerAboutActivity

/**
 * @Author  weiyi
 * @Date 2022/4/13
 * @Description  current project locker-android
 */
class AboutSettingFragment :  BaseSettingFragment(){
    override fun attachPreferenceResource(): Int {
        return R.xml.locker_pref_setting_about
    }

    override fun initPreferenceView() {

        findPreference<Preference>(SettingConstant.SP_KEY_SCAN_QR_CODE)?.onPreferenceClickListener = this

        findPreference<Preference>(SettingConstant.SP_KEY_APP_VERSION)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_APP_WEBSITE)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_UPDATE_LOG)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_SOURCE_CODE)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_COPYRIGHT)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_ABOUT_US)?.onPreferenceClickListener = this

    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

    }

    override fun onPreferenceClick(preference: Preference?): Boolean {
        when (preference?.key) {
            SettingConstant.SP_KEY_APP_VERSION -> {

            }
            SettingConstant.SP_KEY_APP_WEBSITE -> {

            }
            SettingConstant.SP_KEY_UPDATE_LOG -> {

            }
            SettingConstant.SP_KEY_SOURCE_CODE -> {

            }
            SettingConstant.SP_KEY_COPYRIGHT -> {
                AlertDialog.Builder(mContext)
                    .setTitle(com.ve.lib.application.R.string.copyright)
                    .setMessage(com.ve.lib.application.R.string.copyright_content)
                    .setCancelable(true)
                    .show()
            }
            SettingConstant.SP_KEY_ABOUT_US -> {
                startActivity(mContext, LockerAboutActivity::class.java)
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
            val version = context?.resources?.getString(com.ve.lib.application.R.string.current_version).toString()
                .plus(
                    context?.packageManager?.getPackageInfo(
                        context?.packageName ?: "",
                        0
                    )?.versionName
                )
            findPreference<Preference>(SettingConstant.SP_KEY_APP_VERSION)!!.summary = version

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
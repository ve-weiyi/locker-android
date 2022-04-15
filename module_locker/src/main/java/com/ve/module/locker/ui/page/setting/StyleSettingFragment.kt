package com.ve.module.locker.ui.page.setting


import android.content.SharedPreferences
import androidx.appcompat.app.AlertDialog

import androidx.preference.Preference
import com.afollestad.materialdialogs.color.ColorChooserDialog
import com.ve.lib.view.widget.preference.IconPreference

import com.ve.module.locker.R

/**
 * @Author  weiyi
 * @Date 2022/4/13
 * @Description  current project locker-android
 */
class StyleSettingFragment :  BaseSettingFragment(){

    private lateinit var colorPreview: IconPreference

    override fun attachPreferenceResource(): Int {
        return R.xml.locker_pref_setting_style
    }

    override fun initPreferenceView() {

        colorPreview=findPreference<IconPreference>(SettingConstant.SP_KEY_THEME_COLOR)!!

        findPreference<Preference>(SettingConstant.SP_KEY_NIGHT_MODE)?.onPreferenceClickListener = this

        findPreference<Preference>(SettingConstant.SP_KEY_AUTO_NIGHT_MODE)?.onPreferenceClickListener = this

        findPreference<Preference>(SettingConstant.SP_KEY_TEXT_SIZE)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_THEME_COLOR)?.onPreferenceClickListener = this
        findPreference<Preference>(SettingConstant.SP_KEY_NAV_COLOR)?.onPreferenceClickListener = this

        setDefaultText()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            "color"->{
                colorPreview.setView()
            }
            else -> {
                showMsg("功能未实现. key=$key  ")
            }
        }
    }

    override fun onPreferenceClick(preference: Preference?): Boolean {
        when (preference?.key) {
            /**
             * 其他设置
             */
            SettingConstant.SP_KEY_THEME_COLOR -> {
                ColorChooserDialog.Builder(mSettingActivity as LockerSettingActivity, com.ve.lib.application.R.string.choose_theme_color)
                    .backButton(com.ve.lib.application.R.string.back)
                    .cancelButton(com.ve.lib.application.R.string.cancel)
                    .doneButton(com.ve.lib.application.R.string.done)
                    .customButton(com.ve.lib.application.R.string.custom)
                    .presetsButton(com.ve.lib.application.R.string.back)
                    .allowUserColorInputAlpha(false)
                    .show()
                false
            }
            SettingConstant.SP_KEY_AUTO_NIGHT_MODE -> {
                LockerSettingActivity.start(mContext,AutoNightModeFragment::class.java.name)
            }
            else->{
                showMsg("${preference?.title} 功能未实现.key=${preference?.key}")
            }
        }
        return false
    }

    private fun setDefaultText() {
        try {
            colorPreview = findPreference<IconPreference>(SettingConstant.SP_KEY_THEME_COLOR)!!
            colorPreview.setView()
            val version = context?.resources?.getString(com.ve.lib.application.R.string.current_version).toString()
                .plus(
                    context?.packageManager?.getPackageInfo(
                        context?.packageName ?: "",
                        0
                    )?.versionName
                )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
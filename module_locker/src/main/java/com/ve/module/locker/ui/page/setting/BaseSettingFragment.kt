package com.ve.module.locker.ui.page.setting

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.ve.lib.view.widget.preference.IconPreference

/**
 * @Author  weiyi
 * @Date 2022/4/13
 * @Description  current project locker-android
 */
abstract class BaseSettingFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceClickListener {

    lateinit var mContext: LockerSettingActivity


    abstract fun attachPreferenceResource():Int
    abstract fun initPreferenceView()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(attachPreferenceResource(), rootKey)
        setHasOptionsMenu(true)
        mContext=activity as LockerSettingActivity

        initPreferenceView()
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    fun startActivity(context: Context,activityClass: Class<*>){
        val intent = Intent(context,activityClass)
        context.startActivity(intent)
    }
}
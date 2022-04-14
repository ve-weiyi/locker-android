package com.ve.lib.view.widget.preference

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import com.ve.lib.utils.SettingUtil.getColor
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import com.afollestad.materialdialogs.color.CircleView
import com.ve.lib.utils.SettingUtil
import com.ve.lib.view.R

/**
 * @Author weiyi
 * @Date 2022/4/13
 * @Description current project locker-android
 * Android自定义控件——自定义Preference
 * https://www.cnblogs.com/gmm283029/p/4498933.html
 */
class MyPreference(
    context: Context,
    attributeSet: AttributeSet
): Preference(context, attributeSet) {

    init {
        // 将刚刚写好的布局赋值给 layoutResource
        layoutResource = R.layout.preference_color_picker
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)

        // 找到自己定义的view
        val imageView = holder.findViewById(R.id.image)
        // 做个朴实无华的运动
        ValueAnimator.ofFloat(0f, 360f).apply {
            duration = 2000
            repeatMode = ValueAnimator.RESTART
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                imageView.rotation = it.animatedValue as Float
            }
            start()
        }
    }
}

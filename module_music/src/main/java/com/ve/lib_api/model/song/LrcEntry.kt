package com.ve.lib_api.model.song

import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.text.TextUtils

/**
 * 一行歌词的实体类,因为要按照时间排序，所以需要实现Comparable
 * 用它来画到View上
 */
class LrcEntry(
//歌词所对应的时间
    val time: Long, //第一种语言的歌词的内容
    val text: String
) : Comparable<LrcEntry?> {

    //第二种语言的歌词内容，一开始是空的，需要设置
    var secondText: String? = null

    //StaticLayout，可以自动换行
    var staticLayout: StaticLayout? = null
        private set

    //这一行歌词距离视图顶部的距离
    var offset = Float.MIN_VALUE

    /**
     * 绘制时每一行都要初始化其内容、宽度、绘制格式
     */
    fun init(paint: TextPaint?, width: Int, gravity: Int) {
        val align: Layout.Alignment
        align = when (gravity) {
            GRAVITY_LEFT -> Layout.Alignment.ALIGN_NORMAL
            GRAVITY_CENTER -> Layout.Alignment.ALIGN_CENTER
            GRAVITY_RIGHT -> Layout.Alignment.ALIGN_OPPOSITE
            else -> Layout.Alignment.ALIGN_CENTER
        }
        staticLayout = StaticLayout(showText, paint, width, align, 1f, 0f, false)
        offset = Float.MIN_VALUE
    }

    /**
     * 获取歌词高度
     */
    val height: Int
        get() = if (staticLayout == null) {
            0
        } else staticLayout!!.height
    private val showText: String
        private get() = if (!TextUtils.isEmpty(secondText)) {
            """
     $text
     $secondText
     """.trimIndent()
        } else text

    /**
     * 根据歌词时间来比较大小
     */
    override fun compareTo(entry: LrcEntry?): Int {
        return if (entry == null) {
            -1
        } else (time - entry.time).toInt()
    }

    companion object {
        //歌词的居中/左/右显示
        const val GRAVITY_CENTER = 0
        const val GRAVITY_LEFT = 1
        const val GRAVITY_RIGHT = 2
    }
}
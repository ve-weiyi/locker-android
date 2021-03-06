package com.ve.lib.view.ext

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Checkable
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.google.android.material.snackbar.Snackbar
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient
import com.ve.lib.application.BaseApplication

import com.ve.lib.utils.BuildConfig
import com.ve.lib.view.R
import com.ve.lib.view.widget.CustomToast
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by chenxz on 2018/4/22.
 */
/**
 * Log
 */
fun Any.loge(content: String?) {
    loge(this.javaClass.simpleName ?: BaseApplication.TAG, content ?: "")
}

fun loge(tag: String, content: String?) {
    if (BuildConfig.DEBUG) {
        Log.e(tag, content ?: "")
    }
}

fun showToast(content: String) {
    CustomToast(BaseApplication.mContext, content).show()
}

fun Fragment.showToast(content: String) {
    CustomToast(this.requireContext(), content).show()
}

fun Context.showToast(content: String) {
    CustomToast(this, content).show()
}

fun Activity.showSnackMsg(msg: String) {
    val snackbar = Snackbar.make(this.window.decorView, msg, Snackbar.LENGTH_SHORT)
    val view = snackbar.view
    view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        .setTextColor(Color.WHITE)
    snackbar.show()
}

fun Fragment.showSnackMsg(msg: String) {
    this.activity ?: return
    val snackbar = Snackbar.make(this.requireActivity().window.decorView, msg, Snackbar.LENGTH_SHORT)
    val view = snackbar.view
    view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        .setTextColor(Color.WHITE)
    snackbar.show()
}

fun Fragment.getInstance() :Fragment{
    return javaClass.newInstance()
}

fun Fragment.newInstance() :Fragment{
    return javaClass.newInstance()
}

// ????????????????????????(??????????????????)
var <T : View> T.lastClickTime: Long
    set(value) = setTag(1766613352, value)
    get() = getTag(1766613352) as? Long ?: 0

// ????????????????????????
inline fun <T : View> T.setSingleClickListener(time: Long = 1000, crossinline block: (T) -> Unit) {
    setOnClickListener {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - lastClickTime > time || this is Checkable) {
            lastClickTime = currentTimeMillis
            block(this)
        }
    }
}

/**
 * getAgentWeb
 */
fun String.getAgentWeb(
    activity: Activity,
    webContent: ViewGroup,
    layoutParams: ViewGroup.LayoutParams,
    webView: WebView,
    webViewClient: WebViewClient?,
    webChromeClient: WebChromeClient?,
    indicatorColor: Int
): AgentWeb = AgentWeb.with(activity)//??????Activity or Fragment
    .setAgentWebParent(webContent, 1, layoutParams)//??????AgentWeb ????????????
    .useDefaultIndicator(indicatorColor, 2)// ?????????????????????
    .setWebView(webView)
    .setWebViewClient(webViewClient)
    .setWebChromeClient(webChromeClient)
    .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
    .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
    .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//??????????????????????????????????????????????????????????????????
    .interceptUnkownUrl()
    .createAgentWeb()//
    .ready()
    .go(this)

/**
 * ?????????????????????
 */
fun formatCurrentDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    return sdf.format(Date())
}

/**
 * String ??? Calendar
 */
fun String.stringToCalendar(): Calendar {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    val date = sdf.parse(this)
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar
}
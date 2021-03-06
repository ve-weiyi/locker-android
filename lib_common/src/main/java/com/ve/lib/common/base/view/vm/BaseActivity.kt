package com.ve.lib.common.base.view.vm

import android.content.Context
import android.content.IntentFilter
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewbinding.ViewBinding
import com.ve.lib.common.event.ColorEvent
import com.ve.lib.common.receiver.NetworkChangeReceiver
import com.ve.lib.utils.KeyBoardUtil
import com.ve.lib.utils.SettingUtil
import com.ve.lib.utils.StatusBarUtil
import com.ve.lib.vutils.LogUtil
import com.ve.lib.vutils.ToastUtil
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @author chenxz
 * @date 2018/11/19
 * @desc BaseActivity 泛型实化 ，内部存有binding对象
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), IView<VB> {

    lateinit var mBinding: VB
    protected open var mViewName: String? = this.javaClass.simpleName

    protected var mNetworkChangeReceiver: NetworkChangeReceiver? = null
    protected var mThemeColor: Int = SettingUtil.getColor()
    protected val mContext: Context by lazy { this }

    /**
     * 是否使用 EventBus
     */
    open fun useEventBus(): Boolean = true

    /**
     * 1. onCreate()，创建时调用，初始化操作写在这里，如指定布局文件，成员变量绑定对应ID等。
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.d("$mViewName onCreate")
        /**************************/
        //设置窗口软键盘的交互模式,保证用户要进行输入的输入框肯定在用户的视野范围里面
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //由系统选择显示方向，不同的设备可能会有所不同。（旋转手机，界面会跟着旋转）
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        mBinding = attachViewBinding()
        setContentView(mBinding.root)

        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        initialize(savedInstanceState)
    }

    /**
     * Theme color Change
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onColorChangeEvent(event: ColorEvent) {
        initColor()
        LogUtil.d("$mViewName receiver theme color change ")
    }

    /**
     * 设置标题栏，调用此方法后标题栏颜色与主题色保持一致
     */
    protected fun initToolbar(
        toolbar: Toolbar,
        title: String = "无标题",
        homeAsUpEnabled: Boolean = true
    ) {
        toolbar.title = title
        //需要先设置设置toolbar
        setSupportActionBar(toolbar)
        //左侧添加一个默认的返回图标
        supportActionBar?.setDisplayHomeAsUpEnabled(homeAsUpEnabled)
        //设置返回键可用
        supportActionBar?.setHomeButtonEnabled(homeAsUpEnabled)
    }

    open fun initColor() {
        mThemeColor = if (!SettingUtil.getIsNightMode()) {
            //非夜间模式
            SettingUtil.getColor()
        } else {
            resources.getColor(com.ve.lib.application.R.color.colorPrimary,null)
        }
        application
        //沉浸式状态栏
        StatusBarUtil.setColor(this, mThemeColor, 0)
        //标题栏
        if (this.supportActionBar != null) {
            this.supportActionBar?.setBackgroundDrawable(ColorDrawable(mThemeColor))
        }
        //是否开启导航栏上色
        if (SettingUtil.getNavBar()) {
            window.navigationBarColor = mThemeColor
        } else {
            window.navigationBarColor = Color.BLACK
        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_UP) {
            val v = currentFocus
            // 如果不是落在EditText区域，则需要关闭输入法
            if (KeyBoardUtil.isHideKeyboard(v, ev)) {
                KeyBoardUtil.hideKeyBoard(this, v)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    /**
     * 返回键选中处理
     */
    //需要在onCreate设置 setHasOptionsMenu()
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                LogUtil.d(mViewName + "action id=" + item.itemId)
                onBackPressed()
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // Fragment 逐个出栈
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    /**
     * 3. onResume()，在活动准备好与用户交互时调用，此时活动一定处于栈顶，且在运行状态。
     *  onResume（）和onPause（）方法是调用比较频繁的，在这两个方法里面一般做很小耗时的操作，以增强用户体验。
     */
    override fun onResume() {
        // 动态注册网络变化广播
        val filter = IntentFilter()
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        mNetworkChangeReceiver = NetworkChangeReceiver()
        registerReceiver(mNetworkChangeReceiver, filter)
        initColor()

        super.onResume()
    }

    /**
     *  4.onPause()，准备去启动或恢复另一活动时调用，当系统遇到紧急情况需要恢复内存，那么onStop()，onDestory()可能不被执行，
     *  因此你应当在onPause里保存一些至关重要的状态属性，这些属性会被保存到物理内存中。但此方法执行速度一定要快，否则会影响新栈顶活动的使用。
     */
    override fun onPause() {
        if (mNetworkChangeReceiver != null) {
            unregisterReceiver(mNetworkChangeReceiver)
            mNetworkChangeReceiver = null
        }
        super.onPause()
    }

    /**
     * 6.    onDestory()，被销毁前用，之后该Activity进入销毁状态，一般在这里释放内存。
     */
    override fun onDestroy() {
        super.onDestroy()
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
        }

        //CommonUtil.fixInputMethodManagerLeak(this)
        ToastUtil.release()
    }


}

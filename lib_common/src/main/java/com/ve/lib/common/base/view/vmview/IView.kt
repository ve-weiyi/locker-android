package com.ve.lib.common.base.view.vmview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.ve.lib.vutils.ToastUtil

/**
 * @author chenxz
 *
 * JDK1.8之后，在接口里面可以定义default方法，default方法里面是可以具备方法体的，
 * 当子类实现该接口之后，不需要重写该方法即可以调用该方法。
 *
 * @date 2019/11/1
 * @desc IView
 */
interface IView <VB : ViewBinding> {

    /**
     * 返回绑定对象
     * return ActivityMainBinding.inflate(layoutInflater)
     */
    abstract fun attachViewBinding(): VB

    /**
     * 初始化函数，命名与子类BaseVmActivity初始化函数区分。
     */
    abstract fun initialize(saveInstanceState: Bundle?)

    /**
     * 显示加载
     */
    fun showLoading(msg: String){
        ToastUtil.show(msg)
    }

    /**
     * 隐藏加载
     */
    fun hideLoading(){

    }

    /**
     * 显示信息
     */
    fun showMsg(msg: String){
        ToastUtil.show(msg)
    }

    /**
     * 显示错误信息
     */
    fun showError(errorMsg: String) {
        ToastUtil.show(errorMsg)
    }

    fun startActivity(context: Context,activityClass: Class<*>){
        val intent = Intent(context,activityClass)
        context.startActivity(intent)
    }
}
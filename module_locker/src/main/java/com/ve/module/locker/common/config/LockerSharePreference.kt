package com.ve.module.locker.common.config

import com.ve.lib.utils.BaseSharePreference
import com.ve.module.locker.logic.http.model.LoginVO

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
object LockerSharePreference :BaseSharePreference() {

    override fun attachFileName(): String {
        return "locker_sp_file"
    }

    fun getLoginState():Boolean{
        return getValue(LockerConstant.LOGIN_STATE_KEY,false)
    }
    fun getLoginData():LoginVO{

        return getValue(LockerConstant.LOGIN_DATA_KEY,LoginVO())
    }
}
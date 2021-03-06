package com.ve.module.locker.model.http.model

import com.ve.lib.network.http.exception.ApiException

/**
 * @author admin
 * @date 2018/11/21
 * @desc
 */
/**
 * Created by yechaoa on 2020/2/4.
 * Describe :
 */
data class LockerBaseBean<T>(val flag: Boolean,private val code: Int, private val data: T, val message: String) {

    fun code(): Int {
        if (code == 0) {
            return code
        } else {
            throw ApiException(code, message ?: "")
        }
    }

    fun data(): T {
        return data
    }


}
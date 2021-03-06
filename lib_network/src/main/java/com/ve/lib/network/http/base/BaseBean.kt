package com.ve.lib.network.http.base

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
open class BaseBean<T>
    (val errorCode: Int, private val data: T, val errorMsg: String)
{

    fun code(): Int {
        if (errorCode == 0) {
            return errorCode
        } else {
            throw ApiException(errorCode, errorMsg ?: "")
        }
    }

    fun data(): T {
        if (errorCode == 0) {
            return data
        } else {
            throw ApiException(errorCode, errorMsg ?: "")
        }
    }
}
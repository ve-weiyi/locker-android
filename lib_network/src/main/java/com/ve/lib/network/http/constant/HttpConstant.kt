package com.ve.lib.network.http.constant

/**
 * @author chenxz
 * @date 2018/11/21
 * @desc HttpConstant
 */
object HttpConstant {

    const val DEFAULT_TIMEOUT: Long = 10

    const val MAX_CACHE_SIZE: Long = 1024 * 1024 * 50 // 50M 的缓存大小

    const val TOKEN_KEY = "token"
    const val SET_COOKIE_KEY = "set-cookie"
    const val COOKIE_NAME = "Cookie"

}

object HttpErrorCode {
    const val SUCCESS = 0
}
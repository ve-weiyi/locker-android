package com.ve.module.locker.logic.respository



import com.ve.module.locker.base.BaseLockerRepository
import com.ve.module.locker.logic.http.model.LoginVO
import com.ve.module.locker.logic.http.api.LockerApiService
import com.ve.module.locker.logic.http.model.LockerBaseBean

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
object AuthRepository : BaseLockerRepository(){

    private val apiService = LockerApiService().getApiService()

    suspend fun loginLocker(
        username: String?,
        password: String?,
        code: String? = "1234",
    ): LockerBaseBean<LoginVO> {
        return apiService.loginLocker(username, password, code)
    }
}
package com.ve.module.locker.logic.http.respository



import com.ve.lib.common.base.repository.BaseRepository
import com.ve.module.locker.logic.http.model.LoginVO
import com.ve.module.locker.api.LockerApiService
import com.ve.module.locker.logic.http.model.LockerBaseBean

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
object AuthRepository : BaseRepository(){

    private val apiService = LockerApiService().getApiService()

    suspend fun loginLocker(
        username: String?,
        password: String?,
        code: String? = "1234",
    ): LockerBaseBean<LoginVO> {
        return apiService.loginLocker(username, password, code)
    }
}
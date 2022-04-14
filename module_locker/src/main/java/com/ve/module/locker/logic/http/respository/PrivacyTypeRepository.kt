package com.ve.module.locker.logic.http.respository

import com.ve.lib.common.base.repository.BaseRepository
import com.ve.module.locker.api.LockerApiService
import com.ve.module.locker.logic.http.model.*

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
object  PrivacyTypeRepository : BaseRepository(){

    private val apiService = LockerApiService().getApiService()

    suspend fun typeAdd(privacyType: PrivacyType): LockerBaseBean<Any> =
        apiService.typeAdd(privacyType)

    suspend fun typeDelete(privacyTypeId: Int): LockerBaseBean<Any> =
        apiService.typeDelete(privacyTypeId)

    suspend fun typeUpdate(privacyType: PrivacyType): LockerBaseBean<Any> =
        apiService.typeUpdate(privacyType)

    suspend fun typeQuery(id: Int): LockerBaseBean<Any> =
        apiService.typeQuery(id)

    suspend fun typeQueryList(conditionVO: ConditionVO? = null): LockerBaseBean<MutableList<PrivacyType>> {
        if (conditionVO == null) {
            return apiService.typeQueryList(ConditionVO())
        } else {
            return apiService.typeQueryList(conditionVO)
        }
    }


}
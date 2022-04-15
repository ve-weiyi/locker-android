package com.ve.module.locker.logic.respository

import com.ve.module.locker.base.BaseLockerRepository
import com.ve.module.locker.logic.http.model.ConditionVO
import com.ve.module.locker.logic.database.entity.PrivacyTag
import com.ve.module.locker.logic.http.api.LockerApiService
import com.ve.module.locker.logic.http.model.LockerBaseBean

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
object PrivacyTagRepository : BaseLockerRepository() {

    val apiService = LockerApiService().getApiService()

    suspend fun tagAdd(privacyTag: PrivacyTag): LockerBaseBean<Any> =
        apiService.tagAdd(privacyTag)

    suspend fun tagDelete(privacyTagId: Int): LockerBaseBean<Any> =
        apiService.tagDelete(privacyTagId)

    suspend fun tagUpdate(privacyTag: PrivacyTag): LockerBaseBean<Any> =
        apiService.tagUpdate(privacyTag)

    suspend fun tagQuery(id: Int): LockerBaseBean<Any> =
        apiService.tagQuery(id)

    suspend fun tagQueryList(conditionVO: ConditionVO? = null): LockerBaseBean<MutableList<PrivacyTag>> {
        if (conditionVO == null) {
            return apiService.tagQueryList(ConditionVO())
        } else {
            return apiService.tagQueryList(conditionVO)
        }
    }



}
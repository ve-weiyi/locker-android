package com.ve.module.locker.logic.http.respository

import com.ve.lib.common.base.repository.BaseRepository
import com.ve.module.locker.api.LockerApiService
import com.ve.module.locker.logic.http.model.*

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
object  PrivacyFolderRepository : BaseRepository(){

    private val apiService = LockerApiService().getApiService()

    suspend fun folderAdd(privacyFolder: PrivacyFolder): LockerBaseBean<Any> =
        apiService.folderAdd(privacyFolder)

    suspend fun folderDelete(privacyFolderId: Int): LockerBaseBean<Any> =
        apiService.folderDelete(privacyFolderId)

    suspend fun folderUpdate(privacyFolder: PrivacyFolder): LockerBaseBean<Any> =
        apiService.folderUpdate(privacyFolder)

    suspend fun folderQuery(id: Int): LockerBaseBean<Any> =
        apiService.folderQuery(id)

    suspend fun folderQueryList(conditionVO: ConditionVO? = null): LockerBaseBean<MutableList<PrivacyFolder>> {
        if (conditionVO == null) {
            return apiService.folderQueryList(ConditionVO())
        } else {
            return apiService.folderQueryList(conditionVO)
        }
    }

}
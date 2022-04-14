package com.ve.module.locker.ui.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.logic.http.respository.PrivacyFolderRepository
import com.ve.module.locker.logic.http.respository.PrivacyTagRepository
import com.ve.module.locker.logic.http.respository.PrivacyTypeRepository
import com.ve.module.locker.logic.http.model.PrivacyFolder
import com.ve.module.locker.logic.http.model.PrivacyTag
import com.ve.module.locker.logic.http.model.PrivacyType

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyCategoryViewModel : LockerViewModel() {



    /**
     * 网络获取数据，不允许其他途径改变
     */
    private val _tagList = MutableLiveData<MutableList<PrivacyTag>>()

    /**
     * 页面可观察到的数据，只能通过网络改变
     */

    private val privacyTagRepository = PrivacyTagRepository
    val tagList: LiveData<MutableList<PrivacyTag>> = _tagList

    fun tagList() {
        launch(
            block = {
                _tagList.value=privacyTagRepository.tagQueryList().data()
            }
        )
    }

    val tagAddMsg = MutableLiveData<String>()
    fun tagAdd(privacyTag: PrivacyTag) {
        launch(
            block = {
                val result=privacyTagRepository.tagAdd(privacyTag)
                tagAddMsg.value=result.message
            }
        )
    }

    val tagDeleteMsg = MutableLiveData<String>()
    fun tagDelete(privacyTagId: Int) {
        launch(
            block = {
                val result=privacyTagRepository.tagDelete(privacyTagId)
                tagDeleteMsg.value=result.message
            }
        )
    }

    val tagUpdateMsg = MutableLiveData<String>()
    fun tagUpdate(privacyTag: PrivacyTag) {
        launch(
            block = {
                val result=privacyTagRepository.tagUpdate(privacyTag)
                tagUpdateMsg.value=result.message
            }
        )
    }



    /******************************* type *******************************/

    private val privacyTypeRepository = PrivacyTypeRepository

    val typeList: MutableLiveData<MutableList<PrivacyType>> = MutableLiveData<MutableList<PrivacyType>>()
    fun typeList() {
        launch(
            block = {
                val result=privacyTypeRepository.typeQueryList()
                typeList.value=result.data()
            }
        )
    }

    val typeAddMsg = MutableLiveData<String>()
    fun typeAdd(privacyType: PrivacyType) {
        launch(
            block = {
                val result=privacyTypeRepository.typeAdd(privacyType)
                typeAddMsg.value=result.message
            }
        )
    }

    val typeDeleteMsg = MutableLiveData<String>()
    fun typeDelete(privacyTypeId: Int) {
        launch(
            block = {
                val result=privacyTypeRepository.typeDelete(privacyTypeId)
                typeDeleteMsg.value=result.message
            }
        )
    }

    val typeUpdateMsg = MutableLiveData<String>()
    fun typeUpdate(privacyType: PrivacyType) {
        launch(
            block = {
                val result=privacyTypeRepository.typeUpdate(privacyType)
                typeUpdateMsg.value=result.message
            }
        )
    }


    /******************************* folder *******************************/

    private val privacyFolderRepository = PrivacyFolderRepository

    val folderList: MutableLiveData<MutableList<PrivacyFolder>> = MutableLiveData<MutableList<PrivacyFolder>>()
    fun folderList() {
        launch(
            block = {
                val result=privacyFolderRepository.folderQueryList()
                folderList.value=result.data()
            }
        )
    }

    val folderAddMsg = MutableLiveData<String>()
    fun folderAdd(privacyFolder: PrivacyFolder) {
        launch(
            block = {
                val result=privacyFolderRepository.folderAdd(privacyFolder)
                folderAddMsg.value=result.message
            }
        )
    }

    val folderDeleteMsg = MutableLiveData<String>()
    fun folderDelete(privacyFolderId: Int) {
        launch(
            block = {
                val result=privacyFolderRepository.folderDelete(privacyFolderId)
                folderDeleteMsg.value=result.message
            }
        )
    }

    val folderUpdateMsg = MutableLiveData<String>()
    fun folderUpdate(privacyFolder: PrivacyFolder) {
        launch(
            block = {
                val result=privacyFolderRepository.folderUpdate(privacyFolder)
                folderUpdateMsg.value=result.message
            }
        )
    }
}
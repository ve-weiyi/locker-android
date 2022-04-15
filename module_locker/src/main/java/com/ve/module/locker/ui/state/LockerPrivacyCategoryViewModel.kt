package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.logic.respository.PrivacyFolderRepository
import com.ve.module.locker.logic.respository.PrivacyTagRepository
import com.ve.module.locker.logic.database.entity.PrivacyFolder
import com.ve.module.locker.logic.database.entity.PrivacyTag
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyCategoryViewModel : LockerViewModel() {


//    val localTagList= MutableLiveData<MutableList<PrivacyTag>>()
//

    private val privacyTagRepository = PrivacyTagRepository
    val tagList = MutableLiveData<MutableList<PrivacyTag>>()

    fun getTagList() {
        launch(
            block = {
                val result = privacyTagRepository.tagQueryList().data()
                //没有网络被阻塞了
                LitePal.saveAll(result)
                tagList.value = result
            },
            local = {
                tagList.value = LitePal.findAll(PrivacyTag::class.java)
            }
        )
    }

    val tagAddMsg = MutableLiveData<String>()
    fun saveTag(privacyTag: PrivacyTag) {
        launch(
            block = {
                val result = privacyTagRepository.tagAdd(privacyTag)
                tagAddMsg.value = result.message
            },
            local = {
                val result=privacyTag.save()
                if(result){
                    tagAddMsg.value="保存成功！"
                }else{
                    tagAddMsg.value="保存失败！"
                }
            }
        )
    }

    val tagDeleteMsg = MutableLiveData<String>()
    fun tagDelete(privacyTagId: Int) {
        launch(
            block = {
                val result = privacyTagRepository.tagDelete(privacyTagId)
                tagDeleteMsg.value = result.message
            },
            local = {
                val result=LitePal.delete(PrivacyTag::class.java,privacyTagId.toLong())
                if(result>0){
                    tagDeleteMsg.value="删除成功！"+result
                }else{
                    tagDeleteMsg.value="删除失败！"+result
                }
            }
        )
    }

    val tagUpdateMsg = MutableLiveData<String>()
    fun tagUpdate(privacyTag: PrivacyTag) {
        launch(
            block = {
                val result = privacyTagRepository.tagUpdate(privacyTag)
                tagUpdateMsg.value = result.message
            },
            local = {
                val result=privacyTag.update(privacyTag.id.toLong())
                if(result>0){
                    tagUpdateMsg.value="保存成功！"+result
                }else{
                    tagUpdateMsg.value="保存失败！"+result
                }
            }
        )
    }

    /******************************* folder *******************************/

    private val privacyFolderRepository = PrivacyFolderRepository

    val folderList: MutableLiveData<MutableList<PrivacyFolder>> =
        MutableLiveData<MutableList<PrivacyFolder>>()

    fun folderList() {
        launch(
            block = {
                val result = privacyFolderRepository.folderQueryList()
                LitePal.saveAll(result.data())
                folderList.value = result.data()

            },
            local = {
                folderList.value = LitePal.findAll(PrivacyFolder::class.java)
            }
        )
    }

    val folderAddMsg = MutableLiveData<String>()
    fun folderAdd(privacyFolder: PrivacyFolder) {
        launch(
            block = {
                val result = privacyFolderRepository.folderAdd(privacyFolder)
                folderAddMsg.value = result.message
            },
            local = {
                val result=privacyFolder.delete()
                if(result>0){
                    folderAddMsg.value="操作成功！"+result
                }else{
                    folderAddMsg.value="操作失败！"+result
                }
            }
        )
    }

    val folderDeleteMsg = MutableLiveData<String>()
    fun folderDelete(privacyFolderId: Int) {
        launch(
            block = {
                val result = privacyFolderRepository.folderDelete(privacyFolderId)
                folderDeleteMsg.value = result.message
            },
            local = {
                val result=LitePal.delete(PrivacyFolder::class.java,privacyFolderId.toLong())
                if(result>0){
                    folderDeleteMsg.value="操作成功！"+result
                }else{
                    folderDeleteMsg.value="操作失败！"+result
                }
            }
        )
    }

    val folderUpdateMsg = MutableLiveData<String>()
    fun folderUpdate(privacyFolder: PrivacyFolder) {
        launch(
            block = {
                val result = privacyFolderRepository.folderUpdate(privacyFolder)
                folderUpdateMsg.value = result.message
            },
            local = {
                val result=privacyFolder.update(privacyFolder.id.toLong())
                if(result>0){
                    folderUpdateMsg.value="操作成功！"+result
                }else{
                    folderUpdateMsg.value="操作失败！"+result
                }
            }
        )
    }
}
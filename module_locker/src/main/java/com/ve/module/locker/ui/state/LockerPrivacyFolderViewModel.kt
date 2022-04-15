package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData

import com.ve.module.locker.logic.database.entity.PrivacyFolder
import com.ve.module.locker.logic.http.model.PrivacyDetailsCard
import com.ve.module.locker.logic.respository.PrivacyCardRepository
import com.ve.module.locker.logic.http.model.*
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyFolderViewModel : LockerViewModel() {

    val allPrivacyFolderList = MutableLiveData<MutableList<PrivacyFolder>>()

    fun getPrivacyFolderList() {
        launch(
            block = {

            },
            local = {
                allPrivacyFolderList.value = LitePal.findAll(PrivacyFolder::class.java)
            }
        )
    }

    val savePrivacyFolderMsg = MutableLiveData<String>()
    fun savePrivacyFolder(privacyFolder: PrivacyFolder) {
        launch(
            block = {


            },
            local = {
                val result=privacyFolder.save()
                if(result){
                    savePrivacyFolderMsg.value="保存成功！"
                }else{
                    savePrivacyFolderMsg.value="保存失败！"
                }
            }
        )
    }
    val deletePrivacyFolderMsg = MutableLiveData<String>()
    fun deletePrivacyFolder(privacyFolder: PrivacyFolder) {
        launch(
            block = {


            },
            local = {
                val result=privacyFolder.delete()
                if(result>0){
                    savePrivacyFolderMsg.value="删除成功！"+result
                }else{
                    savePrivacyFolderMsg.value="删除失败！"+result
                }
            }
        )
    }

    val updatePrivacyFolderMsg = MutableLiveData<String>()
    fun updatePrivacyFolder(privacyFolder: PrivacyFolder) {
        launch(
            block = {

            },
            local = {
                val result=privacyFolder.update(privacyFolder.id)
                if(result>0){
                    savePrivacyFolderMsg.value="删除成功！"+result
                }else{
                    savePrivacyFolderMsg.value="删除失败！"+result
                }
            }
        )
    }
}
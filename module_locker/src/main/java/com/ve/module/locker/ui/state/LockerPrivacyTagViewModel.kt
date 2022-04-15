package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData

import com.ve.module.locker.logic.database.entity.PrivacyTag
import com.ve.module.locker.logic.http.model.PrivacyDetailsCard
import com.ve.module.locker.logic.respository.PrivacyCardRepository
import com.ve.module.locker.logic.http.model.*
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyTagViewModel : LockerViewModel() {

    val allPrivacyTagList = MutableLiveData<MutableList<PrivacyTag>>()

    fun getPrivacyTagList() {
        launch(
            block = {

            },
            local = {
                allPrivacyTagList.value = LitePal.findAll(PrivacyTag::class.java)
            }
        )
    }

    val savePrivacyTagMsg = MutableLiveData<String>()
    fun savePrivacyTag(privacyTag: PrivacyTag) {
        launch(
            block = {


            },
            local = {
                val result=privacyTag.save()
                if(result){
                    savePrivacyTagMsg.value="保存成功！"
                }else{
                    savePrivacyTagMsg.value="保存失败！"
                }
            }
        )
    }
    val deletePrivacyTagMsg = MutableLiveData<String>()
    fun deletePrivacyTag(privacyTag: PrivacyTag) {
        launch(
            block = {


            },
            local = {
                val result=privacyTag.delete()
                if(result>0){
                    savePrivacyTagMsg.value="删除成功！"+result
                }else{
                    savePrivacyTagMsg.value="删除失败！"+result
                }
            }
        )
    }

    val updatePrivacyTagMsg = MutableLiveData<String>()
    fun updatePrivacyTag(privacyTag: PrivacyTag) {
        launch(
            block = {

            },
            local = {
                val result=privacyTag.update(privacyTag.id)
                if(result>0){
                    savePrivacyTagMsg.value="删除成功！"+result
                }else{
                    savePrivacyTagMsg.value="删除失败！"+result
                }
            }
        )
    }
}
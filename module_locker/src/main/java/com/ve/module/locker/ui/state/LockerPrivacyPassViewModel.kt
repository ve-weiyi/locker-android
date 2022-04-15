package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.logic.database.dao.PrivacyInfoDao
import com.ve.module.locker.logic.database.entity.DetailsPass
import com.ve.module.locker.logic.database.entity.PrivacyInfoPass
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyPassViewModel : LockerViewModel() {

//    val privacyRepository = PrivacyPassRepository

    val allPrivacyInfoList = MutableLiveData<MutableList<PrivacyInfoPass>>()
    val dao=PrivacyInfoDao
    fun getPrivacyInfoList() {
        launch(
            block = {

            },
            local = {
                allPrivacyInfoList.value = LitePal.findAll(PrivacyInfoPass::class.java)
            }
        )
    }

    val savePrivacyInfoMsg = MutableLiveData<String>()
    fun savePrivacyInfo(privacyInfo: PrivacyInfoPass) {
        launch(
            block = {


            },
            local = {
                val result=privacyInfo.save()
                if(result){
                    savePrivacyInfoMsg.value="保存成功！"
                }else{
                    savePrivacyInfoMsg.value="保存失败！"
                }
            }
        )
    }
    val deletePrivacyInfoMsg = MutableLiveData<String>()
    fun deletePrivacyInfo(privacyInfo: PrivacyInfoPass) {
        launch(
            block = {


            },
            local = {
                val result=privacyInfo.delete()
                if(result>0){
                    savePrivacyInfoMsg.value="删除成功！"+result
                }else{
                    savePrivacyInfoMsg.value="删除失败！"+result
                }
            }
        )
    }

    val updatePrivacyInfoMsg = MutableLiveData<String>()
    fun updatePrivacyInfo(privacyInfo: PrivacyInfoPass) {
        launch(
            block = {

            },
            local = {
                val result=privacyInfo.update(privacyInfo.id)
                if(result>0){
                    savePrivacyInfoMsg.value="删除成功！"+result
                }else{
                    savePrivacyInfoMsg.value="删除失败！"+result
                }
            }
        )
    }

    val queryDetailsResult = MutableLiveData<DetailsPass>()
    fun queryPrivacyDetails(id:Long) {
        launch(
            block = {

            },
            local = {
                val result=LitePal.find(DetailsPass::class.java,id)
                queryDetailsResult.value=result
            }
        )
    }
}
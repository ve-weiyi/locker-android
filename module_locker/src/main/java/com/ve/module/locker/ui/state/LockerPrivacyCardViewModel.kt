package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.logic.database.dao.PrivacyInfoDao
import com.ve.module.locker.logic.database.entity.*
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyCardViewModel : LockerViewModel() {

//    val privacyRepository = PrivacyCardRepository

//    fun getPrivacyCardList() {
//        launch(
//            block = {
//
//            },
//            local = {
//                val privacyCardList= mutableListOf<PrivacyCard>()
//                val privacyInfoAndCardList= LitePal.findAll(PrivacyInfoAndCard::class.java)
//                privacyInfoAndCardList.forEach{
//                    it->
//                    val folder=LitePal.find(PrivacyFolder::class.java,it.privacyFolderId)
//                    val tagAndCards=LitePal.where("privacyId=?","${it.privacyDetailsId}").find(TagAndCard::class.java)
//
//
//                }
//            }
//        )
//    }


    val allPrivacyInfoList = MutableLiveData<MutableList<PrivacyCardInfo>>()
    val dao=PrivacyInfoDao
    fun getPrivacyInfoList() {
        launch(
            block = {

            },
            local = {
                allPrivacyInfoList.value = LitePal.findAll(PrivacyCardInfo::class.java)
            }
        )
    }

    val savePrivacyInfoMsg = MutableLiveData<String>()
    fun savePrivacyInfo(privacyInfo: PrivacyCardInfo) {
        launch(
            block = {


            },
            local = {
               // val result=dao.savePrivacyInfo(privacyInfo)
                val result=privacyInfo.save()
                if(result){
                    savePrivacyInfoMsg.value="保存成功！"
                }else{
                    savePrivacyInfoMsg.value="保存失败！"
                }
            }
        )
    }
    val deletePrivacyInfoMsg = MutableLiveData<Int>()
    fun deletePrivacyInfo(privacyInfo: PrivacyCardInfo) {
        launch(
            block = {


            },
            local = {
                val result=privacyInfo.delete()
                deletePrivacyInfoMsg.value=result
            }
        )
    }

    val updatePrivacyInfoMsg = MutableLiveData<String>()
    fun updatePrivacyInfo(privacyInfo: PrivacyCardInfo) {
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


    val addPrivacyInfoMsg = MutableLiveData<String>()
    fun addPrivacyInfo(privacyInfo: PrivacyCardInfo, cardDetails: PrivacyCardDetails, folder: PrivacyFolder?=null, tags: List<PrivacyTag>?=null) {
        launch(
            block = {


            },
            local = {
                privacyInfo.setPrivacyDetails(cardDetails)
                privacyInfo.setPrivacyFolder(folder)
                privacyInfo.setPrivacyTags(tags)
                val result=privacyInfo.save()
                LogUtil.msg(result.toString())
                if(result){
                    addPrivacyInfoMsg.value="保存成功！"
                }else{
                    addPrivacyInfoMsg.value="保存失败！"
                }
            }
        )
    }
}
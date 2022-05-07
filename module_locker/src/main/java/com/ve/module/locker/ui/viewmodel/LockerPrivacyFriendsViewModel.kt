package com.ve.module.locker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ve.lib.vutils.LogUtil
import com.ve.module.locker.model.database.entity.PrivacyFriendsInfo
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyFriendsViewModel : LockerViewModel() {

    val privacyFriendsInfoList = MutableLiveData<MutableList<PrivacyFriendsInfo>>()
    fun getPrivacyFriendsList() {
        launch(
            block = {

            },
            local = {
                privacyFriendsInfoList.value =
                    LitePal.findAll(PrivacyFriendsInfo::class.java)
            }
        )
    }

    val reslutSaveOrUpdate = MutableLiveData<Boolean>()
    fun saveOrUpdatePrivacyFriends(privacyFriends: PrivacyFriendsInfo) {
        launch(
            block = {


            },
            local = {
                val result = privacyFriends.saveOrUpdate("id= ?", privacyFriends.id.toString())
                reslutSaveOrUpdate.value = result
            }
        )
    }

    val deletePrivacyFriendsResult = MutableLiveData<Int>()
    fun deletePrivacyFriends(privacyInfo: PrivacyFriendsInfo) {
        launch(
            block = {


            },
            local = {
                val result = privacyInfo.delete()
                deletePrivacyFriendsResult.value = result
            }
        )
    }

}
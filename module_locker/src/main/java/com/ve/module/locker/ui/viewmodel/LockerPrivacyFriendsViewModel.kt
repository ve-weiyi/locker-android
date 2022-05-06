package com.ve.module.locker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.model.database.entity.PrivacyFriendsInfo
import com.ve.module.locker.model.http.model.ConditionVO
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


    fun getPrivacyFriendsList(condition: ConditionVO) {
        launch(
            block = {

            },
            local = {

            }
        )
    }
}
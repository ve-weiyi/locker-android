package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.logic.http.respository.PrivacyPassRepository
import com.ve.module.locker.logic.http.model.*

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyPassViewModel : LockerViewModel() {

    val privacyRepository= PrivacyPassRepository

    val allPrivacyInfoList = MutableLiveData<MutableList<PrivacyDetailsPass>>()

    val userPrivacyInfoList = MutableLiveData<MutableList<UserPrivacyInfoPassVO>>()

    fun privacyInfoList() {
        launch(
            block = {
               allPrivacyInfoList.value=privacyRepository.privacyInfoList().data()
            }
        )
    }

    fun privacyInfoAdd(userPrivacyInfoVO: UserPrivacyInfoPassVO) {
        launch(
            block = {
                privacyRepository.privacyInfoAdd(userPrivacyInfoVO).data()
            }
        )
    }

    fun privacyInfoDelete(privacyInfoId: Int) {
        launch(
            block = {
                privacyRepository.privacyInfoDelete(privacyInfoId).data()
            }
        )
    }

    fun privacyInfoUpdate(userPrivacyInfoVO: UserPrivacyInfoPassVO) {
        launch(
            block = {
                privacyRepository.privacyInfoUpdate(userPrivacyInfoVO).data()
            }
        )
    }

    fun privacyInfoUser() {
        launch(
            block = {
                userPrivacyInfoList.value=privacyRepository.privacyInfoUser().data()
            }
        )
    }

    fun privacyInfoParsing(userPrivacyInfoVO: UserPrivacyInfoPassVO) {
        launch(
            block = {
                privacyRepository.privacyInfoParsing(userPrivacyInfoVO).data()
            }
        )
    }
}
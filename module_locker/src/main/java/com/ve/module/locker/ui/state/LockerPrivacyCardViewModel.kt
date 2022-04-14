package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.logic.http.respository.PrivacyCardRepository
import com.ve.module.locker.logic.http.model.*

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyCardViewModel : LockerViewModel() {

    val privacyRepository= PrivacyCardRepository

    val allPrivacyInfoList = MutableLiveData<MutableList<PrivacyDetailsCard>>()

    val userPrivacyInfoList = MutableLiveData<MutableList<UserPrivacyInfoCardResponse>>()

    fun privacyInfoList() {
        launch(
            block = {
                allPrivacyInfoList.value=privacyRepository.privacyInfoList().data()
            }
        )
    }

    fun privacyInfoAdd(userPrivacyInfoVO: UserPrivacyInfoCardResponse) {
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

    fun privacyInfoUpdate(userPrivacyInfoVO: UserPrivacyInfoCardResponse) {
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

    fun privacyInfoParsing(userPrivacyInfoVO: UserPrivacyInfoCardResponse) {
        launch(
            block = {
                privacyRepository.privacyInfoParsing(userPrivacyInfoVO).data()
            }
        )
    }
}
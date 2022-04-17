package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.logic.database.vo.PrivacyCard
import com.ve.module.locker.logic.respository.PrivacyCardRepository

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyInfoViewModel : LockerViewModel() {

    val privacyRepository = PrivacyCardRepository

    val addPrivacyInfoResult = MutableLiveData<Boolean>()

    fun addPrivacyInfo(privacyCard: PrivacyCard) {
        launch(
            block = {

            },
            local = {
                addPrivacyInfoResult.value=privacyCard.save()
            }
        )
    }
}
package com.ve.module.locker.ui.state

import androidx.lifecycle.MutableLiveData
import com.ve.module.locker.logic.database.entity.PrivacyInfoCard
import com.ve.module.locker.logic.respository.PrivacyCardRepository
import org.litepal.LitePal

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class LockerPrivacyInfoViewModel : LockerViewModel() {

    val privacyRepository = PrivacyCardRepository

    val allPrivacyInfoList = MutableLiveData<MutableList<PrivacyInfoCard>>()

    fun getPrivacyInfoList() {
        launch(
            block = {

            },
            local = {
                allPrivacyInfoList.value=LitePal.findAll(PrivacyInfoCard::class.java)
            }
        )
    }
}
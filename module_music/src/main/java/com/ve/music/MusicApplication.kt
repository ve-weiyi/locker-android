package com.ve.music

import com.ve.lib.application.BaseApplication
import com.ve.lib.application.impl.ApplicationImpl
import com.ve.lib.vutils.LogUtil
import com.ve.lib_audio.app.AudioHelper
import com.ve.music.service.MusicService

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/6
 */
class MusicApplication: ApplicationImpl {
    override fun onCreate(application: BaseApplication) {
        // 各个模块特有的第三方库等的初始化逻辑
        LogUtil.d("MusicApplication init ")
        AudioHelper.init(application)
        MusicService.startMusicService()
    }
}
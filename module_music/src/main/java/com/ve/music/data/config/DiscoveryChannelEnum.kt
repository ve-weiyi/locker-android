package com.ve.music.data.config

/**
 * @author weiyi
 */
enum class DiscoveryChannelEnum(val key: String, val value: Int) {
    MY("我的", 0x01), DISCORY("发现", 0x02), YUNCUN("云村", 0x03), VIDEO("视频", 0x04);

    companion object {
        //所有类型标识
        const val MINE_ID = 0x01
        const val DISCORY_ID = 0x02
        const val YUNCUN_ID = 0x03
        const val VIDEO_ID = 0x04
    }
}
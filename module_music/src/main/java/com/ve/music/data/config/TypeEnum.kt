package com.ve.music.data.config

import java.lang.IllegalArgumentException

/**
 * @author weiyi
 */
enum class TypeEnum(val key: String, val value: Int) {
    SONG("歌曲", 0x00), MV("MV", 0x01), PLAYLIST("歌单", 0x02), ALBUM("专辑", 0x03), RADIO("电台",
        0x04),
    VIDEO("视频", 0x05), EVENT("动态", 0x06);

    companion object {
        //所有类型标识
        const val SONG_ID = 0x00
        const val MV_ID = 0x01
        const val PLAYLIST_ID = 0x02
        const val ALBUM_ID = 0x03
        const val RADIO_ID = 0x04
        const val VIDEO_ID = 0x05
        const val EVENT_ID = 0x06
        fun getTypeByID(id: Int): TypeEnum {
            when (id) {
                PLAYLIST_ID -> return PLAYLIST
                MV_ID -> return MV
                ALBUM_ID -> return ALBUM
                RADIO_ID -> return RADIO
                VIDEO_ID -> return VIDEO
                EVENT_ID -> return EVENT
                SONG_ID -> return SONG
                else -> {}
            }
            throw IllegalArgumentException("cannot find type")
        }
    }
}
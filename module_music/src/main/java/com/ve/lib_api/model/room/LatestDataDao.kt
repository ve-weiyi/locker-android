package com.ve.lib_api.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ve.lib_api.model.song.LatestAudioBean

@Dao
interface LatestDataDao {
    /**
     * 存储并且获取最近播放的歌曲、视频、专辑、歌单、电台
     */
    //获取最近播放的歌曲
    @Query("SELECT * FROM LatestAudioBean")
    fun getRecentAduio(): MutableList<LatestAudioBean?>?

    //查询最近播放的歌曲的数量
    @Query("SELECT COUNT(*) FROM LatestAudioBean")
    fun getRecentSongSize(): LiveData<Int?>?

    //插入最近播放的一首歌曲
    @Insert
    fun insertRecentSong(vararg song: LatestAudioBean?)

    @Query("SELECT * FROM LatestAudioBean WHERE song_id = :id")
    fun getAudioBeanById(id: String?): LatestAudioBean?

    //清空最近播放的音乐存储
    @Query("DELETE FROM LatestAudioBean")
    fun deleteAllRecentSong()
}
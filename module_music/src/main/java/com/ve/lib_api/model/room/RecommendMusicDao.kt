package com.ve.lib_api.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ve.lib_api.model.song.DailyRecommendSongsBean

@Dao
interface RecommendMusicDao {
    //获取日推列表
    @Query("SELECT * FROM DailyRecommendSongsBean")
    fun getDailyRecommendMusic(): List<DailyRecommendSongsBean?>?

    //存储日推列表
    @Insert
    fun insertRecentSong(vararg song: DailyRecommendSongsBean?)

    //清空最近播放的音乐存储
    @Query("DELETE FROM DailyRecommendSongsBean")
    fun clearDailyRecommendSong()
}
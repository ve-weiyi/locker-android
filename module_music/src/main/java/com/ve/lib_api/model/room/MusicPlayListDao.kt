package com.ve.lib_api.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ve.lib_api.model.song.AudioBean

@Dao
interface MusicPlayListDao {
    //音乐播放列表
    //音乐播放列表
    //获取最近播放的歌曲
    @Query("SELECT * FROM AudioBean")
    fun getMusicPlayList(): MutableList<AudioBean?>?

    //插入音乐播放列表的歌曲
    @Insert
    fun insertMusicPlayList(vararg song: AudioBean?)

    @Query("DELETE FROM AudioBean")
    fun clearMusicPlayList()

    @Delete
    fun deleteMusicFromPlayList(music: AudioBean?)
}
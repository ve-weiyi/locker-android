package com.ve.lib_api.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ve.lib_api.model.song.AudioBean
import com.ve.lib_api.model.song.DailyRecommendSongsBean
import com.ve.lib_api.model.song.LatestAudioBean

@Database(entities = [AudioBean::class, LatestAudioBean::class, DailyRecommendSongsBean::class],
    version = 1,
    exportSchema = false)
@TypeConverters(
    Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val latestSongDao: LatestDataDao?
    abstract val musicPlayListDao: MusicPlayListDao?
    abstract val dailyRecommendDao: RecommendMusicDao?

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cloud_music_data.db") //允许在主线程访问数据库
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}
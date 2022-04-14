package com.ve.lib_api.model.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.ve.lib_api.model.song.DailyRecommendSongsBean

object Converters {
    @TypeConverter
    fun fromAlBean(value: String?): DailyRecommendSongsBean.AlBean {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.serializeNulls()
        val gson: Gson = gsonBuilder.create()
        return gson.fromJson(value, DailyRecommendSongsBean.AlBean::class.java)
    }

    @TypeConverter
    fun albeanToString(albean: DailyRecommendSongsBean.AlBean?): String {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.serializeNulls()
        val gson: Gson = gsonBuilder.create()
        return gson.toJson(albean)
    }

    @TypeConverter
    fun fromAlBean1(value: String?): List<DailyRecommendSongsBean.ArBean> {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.serializeNulls()
        val gson: Gson = gsonBuilder.create()
        return gson.fromJson<List<DailyRecommendSongsBean.ArBean>>(value,
            object : TypeToken<List<DailyRecommendSongsBean.ArBean?>?>() {}.getType())
    }

    @TypeConverter
    fun albean1ToString(albean: List<DailyRecommendSongsBean.ArBean?>?): String {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.serializeNulls()
        val gson: Gson = gsonBuilder.create()
        return gson.toJson(albean)
    }
}
package com.ve.lib_api.model.info

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

class AlbumInfo : Parcelable {
    @JvmField
    //专辑名称
    var album_name: String? = null
    @JvmField
    //专辑在数据库中的id
    var album_id = -1
    @JvmField
    //专辑的歌曲数目
    var number_of_songs = 0
    @JvmField
    //专辑封面图片路径
    var album_art: String? = null
    @JvmField
    var album_artist: String? = null
    @JvmField
    var album_sort: String? = null
    override fun describeContents(): Int {
        return 0
    }

    //写数据保存数据
    override fun writeToParcel(dest: Parcel, flags: Int) {
        val bundle = Bundle()
        bundle.putString(KEY_ALBUM_NAME, album_name)
        bundle.putString(KEY_ALBUM_ART, album_art)
        bundle.putInt(KEY_NUMBER_OF_SONGS, number_of_songs)
        bundle.putInt(KEY_ALBUM_ID, album_id)
        bundle.putString(KEY_ALBUM_ARTIST, album_artist)
        bundle.putString(KEY_ALBUM_SORT, album_sort)
        dest.writeBundle(bundle)
    }

    companion object {
        const val KEY_ALBUM_NAME = "album_name"
        const val KEY_ALBUM_ID = "album_id"
        const val KEY_NUMBER_OF_SONGS = "number_of_songs"
        const val KEY_ALBUM_ART = "album_art"
        const val KEY_ALBUM_ARTIST = "album_artist"
        const val KEY_ALBUM_SORT = "album_sort"
        @JvmField
        val CREATOR: Parcelable.Creator<AlbumInfo?> = object : Parcelable.Creator<AlbumInfo?> {
            //读数据恢复数据
            override fun createFromParcel(source: Parcel): AlbumInfo? {
                val info = AlbumInfo()
                val bundle = source.readBundle()
                info.album_name = bundle!!.getString(KEY_ALBUM_NAME)
                info.album_art = bundle.getString(KEY_ALBUM_ART)
                info.number_of_songs = bundle.getInt(KEY_NUMBER_OF_SONGS)
                info.album_id = bundle.getInt(KEY_ALBUM_ID)
                info.album_artist = bundle.getString(KEY_ALBUM_ARTIST)
                info.album_sort = bundle.getString(KEY_ALBUM_SORT)
                return info
            }

            override fun newArray(size: Int): Array<AlbumInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}
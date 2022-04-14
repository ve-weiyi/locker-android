package com.ve.lib_api.model.info

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

class MusicInfo : Parcelable {
    /**
     * 数据库中的_id
     */
    @JvmField
    public var songId: Long = -1
    @JvmField
    public var albumId = -1
    @JvmField
    public var albumName: String? = null
    @JvmField
    public var albumData: String? = null
    @JvmField
    var duration = 0
    @JvmField
    var musicName: String? = null
    @JvmField
    var artist: String? = null
    @JvmField
    var artistId: Long = 0
    @JvmField
    var data: String? = null
    @JvmField
    var folder: String? = null
    @JvmField
    var lrc: String? = null
    @JvmField
    var islocal = false
    @JvmField
    var sort: String? = null
    @JvmField
    var size = 0

    /**
     * 0表示没有收藏 1表示收藏
     */
    var favorite = 0
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        val bundle = Bundle()
        bundle.putLong(KEY_SONG_ID, songId)
        bundle.putInt(KEY_ALBUM_ID, albumId)
        bundle.putString(KEY_ALBUM_NAME, albumName)
        bundle.putString(KEY_ALBUM_DATA, albumData)
        bundle.putInt(KEY_DURATION, duration)
        bundle.putString(KEY_MUSIC_NAME, musicName)
        bundle.putString(KEY_ARTIST, artist)
        bundle.putLong(KEY_ARTIST_ID, artistId)
        bundle.putString(KEY_DATA, data)
        bundle.putString(KEY_FOLDER, folder)
        bundle.putInt(KEY_SIZE, size)
        bundle.putString(KEY_LRC, lrc)
        bundle.putBoolean(KEY_ISLOCAL, islocal)
        bundle.putString(KEY_SORT, sort)
        dest.writeBundle(bundle)
    }

    companion object {
        const val KEY_SONG_ID = "songid"
        const val KEY_ALBUM_ID = "albumid"
        const val KEY_ALBUM_NAME = "albumname"
        const val KEY_ALBUM_DATA = "albumdata"
        const val KEY_DURATION = "duration"
        const val KEY_MUSIC_NAME = "musicname"
        const val KEY_ARTIST = "artist"
        const val KEY_ARTIST_ID = "artist_id"
        const val KEY_DATA = "data"
        const val KEY_FOLDER = "folder"
        const val KEY_SIZE = "size"
        const val KEY_FAVORITE = "favorite"
        const val KEY_LRC = "lrc"
        const val KEY_ISLOCAL = "islocal"
        const val KEY_SORT = "sort"
        @JvmField
        val CREATOR: Parcelable.Creator<MusicInfo?> = object : Parcelable.Creator<MusicInfo?> {
            override fun createFromParcel(source: Parcel): MusicInfo? {
                val music = MusicInfo()
                var bundle: Bundle? = Bundle()
                bundle = source.readBundle()
                music.songId = bundle!!.getLong(KEY_SONG_ID)
                music.albumId = bundle.getInt(KEY_ALBUM_ID)
                music.albumName = bundle.getString(KEY_ALBUM_NAME)
                music.duration = bundle.getInt(KEY_DURATION)
                music.musicName = bundle.getString(KEY_MUSIC_NAME)
                music.artist = bundle.getString(KEY_ARTIST)
                music.artistId = bundle.getLong(KEY_ARTIST_ID)
                music.data = bundle.getString(KEY_DATA)
                music.folder = bundle.getString(KEY_FOLDER)
                music.albumData = bundle.getString(KEY_ALBUM_DATA)
                music.size = bundle.getInt(KEY_SIZE)
                music.lrc = bundle.getString(KEY_LRC)
                music.islocal = bundle.getBoolean(KEY_ISLOCAL)
                music.sort = bundle.getString(KEY_SORT)
                return music
            }

            override fun newArray(size: Int): Array<MusicInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}
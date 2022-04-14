package com.ve.lib_api.model.info

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

class ArtistInfo : Parcelable {
    @JvmField
    var artist_name: String? = null
    @JvmField
    var number_of_tracks = 0
    @JvmField
    var artist_id: Long = 0
    @JvmField
    var artist_sort: String? = null
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        val bundle = Bundle()
        bundle.putString(KEY_ARTIST_NAME, artist_name)
        bundle.putInt(KEY_NUMBER_OF_TRACKS, number_of_tracks)
        bundle.putLong(KEY_ARTIST_ID, artist_id)
        bundle.putString(KEY_ARTIST_SORT, artist_sort)
        dest.writeBundle(bundle)
    }

    companion object {
        const val KEY_ARTIST_NAME = "artist_name"
        const val KEY_NUMBER_OF_TRACKS = "number_of_tracks"
        const val KEY_ARTIST_ID = "artist_id"
        const val KEY_ARTIST_SORT = "artist_sort"
        @JvmField
        val CREATOR: Parcelable.Creator<ArtistInfo?> = object : Parcelable.Creator<ArtistInfo?> {
            override fun createFromParcel(source: Parcel): ArtistInfo? {
                val bundle = source.readBundle()
                val info = ArtistInfo()
                info.artist_name = bundle!!.getString(KEY_ARTIST_NAME)
                info.number_of_tracks = bundle.getInt(KEY_NUMBER_OF_TRACKS)
                info.artist_id = bundle.getLong(KEY_ARTIST_ID)
                info.artist_sort = bundle.getString(KEY_ARTIST_SORT)
                return info
            }

            override fun newArray(size: Int): Array<ArtistInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}
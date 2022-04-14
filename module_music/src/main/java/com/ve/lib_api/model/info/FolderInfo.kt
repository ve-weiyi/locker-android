package com.ve.lib_api.model.info

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

class FolderInfo : Parcelable {
    @JvmField
    var folder_name: String? = null
    @JvmField
    var folder_path: String? = null
    @JvmField
    var folder_sort: String? = null
    @JvmField
    var folder_count = 0
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        val bundle = Bundle()
        bundle.putString(KEY_FOLDER_NAME, folder_name)
        bundle.putString(KEY_FOLDER_PATH, folder_path)
        bundle.putString(KEY_FOLDER_SORT, folder_sort)
        bundle.putInt(KEY_FOLDER_FILE_COUNT, folder_count)
        dest.writeBundle(bundle)
    }

    companion object {
        var KEY_FOLDER_NAME = "folder_name"
        var KEY_FOLDER_PATH = "folder_path"
        const val KEY_FOLDER_SORT = "folder_sort"
        const val KEY_FOLDER_FILE_COUNT = "file_count"

        // 用来创建自定义的Parcelable的对象
        @JvmField
        var CREATOR: Parcelable.Creator<FolderInfo?> = object : Parcelable.Creator<FolderInfo?> {
            override fun createFromParcel(source: Parcel): FolderInfo? {
                val info = FolderInfo()
                val bundle = source.readBundle()
                info.folder_name = bundle!!.getString(KEY_FOLDER_NAME)
                info.folder_path = bundle.getString(KEY_FOLDER_PATH)
                info.folder_sort = bundle.getString(KEY_FOLDER_SORT)
                info.folder_count = bundle.getInt(KEY_FOLDER_FILE_COUNT)
                return info
            }

            override fun newArray(size: Int): Array<FolderInfo?> {
                return arrayOfNulls(size)
            }
        }
    }
}
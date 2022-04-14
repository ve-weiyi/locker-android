package com.ve.lib_api.model.album

class AlbumOrSongBean(
    private var id: String,
    var type: Int,
    var picUrl: String,
    var topText: String,
    var bottomText: String
) {
    fun getId(): Long {
        return id.toLong()
    }

    fun setId(id: String) {
        this.id = id
    }
}
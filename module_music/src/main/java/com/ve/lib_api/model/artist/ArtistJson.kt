package com.ve.lib_api.model.artist

class ArtistJson {
    /**
     * "id": 30796254,
     * "name": "勃勃",
     * "picUrl": "http://p2.music.126.net/Pgoqw9ex_mZEObuWBmddqA==/109951163682857566.jpg",
     * "alias": [],
     * "albumSize": 1,
     * "picId": 109951163682857566,
     * "img1v1Url": "http://p2.music.126.net/AITCmhyiNQXNeHyYMB6OZg==/109951163682852742.jpg",
     * "accountId": 263104397,
     * "img1v1": 109951163682852742,
     * "mvSize": 0,
     * "followed": false,
     * "trans": null
     */
    var result: ArtistDtoInfo? = null
    var code: String? = null

    inner class ArtistDtoInfo {
        var artistCount: String? = null
        var artists: Array<info>?=null
    }

    class info {
        var id: Long = 0
        var name: String? = null
        var picUrl: String? = null
        var alias: Any? = null
        var picId: Long = 0
        var img1v1Url: String? = null
        var accountId: String? = null
        var img1v1: Long = 0
        var isFollowed = false
        var trans: Any? = null
    }
}
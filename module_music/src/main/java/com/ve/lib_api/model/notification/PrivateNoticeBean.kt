package com.ve.lib_api.model.notification

class PrivateNoticeBean {
    var code = 0
    var isMore = false
    var notices: ArrayList<Notice>? = null

    /**
     * "queued": false,
     * "id": 49595824594,
     * "userId": 123170560,
     * "time": 1589466289377,
     * "notice": "{\"playlist\":{\"name\":\"张张________喜欢的音乐\",\"id\":153503871,\"adType\":0,\"adjustedPlayCount\":427.0,\"validCloudTrackCount\":0,\"anonimous\":false,\"trackNumberUpdateTime\":1588243604470,\"validTrackCount\":20,\"description\":null,\"tags\":[],\"playCount\":159,\"trackUpdateTime\":1589370429380,\"specialType\":5,\"coverImgId\":109951164268555963,\"trackCount\":20,\"bookedCount\":0,\"privacy\":0,\"status\":0,\"userId\":123170560,\"createTime\":1452661838402,\"updateTime\":1588243604470,\"auditRejected\":false,\"approved\":false,\"recommended\":false,\"auditStatus\":0,\"auditTime\":1477055977051,\"copied\":false,\"highQuality\":0,\"coverStatus\":1,\"defaultCover\":false,\"createEventId\":0},\"type\":2,\"user\":{\"description\":\"\",\"avatarImgIdStr\":\"109951164899669891\",\"backgroundImgIdStr\":\"109951162868128395\",\"backgroundImgId\":109951162868128395,\"birthday\":633974400000,\"accountStatus\":0,\"city\":1002800,\"detailDescription\":\"\",\"defaultAvatar\":false,\"djStatus\":0,\"followed\":false,\"backgroundUrl\":\"https://p2.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg\",\"nickname\":\"s03z00joq\",\"userId\":3292887580,\"province\":1000000,\"avatarUrl\":\"https://p2.music.126.net/PwlpwKvVy5nKdP7cNDJ3CQ==/109951164899669891.jpg\",\"authStatus\":0,\"expertTags\":null,\"userType\":0,\"remarkName\":null,\"vipType\":0,\"experts\":null,\"gender\":2,\"mutual\":false,\"avatarImgId\":109951164899669891,\"signature\":\"       如果能好好在一起，大起大落，些许困难也没关系。可有些人和事再也回不去。\",\"authority\":0}}",
     * "pushMsg": null,
     * "type": 0
     */
    class Notice {
        var isQueued = false
        var id: String? = null
        var userId: String? = null
        var time: Long = 0

        //再次解析为json
        var notice: String? = null
        var pushMsg: Any? = null
        var type = 0
    }
}
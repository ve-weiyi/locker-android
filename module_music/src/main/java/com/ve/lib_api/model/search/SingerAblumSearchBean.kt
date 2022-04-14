package com.ve.lib_api.model.search

/**
 * 歌手专辑的bean
 */
class SingerAblumSearchBean {
    /**
     * artist : {"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":88,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"}
     * hotAlbums : [{"songs":[],"paid":false,"onSale":false,"mark":0,"tags":"","status":0,"artists":[{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"followed":false,"musicSize":0,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":0,"name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}],"alias":[],"company":"(P)King Record Co., Ltd.","copyrightId":756010,"picUrl":"https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg","blurPicUrl":"https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg","companyId":0,"commentThreadId":"R_AL_3_79880626","publishTime":1563292800000,"briefDesc":"","pic":109951164158415710,"subType":"录音室版","description":"","picId":109951164158415710,"artist":{"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":84,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"},"name":"METANOIA","id":79880626,"type":"EP/Single","size":3,"picId_str":"109951164158415714"},{"songs":[],"paid":false,"onSale":false,"mark":0,"tags":"","status":0,"artists":[{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"followed":false,"musicSize":0,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":0,"name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}],"alias":[],"company":"(P)King Record Co., Ltd.","copyrightId":756010,"picUrl":"https://p1.music.126.net/ankcIREsX8yMplseQ02Qyg==/109951163811942476.jpg","blurPicUrl":"https://p1.music.126.net/ankcIREsX8yMplseQ02Qyg==/109951163811942476.jpg","companyId":0,"commentThreadId":"R_AL_3_75292586","publishTime":1548172800000,"briefDesc":"","pic":109951163811942480,"subType":"录音室版","description":"","picId":109951163811942480,"artist":{"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":84,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"},"name":"REBELLION","id":75292586,"type":"EP/Single","size":1,"picId_str":"109951163811942476"}]
     * more : true
     * code : 200
     */
    var artist: ArtistBean? = null
    var isMore = false
    var code = 0
    var hotAlbums: List<HotAlbumsBean>? = null

    class ArtistBean {
        /**
         * img1v1Id : 18686200114669624
         * topicPerson : 0
         * alias : ["Mizuki Nana"]
         * trans : 水树奈奈
         * picUrl : https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg
         * albumSize : 88
         * followed : false
         * musicSize : 739
         * briefDesc :
         * img1v1Url : https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
         * picId : 109951164158280930
         * name : 水樹奈々
         * id : 17028
         * picId_str : 109951164158280936
         * transNames : ["水树奈奈"]
         * img1v1Id_str : 18686200114669622
         */
        var img1v1Id: Long = 0
        var topicPerson: Long = 0
        var trans: String? = null
        var picUrl: String? = null
        var albumSize = 0
        var isFollowed = false
        var musicSize = 0
        var briefDesc: String? = null
        var img1v1Url: String? = null
        var picId: Long = 0
        var name: String? = null
        var id: Long = 0
        var picId_str: String? = null
        var img1v1Id_str: String? = null
        var alias: List<String>? = null
        var transNames: List<String>? = null
    }

    class HotAlbumsBean {
        /**
         * songs : []
         * paid : false
         * onSale : false
         * mark : 0
         * tags :
         * status : 0
         * artists : [{"img1v1Id":18686200114669624,"topicPerson":0,"alias":[],"trans":"","picUrl":"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"followed":false,"musicSize":0,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":0,"name":"水樹奈々","id":17028,"img1v1Id_str":"18686200114669622"}]
         * alias : []
         * company : (P)King Record Co., Ltd.
         * copyrightId : 756010
         * picUrl : https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg
         * blurPicUrl : https://p1.music.126.net/qcBgobhvSn6cKAA78JplxQ==/109951164158415714.jpg
         * companyId : 0
         * commentThreadId : R_AL_3_79880626
         * publishTime : 1563292800000
         * briefDesc :
         * pic : 109951164158415710
         * subType : 录音室版
         * description :
         * picId : 109951164158415710
         * artist : {"img1v1Id":18686200114669624,"topicPerson":0,"alias":["Mizuki Nana"],"trans":"水树奈奈","picUrl":"https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg","albumSize":84,"followed":false,"musicSize":739,"briefDesc":"","img1v1Url":"https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","picId":109951164158280930,"name":"水樹奈々","id":17028,"picId_str":"109951164158280936","transNames":["水树奈奈"],"img1v1Id_str":"18686200114669622"}
         * name : METANOIA
         * id : 79880626
         * type : EP/Single
         * size : 3
         * picId_str : 109951164158415714
         */
        var isPaid = false
        var isOnSale = false
        var mark = 0
        var tags: String? = null
        var status = 0
        var company: String? = null
        var copyrightId = 0
        var picUrl: String? = null
        var blurPicUrl: String? = null
        var companyId = 0
        var commentThreadId: String? = null
        var publishTime: Long = 0
        var briefDesc: String? = null
        var pic: Long = 0
        var subType: String? = null
        var description: String? = null
        var picId: Long = 0
        var artist: ArtistBeanX? = null
        var name: String? = null
        var id = 0
        var type: String? = null
        var size = 0
        var picId_str: String? = null
        var songs: List<*>? = null
        var artists: List<ArtistsBean>? = null
        var alias: List<*>? = null

        class ArtistBeanX {
            /**
             * img1v1Id : 18686200114669624
             * topicPerson : 0
             * alias : ["Mizuki Nana"]
             * trans : 水树奈奈
             * picUrl : https://p1.music.126.net/00jICa1MThsPSrcCGzpmEw==/109951164158280936.jpg
             * albumSize : 84
             * followed : false
             * musicSize : 739
             * briefDesc :
             * img1v1Url : https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * picId : 109951164158280930
             * name : 水樹奈々
             * id : 17028
             * picId_str : 109951164158280936
             * transNames : ["水树奈奈"]
             * img1v1Id_str : 18686200114669622
             */
            var img1v1Id: Long = 0
            var topicPerson = 0
            var trans: String? = null
            var picUrl: String? = null
            var albumSize = 0
            var isFollowed = false
            var musicSize = 0
            var briefDesc: String? = null
            var img1v1Url: String? = null
            var picId: Long = 0
            var name: String? = null
            var id = 0
            var picId_str: String? = null
            var img1v1Id_str: String? = null
            var alias: List<String>? = null
            var transNames: List<String>? = null
        }

        class ArtistsBean {
            /**
             * img1v1Id : 18686200114669624
             * topicPerson : 0
             * alias : []
             * trans :
             * picUrl : https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * albumSize : 0
             * followed : false
             * musicSize : 0
             * briefDesc :
             * img1v1Url : https://p1.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * picId : 0
             * name : 水樹奈々
             * id : 17028
             * img1v1Id_str : 18686200114669622
             */
            var img1v1Id: Long = 0
            var topicPerson = 0
            var trans: String? = null
            var picUrl: String? = null
            var albumSize = 0
            var isFollowed = false
            var musicSize = 0
            var briefDesc: String? = null
            var img1v1Url: String? = null
            var picId = 0
            var name: String? = null
            var id = 0
            var img1v1Id_str: String? = null
            var alias: List<*>? = null
        }
    }
}
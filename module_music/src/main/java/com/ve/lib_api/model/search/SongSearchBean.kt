package com.ve.lib_api.model.search

/**
 * 通过API获取的搜索歌曲结果类
 */
class SongSearchBean {
    /**
     * result : {"songs":[{"id":27917548,"name":"JoJo","artists":[{"id":48514,"name":"Boz Scaggs","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2694934,"name":"The Essential Boz Scaggs","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1383004800000,"size":32,"copyrightId":7001,"status":0,"picId":17829680556434244,"mark":0},"duration":354746,"copyrightId":7001,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":0},{"id":34072632,"name":"Save My Soul","artists":[{"id":60943,"name":"JoJo","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":3270985,"name":"III.","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1440086400007,"size":3,"copyrightId":0,"status":3,"picId":7974757838028840,"mark":0},"duration":224908,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":5269161,"fee":8,"rUrl":null,"mark":0}],"songCount":600}
     * code : 200
     */
    var result: ResultBean? = null
    var code = 0

    class ResultBean {
        /**
         * songs : [{"id":27917548,"name":"JoJo","artists":[{"id":48514,"name":"Boz Scaggs","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2694934,"name":"The Essential Boz Scaggs","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1383004800000,"size":32,"copyrightId":7001,"status":0,"picId":17829680556434244,"mark":0},"duration":354746,"copyrightId":7001,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":0,"fee":8,"rUrl":null,"mark":0},{"id":34072632,"name":"Save My Soul","artists":[{"id":60943,"name":"JoJo","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":3270985,"name":"III.","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1440086400007,"size":3,"copyrightId":0,"status":3,"picId":7974757838028840,"mark":0},"duration":224908,"copyrightId":7002,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":5269161,"fee":8,"rUrl":null,"mark":0}]
         * songCount : 600
         */
        var songCount = 0
        var songs: List<SongsBean>? = null
        private val data: List<SongsBean>? = null

        class SongsBean {
            /**
             * id : 27917548
             * name : JoJo
             * artists : [{"id":48514,"name":"Boz Scaggs","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}]
             * album : {"id":2694934,"name":"The Essential Boz Scaggs","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1383004800000,"size":32,"copyrightId":7001,"status":0,"picId":17829680556434244,"mark":0}
             * duration : 354746
             * copyrightId : 7001
             * status : 0
             * alias : []
             * rtype : 0
             * ftype : 0
             * mvid : 0
             * fee : 8
             * rUrl : null
             * mark : 0
             */
            var id: Long = 0
            var name: String? = null
            var album: AlbumBean? = null
            var duration = 0
            var copyrightId = 0
            var status = 0
            var rtype = 0
            var ftype = 0

            //是否有MV
            var mvid = 0
            var fee = 0
            var rUrl: Any? = null
            var mark: Long = 0
            var artists: List<ArtistsBean>? = null
            var alias: List<*>? = null

            class AlbumBean {
                /**
                 * id : 2694934
                 * name : The Essential Boz Scaggs
                 * artist : {"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}
                 * publishTime : 1383004800000
                 * size : 32
                 * copyrightId : 7001
                 * status : 0
                 * picId : 17829680556434244
                 * mark : 0
                 */
                var id = 0
                var name: String? = null
                var artist: ArtistBean? = null
                var publishTime: Long = 0
                var size = 0
                var copyrightId = 0
                var status = 0
                var picId: Long = 0
                var mark: Long = 0

                class ArtistBean {
                    /**
                     * id : 0
                     * name :
                     * picUrl : null
                     * alias : []
                     * albumSize : 0
                     * picId : 0
                     * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1 : 0
                     * trans : null
                     */
                    var id = 0
                    var name: String? = null
                    var picUrl: Any? = null
                    var albumSize = 0
                    var picId = 0
                    var img1v1Url: String? = null
                    var img1v1 = 0
                    var trans: Any? = null
                    var alias: List<*>? = null
                }
            }

            class ArtistsBean {
                /**
                 * id : 48514
                 * name : Boz Scaggs
                 * picUrl : null
                 * alias : []
                 * albumSize : 0
                 * picId : 0
                 * img1v1Url : https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1 : 0
                 * trans : null
                 */
                var id = 0
                var name: String? = null
                var picUrl: String? = null
                var albumSize = 0
                var picId = 0
                var img1v1Url: String? = null
                var img1v1 = 0
                var trans: Any? = null
                var alias: List<*>? = null
            }

            override fun toString(): String {
                return "SongsBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", album=" + album +
                        ", duration=" + duration +
                        ", copyrightId=" + copyrightId +
                        ", status=" + status +
                        ", rtype=" + rtype +
                        ", ftype=" + ftype +
                        ", mvid=" + mvid +
                        ", fee=" + fee +
                        ", rUrl=" + rUrl +
                        ", mark=" + mark +
                        ", artists=" + artists +
                        ", alias=" + alias +
                        '}'
            }
        }

        override fun toString(): String {
            return "ResultBean{" +
                    "songCount=" + songCount +
                    ", songs=" + songs +
                    '}'
        }
    }

    override fun toString(): String {
        return "SongSearchBean{" +
                "result=" + result +
                ", code=" + code +
                '}'
    }
}
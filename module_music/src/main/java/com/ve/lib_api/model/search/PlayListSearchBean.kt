package com.ve.lib_api.model.search

class PlayListSearchBean {
    /**
     * result : {"playlists":[{"id":52746318,"name":"「JOJO的奇妙冒险」OP ED OST","coverImgUrl":"https://p1.music.126.net/sicaanj9a2OIqBrh-KYCuQ==/7765850627343694.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":363,"userId":8892659,"playCount":6865719,"bookCount":108033,"description":"ジョジョの奇妙な冒険","highQuality":false,"alg":"alg_playlist_total_intervene_basic"},{"id":9515375,"name":"「JOJO的奇妙冒险」OP ED 处刑曲","coverImgUrl":"https://p1.music.126.net/93wbHgPDkGRUHdRPJt96Gw==/109951163982689178.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":58,"userId":8892659,"playCount":2894732,"bookCount":45866,"description":"その血の運命～JO～JO！","highQuality":false,"alg":"alg_playlist_total_intervene_basic"}],"playlistCount":300}
     * code : 200
     */
    var result: ResultBean? = null
    var code = 0

    class ResultBean {
        /**
         * playlists : [{"id":52746318,"name":"「JOJO的奇妙冒险」OP ED OST","coverImgUrl":"https://p1.music.126.net/sicaanj9a2OIqBrh-KYCuQ==/7765850627343694.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":363,"userId":8892659,"playCount":6865719,"bookCount":108033,"description":"ジョジョの奇妙な冒険","highQuality":false,"alg":"alg_playlist_total_intervene_basic"},{"id":9515375,"name":"「JOJO的奇妙冒险」OP ED 处刑曲","coverImgUrl":"https://p1.music.126.net/93wbHgPDkGRUHdRPJt96Gw==/109951163982689178.jpg","creator":{"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":58,"userId":8892659,"playCount":2894732,"bookCount":45866,"description":"その血の運命～JO～JO！","highQuality":false,"alg":"alg_playlist_total_intervene_basic"}]
         * playlistCount : 300
         */
        var playlistCount = 0
        var playlists: List<PlaylistsBean>? = null

        class PlaylistsBean {
            /**
             * id : 52746318
             * name : 「JOJO的奇妙冒险」OP ED OST
             * coverImgUrl : https://p1.music.126.net/sicaanj9a2OIqBrh-KYCuQ==/7765850627343694.jpg
             * creator : {"nickname":"螃蟹与干脆面","userId":8892659,"userType":200,"authStatus":0,"expertTags":null,"experts":null}
             * subscribed : false
             * trackCount : 363
             * userId : 8892659
             * playCount : 6865719
             * bookCount : 108033
             * description : ジョジョの奇妙な冒険
             * highQuality : false
             * alg : alg_playlist_total_intervene_basic
             */
            var id: Long = 0
            var name: String? = null
            var coverImgUrl: String? = null
            var creator: CreatorBean? = null
            var isSubscribed = false
            var trackCount = 0
            var userId: Long = 0
            var playCount = 0
            var bookCount = 0
            var description: String? = null
            var isHighQuality = false
            var alg: String? = null

            class CreatorBean {
                /**
                 * nickname : 螃蟹与干脆面
                 * userId : 8892659
                 * userType : 200
                 * authStatus : 0
                 * expertTags : null
                 * experts : null
                 */
                var nickname: String? = null
                var userId: Long = 0
                var userType = 0
                var authStatus = 0
                var expertTags: Any? = null
                var experts: Any? = null
            }
        }
    }
}
package com.ve.lib_api.model.search

/**
 * 根据api获取的视频搜索结果
 */
class FeedSearchBean {
    /**
     * result : {"videoCount":600,"videos":[{"coverUrl":"http://p1.music.126.net/R6pCjd9qmH4LQm1idWOZig==/109951163888857522.jpg","title":"《jojo的奇妙冒险》各部BOSS的精彩操作（大误）P3","durationms":468695,"playTime":714924,"type":1,"creator":[{"userId":1484858585,"userName":"TwoFlyCats"}],"aliaName":null,"transName":null,"vid":"E7324156176B933029D10CB5E92E5B3F","markTypes":[],"alg":"alg_video_a"},{"coverUrl":"http://p1.music.126.net/grzV0_AtUPoyTT-0lEuJFQ==/109951163918650420.jpg","title":"一起来跟着黑帮摇//","durationms":59000,"playTime":1120173,"type":1,"creator":[{"userId":266801423,"userName":"我还没玩死"}],"aliaName":null,"transName":null,"vid":"B48CB3849AC193321699BA76DCE3B822","markTypes":[],"alg":"alg_video_a"}]}
     * code : 200
     */
    var result: ResultBean? = null
    var code = 0

    class ResultBean {
        /**
         * videoCount : 600
         * videos : [{"coverUrl":"http://p1.music.126.net/R6pCjd9qmH4LQm1idWOZig==/109951163888857522.jpg","title":"《jojo的奇妙冒险》各部BOSS的精彩操作（大误）P3","durationms":468695,"playTime":714924,"type":1,"creator":[{"userId":1484858585,"userName":"TwoFlyCats"}],"aliaName":null,"transName":null,"vid":"E7324156176B933029D10CB5E92E5B3F","markTypes":[],"alg":"alg_video_a"},{"coverUrl":"http://p1.music.126.net/grzV0_AtUPoyTT-0lEuJFQ==/109951163918650420.jpg","title":"一起来跟着黑帮摇//","durationms":59000,"playTime":1120173,"type":1,"creator":[{"userId":266801423,"userName":"我还没玩死"}],"aliaName":null,"transName":null,"vid":"B48CB3849AC193321699BA76DCE3B822","markTypes":[],"alg":"alg_video_a"}]
         */
        var videoCount = 0
        var videos: List<VideosBean>? = null

        class VideosBean {
            /**
             * coverUrl : http://p1.music.126.net/R6pCjd9qmH4LQm1idWOZig==/109951163888857522.jpg
             * title : 《jojo的奇妙冒险》各部BOSS的精彩操作（大误）P3
             * durationms : 468695
             * playTime : 714924
             * type : 1
             * creator : [{"userId":1484858585,"userName":"TwoFlyCats"}]
             * aliaName : null
             * transName : null
             * vid : E7324156176B933029D10CB5E92E5B3F
             * markTypes : []
             * alg : alg_video_a
             */
            var coverUrl: String? = null
            var title: String? = null
            var durationms = 0
            var playTime: Long = 0
            var type = 0
            var aliaName: Any? = null
            var transName: Any? = null
            var vid: String? = null
            var alg: String? = null
            var creator: List<MvBean.CreatorBean>? = null
            var markTypes: List<*>? = null
            override fun toString(): String {
                return "VideosBean{" +
                        "coverUrl='" + coverUrl + '\'' +
                        ", title='" + title + '\'' +
                        ", durationms=" + durationms +
                        ", playTime=" + playTime +
                        ", type=" + type +
                        ", aliaName=" + aliaName +
                        ", transName=" + transName +
                        ", vid='" + vid + '\'' +
                        ", alg='" + alg + '\'' +
                        ", creator=" + creator +
                        ", markTypes=" + markTypes +
                        '}'
            }
        }
    }
}
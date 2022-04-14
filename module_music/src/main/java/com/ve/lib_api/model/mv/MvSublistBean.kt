package com.ve.lib_api.model.mv

import com.ve.lib_api.model.search.FeedSearchBean

class MvSublistBean {
    /**
     * code : 200
     * data : [{"type":0,"title":"你的微笑","durationms":265000,"creator":[{"userId":11562,"userName":"F.I.R"}],"playTime":782783,"coverUrl":"http://p1.music.126.net/UIlOiMnUleUmaxyEXThmPw==/1426066585668185.jpg","vid":"5307442","aliaName":null,"transName":null,"alg":null,"markTypes":null},{"type":1,"title":"找到《往后余生》最好听的版本，配上这个MV，看哭了","durationms":269047,"creator":[{"userId":19389416,"userName":"全球趣音乐"}],"playTime":2969673,"coverUrl":"http://p1.music.126.net/6B4jCaJQtfn60wuGKltX7Q==/109951163842985266.jpg","vid":"4E673ABCA5B939B889FDE4A2B148C2BD","aliaName":null,"transName":null,"alg":null,"markTypes":[]}]
     * hasMore : false
     * count : 2
     */
    var code = 0
    var isHasMore = false
    var count = 0
    var data: List<FeedSearchBean.ResultBean.VideosBean>? = null
}
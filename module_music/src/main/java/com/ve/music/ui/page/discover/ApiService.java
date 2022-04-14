package com.ve.music.ui.page.discover;


import com.ve.lib_api.model.album.AlbumDetailBean;
import com.ve.lib_api.model.album.AlbumDynamicBean;
import com.ve.lib_api.model.album.AlbumSublistBean;
import com.ve.lib_api.model.artist.ArtistListBean;
import com.ve.lib_api.model.artist.ArtistSublistBean;
import com.ve.lib_api.model.banner.BannerBean;
import com.ve.lib_api.model.dj.DjBannerBean;
import com.ve.lib_api.model.dj.DjCategoryRecommendBean;
import com.ve.lib_api.model.dj.DjCatelistBean;
import com.ve.lib_api.model.dj.DjDetailBean;
import com.ve.lib_api.model.dj.DjPaygiftBean;
import com.ve.lib_api.model.dj.DjProgramBean;
import com.ve.lib_api.model.dj.DjRecommendBean;
import com.ve.lib_api.model.dj.DjRecommendTypeBean;
import com.ve.lib_api.model.dj.DjSubListBean;
import com.ve.lib_api.model.mv.MvBean;
import com.ve.lib_api.model.mv.MvInfoBean;
import com.ve.lib_api.model.mv.MvSublistBean;
import com.ve.lib_api.model.mv.MvTopBean;
import com.ve.lib_api.model.mv.VideoBean;
import com.ve.lib_api.model.mv.VideoDetailBean;
import com.ve.lib_api.model.mv.VideoGroupBean;
import com.ve.lib_api.model.mv.VideoRelatedBean;
import com.ve.lib_api.model.mv.VideoUrlBean;
import com.ve.lib_api.model.notification.CommonMessageBean;
import com.ve.lib_api.model.notification.ForwardsMeBean;
import com.ve.lib_api.model.notification.PrivateCommentBean;
import com.ve.lib_api.model.notification.PrivateMsgBean;
import com.ve.lib_api.model.notification.PrivateNoticeBean;
import com.ve.lib_api.model.notification.UserCloudBean;
import com.ve.lib_api.model.playlist.CatlistBean;
import com.ve.lib_api.model.playlist.DailyRecommendBean;
import com.ve.lib_api.model.playlist.HighQualityPlayListBean;
import com.ve.lib_api.model.playlist.MainRecommendPlayListBean;
import com.ve.lib_api.model.playlist.MyFmBean;
import com.ve.lib_api.model.playlist.PlayModeIntelligenceBean;
import com.ve.lib_api.model.playlist.PlaylistDetailBean;
import com.ve.lib_api.model.playlist.RecommendPlayListBean;
import com.ve.lib_api.model.playlist.TopListBean;
import com.ve.lib_api.model.search.AlbumSearchBean;
import com.ve.lib_api.model.search.FeedSearchBean;
import com.ve.lib_api.model.search.HotSearchDetailBean;
import com.ve.lib_api.model.search.PlayListSearchBean;
import com.ve.lib_api.model.search.RadioSearchBean;
import com.ve.lib_api.model.search.SimiSingerBean;
import com.ve.lib_api.model.search.SingerAblumSearchBean;
import com.ve.lib_api.model.search.SingerDescriptionBean;
import com.ve.lib_api.model.search.SingerSearchBean;
import com.ve.lib_api.model.search.SingerSongSearchBean;
import com.ve.lib_api.model.search.SongSearchBean;
import com.ve.lib_api.model.search.SynthesisSearchBean;
import com.ve.lib_api.model.search.TopAlbumBean;
import com.ve.lib_api.model.search.UserSearchBean;
import com.ve.lib_api.model.song.CommentLikeBean;
import com.ve.lib_api.model.song.LikeMusicBean;
import com.ve.lib_api.model.song.LyricBean;
import com.ve.lib_api.model.song.MusicCanPlayBean;
import com.ve.lib_api.model.song.NewSongBean;
import com.ve.lib_api.model.song.PlayListCommentBean;
import com.ve.lib_api.model.song.SongDetailBean;
import com.ve.lib_api.model.user.FollowBean;
import com.ve.lib_api.model.user.LikeListBean;
import com.ve.lib_api.model.user.LoginBean;
import com.ve.lib_api.model.user.MainEventBean;
import com.ve.lib_api.model.user.UserDetailBean;
import com.ve.lib_api.model.user.UserEventBean;
import com.ve.lib_api.model.user.UserFollowedBean;
import com.ve.lib_api.model.user.UserFollowerBean;
import com.ve.lib_api.model.user.UserPlaylistBean;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String BASE_URL = "http://192.168.1.184:3000/";


    @GET("/")
    Single<ResponseBody> checkNetwork();

    @GET("login/cellphone")
    Single<LoginBean> login(@Query("phone") String phone, @Query("password") String password);

    @GET("captcha/sent")
    Single<CommonMessageBean> capture(@Query("phone") String phone);

    @GET("video/url")
    Single<VideoUrlBean> getVideoUrl(@Query("id") String id);

    @GET("user/cloud")
    Single<UserCloudBean> getUserCloudMusic();

    @GET("dj/detail")
    Single<DjDetailBean> getRadioDetail(@Query("rid") String id);

    @GET("dj/sublist")
    Single<DjSubListBean> getDjSubList();

    @GET("dj/program")
    Single<DjProgramBean> getRadioProgram(@Query("rid") String id, @Query("asc") boolean asc);

    @GET("album")
    Single<AlbumDetailBean> getAlbumDetail(@Query("id") long id);

    @GET("album/detail/dynamic")
    Single<AlbumDynamicBean> getAlbumDynamic(@Query("id") long id);

    @GET("register/cellphone")
    Single<LoginBean> register(@Query("phone") String phone, @Query("password") String password, @Query("capture") String capture);

    @GET("logout")
    Single<CommonMessageBean> logout();

    @GET("banner")
    Single<BannerBean> getBanner(@Query("type") String type);

    @GET("dj/banner")
    Single<DjBannerBean> getRadioBanner();

    @GET("recommend/resource")
    Single<MainRecommendPlayListBean> getRecommendPlayList();

    @GET("recommend/songs")
    Single<DailyRecommendBean> getDailyRecommend();

    @GET("toplist")
    Single<TopListBean> getTopList();

    @GET("dj/recommend")
    Single<DjRecommendBean> getRadioRecommend();

    @GET("dj/recommend/type")
    Single<DjRecommendTypeBean> getDjRecommend(@Query("type") int type);

    @GET("top/playlist")
    Single<RecommendPlayListBean> getPlayList(@Query("cat") String type, @Query("limit") int limit);

    @GET("top/artists")
    Single<ArtistListBean> getHotSingerList();

    @GET("top/playlist/highquality")
    Single<HighQualityPlayListBean> getHighquality(@Query("limit") int limit, @Query("before") long before);

    @GET("playlist/catlist")
    Single<CatlistBean> getCatlist();

    @GET("playlist/detail")
    Single<PlaylistDetailBean> getPlaylistDetail(@Query("id") long id);

    @GET("check/music")
    Single<MusicCanPlayBean> getMusicCanPlay(@Query("id") long id);

    @GET("user/playlist")
    Single<UserPlaylistBean> getUserPlaylist(@Query("uid") long uid);

    /**
     * 对歌单添加或删除歌曲
     * 参数:op: 从歌单增加单曲为 add, 删除为 del
     * pid: 歌单 id
     * tracks: 歌曲 id,可多个,用逗号隔开
     */
    @GET("playlist/tracks")
    Single<CommonMessageBean> trackPlayList(@Query("pid") long id, @Query("tracks") String tracksId, @Query("op") String op);

    @GET("user/event")
    Single<UserEventBean> getUserEvent(@Query("uid") long uid, @Query("limit") int limit, @Query("lasttime") long time);

    @GET("user/detail")
    Single<UserDetailBean> getUserDetail(@Query("uid") long uid);

    // t:1关注 0:取消关注
    @GET("follow")
    Single<FollowBean> getUserFollow(@Query("id") long uid, @Query("t") int t);


    @GET("user/follows")
    Single<UserFollowerBean> getUserFollower(@Query("id") long uid);

    @GET("user/followeds")
    Single<UserFollowedBean> getUserFollowed(@Query("id") long uid);

    @GET("search/hot/detail")
    Single<HotSearchDetailBean> getSearchHotDetail();

    /**
     * 搜索
     * PS.type: 搜索类型；默认为 1 即单曲 , 取值意义 :
     * 1: 单曲, 10: 专辑, 100: 歌手, 1000: 歌单,
     * 1002: 用户, 1004: MV, 1006: 歌词, 1009: 电台,
     * 1014: 视频, 1018:综合
     */
    @GET("search")
    Single<SongSearchBean> getSongSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("search")
    Single<FeedSearchBean> getVideoSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("search")
    Single<SingerSearchBean> getSingerSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("search")
    Single<AlbumSearchBean> getAlbumSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("search")
    Single<PlayListSearchBean> getPlayListSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("search")
    Single<RadioSearchBean> getRadioSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("search")
    Single<UserSearchBean> getUserSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("search")
    Single<SynthesisSearchBean> getSynthesisSearch(@Query("keywords") String keywords, @Query("type") int type);

    @GET("artists")
    Single<SingerSongSearchBean> getSingerHotSong(@Query("id") String id);

    /**
     * 歌手分类
     * type 1:男歌手 2:女歌手 3:乐队
     * area  -1:全部 7:华语(1) 96:欧美(2) 8:日本(3) 16韩国(4) 0:其他
     */
    @GET("artist/list")
    Single<ArtistListBean> getSingerList(@Query("type") int type, @Query("area") int area);

    @GET("artist/album")
    Single<SingerAblumSearchBean> getSingerAlbum(@Query("id") long id);

    @GET("artist/desc")
    Single<SingerDescriptionBean> getSingerDesc(@Query("id") long id);

    @GET("simi/artist")
    Single<SimiSingerBean> getSimiSinger(@Query("id") long id);

    @GET("likelist")
    Single<LikeListBean> getLikeList(@Query("uid") long uid);

    @GET("song/detail")
    Single<SongDetailBean> getSongDetail(@Query("ids") String ids);

    @GET("like")
    Single<LikeMusicBean> likeMusic(@Query("id") String id, @Query("like") boolean like);

    @GET("comment/music")
    Single<PlayListCommentBean> getMusicComment(@Query("id") String id);

    @GET("comment/playlist")
    Single<PlayListCommentBean> getPlayListComment(@Query("id") String id);

    @GET("comment/album")
    Single<PlayListCommentBean> getAlbumComment(@Query("id") String id);

    @GET("comment/mv")
    Single<PlayListCommentBean> getMvComment(@Query("id") String id);

    @GET("video/group/list")
    Single<VideoGroupBean> getVideoGroup();

    @GET("video/group")
    Single<VideoBean> getVideoTab(@Query("id") long id);

    @GET("video/detail")
    Single<VideoDetailBean> getVideoDetail(@Query("id") String id);

    @GET("video/timeline/recommend")
    Single<VideoBean> getVideoRecommend();

    @GET("related/allvideo")
    Single<VideoRelatedBean> getVideoRelated(@Query("id") String id);

    /**
     * 给评论点赞
     * id : 资源 id, 如歌曲 id, mv id
     * cid : 评论 id
     * t : 是否点赞 ,1 为点赞 ,0 为取消点赞
     * tpye: 数字 , 资源类型 , 对应歌曲 , mv, 专辑 , 歌单 , 电台, 视频对应以下类型
     * 0: 歌曲 1: mv 2: 歌单 3: 专辑 4: 电台 5: 视频 6: 动态
     */
    @GET("comment/like")
    Single<CommentLikeBean> likeComment(@Query("id") String id, @Query("cid") long cid, @Query("t") int t, @Query("type") int type);

    /**
     * 给资源点赞
     * type : 资源类型 1: mv 4: 电台 5: 视频 6: 动态
     * t : 是否点赞 ,1 为点赞 ,0 为取消点赞
     * id: 资源 id
     * PS  注意：如给动态点赞，不需要传入 id，需要传入 threadId,可通过 event,/user/event 接口获取，如： /resource/like?t=1&type=6&threadId=A_EV_2_6559519868_32953014
     */
    @GET("resource/like")
    Single<CommentLikeBean> likeResource(@Query("id") String id, @Query("t") int t, @Query("type") int type);

    @GET("resource/like")
    Single<CommentLikeBean> likeEventResource(@Query("threadId") String id, @Query("t") int t, @Query("type") int type);

    @GET("playmode/intelligence/list")
    Single<PlayModeIntelligenceBean> getIntelligenceList(@Query("id") long id, @Query("pid") long pid);

    // t=1 收藏 2 取消收藏
    @GET("playlist/subscribe")
    Single<CommonMessageBean> subscribePlayList(@Query("id") long id, @Query("t") long t);

    @GET("playlist/create")
    Single<CommonMessageBean> createPlayList(@Query("name") String name);

    // t=1 收藏 2 取消收藏
    @GET("album/sub")
    Single<CommonMessageBean> subscribeAlbum(@Query("id") long id, @Query("t") long t);

    // t=1 收藏 2 取消收藏
    @GET("video/sub")
    Single<CommonMessageBean> subscribeVideo(@Query("id") String id, @Query("t") long t);

    @GET("top/album")
    Single<TopAlbumBean> getTopAlbum(@Query("limit") int limit);

    @GET("album/newest")
    Single<AlbumSearchBean.ResultBean> getNewAlbum();

    //PS.全部:0 华语:7  欧美:96 日本:8 韩国:16
    @GET("top/song")
    Single<NewSongBean> getTopSong(@Query("type") int type);

    @GET("album/sublist")
    Single<AlbumSublistBean> getAlbumSublist();

    @GET("artist/sublist")
    Single<ArtistSublistBean> getArtistSublist();

    @GET("artist/sub")
        //t =1 true  0 = false
    Single<CommonMessageBean> getSubArtist(@Query("id") int id, @Query("t") int t);

    @GET("mv/sublist")
    Single<MvSublistBean> getMvSublist();

    @GET("mv/sub")
    Single<CommentLikeBean> getMvSub(@Query("id") int id, @Query("t") int t);

    @GET("personal_fm")
    Single<MyFmBean> getMyFm();

    @GET("event")
    Single<MainEventBean> getMainEvent();

    @GET("lyric")
    Single<LyricBean> getLyric(@Query("id") String id);

    @GET("comment/playlist")
    Single<PlayListCommentBean> getPlaylistComment(@Query("id") long id);

    @GET("comment/video")
    Single<PlayListCommentBean> getVideoComment(@Query("id") String id);

    @GET("dj/paygift")
    Single<DjPaygiftBean> getDjPaygift(@Query("limit") int limit, @Query("offset") int offset);

    @GET("dj/category/recommend")
    Single<DjCategoryRecommendBean> getDjCategoryRecommend();

    @GET("dj/catelist")
    Single<DjCatelistBean> getDjCatelist();

    // 1 订阅 0取消订阅
    @GET("dj/sub")
    Single<CommonMessageBean> getSubRadio(@Query("rid") String rid, @Query("t") int isSub);

    @GET("top/mv")
    Single<MvTopBean> getMvTop();

    @GET("mv/detail")
    Single<MvInfoBean> getMvDetail(@Query("mvid") String mvId);

    @GET("top/mv")
    Single<MvTopBean> getMvTop(@Query("area") String area);

    @GET("mv/first")
    Single<MvBean> getFirstMv(@Query("area") String area, @Query("limit") int limit);

    /**
     * 获取全部MV
     * area: 地区,可选值为全部,内地,港台,欧美,日本,韩国,不填则为全部
     * type: 类型,可选值为全部,官方版,原生,现场版,网易出品,不填则为全部
     * order: 排序,可选值为上升最快,最热,最新,不填则为上升最快
     * limit: 取出数量 , 默认为 30
     * offset: 偏移数量 , 用于分页 , 如 :( 页数 -1)*50, 其中 50 为 limit 的值 , 默认 为 0
     */
    @GET("mv/all")
    Single<MvBean> getAllMv(@Query("area") String area, @Query("type") String type, @Query("order") String order, @Query("limit") int limit);

    @GET("msg/comments")
    Single<PrivateCommentBean> getPrivateComment(@Query("uid") int userId);

    @GET("msg/private")
    Single<PrivateMsgBean> getPrivateLetter(@Query("limit") int limit);

    @GET("msg/notices")
    Single<PrivateNoticeBean> getPrivateNotice();

    @GET("msg/forwards")
    Single<ForwardsMeBean> getPrivateFowards();

}

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
     * ??????????????????????????????
     * ??????:op: ???????????????????????? add, ????????? del
     * pid: ?????? id
     * tracks: ?????? id,?????????,???????????????
     */
    @GET("playlist/tracks")
    Single<CommonMessageBean> trackPlayList(@Query("pid") long id, @Query("tracks") String tracksId, @Query("op") String op);

    @GET("user/event")
    Single<UserEventBean> getUserEvent(@Query("uid") long uid, @Query("limit") int limit, @Query("lasttime") long time);

    @GET("user/detail")
    Single<UserDetailBean> getUserDetail(@Query("uid") long uid);

    // t:1?????? 0:????????????
    @GET("follow")
    Single<FollowBean> getUserFollow(@Query("id") long uid, @Query("t") int t);


    @GET("user/follows")
    Single<UserFollowerBean> getUserFollower(@Query("id") long uid);

    @GET("user/followeds")
    Single<UserFollowedBean> getUserFollowed(@Query("id") long uid);

    @GET("search/hot/detail")
    Single<HotSearchDetailBean> getSearchHotDetail();

    /**
     * ??????
     * PS.type: ???????????????????????? 1 ????????? , ???????????? :
     * 1: ??????, 10: ??????, 100: ??????, 1000: ??????,
     * 1002: ??????, 1004: MV, 1006: ??????, 1009: ??????,
     * 1014: ??????, 1018:??????
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
     * ????????????
     * type 1:????????? 2:????????? 3:??????
     * area  -1:?????? 7:??????(1) 96:??????(2) 8:??????(3) 16??????(4) 0:??????
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
     * ???????????????
     * id : ?????? id, ????????? id, mv id
     * cid : ?????? id
     * t : ???????????? ,1 ????????? ,0 ???????????????
     * tpye: ?????? , ???????????? , ???????????? , mv, ?????? , ?????? , ??????, ????????????????????????
     * 0: ?????? 1: mv 2: ?????? 3: ?????? 4: ?????? 5: ?????? 6: ??????
     */
    @GET("comment/like")
    Single<CommentLikeBean> likeComment(@Query("id") String id, @Query("cid") long cid, @Query("t") int t, @Query("type") int type);

    /**
     * ???????????????
     * type : ???????????? 1: mv 4: ?????? 5: ?????? 6: ??????
     * t : ???????????? ,1 ????????? ,0 ???????????????
     * id: ?????? id
     * PS  ????????????????????????????????????????????? id??????????????? threadId,????????? event,/user/event ????????????????????? /resource/like?t=1&type=6&threadId=A_EV_2_6559519868_32953014
     */
    @GET("resource/like")
    Single<CommentLikeBean> likeResource(@Query("id") String id, @Query("t") int t, @Query("type") int type);

    @GET("resource/like")
    Single<CommentLikeBean> likeEventResource(@Query("threadId") String id, @Query("t") int t, @Query("type") int type);

    @GET("playmode/intelligence/list")
    Single<PlayModeIntelligenceBean> getIntelligenceList(@Query("id") long id, @Query("pid") long pid);

    // t=1 ?????? 2 ????????????
    @GET("playlist/subscribe")
    Single<CommonMessageBean> subscribePlayList(@Query("id") long id, @Query("t") long t);

    @GET("playlist/create")
    Single<CommonMessageBean> createPlayList(@Query("name") String name);

    // t=1 ?????? 2 ????????????
    @GET("album/sub")
    Single<CommonMessageBean> subscribeAlbum(@Query("id") long id, @Query("t") long t);

    // t=1 ?????? 2 ????????????
    @GET("video/sub")
    Single<CommonMessageBean> subscribeVideo(@Query("id") String id, @Query("t") long t);

    @GET("top/album")
    Single<TopAlbumBean> getTopAlbum(@Query("limit") int limit);

    @GET("album/newest")
    Single<AlbumSearchBean.ResultBean> getNewAlbum();

    //PS.??????:0 ??????:7  ??????:96 ??????:8 ??????:16
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

    // 1 ?????? 0????????????
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
     * ????????????MV
     * area: ??????,??????????????????,??????,??????,??????,??????,??????,??????????????????
     * type: ??????,??????????????????,?????????,??????,?????????,????????????,??????????????????
     * order: ??????,????????????????????????,??????,??????,????????????????????????
     * limit: ???????????? , ????????? 30
     * offset: ???????????? , ???????????? , ??? :( ?????? -1)*50, ?????? 50 ??? limit ?????? , ?????? ??? 0
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

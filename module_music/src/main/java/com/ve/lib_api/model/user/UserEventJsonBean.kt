package com.ve.lib_api.model.user

import com.google.gson.annotations.SerializedName
import com.ve.lib_api.model.playlist.DailyRecommendBean
import com.ve.lib_api.model.search.AlbumSearchBean

/**
 * 用户动态的json bean
 * msg里面是 content
 * 附带的bean 有 song（歌曲） video（视频） program（电台）
 * event（转发）
 */
class UserEventJsonBean {
    /**
     * msg : Armin Van Buuren发推庆祝和他爱人的10年纪念日
     * song : {"name":"It Could Be","id":1391810715,"position":0,"alias":[],"status":0,"fee":8,"copyrightId":665010,"disc":"01","no":1,"artists":[{"name":"Armin van Buuren","id":27621,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},{"name":"Inner City","id":60435,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"album":{"name":"It Could Be","id":81750597,"type":"EP/Single","size":0,"picId":109951164372996407,"blurPicUrl":"http://p2.music.126.net/jKztNn2WzZ3bez6Rrez88Q==/109951164372996407.jpg","companyId":0,"pic":109951164372996407,"picUrl":"http://p2.music.126.net/jKztNn2WzZ3bez6Rrez88Q==/109951164372996407.jpg","publishTime":1568908800000,"description":"","tags":"","company":"Armada Music","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":1,"copyrightId":665010,"commentThreadId":"R_AL_3_81750597","artists":[{"name":"Armin van Buuren","id":27621,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},{"name":"Inner City","id":60435,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"img80x80":"https://p1.music.126.net/jKztNn2WzZ3bez6Rrez88Q==/109951164372996407.jpg?param=80x80x1"},"starred":false,"popularity":5,"score":5,"starredNum":0,"duration":157517,"playedNum":0,"dayPlays":0,"hearTime":0,"ringtone":"","crbt":null,"audition":null,"copyFrom":"","commentThreadId":"R_SO_4_1391810715","rtUrl":null,"ftype":0,"rtUrls":[],"copyright":1,"rtype":0,"rurl":null,"mvid":0,"bMusic":{"name":null,"id":3978676183,"size":2521173,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":157517,"volumeDelta":-63497},"mp3Url":null,"lMusic":{"name":null,"id":3978676183,"size":2521173,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":157517,"volumeDelta":-63497},"hMusic":{"name":null,"id":3978676181,"size":6302868,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":157517,"volumeDelta":-67359},"mMusic":{"name":null,"id":3978676182,"size":3781738,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":192000,"playTime":157517,"volumeDelta":-64960}}
     */
    var msg: String? = null

    //歌曲
    private var song: DailyRecommendBean.RecommendBean? = null

    //视频
    var video: VideoBean? = null

    //电台节目
    var program: ProgramBean? = null

    //动态
    var event: UserEventBean? = null

    //歌单
    var playlist: UserPlaylistBean.PlaylistBean? = null

    //专辑
    private val album: AlbumSearchBean.ResultBean.AlbumsBean? = null
    override fun toString(): String {
        return "UserEventJsonBean{" +
                "msg='" + msg + '\'' +
                ", song=" + song +
                ", video=" + video +
                ", program=" + program +
                ", event=" + event +
                ", playlist=" + playlist +
                ", album=" + album +
                '}'
    }

    fun getAlbum(): AlbumSearchBean.ResultBean.AlbumsBean? {
        return album
    }

    fun getSong(): DailyRecommendBean.RecommendBean? {
        return song
    }

    fun setSong(song: DailyRecommendBean.RecommendBean?) {
        this.song = song
    }

    class VideoBean {
        /**
         * vid : 0
         * coverUrl : http://p4.music.126.net/sYzTtvaqErQJreMlI_gjqg==/109951164375596429.jpg
         * duration : 264
         * playTime : 21
         * height : 720
         * width : 1280
         * size : 57982295
         * state : 1
         * coverType : 0
         * urlInfo : null
         * videoId : 38021ABAB8C082ABEC9286D1D57B1B01
         * threadId : null
         * title : Yellow Claw新单《Let's Get Married》MV首播
         * description : 黄爪Yellow Claw新单《Let's Get Married》MV超清首播，全程撒狗粮！MV记录了一对情侣在黄爪演出现场求婚成功和结婚的故事。这对情侣在MV中表示是黄爪的音乐让他们在一起，音乐的魅力就是如此！
         * creator : {"defaultAvatar":false,"province":1000000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/KAw1_uQP354hY7BxfBTmfA==/109951164311340072.jpg","accountStatus":0,"gender":1,"city":1003100,"birthday":912268800000,"userId":45144541,"userType":10,"nickname":"泛电音","signature":"致力于分享电子音乐文化，合作请私信。","description":"音乐博主","detailDescription":"音乐博主","avatarImgId":109951164311340072,"backgroundImgId":109951164311196266,"backgroundUrl":"http://p1.music.126.net/EjXB-9S3AlZ3VNpJoTocJg==/109951164311196266.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951164311340072","backgroundImgIdStr":"109951164311196266","avatarImgId_str":"109951164311340072"}
         * videoStatus : 0
         * resolutions : [{"resolution":0,"size":57982295}]
         * antisChecking : false
         * durationms : 264290
         */
        var vid: String? = null
        var coverUrl: String? = null
        var duration = 0
        var playTime = 0
        var height = 0
        var width = 0
        var size = 0
        var state = 0
        var coverType = 0
        var urlInfo: Any? = null
        var videoId: String? = null
        var threadId: Any? = null
        var title: String? = null
        var description: String? = null
        var creator: CreatorBean? = null
        var videoStatus = 0
        var isAntisChecking = false
        var durationms = 0
        var resolutions: List<ResolutionsBean>? = null

        class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 1
             * followed : false
             * avatarUrl : http://p1.music.126.net/KAw1_uQP354hY7BxfBTmfA==/109951164311340072.jpg
             * accountStatus : 0
             * gender : 1
             * city : 1003100
             * birthday : 912268800000
             * userId : 45144541
             * userType : 10
             * nickname : 泛电音
             * signature : 致力于分享电子音乐文化，合作请私信。
             * description : 音乐博主
             * detailDescription : 音乐博主
             * avatarImgId : 109951164311340072
             * backgroundImgId : 109951164311196266
             * backgroundUrl : http://p1.music.126.net/EjXB-9S3AlZ3VNpJoTocJg==/109951164311196266.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 10
             * vipType : 11
             * remarkName : null
             * avatarImgIdStr : 109951164311340072
             * backgroundImgIdStr : 109951164311196266
             * avatarImgId_str : 109951164311340072
             */
            var isDefaultAvatar = false
            var province = 0
            var authStatus = 0
            var isFollowed = false
            var avatarUrl: String? = null
            var accountStatus = 0
            var gender = 0
            var city = 0
            var birthday: Long = 0
            var userId = 0
            var userType = 0
            var nickname: String? = null
            var signature: String? = null
            var description: String? = null
            var detailDescription: String? = null
            var avatarImgId: Long = 0
            var backgroundImgId: Long = 0
            var backgroundUrl: String? = null
            var authority = 0
            var isMutual = false
            var expertTags: Any? = null
            var experts: Any? = null
            var djStatus = 0
            var vipType = 0
            var remarkName: Any? = null
            var avatarImgIdStr: String? = null
            var backgroundImgIdStr: String? = null
            var avatarImgId_str: String? = null
        }

        class ResolutionsBean {
            /**
             * resolution : 0
             * size : 57982295
             */
            var resolution = 0
            var size = 0
        }
    }

    class ProgramBean {
        /**
         * mainSong : null
         * songs : null
         * dj : {"defaultAvatar":false,"province":1000000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/w6o3OFlljKMxxAMSXbywOg==/109951163112568806.jpg","accountStatus":0,"gender":2,"city":1010000,"birthday":1527782400000,"userId":51721387,"userType":4,"nickname":"某微__JOKER","signature":"翻唱歌手，只要是我发布的都是我唱的。\n我没打算让所有人都满意。","description":"","detailDescription":"","avatarImgId":109951163112568806,"backgroundImgId":2002210674180204,"backgroundUrl":"http://p1.music.126.net/5L9yqWa_UnlHtlp7li5PAg==/2002210674180204.jpg","authority":0,"mutual":false,"expertTags":null,"experts":{"1":"音乐原创视频达人"},"djStatus":10,"vipType":11,"remarkName":null,"backgroundImgIdStr":"2002210674180204","avatarImgIdStr":"109951163112568806","avatarImgId_str":"109951163112568806","brand":"某微__JOKER的电台"}
         * blurCoverUrl : http://music.163.com/api/dj/img/blur/7743860394573149
         * radio : {"id":803001,"dj":null,"name":"某微__JOKER的电台","picUrl":"http://p2.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg","desc":"You should get away from me. Efehu vuruz apurisaz.","subCount":320,"programCount":40,"createTime":1422446203005,"categoryId":2001,"category":"创作|翻唱","radioFeeType":0,"feeScope":0,"buyed":true,"videos":null,"finished":false,"underShelf":false,"purchaseCount":0,"price":0,"originalPrice":0,"discountPrice":null,"lastProgramCreateTime":1564738801692,"lastProgramName":null,"lastProgramId":2062489999,"picId":7743860394573149,"rcmdText":"有辨识度的慵懒女声","composeVideo":false,"subed":true}
         * subscribedCount : 0
         * reward : false
         * mainTrackId : 1392321849
         * serialNum : 40
         * listenerCount : 0
         * name : summertime
         * id : 2063287172
         * createTime : 1569041132676
         * description : ✿原唱：cinnamons / evening cinema
         * ✿翻唱/后期：JOKER（@某微__JOKER ）
         *
         * 摸着夏天的尾巴给大家唱首甜甜的summertime
         * userId : 51721387
         * coverUrl : http://p2.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg
         * commentThreadId : A_DJ_1_2063287172
         * channels : []
         * titbits : null
         * titbitImages : null
         * pubStatus : 5
         * trackCount : 0
         * bdAuditStatus : 2
         * programFeeType : 0
         * buyed : false
         * programDesc : null
         * h5Links : []
         * coverId : 7743860394573149
         * adjustedPlayCount : 0
         * canReward : false
         * auditStatus : 10
         * publish : true
         * duration : 0
         * img80x80 : http://p1.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg?param=80x80x1
         */
        var mainSong: Any? = null
        var songs: Any? = null
        var dj: DjBean? = null
        var blurCoverUrl: String? = null
        var radio: RadioBean? = null
        var subscribedCount = 0
        var isReward = false
        var mainTrackId = 0
        var serialNum = 0
        var listenerCount = 0
        var name: String? = null
        var id: Long = 0
        var createTime: Long = 0
        var description: String? = null
        var userId: Long = 0
        var coverUrl: String? = null
        var commentThreadId: String? = null
        var titbits: Any? = null
        var titbitImages: Any? = null
        var pubStatus = 0
        var trackCount = 0
        var bdAuditStatus = 0
        var programFeeType = 0
        var isBuyed = false
        var programDesc: Any? = null
        var coverId: Long = 0
        var adjustedPlayCount = 0
        var isCanReward = false
        var auditStatus = 0
        var isPublish = false
        var duration = 0
        var img80x80: String? = null
        var channels: List<*>? = null
        var h5Links: List<*>? = null

        class DjBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 1
             * followed : false
             * avatarUrl : http://p1.music.126.net/w6o3OFlljKMxxAMSXbywOg==/109951163112568806.jpg
             * accountStatus : 0
             * gender : 2
             * city : 1010000
             * birthday : 1527782400000
             * userId : 51721387
             * userType : 4
             * nickname : 某微__JOKER
             * signature : 翻唱歌手，只要是我发布的都是我唱的。
             * 我没打算让所有人都满意。
             * description :
             * detailDescription :
             * avatarImgId : 109951163112568806
             * backgroundImgId : 2002210674180204
             * backgroundUrl : http://p1.music.126.net/5L9yqWa_UnlHtlp7li5PAg==/2002210674180204.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : {"1":"音乐原创视频达人"}
             * djStatus : 10
             * vipType : 11
             * remarkName : null
             * backgroundImgIdStr : 2002210674180204
             * avatarImgIdStr : 109951163112568806
             * avatarImgId_str : 109951163112568806
             * brand : 某微__JOKER的电台
             */
            var isDefaultAvatar = false
            var province = 0
            var authStatus = 0
            var isFollowed = false
            var avatarUrl: String? = null
            var accountStatus = 0
            var gender = 0
            var city = 0
            var birthday: Long = 0
            var userId: Long = 0
            var userType = 0
            var nickname: String? = null
            var signature: String? = null
            var description: String? = null
            var detailDescription: String? = null
            var avatarImgId: Long = 0
            var backgroundImgId: Long = 0
            var backgroundUrl: String? = null
            var authority = 0
            var isMutual = false
            var expertTags: Any? = null
            var experts: ExpertsBean? = null
            var djStatus = 0
            var vipType = 0
            var remarkName: Any? = null
            var backgroundImgIdStr: String? = null
            var avatarImgIdStr: String? = null
            var avatarImgId_str: String? = null
            var brand: String? = null

            class ExpertsBean {
                /**
                 * 1 : 音乐原创视频达人
                 */
                @SerializedName("1")
                private var `_$1`: String? = null
                fun `get_$1`(): String? {
                    return `_$1`
                }

                fun `set_$1`(`_$1`: String?) {
                    this.`_$1` = `_$1`
                }
            }
        }

        class RadioBean {
            /**
             * id : 803001
             * dj : null
             * name : 某微__JOKER的电台
             * picUrl : http://p2.music.126.net/N0YvpspFZxSocKSNHF4cUg==/7743860394573149.jpg
             * desc : You should get away from me. Efehu vuruz apurisaz.
             * subCount : 320
             * programCount : 40
             * createTime : 1422446203005
             * categoryId : 2001
             * category : 创作|翻唱
             * radioFeeType : 0
             * feeScope : 0
             * buyed : true
             * videos : null
             * finished : false
             * underShelf : false
             * purchaseCount : 0
             * price : 0
             * originalPrice : 0
             * discountPrice : null
             * lastProgramCreateTime : 1564738801692
             * lastProgramName : null
             * lastProgramId : 2062489999
             * picId : 7743860394573149
             * rcmdText : 有辨识度的慵懒女声
             * composeVideo : false
             * subed : true
             */
            var id: Long = 0
            var dj: Any? = null
            var name: String? = null
            var picUrl: String? = null
            var desc: String? = null
            var subCount = 0
            var programCount = 0
            var createTime: Long = 0
            var categoryId = 0
            var category: String? = null
            var radioFeeType = 0
            var feeScope = 0
            var isBuyed = false
            var videos: Any? = null
            var isFinished = false
            var isUnderShelf = false
            var purchaseCount = 0
            var price = 0
            var originalPrice = 0
            var discountPrice: Any? = null
            var lastProgramCreateTime: Long = 0
            var lastProgramName: Any? = null
            var lastProgramId = 0
            var picId: Long = 0
            var rcmdText: String? = null
            var isComposeVideo = false
            var isSubed = false
        }
    }
}
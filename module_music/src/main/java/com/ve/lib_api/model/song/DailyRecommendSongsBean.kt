package com.ve.lib_api.model.song

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class DailyRecommendSongsBean {
    /**
     * name : JoJo
     * id : 27917548
     * pst : 0
     * t : 0
     * ar : [{"id":48514,"name":"Boz Scaggs","tns":[],"alias":[]}]
     * alia : []
     * pop : 85
     * st : 0
     * rt :
     * fee : 8
     * v : 6
     * crbt : null
     * cf :
     * al : {"id":2694934,"name":"The Essential Boz Scaggs","picUrl":"https://p1.music.126.net/_YmTuIMoG0dh2OJSOE-LPw==/17829680556434243.jpg","tns":[],"pic_str":"17829680556434243","pic":17829680556434244}
     * dt : 354746
     * h : {"br":320000,"fid":0,"size":14220536,"vd":-2.65076E-4}
     * m : {"br":160000,"fid":0,"size":7123590,"vd":0.0324002}
     * l : {"br":96000,"fid":0,"size":4284811,"vd":-2.65076E-4}
     * a : null
     * cd : 2
     * no : 1
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * djId : 0
     * copyright : 1
     * s_id : 0
     * mark : 0
     * mv : 0
     * mst : 9
     * cp : 7001
     * rtype : 0
     * rurl : null
     * publishTime : 1382976000007
     */
    @ColumnInfo(name = "song_name")
    var name: String? = null

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "song_pst")
    var pst = 0

    @ColumnInfo(name = "song_t")
    var t = 0

    @ColumnInfo(name = "song_pop")
    var pop = 0

    @ColumnInfo(name = "song_st")
    var st = 0

    @ColumnInfo(name = "song_rt")
    var rt: String? = null

    @ColumnInfo(name = "song_fee")
    var fee = 0

    @ColumnInfo(name = "song_v")
    var v = 0

    @ColumnInfo(name = "song_cf")
    var cf: String? = null

    @ColumnInfo(name = "song_al")
    var al: AlBean? = null

    //歌曲时间
    @ColumnInfo(name = "song_dt")
    var dt: Long = 0

    @Ignore
    var h: HBean? = null

    @Ignore
    var m: MBean? = null

    @Ignore
    var l: LBean? = null

    @Ignore
    var a: Any? = null
    var cd: String? = null
    var no = 0

    @Ignore
    var rtUrl: Any? = null
    var ftype = 0
    var djId = 0
    var copyright = 0
    var s_id = 0
    var mark: Long = 0

    @Ignore
    var mv: Long = 0
    var mst = 0
    var cp = 0
    var rtype = 0

    @Ignore
    var rurl: Any? = null
    var publishTime: Long = 0
    var ar: List<ArBean?>? = null

    @Ignore
    var alia: List<*>? = null

    @Ignore
    var rtUrls: List<*>? = null

    @ColumnInfo(name = "song_reason")
    var recommendReason: String? = null
    fun setMv(mv: Int) {
        this.mv = mv.toLong()
    }

    class AlBean {
        /**
         * id : 2694934
         * name : The Essential Boz Scaggs
         * picUrl : https://p1.music.126.net/_YmTuIMoG0dh2OJSOE-LPw==/17829680556434243.jpg
         * tns : []
         * pic_str : 17829680556434243
         * pic : 17829680556434244
         */
        var id: Long = 0
        var name: String? = null
        var picUrl: String? = null
        var pic_str: String? = null
        var pic: Long = 0
        var tns: List<*>? = null
    }

    class HBean {
        /**
         * br : 320000
         * fid : 0
         * size : 14220536
         * vd : -2.65076E-4
         */
        var br = 0
        var fid: String? = null
        var size = 0
        var vd = 0.0
    }

    class MBean {
        /**
         * br : 160000
         * fid : 0
         * size : 7123590
         * vd : 0.0324002
         */
        var br = 0
        var fid: String? = null
        var size = 0
        var vd = 0.0
    }

    class LBean {
        /**
         * br : 96000
         * fid : 0
         * size : 4284811
         * vd : -2.65076E-4
         */
        var br = 0
        var fid: String? = null
        var size = 0
        var vd = 0.0
    }

    class ArBean {
        /**
         * id : 48514
         * name : Boz Scaggs
         * tns : []
         * alias : []
         */
        private var id: Long = 0
        var name: String? = null
        var tns: List<*>? = null
        var alias: List<*>? = null
        fun getId(): String {
            return id.toString()
        }

        fun setId(id: Long) {
            this.id = id
        }
    }
}
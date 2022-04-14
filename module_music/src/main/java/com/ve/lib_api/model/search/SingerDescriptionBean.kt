package com.ve.lib_api.model.search

class SingerDescriptionBean {
    /**
     * introduction : [{"ti":"水树奈奈","txt":"出生年月：1980年1月21日\n出生地：爱媛县\n兴趣：音乐鉴赏\n特长：书法"},{"ti":"NANA的作品（部分）","txt":"<动画>\nTBS电视台·MBS电视台·其他《BLOOD-C》 更衣小夜\n富士电视台《美食猎人》 蒂娜\n朝日电视台《Heartcatch 光之美少女！》 花咲蕾/花蕾天使\n东京电视台《NARUTO-疾风传-》 日向雏田\n朝日电视台《信蜂 REVERSE》 希尔贝特·史卫特\nMBS电视台·TBS电视台·CBC电视台·其他《黑执事Ⅱ》　亚洛斯·特兰西\n \n电影《剧场版 神奇宝贝 比克提尼与黑英雄捷克罗姆》\n电影《剧场版 神奇宝贝 比克提尼与白英雄雷希拉姆》 比克提尼\n电影《手塚治虫的佛陀 美丽的红色沙漠》 蜜凯拉\n剧场版《魔法少女奈叶 THE MOVIE 1st》 菲特·泰斯塔罗沙\n \n<游戏>\nGC《仙乐传说》 柯蕾特·布鲁尼\nPSP《合金装备 和平行者》 帕姿\n \nOfficial website\nhttps://www.mizukinana.jp/"}]
     * briefDesc :
     * count : 0
     * topicData : null
     * code : 200
    </游戏></动画> */
    var briefDesc: String? = null
    var count = 0
    var topicData: Any? = null
    var code = 0
    var introduction: List<IntroductionBean>? = null

    class IntroductionBean {
        /**
         * ti : 水树奈奈
         * txt : 出生年月：1980年1月21日
         * 出生地：爱媛县
         * 兴趣：音乐鉴赏
         * 特长：书法
         */
        var ti: String? = null
        var txt: String? = null
    }
}
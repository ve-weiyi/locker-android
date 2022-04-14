package com.ve.lib_api.model.dj

class DjCatelistBean {
    /**
     * categories : [{"picPCBlack":18996262393228948,"picWeb":19119407695444320,"pic84x84Id":18734578627472516,"pic56x56Id":18734578627472516,"pic96x96Id":19131502323477870,"picIPad":19036944323358116,"picPCWhite":18996262393228948,"pic56x56IdStr":"18734578627472515","pic96x96IdStr":"19131502323477870","pic84x84IdUrl":"https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg","picPCWhiteStr":"18996262393228949","picPCBlackStr":"18996262393228949","picWebStr":"19119407695444318","picIPadStr":"19036944323358115","picPCWhiteUrl":"https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg","picPCBlackUrl":"https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg","picWebUrl":"https://p1.music.126.net/cCogGBNagepu5uAd-OuCKQ==/19119407695444318.jpg","picIPadUrl":"https://p1.music.126.net/XQTJvk8i1vP21eCUUt8DwA==/19036944323358115.jpg","picMacId":"109951163921391989","picMacUrl":"https://p1.music.126.net/vUL2pw5_gcmJ8C8n-H_K7g==/109951163921391989.jpg","picUWPId":"19082024300200583","picUWPUrl":"https://p1.music.126.net/AYRhCEXW4StXLcS1Wa4j5g==/19082024300200583.jpg","pic56x56Url":"https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg","pic96x96Url":"https://p1.music.126.net/d4y8InBC-g23wE9ZyC_hgA==/19131502323477870.jpg","name":"创作|翻唱","id":2001},{"picPCBlack":1364493985405387,"picWeb":3389794351757648,"pic84x84Id":18734578627472520,"pic56x56Id":18734578627472520,"pic96x96Id":1379887094138436,"picIPad":3402988502531526,"picPCWhite":1364493985405387,"pic56x56IdStr":"18734578627472519","pic96x96IdStr":"1379887094138436","pic84x84IdUrl":"https://p1.music.126.net/uAYWhAiyE6O50JYAXOEeqg==/18734578627472519.jpg","picPCWhiteStr":"1364493985405387","picPCBlackStr":"1364493985405387","picWebStr":"3389794351757648","picIPadStr":"3402988502531526","picPCWhiteUrl":"https://p1.music.126.net/gu-88pW79Rptye4BQJXFTg==/1364493985405387.jpg","picPCBlackUrl":"https://p1.music.126.net/gu-88pW79Rptye4BQJXFTg==/1364493985405387.jpg","picWebUrl":"https://p1.music.126.net/BVIacbDdjw90QjU4z7mZIw==/3389794351757648.jpg","picIPadUrl":"https://p1.music.126.net/CygRxT-NBOfnYP3V4F17ww==/3402988502531526.jpg","picMacId":"109951163921394792","picMacUrl":"https://p1.music.126.net/Dw8fttHm3NgU_NEq4IUYwg==/109951163921394792.jpg","picUWPId":"1420569034620543","picUWPUrl":"https://p1.music.126.net/Jx3cJ3EQe2k0HGsP0gpLhg==/1420569034620543.jpg","pic56x56Url":"https://p1.music.126.net/uAYWhAiyE6O50JYAXOEeqg==/18734578627472519.jpg","pic96x96Url":"https://p1.music.126.net/Gg5zLIvvJu4FOL19apWnpA==/1379887094138436.jpg","name":"3D|电子","id":10002}]
     * code : 200
     */
    var code = 0
    var categories: List<CategoriesBean>? = null

    class CategoriesBean {
        /**
         * picPCBlack : 18996262393228948
         * picWeb : 19119407695444320
         * pic84x84Id : 18734578627472516
         * pic56x56Id : 18734578627472516
         * pic96x96Id : 19131502323477870
         * picIPad : 19036944323358116
         * picPCWhite : 18996262393228948
         * pic56x56IdStr : 18734578627472515
         * pic96x96IdStr : 19131502323477870
         * pic84x84IdUrl : https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg
         * picPCWhiteStr : 18996262393228949
         * picPCBlackStr : 18996262393228949
         * picWebStr : 19119407695444318
         * picIPadStr : 19036944323358115
         * picPCWhiteUrl : https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg
         * picPCBlackUrl : https://p1.music.126.net/J2c_9ke1EMQ0EvqEXojzLQ==/18996262393228949.jpg
         * picWebUrl : https://p1.music.126.net/cCogGBNagepu5uAd-OuCKQ==/19119407695444318.jpg
         * picIPadUrl : https://p1.music.126.net/XQTJvk8i1vP21eCUUt8DwA==/19036944323358115.jpg
         * picMacId : 109951163921391989
         * picMacUrl : https://p1.music.126.net/vUL2pw5_gcmJ8C8n-H_K7g==/109951163921391989.jpg
         * picUWPId : 19082024300200583
         * picUWPUrl : https://p1.music.126.net/AYRhCEXW4StXLcS1Wa4j5g==/19082024300200583.jpg
         * pic56x56Url : https://p1.music.126.net/7wnqBKKPEme-Fw0WGok8bA==/18734578627472515.jpg
         * pic96x96Url : https://p1.music.126.net/d4y8InBC-g23wE9ZyC_hgA==/19131502323477870.jpg
         * name : 创作|翻唱
         * id : 2001
         */
        var picPCBlack: Long = 0
        var picWeb: Long = 0
        var pic84x84Id: Long = 0
        var pic56x56Id: Long = 0
        var pic96x96Id: Long = 0
        var picIPad: Long = 0
        var picPCWhite: Long = 0
        var pic56x56IdStr: String? = null
        var pic96x96IdStr: String? = null
        var pic84x84IdUrl: String? = null
        var picPCWhiteStr: String? = null
        var picPCBlackStr: String? = null
        var picWebStr: String? = null
        var picIPadStr: String? = null
        var picPCWhiteUrl: String? = null
        var picPCBlackUrl: String? = null
        var picWebUrl: String? = null
        var picIPadUrl: String? = null
        var picMacId: String? = null
        var picMacUrl: String? = null
        var picUWPId: String? = null
        var picUWPUrl: String? = null
        var pic56x56Url: String? = null
        var pic96x96Url: String? = null
        var name: String? = null
        var id = 0
    }
}
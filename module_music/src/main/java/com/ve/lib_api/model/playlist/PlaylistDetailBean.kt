package com.ve.lib_api.model.playlist

/**
 * 歌单详情的bean，里面包含了歌单的歌曲
 */
class PlaylistDetailBean {
    /**
     * playlist : {"subscribers":[{"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/S0eMy4iPCsUF3ExOHQhc8w==/109951164198686079.jpg","accountStatus":0,"gender":1,"city":440500,"birthday":1036373671290,"userId":556581045,"userType":0,"nickname":"LE-TRIOMPHANT","signature":"","description":"","detailDescription":"","avatarImgId":109951164198686080,"backgroundImgId":109951164198676500,"backgroundUrl":"http://p1.music.126.net/njFf4NliyjkcQoRL_FBi4Q==/109951164198676497.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164198686079","backgroundImgIdStr":"109951164198676497","avatarImgId_str":"109951164198686079"},{"defaultAvatar":false,"province":460000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/61OswjC8Qh3FqPeRJSw39A==/109951163449478697.jpg","accountStatus":0,"gender":2,"city":460100,"birthday":-2209017600000,"userId":452268583,"userType":0,"nickname":"光盐可颂","signature":"好听的遇上了也是三生有幸","description":"","detailDescription":"","avatarImgId":109951163449478700,"backgroundImgId":109951163007008960,"backgroundUrl":"http://p1.music.126.net/BkB32BMot5QZBSd9irUZOg==/109951163007008959.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163449478697","backgroundImgIdStr":"109951163007008959","avatarImgId_str":"109951163449478697"},{"defaultAvatar":false,"province":500000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/pwORf7nZcpo0M8Sba0Zhxw==/3245758326597684.jpg","accountStatus":0,"gender":0,"city":500101,"birthday":631123200000,"userId":48288417,"userType":0,"nickname":"阿阿阿阿超","signature":"","description":"","detailDescription":"","avatarImgId":3245758326597684,"backgroundImgId":2002210674180201,"backgroundUrl":"http://p1.music.126.net/o3G7lWrGBQAvSRt3UuApTw==/2002210674180201.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"3245758326597684","backgroundImgIdStr":"2002210674180201"},{"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/6nZjaVGt8KtHNgDOrh5Fkg==/109951163471310891.jpg","accountStatus":0,"gender":1,"city":1003100,"birthday":980784000000,"userId":104844666,"userType":0,"nickname":"源于极光的梦","signature":"等你 回来💓","description":"","detailDescription":"","avatarImgId":109951163471310900,"backgroundImgId":109951163471331700,"backgroundUrl":"http://p1.music.126.net/difVXdfwjlCJCy3BnQC5XA==/109951163471331692.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951163471310891","backgroundImgIdStr":"109951163471331692","avatarImgId_str":"109951163471310891"},{"defaultAvatar":false,"province":320000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/YZpRn5Wha5-Z9tJvWOr5YQ==/109951164187138711.jpg","accountStatus":0,"gender":2,"city":320500,"birthday":1002890550260,"userId":1529625206,"userType":0,"nickname":"生于俗世","signature":"","description":"","detailDescription":"","avatarImgId":109951164187138700,"backgroundImgId":109951164187129310,"backgroundUrl":"http://p1.music.126.net/HScBdyIFUOLSEoXoWWHJzA==/109951164187129312.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164187138711","backgroundImgIdStr":"109951164187129312","avatarImgId_str":"109951164187138711"},{"defaultAvatar":false,"province":520000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/Z8kxNC1VHBAZeCyQLNrhxA==/109951163799162022.jpg","accountStatus":0,"gender":2,"city":520100,"birthday":-2209017600000,"userId":1462180599,"userType":0,"nickname":"梦里梦见梦不见的180519","signature":"","description":"","detailDescription":"","avatarImgId":109951163799162020,"backgroundImgId":109951162868128400,"backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163799162022","backgroundImgIdStr":"109951162868128395","avatarImgId_str":"109951163799162022"},{"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/6MikfYCvRgZ7axP0EXRY3g==/109951163949560568.jpg","accountStatus":0,"gender":2,"city":441800,"birthday":1002043998842,"userId":1348658944,"userType":0,"nickname":"余生想请你指教呀","signature":"","description":"","detailDescription":"","avatarImgId":109951163949560580,"backgroundImgId":109951164084159380,"backgroundUrl":"http://p1.music.126.net/KOsXd33xtiAkxCDQ8QZIAQ==/109951164084159379.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163949560568","backgroundImgIdStr":"109951164084159379","avatarImgId_str":"109951163949560568"},{"defaultAvatar":false,"province":650000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/1rk9_Vn4xjtLZ58ozMtxOA==/18713687906674662.jpg","accountStatus":0,"gender":0,"city":650100,"birthday":-2209017600000,"userId":588367284,"userType":0,"nickname":"知无不为","signature":"","description":"","detailDescription":"","avatarImgId":18713687906674664,"backgroundImgId":109951162868128400,"backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"18713687906674662","backgroundImgIdStr":"109951162868128395","avatarImgId_str":"18713687906674662"}],"subscribed":false,"creator":{"defaultAvatar":false,"province":110000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/QWMV-Ru_6149AKe0mCBXKg==/1420569024374784.jpg","accountStatus":0,"gender":1,"city":110101,"birthday":-2209017600000,"userId":1,"userType":2,"nickname":"网易云音乐","signature":"网易云音乐是6亿人都在使用的音乐平台，致力于帮助用户发现音乐惊喜，帮助音乐人实现梦想。客服@云音乐客服 在线时间：9：00 - 24：00，如您在使用过程中遇到任何问题，欢迎私信咨询，我们会尽快回复。如果仍然不能解决您的问题，与活动相关的疑问请私信@云音乐客服","description":"网易云音乐官方账号","detailDescription":"网易云音乐官方账号","avatarImgId":1420569024374784,"backgroundImgId":2002210674180202,"backgroundUrl":"http://p1.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg","authority":3,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":11,"remarkName":null,"avatarImgIdStr":"1420569024374784","backgroundImgIdStr":"2002210674180202"},"tracks":[{"name":"dark HORSE","id":1234301,"pst":0,"t":0,"ar":[{"id":31286,"name":"The Shanghai Restoration Project","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":127441,"name":"Zodiac","picUrl":"http://p2.music.126.net/2UGeR7vME216HNPmKK-pxw==/816937139480821.jpg","tns":[],"pic":816937139480821},"dt":264661,"h":{"br":320000,"fid":0,"size":10586950,"vd":-0.27},"m":{"br":160000,"fid":0,"size":5293498,"vd":-2.65076E-4},"l":{"br":96000,"fid":0,"size":3176116,"vd":-2.65076E-4},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":412011,"mv":0,"publishTime":1232380800007,"alg":"alg_tag_based"},{"name":"Si Tu Vois Ma Mère","id":3781876,"pst":0,"t":0,"ar":[{"id":83170,"name":"Tina May","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":7,"crbt":null,"cf":"","al":{"id":382615,"name":"Jazz Piquant","picUrl":"http://p2.music.126.net/xGlZt7fSwKmAdinDvONuOQ==/644313813919894.jpg","tns":[],"pic":644313813919894},"dt":256000,"h":null,"m":{"br":192000,"fid":0,"size":6167239,"vd":15648},"l":{"br":128000,"fid":0,"size":4111507,"vd":16650},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":992275200007,"alg":"alg_tag_based"},{"name":"☁","id":863949788,"pst":0,"t":0,"ar":[{"id":12235146,"name":"FAT TIGER","tns":[],"alias":[]},{"id":12771007,"name":"Steve Tist","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":6,"crbt":null,"cf":"","al":{"id":71714657,"name":"☁","picUrl":"http://p2.music.126.net/9MDnkZmWi5SEJ1LPfa86oQ==/109951163386797534.jpg","tns":[],"pic_str":"109951163386797534","pic":109951163386797540},"dt":157455,"h":{"br":320000,"fid":0,"size":6300778,"vd":-14400},"m":{"br":192000,"fid":0,"size":3780484,"vd":-11900},"l":{"br":128000,"fid":0,"size":2520337,"vd":-10300},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1530489600000,"alg":"alg_tag_based"},{"name":"申请加入你的被窝","id":513193769,"pst":0,"t":0,"ar":[{"id":12395338,"name":"RRAN","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":null,"fee":8,"v":15,"crbt":null,"cf":"","al":{"id":36569425,"name":"申请加入你的被窝","picUrl":"http://p2.music.126.net/Pd94O0KOMBvqfZRIdYfM8w==/109951163043922920.jpg","tns":[],"pic_str":"109951163043922920","pic":109951163043922910},"dt":177293,"h":{"br":320000,"fid":0,"size":7093856,"vd":-2},"m":{"br":192000,"fid":0,"size":4256331,"vd":-2},"l":{"br":128000,"fid":0,"size":2837568,"vd":-2},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":1382818,"mv":0,"publishTime":1508061160772,"alg":"alg_tag_based"},{"name":"嘉 禾 天 橙 国 际 大 影 院","id":441437222,"pst":0,"t":0,"ar":[{"id":768266,"name":"ギャラクシー・騎士","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":15,"crbt":null,"cf":"","al":{"id":34993762,"name":"她 ，就 是 东 京","picUrl":"http://p2.music.126.net/M3ieCBkTn-bYYXvZLzcj-Q==/109951162809695511.jpg","tns":[],"pic_str":"109951162809695511","pic":109951162809695500},"dt":107075,"h":{"br":320000,"fid":0,"size":4285170,"vd":-8400},"m":{"br":192000,"fid":0,"size":2571120,"vd":-5700},"l":{"br":128000,"fid":0,"size":1714094,"vd":-4000},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1479228564980,"alg":"alg_tag_based"},{"name":"Wound Up","id":466126415,"pst":0,"t":0,"ar":[{"id":12273052,"name":"Jordyn Edmonds","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":4,"crbt":null,"cf":"","al":{"id":35287327,"name":"Wound Up","picUrl":"http://p2.music.126.net/tO-tTUqM2Pvbk7cA9uWnNg==/18784056650757999.jpg","tns":[],"pic_str":"18784056650757999","pic":18784056650758000},"dt":155245,"h":{"br":320000,"fid":0,"size":6210917,"vd":-3},"m":{"br":192000,"fid":0,"size":3726568,"vd":-2},"l":{"br":128000,"fid":0,"size":2484393,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1473264000007,"alg":"alg_tag_based"},{"name":"陈光荣 - First Date俩少无猜(allenvee Bootleg)","id":492256479,"pst":0,"t":0,"ar":[{"id":12259217,"name":"allenvee","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":26,"crbt":null,"cf":"","al":{"id":35810025,"name":"夜班车.(summer night in nanning)","picUrl":"http://p2.music.126.net/yo4vj2z8jJjyxJQsJM1VpA==/109951163060152521.jpg","tns":[],"pic_str":"109951163060152521","pic":109951163060152530},"dt":194514,"h":{"br":320000,"fid":0,"size":7783489,"vd":66800},"m":{"br":192000,"fid":0,"size":4670111,"vd":69300},"l":{"br":128000,"fid":0,"size":3113422,"vd":64018},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1500644498838,"alg":"alg_tag_based"},{"name":"So Cute~","id":433107530,"pst":0,"t":0,"ar":[{"id":12027465,"name":"Lopu$","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":10,"crbt":null,"cf":"","al":{"id":34901157,"name":"So Cute~（当山瞳-Cathy Lopurmx）","picUrl":"http://p2.music.126.net/yFCpD3GrgmcInAbVvVaFUg==/17999005346907556.jpg","tns":[],"pic_str":"17999005346907556","pic":17999005346907556},"dt":184267,"h":{"br":320000,"fid":0,"size":7372844,"vd":0},"m":{"br":192000,"fid":0,"size":4423724,"vd":0},"l":{"br":128000,"fid":0,"size":2949164,"vd":0},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1475515536761,"alg":"alg_tag_based"},{"name":"Espresso","id":547033571,"pst":0,"t":0,"ar":[{"id":12441401,"name":"Jazzinuf","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":8,"v":6,"crbt":null,"cf":"","al":{"id":38003212,"name":"The Harlem Barber Swing","picUrl":"http://p2.music.126.net/NQbd676jeFbse3HB6wKyaw==/109951163201374587.jpg","tns":[],"pic_str":"109951163201374587","pic":109951163201374600},"dt":91500,"h":{"br":320000,"fid":0,"size":3662411,"vd":-23599},"m":{"br":192000,"fid":0,"size":2197464,"vd":-20900},"l":{"br":128000,"fid":0,"size":1464991,"vd":-19100},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":1416200,"mv":0,"publishTime":1503676800007,"alg":"alg_tag_based"},{"name":"Tea For Two (feat. Beegie Adair)","id":22210176,"pst":0,"t":0,"ar":[{"id":155083,"name":"Jack Jezzro And Friends","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":2,"crbt":null,"cf":"","al":{"id":2042459,"name":"Rio Nights","picUrl":"http://p2.music.126.net/cI-YnYLuOtZ6qaSqRuZzHg==/885106860382035.jpg","tns":[],"pic":885106860382035},"dt":225000,"h":{"br":320000,"fid":0,"size":8989606,"vd":0.041984},"m":{"br":160000,"fid":0,"size":4513787,"vd":0.395072},"l":{"br":96000,"fid":0,"size":2723041,"vd":-2.65076E-4},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1266854400007,"alg":"alg_tag_based"},{"name":"Girlfriend","id":27672135,"pst":0,"t":0,"ar":[{"id":812023,"name":"Triathalon","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":2652842,"name":"Vibes","picUrl":"http://p2.music.126.net/8WpjmaMxRSsBTO9ifc8Gug==/109951164103571377.jpg","tns":[],"pic_str":"109951164103571377","pic":109951164103571380},"dt":253000,"h":null,"m":{"br":192000,"fid":0,"size":6073915,"vd":-8900},"l":{"br":128000,"fid":0,"size":4049321,"vd":-7100},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1362758400007,"alg":"alg_tag_based"},{"name":"Mondo Bongo","id":5048932,"pst":0,"t":0,"ar":[{"id":136571,"name":"Joe Strummer & The Mescaleros","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":39,"crbt":null,"cf":"","al":{"id":501057,"name":"Mr. & Mrs. Smith","picUrl":"http://p2.music.126.net/cqE_grxwx5V21ggoUrEs3w==/2544269907750724.jpg","tns":[],"pic":2544269907750724},"dt":374000,"h":{"br":320000,"fid":0,"size":15019508,"vd":2.23603},"m":{"br":160000,"fid":0,"size":7520799,"vd":2.65615},"l":{"br":96000,"fid":0,"size":4520897,"vd":2.14088},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":7002,"mv":394082,"publishTime":1118332800007,"alg":"alg_tag_based"},{"name":"你 向 我 索 求 的 都 會 給 你","id":537001563,"pst":0,"t":0,"ar":[{"id":12853998,"name":"别网恋","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":null,"fee":8,"v":10,"crbt":null,"cf":"","al":{"id":37543988,"name":"i'm in love with you sᴀᴇɴ. ʀᴇᴍɪx","picUrl":"http://p2.music.126.net/RIrKMaNKx4zTruk4hFYafA==/109951163139708223.jpg","tns":[],"pic_str":"109951163139708223","pic":109951163139708220},"dt":172408,"h":{"br":320000,"fid":0,"size":6898460,"vd":1794},"m":{"br":192000,"fid":0,"size":4139093,"vd":3582},"l":{"br":128000,"fid":0,"size":2759410,"vd":6096},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1518180647176,"alg":"alg_tag_based"},{"name":"Sex on the Beach","id":40249165,"pst":0,"t":0,"ar":[{"id":1185054,"name":"尚先生","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":"","fee":8,"v":34,"crbt":null,"cf":"","al":{"id":3440062,"name":"不打烊的小酒馆 壹","picUrl":"http://p2.music.126.net/k46cY96XTg2s539IHKjobw==/17698838672405377.jpg","tns":[],"pic_str":"17698838672405377","pic":17698838672405376},"dt":184058,"h":{"br":320000,"fid":0,"size":7364485,"vd":2.63},"m":{"br":160000,"fid":0,"size":3682265,"vd":3.05155},"l":{"br":96000,"fid":0,"size":2209377,"vd":1.62662},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1449936000000,"alg":"alg_tag_based"},{"name":"And The Winner Is","id":1383639,"pst":0,"t":0,"ar":[{"id":33899,"name":"Gérard Darmon","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":14,"crbt":null,"cf":"","al":{"id":141875,"name":"On S'Aime","picUrl":"http://p2.music.126.net/u9bYfwafB5JfJz0p-Kcd2g==/6664139976155607.jpg","tns":[],"pic":6664139976155607},"dt":232724,"h":{"br":320000,"fid":0,"size":9311129,"vd":-1},"m":{"br":192000,"fid":0,"size":5586695,"vd":-1},"l":{"br":128000,"fid":0,"size":3724478,"vd":-1},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":8192,"rtype":0,"rurl":null,"mst":9,"cp":7003,"mv":0,"publishTime":1228752000007,"alg":"alg_tag_based"},{"name":"as i sat alone","id":482636135,"pst":0,"t":0,"ar":[{"id":12040094,"name":"Vbnd","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":null,"fee":8,"v":36,"crbt":null,"cf":"","al":{"id":35590037,"name":"colors compilation","picUrl":"http://p2.music.126.net/Cvz4EeFDS9NU00eHwIFstA==/109951163463111510.jpg","tns":[],"pic_str":"109951163463111510","pic":109951163463111500},"dt":125184,"h":{"br":320000,"fid":0,"size":5010329,"vd":0},"m":{"br":192000,"fid":0,"size":3006215,"vd":0},"l":{"br":128000,"fid":0,"size":2004158,"vd":0},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":8320,"rtype":0,"rurl":null,"mst":9,"cp":743010,"mv":0,"publishTime":1510012800000,"alg":"alg_tag_based"},{"name":"@_@","id":461124107,"pst":0,"t":0,"ar":[{"id":12108345,"name":"IOAH","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":2,"crbt":null,"cf":"","al":{"id":35188431,"name":"@_@","picUrl":"http://p2.music.126.net/5R70EdQJ6dms-8ftIpeg0A==/18814842976297331.jpg","tns":[],"pic_str":"18814842976297331","pic":18814842976297332},"dt":164597,"h":null,"m":null,"l":{"br":96000,"fid":0,"size":1975529,"vd":-2.65076E-4},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1456675200007,"alg":"alg_tag_based"},{"name":"Sunny Day","id":2786189,"pst":0,"t":0,"ar":[{"id":61047,"name":"Joy Williams","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":280872,"name":"Songs from This - EP","picUrl":"http://p2.music.126.net/DuT0q1Y9XtN5lCQoy6t9Bw==/1708641069569258.jpg","tns":[],"pic":1708641069569258},"dt":158929,"h":{"br":320000,"fid":0,"size":6393274,"vd":-1.83},"m":{"br":160000,"fid":0,"size":3217830,"vd":-1.4},"l":{"br":96000,"fid":0,"size":1947234,"vd":-1.48},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1252944000007,"alg":"alg_tag_based"},{"name":"if","id":557244721,"pst":0,"t":0,"ar":[{"id":12020017,"name":"阿克江Akin","tns":[],"alias":[]},{"id":789949,"name":"VISUDY","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":17,"crbt":null,"cf":"","al":{"id":38534820,"name":"心碎男孩俱乐部","picUrl":"http://p2.music.126.net/5Rlyg7hXYuywrI3dwGheaA==/109951163279429355.jpg","tns":[],"pic_str":"109951163279429355","pic":109951163279429360},"dt":338000,"h":{"br":320000,"fid":0,"size":13523113,"vd":-9200},"m":{"br":192000,"fid":0,"size":8113885,"vd":-6500},"l":{"br":128000,"fid":0,"size":5409271,"vd":-4600},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":5903039,"publishTime":1525305600000,"alg":"alg_tag_based"},{"name":"午夜心碎俱乐部2.0","id":565794655,"pst":0,"t":0,"ar":[{"id":12114249,"name":"大D(DLyn)","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":8,"v":13,"crbt":null,"cf":"","al":{"id":39112625,"name":"午夜心碎俱乐部2.0","picUrl":"http://p2.music.126.net/NSg1X6Qpc-oi5WAMg3U3ag==/109951163311151254.jpg","tns":[],"pic_str":"109951163311151254","pic":109951163311151250},"dt":154174,"h":{"br":320000,"fid":0,"size":6169121,"vd":-2},"m":{"br":192000,"fid":0,"size":3701490,"vd":-2},"l":{"br":128000,"fid":0,"size":2467675,"vd":-2},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1526918400000,"alg":"alg_tag_based"}],"trackIds":[{"id":1234301,"v":-10000,"alg":"alg_tag_based"},{"id":3781876,"v":-10000,"alg":"alg_tag_based"},{"id":863949788,"v":-10000,"alg":"alg_tag_based"},{"id":513193769,"v":-10000,"alg":"alg_tag_based"},{"id":441437222,"v":-10000,"alg":"alg_tag_based"},{"id":466126415,"v":-10000,"alg":"alg_tag_based"},{"id":492256479,"v":-10000,"alg":"alg_tag_based"},{"id":433107530,"v":-10000,"alg":"alg_tag_based"},{"id":547033571,"v":-10000,"alg":"alg_tag_based"},{"id":22210176,"v":-10000,"alg":"alg_tag_based"},{"id":27672135,"v":-10000,"alg":"alg_tag_based"},{"id":5048932,"v":-10000,"alg":"alg_tag_based"},{"id":537001563,"v":-10000,"alg":"alg_tag_based"},{"id":40249165,"v":-10000,"alg":"alg_tag_based"},{"id":1383639,"v":-10000,"alg":"alg_tag_based"},{"id":482636135,"v":-10000,"alg":"alg_tag_based"},{"id":461124107,"v":-10000,"alg":"alg_tag_based"},{"id":2786189,"v":-10000,"alg":"alg_tag_based"},{"id":557244721,"v":-10000,"alg":"alg_tag_based"},{"id":565794655,"v":-10000,"alg":"alg_tag_based"}],"updateFrequency":"每日更新","backgroundCoverId":109951164173101600,"backgroundCoverUrl":"http://p1.music.126.net/fLUeGxU2ybh2zImBiFfHBA==/109951164173101598.jpg","cloudTrackCount":0,"subscribedCount":4056,"trackNumberUpdateTime":1563400800000,"createTime":1559732650146,"highQuality":false,"userId":1,"updateTime":0,"coverImgId":109951164170712420,"coverImgUrl":"http://p2.music.126.net/xKyXkJ9ZIqov2Frl8C6qwg==/109951164170712411.jpg","specialType":100,"trackCount":20,"commentThreadId":"A_PL_0_2829827274","trackUpdateTime":1563415480405,"privacy":0,"newImported":false,"playCount":403895,"adType":0,"tags":["下午茶"],"ordered":false,"description":"一杯茶，一块甜点\n搭配着闲适的音乐\n都是生活中触手可及的小确幸\n收藏一下午的好时光，来杯下午茶，每日更新～","status":0,"name":"[来杯下午茶] 忙碌之余来点音乐犒劳自己","id":2829827274,"shareCount":44,"commentCount":32}
     * code : 200
     * privileges : [{"id":1234301,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false},{"id":3781876,"fee":0,"payed":0,"st":0,"pl":192000,"dl":192000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":192000,"fl":999000,"toast":false,"flag":128,"preSell":false},{"id":863949788,"fee":0,"payed":0,"st":0,"pl":999000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":999000,"toast":false,"flag":130,"preSell":false},{"id":513193769,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":2,"preSell":false},{"id":441437222,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":999000,"toast":false,"flag":2,"preSell":false},{"id":466126415,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":999000,"toast":false,"flag":128,"preSell":false},{"id":492256479,"fee":0,"payed":0,"st":0,"pl":999000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":999000,"toast":false,"flag":130,"preSell":false},{"id":433107530,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":999000,"toast":false,"flag":130,"preSell":false},{"id":547033571,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":64,"preSell":false},{"id":22210176,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":999000,"toast":false,"flag":128,"preSell":false},{"id":27672135,"fee":0,"payed":0,"st":0,"pl":192000,"dl":192000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":192000,"fl":999000,"toast":false,"flag":128,"preSell":false},{"id":5048932,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":256,"preSell":false},{"id":537001563,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":66,"preSell":false},{"id":40249165,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":64,"preSell":false},{"id":1383639,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":4,"preSell":false},{"id":482636135,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":5,"preSell":false},{"id":461124107,"fee":0,"payed":0,"st":0,"pl":128000,"dl":128000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":128000,"fl":999000,"toast":false,"flag":128,"preSell":false},{"id":2786189,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":999000,"toast":false,"flag":128,"preSell":false},{"id":557244721,"fee":0,"payed":0,"st":0,"pl":999000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":999000,"toast":false,"flag":66,"preSell":false},{"id":565794655,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":64,"preSell":false}]
     */
    var playlist: PlaylistBean? = null
    var code = 0
    var privileges: List<PrivilegesBean>? = null

    class PlaylistBean {
        /**
         * subscribers : [{"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/S0eMy4iPCsUF3ExOHQhc8w==/109951164198686079.jpg","accountStatus":0,"gender":1,"city":440500,"birthday":1036373671290,"userId":556581045,"userType":0,"nickname":"LE-TRIOMPHANT","signature":"","description":"","detailDescription":"","avatarImgId":109951164198686080,"backgroundImgId":109951164198676500,"backgroundUrl":"http://p1.music.126.net/njFf4NliyjkcQoRL_FBi4Q==/109951164198676497.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164198686079","backgroundImgIdStr":"109951164198676497","avatarImgId_str":"109951164198686079"},{"defaultAvatar":false,"province":460000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/61OswjC8Qh3FqPeRJSw39A==/109951163449478697.jpg","accountStatus":0,"gender":2,"city":460100,"birthday":-2209017600000,"userId":452268583,"userType":0,"nickname":"光盐可颂","signature":"好听的遇上了也是三生有幸","description":"","detailDescription":"","avatarImgId":109951163449478700,"backgroundImgId":109951163007008960,"backgroundUrl":"http://p1.music.126.net/BkB32BMot5QZBSd9irUZOg==/109951163007008959.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163449478697","backgroundImgIdStr":"109951163007008959","avatarImgId_str":"109951163449478697"},{"defaultAvatar":false,"province":500000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/pwORf7nZcpo0M8Sba0Zhxw==/3245758326597684.jpg","accountStatus":0,"gender":0,"city":500101,"birthday":631123200000,"userId":48288417,"userType":0,"nickname":"阿阿阿阿超","signature":"","description":"","detailDescription":"","avatarImgId":3245758326597684,"backgroundImgId":2002210674180201,"backgroundUrl":"http://p1.music.126.net/o3G7lWrGBQAvSRt3UuApTw==/2002210674180201.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"3245758326597684","backgroundImgIdStr":"2002210674180201"},{"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/6nZjaVGt8KtHNgDOrh5Fkg==/109951163471310891.jpg","accountStatus":0,"gender":1,"city":1003100,"birthday":980784000000,"userId":104844666,"userType":0,"nickname":"源于极光的梦","signature":"等你 回来💓","description":"","detailDescription":"","avatarImgId":109951163471310900,"backgroundImgId":109951163471331700,"backgroundUrl":"http://p1.music.126.net/difVXdfwjlCJCy3BnQC5XA==/109951163471331692.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":11,"remarkName":null,"avatarImgIdStr":"109951163471310891","backgroundImgIdStr":"109951163471331692","avatarImgId_str":"109951163471310891"},{"defaultAvatar":false,"province":320000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/YZpRn5Wha5-Z9tJvWOr5YQ==/109951164187138711.jpg","accountStatus":0,"gender":2,"city":320500,"birthday":1002890550260,"userId":1529625206,"userType":0,"nickname":"生于俗世","signature":"","description":"","detailDescription":"","avatarImgId":109951164187138700,"backgroundImgId":109951164187129310,"backgroundUrl":"http://p1.music.126.net/HScBdyIFUOLSEoXoWWHJzA==/109951164187129312.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951164187138711","backgroundImgIdStr":"109951164187129312","avatarImgId_str":"109951164187138711"},{"defaultAvatar":false,"province":520000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/Z8kxNC1VHBAZeCyQLNrhxA==/109951163799162022.jpg","accountStatus":0,"gender":2,"city":520100,"birthday":-2209017600000,"userId":1462180599,"userType":0,"nickname":"梦里梦见梦不见的180519","signature":"","description":"","detailDescription":"","avatarImgId":109951163799162020,"backgroundImgId":109951162868128400,"backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163799162022","backgroundImgIdStr":"109951162868128395","avatarImgId_str":"109951163799162022"},{"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/6MikfYCvRgZ7axP0EXRY3g==/109951163949560568.jpg","accountStatus":0,"gender":2,"city":441800,"birthday":1002043998842,"userId":1348658944,"userType":0,"nickname":"余生想请你指教呀","signature":"","description":"","detailDescription":"","avatarImgId":109951163949560580,"backgroundImgId":109951164084159380,"backgroundUrl":"http://p1.music.126.net/KOsXd33xtiAkxCDQ8QZIAQ==/109951164084159379.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163949560568","backgroundImgIdStr":"109951164084159379","avatarImgId_str":"109951163949560568"},{"defaultAvatar":false,"province":650000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/1rk9_Vn4xjtLZ58ozMtxOA==/18713687906674662.jpg","accountStatus":0,"gender":0,"city":650100,"birthday":-2209017600000,"userId":588367284,"userType":0,"nickname":"知无不为","signature":"","description":"","detailDescription":"","avatarImgId":18713687906674664,"backgroundImgId":109951162868128400,"backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"18713687906674662","backgroundImgIdStr":"109951162868128395","avatarImgId_str":"18713687906674662"}]
         * subscribed : false
         * creator : {"defaultAvatar":false,"province":110000,"authStatus":1,"followed":false,"avatarUrl":"http://p1.music.126.net/QWMV-Ru_6149AKe0mCBXKg==/1420569024374784.jpg","accountStatus":0,"gender":1,"city":110101,"birthday":-2209017600000,"userId":1,"userType":2,"nickname":"网易云音乐","signature":"网易云音乐是6亿人都在使用的音乐平台，致力于帮助用户发现音乐惊喜，帮助音乐人实现梦想。客服@云音乐客服 在线时间：9：00 - 24：00，如您在使用过程中遇到任何问题，欢迎私信咨询，我们会尽快回复。如果仍然不能解决您的问题，与活动相关的疑问请私信@云音乐客服","description":"网易云音乐官方账号","detailDescription":"网易云音乐官方账号","avatarImgId":1420569024374784,"backgroundImgId":2002210674180202,"backgroundUrl":"http://p1.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg","authority":3,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":11,"remarkName":null,"avatarImgIdStr":"1420569024374784","backgroundImgIdStr":"2002210674180202"}
         * tracks : [{"name":"dark HORSE","id":1234301,"pst":0,"t":0,"ar":[{"id":31286,"name":"The Shanghai Restoration Project","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":127441,"name":"Zodiac","picUrl":"http://p2.music.126.net/2UGeR7vME216HNPmKK-pxw==/816937139480821.jpg","tns":[],"pic":816937139480821},"dt":264661,"h":{"br":320000,"fid":0,"size":10586950,"vd":-0.27},"m":{"br":160000,"fid":0,"size":5293498,"vd":-2.65076E-4},"l":{"br":96000,"fid":0,"size":3176116,"vd":-2.65076E-4},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":412011,"mv":0,"publishTime":1232380800007,"alg":"alg_tag_based"},{"name":"Si Tu Vois Ma Mère","id":3781876,"pst":0,"t":0,"ar":[{"id":83170,"name":"Tina May","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":7,"crbt":null,"cf":"","al":{"id":382615,"name":"Jazz Piquant","picUrl":"http://p2.music.126.net/xGlZt7fSwKmAdinDvONuOQ==/644313813919894.jpg","tns":[],"pic":644313813919894},"dt":256000,"h":null,"m":{"br":192000,"fid":0,"size":6167239,"vd":15648},"l":{"br":128000,"fid":0,"size":4111507,"vd":16650},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":992275200007,"alg":"alg_tag_based"},{"name":"☁","id":863949788,"pst":0,"t":0,"ar":[{"id":12235146,"name":"FAT TIGER","tns":[],"alias":[]},{"id":12771007,"name":"Steve Tist","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":6,"crbt":null,"cf":"","al":{"id":71714657,"name":"☁","picUrl":"http://p2.music.126.net/9MDnkZmWi5SEJ1LPfa86oQ==/109951163386797534.jpg","tns":[],"pic_str":"109951163386797534","pic":109951163386797540},"dt":157455,"h":{"br":320000,"fid":0,"size":6300778,"vd":-14400},"m":{"br":192000,"fid":0,"size":3780484,"vd":-11900},"l":{"br":128000,"fid":0,"size":2520337,"vd":-10300},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1530489600000,"alg":"alg_tag_based"},{"name":"申请加入你的被窝","id":513193769,"pst":0,"t":0,"ar":[{"id":12395338,"name":"RRAN","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":null,"fee":8,"v":15,"crbt":null,"cf":"","al":{"id":36569425,"name":"申请加入你的被窝","picUrl":"http://p2.music.126.net/Pd94O0KOMBvqfZRIdYfM8w==/109951163043922920.jpg","tns":[],"pic_str":"109951163043922920","pic":109951163043922910},"dt":177293,"h":{"br":320000,"fid":0,"size":7093856,"vd":-2},"m":{"br":192000,"fid":0,"size":4256331,"vd":-2},"l":{"br":128000,"fid":0,"size":2837568,"vd":-2},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":1382818,"mv":0,"publishTime":1508061160772,"alg":"alg_tag_based"},{"name":"嘉 禾 天 橙 国 际 大 影 院","id":441437222,"pst":0,"t":0,"ar":[{"id":768266,"name":"ギャラクシー・騎士","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":15,"crbt":null,"cf":"","al":{"id":34993762,"name":"她 ，就 是 东 京","picUrl":"http://p2.music.126.net/M3ieCBkTn-bYYXvZLzcj-Q==/109951162809695511.jpg","tns":[],"pic_str":"109951162809695511","pic":109951162809695500},"dt":107075,"h":{"br":320000,"fid":0,"size":4285170,"vd":-8400},"m":{"br":192000,"fid":0,"size":2571120,"vd":-5700},"l":{"br":128000,"fid":0,"size":1714094,"vd":-4000},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1479228564980,"alg":"alg_tag_based"},{"name":"Wound Up","id":466126415,"pst":0,"t":0,"ar":[{"id":12273052,"name":"Jordyn Edmonds","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":4,"crbt":null,"cf":"","al":{"id":35287327,"name":"Wound Up","picUrl":"http://p2.music.126.net/tO-tTUqM2Pvbk7cA9uWnNg==/18784056650757999.jpg","tns":[],"pic_str":"18784056650757999","pic":18784056650758000},"dt":155245,"h":{"br":320000,"fid":0,"size":6210917,"vd":-3},"m":{"br":192000,"fid":0,"size":3726568,"vd":-2},"l":{"br":128000,"fid":0,"size":2484393,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1473264000007,"alg":"alg_tag_based"},{"name":"陈光荣 - First Date俩少无猜(allenvee Bootleg)","id":492256479,"pst":0,"t":0,"ar":[{"id":12259217,"name":"allenvee","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":26,"crbt":null,"cf":"","al":{"id":35810025,"name":"夜班车.(summer night in nanning)","picUrl":"http://p2.music.126.net/yo4vj2z8jJjyxJQsJM1VpA==/109951163060152521.jpg","tns":[],"pic_str":"109951163060152521","pic":109951163060152530},"dt":194514,"h":{"br":320000,"fid":0,"size":7783489,"vd":66800},"m":{"br":192000,"fid":0,"size":4670111,"vd":69300},"l":{"br":128000,"fid":0,"size":3113422,"vd":64018},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1500644498838,"alg":"alg_tag_based"},{"name":"So Cute~","id":433107530,"pst":0,"t":0,"ar":[{"id":12027465,"name":"Lopu$","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":10,"crbt":null,"cf":"","al":{"id":34901157,"name":"So Cute~（当山瞳-Cathy Lopurmx）","picUrl":"http://p2.music.126.net/yFCpD3GrgmcInAbVvVaFUg==/17999005346907556.jpg","tns":[],"pic_str":"17999005346907556","pic":17999005346907556},"dt":184267,"h":{"br":320000,"fid":0,"size":7372844,"vd":0},"m":{"br":192000,"fid":0,"size":4423724,"vd":0},"l":{"br":128000,"fid":0,"size":2949164,"vd":0},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1475515536761,"alg":"alg_tag_based"},{"name":"Espresso","id":547033571,"pst":0,"t":0,"ar":[{"id":12441401,"name":"Jazzinuf","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":8,"v":6,"crbt":null,"cf":"","al":{"id":38003212,"name":"The Harlem Barber Swing","picUrl":"http://p2.music.126.net/NQbd676jeFbse3HB6wKyaw==/109951163201374587.jpg","tns":[],"pic_str":"109951163201374587","pic":109951163201374600},"dt":91500,"h":{"br":320000,"fid":0,"size":3662411,"vd":-23599},"m":{"br":192000,"fid":0,"size":2197464,"vd":-20900},"l":{"br":128000,"fid":0,"size":1464991,"vd":-19100},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":1416200,"mv":0,"publishTime":1503676800007,"alg":"alg_tag_based"},{"name":"Tea For Two (feat. Beegie Adair)","id":22210176,"pst":0,"t":0,"ar":[{"id":155083,"name":"Jack Jezzro And Friends","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":2,"crbt":null,"cf":"","al":{"id":2042459,"name":"Rio Nights","picUrl":"http://p2.music.126.net/cI-YnYLuOtZ6qaSqRuZzHg==/885106860382035.jpg","tns":[],"pic":885106860382035},"dt":225000,"h":{"br":320000,"fid":0,"size":8989606,"vd":0.041984},"m":{"br":160000,"fid":0,"size":4513787,"vd":0.395072},"l":{"br":96000,"fid":0,"size":2723041,"vd":-2.65076E-4},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1266854400007,"alg":"alg_tag_based"},{"name":"Girlfriend","id":27672135,"pst":0,"t":0,"ar":[{"id":812023,"name":"Triathalon","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":2652842,"name":"Vibes","picUrl":"http://p2.music.126.net/8WpjmaMxRSsBTO9ifc8Gug==/109951164103571377.jpg","tns":[],"pic_str":"109951164103571377","pic":109951164103571380},"dt":253000,"h":null,"m":{"br":192000,"fid":0,"size":6073915,"vd":-8900},"l":{"br":128000,"fid":0,"size":4049321,"vd":-7100},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1362758400007,"alg":"alg_tag_based"},{"name":"Mondo Bongo","id":5048932,"pst":0,"t":0,"ar":[{"id":136571,"name":"Joe Strummer & The Mescaleros","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":39,"crbt":null,"cf":"","al":{"id":501057,"name":"Mr. & Mrs. Smith","picUrl":"http://p2.music.126.net/cqE_grxwx5V21ggoUrEs3w==/2544269907750724.jpg","tns":[],"pic":2544269907750724},"dt":374000,"h":{"br":320000,"fid":0,"size":15019508,"vd":2.23603},"m":{"br":160000,"fid":0,"size":7520799,"vd":2.65615},"l":{"br":96000,"fid":0,"size":4520897,"vd":2.14088},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":7002,"mv":394082,"publishTime":1118332800007,"alg":"alg_tag_based"},{"name":"你 向 我 索 求 的 都 會 給 你","id":537001563,"pst":0,"t":0,"ar":[{"id":12853998,"name":"别网恋","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":null,"fee":8,"v":10,"crbt":null,"cf":"","al":{"id":37543988,"name":"i'm in love with you sᴀᴇɴ. ʀᴇᴍɪx","picUrl":"http://p2.music.126.net/RIrKMaNKx4zTruk4hFYafA==/109951163139708223.jpg","tns":[],"pic_str":"109951163139708223","pic":109951163139708220},"dt":172408,"h":{"br":320000,"fid":0,"size":6898460,"vd":1794},"m":{"br":192000,"fid":0,"size":4139093,"vd":3582},"l":{"br":128000,"fid":0,"size":2759410,"vd":6096},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1518180647176,"alg":"alg_tag_based"},{"name":"Sex on the Beach","id":40249165,"pst":0,"t":0,"ar":[{"id":1185054,"name":"尚先生","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":"","fee":8,"v":34,"crbt":null,"cf":"","al":{"id":3440062,"name":"不打烊的小酒馆 壹","picUrl":"http://p2.music.126.net/k46cY96XTg2s539IHKjobw==/17698838672405377.jpg","tns":[],"pic_str":"17698838672405377","pic":17698838672405376},"dt":184058,"h":{"br":320000,"fid":0,"size":7364485,"vd":2.63},"m":{"br":160000,"fid":0,"size":3682265,"vd":3.05155},"l":{"br":96000,"fid":0,"size":2209377,"vd":1.62662},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1449936000000,"alg":"alg_tag_based"},{"name":"And The Winner Is","id":1383639,"pst":0,"t":0,"ar":[{"id":33899,"name":"Gérard Darmon","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":14,"crbt":null,"cf":"","al":{"id":141875,"name":"On S'Aime","picUrl":"http://p2.music.126.net/u9bYfwafB5JfJz0p-Kcd2g==/6664139976155607.jpg","tns":[],"pic":6664139976155607},"dt":232724,"h":{"br":320000,"fid":0,"size":9311129,"vd":-1},"m":{"br":192000,"fid":0,"size":5586695,"vd":-1},"l":{"br":128000,"fid":0,"size":3724478,"vd":-1},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":8192,"rtype":0,"rurl":null,"mst":9,"cp":7003,"mv":0,"publishTime":1228752000007,"alg":"alg_tag_based"},{"name":"as i sat alone","id":482636135,"pst":0,"t":0,"ar":[{"id":12040094,"name":"Vbnd","tns":[],"alias":[]}],"alia":[],"pop":95,"st":0,"rt":null,"fee":8,"v":36,"crbt":null,"cf":"","al":{"id":35590037,"name":"colors compilation","picUrl":"http://p2.music.126.net/Cvz4EeFDS9NU00eHwIFstA==/109951163463111510.jpg","tns":[],"pic_str":"109951163463111510","pic":109951163463111500},"dt":125184,"h":{"br":320000,"fid":0,"size":5010329,"vd":0},"m":{"br":192000,"fid":0,"size":3006215,"vd":0},"l":{"br":128000,"fid":0,"size":2004158,"vd":0},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":8320,"rtype":0,"rurl":null,"mst":9,"cp":743010,"mv":0,"publishTime":1510012800000,"alg":"alg_tag_based"},{"name":"@_@","id":461124107,"pst":0,"t":0,"ar":[{"id":12108345,"name":"IOAH","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":2,"crbt":null,"cf":"","al":{"id":35188431,"name":"@_@","picUrl":"http://p2.music.126.net/5R70EdQJ6dms-8ftIpeg0A==/18814842976297331.jpg","tns":[],"pic_str":"18814842976297331","pic":18814842976297332},"dt":164597,"h":null,"m":null,"l":{"br":96000,"fid":0,"size":1975529,"vd":-2.65076E-4},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1456675200007,"alg":"alg_tag_based"},{"name":"Sunny Day","id":2786189,"pst":0,"t":0,"ar":[{"id":61047,"name":"Joy Williams","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":280872,"name":"Songs from This - EP","picUrl":"http://p2.music.126.net/DuT0q1Y9XtN5lCQoy6t9Bw==/1708641069569258.jpg","tns":[],"pic":1708641069569258},"dt":158929,"h":{"br":320000,"fid":0,"size":6393274,"vd":-1.83},"m":{"br":160000,"fid":0,"size":3217830,"vd":-1.4},"l":{"br":96000,"fid":0,"size":1947234,"vd":-1.48},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1252944000007,"alg":"alg_tag_based"},{"name":"if","id":557244721,"pst":0,"t":0,"ar":[{"id":12020017,"name":"阿克江Akin","tns":[],"alias":[]},{"id":789949,"name":"VISUDY","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":0,"v":17,"crbt":null,"cf":"","al":{"id":38534820,"name":"心碎男孩俱乐部","picUrl":"http://p2.music.126.net/5Rlyg7hXYuywrI3dwGheaA==/109951163279429355.jpg","tns":[],"pic_str":"109951163279429355","pic":109951163279429360},"dt":338000,"h":{"br":320000,"fid":0,"size":13523113,"vd":-9200},"m":{"br":192000,"fid":0,"size":8113885,"vd":-6500},"l":{"br":128000,"fid":0,"size":5409271,"vd":-4600},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":64,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":5903039,"publishTime":1525305600000,"alg":"alg_tag_based"},{"name":"午夜心碎俱乐部2.0","id":565794655,"pst":0,"t":0,"ar":[{"id":12114249,"name":"大D(DLyn)","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":null,"fee":8,"v":13,"crbt":null,"cf":"","al":{"id":39112625,"name":"午夜心碎俱乐部2.0","picUrl":"http://p2.music.126.net/NSg1X6Qpc-oi5WAMg3U3ag==/109951163311151254.jpg","tns":[],"pic_str":"109951163311151254","pic":109951163311151250},"dt":154174,"h":{"br":320000,"fid":0,"size":6169121,"vd":-2},"m":{"br":192000,"fid":0,"size":3701490,"vd":-2},"l":{"br":128000,"fid":0,"size":2467675,"vd":-2},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1526918400000,"alg":"alg_tag_based"}]
         * trackIds : [{"id":1234301,"v":-10000,"alg":"alg_tag_based"},{"id":3781876,"v":-10000,"alg":"alg_tag_based"},{"id":863949788,"v":-10000,"alg":"alg_tag_based"},{"id":513193769,"v":-10000,"alg":"alg_tag_based"},{"id":441437222,"v":-10000,"alg":"alg_tag_based"},{"id":466126415,"v":-10000,"alg":"alg_tag_based"},{"id":492256479,"v":-10000,"alg":"alg_tag_based"},{"id":433107530,"v":-10000,"alg":"alg_tag_based"},{"id":547033571,"v":-10000,"alg":"alg_tag_based"},{"id":22210176,"v":-10000,"alg":"alg_tag_based"},{"id":27672135,"v":-10000,"alg":"alg_tag_based"},{"id":5048932,"v":-10000,"alg":"alg_tag_based"},{"id":537001563,"v":-10000,"alg":"alg_tag_based"},{"id":40249165,"v":-10000,"alg":"alg_tag_based"},{"id":1383639,"v":-10000,"alg":"alg_tag_based"},{"id":482636135,"v":-10000,"alg":"alg_tag_based"},{"id":461124107,"v":-10000,"alg":"alg_tag_based"},{"id":2786189,"v":-10000,"alg":"alg_tag_based"},{"id":557244721,"v":-10000,"alg":"alg_tag_based"},{"id":565794655,"v":-10000,"alg":"alg_tag_based"}]
         * updateFrequency : 每日更新
         * backgroundCoverId : 109951164173101600
         * backgroundCoverUrl : http://p1.music.126.net/fLUeGxU2ybh2zImBiFfHBA==/109951164173101598.jpg
         * cloudTrackCount : 0
         * subscribedCount : 4056
         * trackNumberUpdateTime : 1563400800000
         * createTime : 1559732650146
         * highQuality : false
         * userId : 1
         * updateTime : 0
         * coverImgId : 109951164170712420
         * coverImgUrl : http://p2.music.126.net/xKyXkJ9ZIqov2Frl8C6qwg==/109951164170712411.jpg
         * specialType : 100
         * trackCount : 20
         * commentThreadId : A_PL_0_2829827274
         * trackUpdateTime : 1563415480405
         * privacy : 0
         * newImported : false
         * playCount : 403895
         * adType : 0
         * tags : ["下午茶"]
         * ordered : false
         * description : 一杯茶，一块甜点
         * 搭配着闲适的音乐
         * 都是生活中触手可及的小确幸
         * 收藏一下午的好时光，来杯下午茶，每日更新～
         * status : 0
         * name : [来杯下午茶] 忙碌之余来点音乐犒劳自己
         * id : 2829827274
         * shareCount : 44
         * commentCount : 32
         */
        var isSubscribed = false
        var creator: CreatorBean? = null
        var updateFrequency: String? = null
        var backgroundCoverId: Long = 0
        var backgroundCoverUrl: String? = null
        var cloudTrackCount = 0
        private var subscribedCount = 0
        var trackNumberUpdateTime: Long = 0
        var createTime: Long = 0
        var isHighQuality = false
        var userId = 0
        var updateTime: Long = 0
        var coverImgId: Long = 0
        var coverImgUrl: String? = null
        var specialType = 0
        var trackCount = 0
        var commentThreadId: String? = null
        var trackUpdateTime: Long = 0
        var privacy = 0
        var isNewImported = false
        private var playCount: Long = 0
        var adType = 0
        var isOrdered = false
        var description: String? = null
        var status = 0
        var name: String? = null
        var id: Long = 0
        private var shareCount = 0
        private var commentCount = 0
        var subscribers: List<SubscribersBean>? = null
        var tracks: List<TracksBean>? = null
        var trackIds: List<TrackIdsBean>? = null
        var tags: List<String>? = null
        fun getSubscribedCount(): String {
            return subscribedCount.toString()
        }

        fun setSubscribedCount(subscribedCount: Int) {
            this.subscribedCount = subscribedCount
        }

        fun getPlayCount(): String {
            return playCount.toString()
        }

        fun setPlayCount(playCount: Long) {
            this.playCount = playCount
        }

        fun getShareCount(): String {
            return shareCount.toString()
        }

        fun setShareCount(shareCount: Int) {
            this.shareCount = shareCount
        }

        fun getCommentCount(): String {
            return commentCount.toString()
        }

        fun setCommentCount(commentCount: Int) {
            this.commentCount = commentCount
        }

        class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 110000
             * authStatus : 1
             * followed : false
             * avatarUrl : http://p1.music.126.net/QWMV-Ru_6149AKe0mCBXKg==/1420569024374784.jpg
             * accountStatus : 0
             * gender : 1
             * city : 110101
             * birthday : -2209017600000
             * userId : 1
             * userType : 2
             * nickname : 网易云音乐
             * signature : 网易云音乐是6亿人都在使用的音乐平台，致力于帮助用户发现音乐惊喜，帮助音乐人实现梦想。客服@云音乐客服 在线时间：9：00 - 24：00，如您在使用过程中遇到任何问题，欢迎私信咨询，我们会尽快回复。如果仍然不能解决您的问题，与活动相关的疑问请私信@云音乐客服
             * description : 网易云音乐官方账号
             * detailDescription : 网易云音乐官方账号
             * avatarImgId : 1420569024374784
             * backgroundImgId : 2002210674180202
             * backgroundUrl : http://p1.music.126.net/pmHS4fcQtcNEGewNb5HRhg==/2002210674180202.jpg
             * authority : 3
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 10
             * vipType : 11
             * remarkName : null
             * avatarImgIdStr : 1420569024374784
             * backgroundImgIdStr : 2002210674180202
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
            var experts: Any? = null
            var djStatus = 0
            var vipType = 0
            var remarkName: Any? = null
            var avatarImgIdStr: String? = null
            var backgroundImgIdStr: String? = null
        }

        class SubscribersBean {
            /**
             * defaultAvatar : false
             * province : 440000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/S0eMy4iPCsUF3ExOHQhc8w==/109951164198686079.jpg
             * accountStatus : 0
             * gender : 1
             * city : 440500
             * birthday : 1036373671290
             * userId : 556581045
             * userType : 0
             * nickname : LE-TRIOMPHANT
             * signature :
             * description :
             * detailDescription :
             * avatarImgId : 109951164198686080
             * backgroundImgId : 109951164198676500
             * backgroundUrl : http://p1.music.126.net/njFf4NliyjkcQoRL_FBi4Q==/109951164198676497.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 109951164198686079
             * backgroundImgIdStr : 109951164198676497
             * avatarImgId_str : 109951164198686079
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
                private set
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
            fun setUserId(userId: Int) {
                this.userId = userId.toLong()
            }
        }

        class TracksBean {
            /**
             * name : dark HORSE
             * id : 1234301
             * pst : 0
             * t : 0
             * ar : [{"id":31286,"name":"The Shanghai Restoration Project","tns":[],"alias":[]}]
             * alia : []
             * pop : 100
             * st : 0
             * rt :
             * fee : 8
             * v : 10
             * crbt : null
             * cf :
             * al : {"id":127441,"name":"Zodiac","picUrl":"http://p2.music.126.net/2UGeR7vME216HNPmKK-pxw==/816937139480821.jpg","tns":[],"pic":816937139480821}
             * dt : 264661
             * h : {"br":320000,"fid":0,"size":10586950,"vd":-0.27}
             * m : {"br":160000,"fid":0,"size":5293498,"vd":-2.65076E-4}
             * l : {"br":96000,"fid":0,"size":3176116,"vd":-2.65076E-4}
             * a : null
             * cd : 1
             * no : 6
             * rtUrl : null
             * ftype : 0
             * rtUrls : []
             * djId : 0
             * copyright : 2
             * s_id : 0
             * mark : 0
             * rtype : 0
             * rurl : null
             * mst : 9
             * cp : 412011
             * mv : 0
             * publishTime : 1232380800007
             * alg : alg_tag_based
             */
            var name: String? = null
            var id = 0
            var pst = 0
            var t = 0
            var pop = 0
            var st = 0
            var rt: String? = null
            var fee = 0
            var v = 0
            var crbt: Any? = null
            var cf: String? = null
            var al: AlBean? = null
            var dt = 0
            var h: HBean? = null
            var m: MBean? = null
            var l: LBean? = null
            var a: Any? = null
            var cd: String? = null
            var no = 0
            var rtUrl: Any? = null
            var ftype = 0
            var djId = 0
            var copyright = 0
            var s_id = 0
            var mark: Long = 0
            var rtype = 0
            var rurl: Any? = null
            var mst = 0
            var cp = 0
            var mv = 0
            var publishTime: Long = 0
            var alg: String? = null
            var ar: List<ArBean>? = null
            var alia: List<*>? = null
            var rtUrls: List<*>? = null

            class AlBean {
                /**
                 * id : 127441
                 * name : Zodiac
                 * picUrl : http://p2.music.126.net/2UGeR7vME216HNPmKK-pxw==/816937139480821.jpg
                 * tns : []
                 * pic : 816937139480821
                 */
                var id = 0
                var name: String? = null
                var picUrl: String? = null
                var pic: Long = 0
                var tns: List<*>? = null
            }

            class HBean {
                /**
                 * br : 320000
                 * fid : 0
                 * size : 10586950
                 * vd : -0.27
                 */
                var br = 0
                var fid = 0
                var size = 0
                var vd = 0.0
            }

            class MBean {
                /**
                 * br : 160000
                 * fid : 0
                 * size : 5293498
                 * vd : -2.65076E-4
                 */
                var br = 0
                var fid = 0
                var size = 0
                var vd = 0.0
            }

            class LBean {
                /**
                 * br : 96000
                 * fid : 0
                 * size : 3176116
                 * vd : -2.65076E-4
                 */
                var br = 0
                var fid = 0
                var size = 0
                var vd = 0.0
            }

            class ArBean {
                /**
                 * id : 31286
                 * name : The Shanghai Restoration Project
                 * tns : []
                 * alias : []
                 */
                var id = 0
                var name: String? = null
                var tns: List<*>? = null
                var alias: List<*>? = null
            }
        }

        class TrackIdsBean {
            /**
             * id : 1234301
             * v : -10000
             * alg : alg_tag_based
             */
            var id = 0
            var v = 0
            var alg: String? = null
        }
    }

    class PrivilegesBean {
        /**
         * id : 1234301
         * fee : 8
         * payed : 0
         * st : 0
         * pl : 128000
         * dl : 0
         * sp : 7
         * cp : 1
         * subp : 1
         * cs : false
         * maxbr : 320000
         * fl : 128000
         * toast : false
         * flag : 0
         * preSell : false
         */
        var id = 0
        var fee = 0
        var payed = 0
        var st = 0
        var pl = 0
        var dl = 0
        var sp = 0
        var cp = 0
        var subp = 0
        var isCs = false
        var maxbr = 0
        var fl = 0
        var isToast = false
        var flag = 0
        var isPreSell = false
        override fun toString(): String {
            return "PrivilegesBean{" +
                    "id=" + id +
                    ", fee=" + fee +
                    ", payed=" + payed +
                    ", st=" + st +
                    ", pl=" + pl +
                    ", dl=" + dl +
                    ", sp=" + sp +
                    ", cp=" + cp +
                    ", subp=" + subp +
                    ", cs=" + isCs +
                    ", maxbr=" + maxbr +
                    ", fl=" + fl +
                    ", toast=" + isToast +
                    ", flag=" + flag +
                    ", preSell=" + isPreSell +
                    '}'
        }
    }
}
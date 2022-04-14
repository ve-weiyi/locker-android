package com.ve.lib_api.model.user

class SettingBean {
    var code = 0
    var setting: Setting? = null

    /*
     * {
     *     "setting": {
     *         "profileSetting": 0,
     *         "ageSetting": 0,
     *         "areaSetting": 0,
     *         "collegeSetting": 0,
     *         "villageAgeSetting": 0,
     *         "followSingerSetting": 0,
     *         "personalServiceSetting": 0,
     *         "newSongDiskSetting": null,
     *         "concertSetting": 0,
     *         "phoneFriendSetting": true,
     *         "userId": 123170560,
     *         "shareSetting": 0,
     *         "peopleNearbyCanSeeMe": true,
     *         "allowSubscriptionNotify": true,
     *         "allowLikedNotify": true,
     *         "allowNewFollowerNotify": true,
     *         "needRcmdEvent": true,
     *         "playRecordSetting": 0,
     *         "allowPlaylistShareNotify": true,
     *         "allowDJProgramShareNotify": true,
     *         "allowDJProgramSubscriptionNotify": true,
     *         "allowDJRadioSubscriptionNotify": true,
     *         "allowPeopleCanSeeMyPlayRecord": true,
     *         "allowOfflinePrivateMessageNotify": true,
     *         "allowOfflineForwardNotify": true,
     *         "allowOfflineCommentNotify": true,
     *         "allowOfflineCommentReplyNotify": true,
     *         "allowOfflineNotify": true,
     *         "allowVideoSubscriptionNotify": true,
     *         "sendMiuiMsg": false,
     *         "allowImportDoubanPlaylist": true,
     *         "importedDoubanPlaylist": false,
     *         "importedXiamiPlaylist": false,
     *         "allowImportXiamiPlaylist": true,
     *         "allowFollowedCanSeeMyPlayRecord": true,
     *         "finishedFollowGuide": true,
     *         "socialSetting": 0,
     *         "broadcastSetting": 2,
     *         "commentSetting": 2
     *     },
     *     "code": 200
     * }
     */
    class Setting {
        private val phoneFriendSetting = false

        //可以再附近页看到我
        private val peopleNearbyCanSeeMe = false

        //
        private val allowSubscriptionNotify = false

        //收到赞
        private val allowLikedNotify = false

        //新粉丝
        private val allowNewFollowerNotify = false
        private val needRcmdEvent = false

        //歌单被收藏
        private val allowPlaylistShareNotify = false
        private val allowDJProgramShareNotify = false
        private val allowDJProgramSubscriptionNotify = false
        private val allowDJRadioSubscriptionNotify = false
        private val allowPeopleCanSeeMyPlayRecord = false
        private val allowOfflinePrivateMessageNotify = false
        private val allowOfflineForwardNotify = false
        private val allowOfflineCommentNotify = false
        private val allowOfflineCommentReplyNotify = false
        private val allowOfflineNotify = false
        private val allowVideoSubscriptionNotify = false
        private val sendMiuiMsg = false
        private val allowImportDoubanPlaylist = false
        private val importedDoubanPlaylist = false
        private val importedXiamiPlaylist = false
        private val allowImportXiamiPlaylist = false
        private val allowFollowedCanSeeMyPlayRecord = false
        private val finishedFollowGuide = false
    }
}
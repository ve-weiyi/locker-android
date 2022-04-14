package com.ve.lib_api.model.search

import androidx.room.Entity

/**
 * 用于存放历史搜索的GreenDao Bean
 */
@Entity
class SearchHistoryBean {
    var keyowrds: String? = null

    constructor(keyowrds: String?) {
        this.keyowrds = keyowrds
    }

    constructor() {}
}
package com.ve.lib.common.event

import com.ve.lib.utils.SettingUtil

/**
 * Created by chenxz on 2018/6/18.
 */
class ColorEvent(var isRefresh: Boolean, var color: Int = SettingUtil.getColor())
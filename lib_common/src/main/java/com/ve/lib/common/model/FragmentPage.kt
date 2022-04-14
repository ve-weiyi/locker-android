package com.ve.lib.common.model

import androidx.fragment.app.Fragment

/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/7
 */
class FragmentPage(
    var mFragmentIndex: Int = 0,
    var mFragmentTitle: String = "",
    var mFragmentClass: Class<out Fragment>,
) {

    var mFragment: Fragment ? = null

    fun getFragment(): Fragment? {
        if(mFragment==null){
            mFragment=mFragmentClass.newInstance()
        }
        return mFragment
    }
}
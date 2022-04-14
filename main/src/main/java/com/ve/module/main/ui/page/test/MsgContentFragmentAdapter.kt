package com.ve.module.main.ui.page.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * 消息内容子页面适配器
 */
class MsgContentFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    private val names: MutableList<String>

    /**
     * 数据列表
     *
     * @param datas
     */
    fun setList(datas: List<String>?) {
        names.clear()
        names.addAll(datas!!)
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        val fragment = MsgContentFragment()
        val bundle = Bundle()
        bundle.putString("name", names[position])
        fragment.setArguments(bundle)
        return fragment
    }

    override fun getCount(): Int {
        return names.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var plateName = names[position]
        if (plateName == null) {
            plateName = ""
        } else if (plateName.length > 15) {
            plateName = plateName.substring(0, 15) + "..."
        }
        return plateName
    }

    init {
        names = ArrayList()
    }
}
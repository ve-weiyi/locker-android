package com.ve.module.locker.ui.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.TextView
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ve.lib.common.utils.ImageLoader
import com.ve.lib.common.base.adapter.BaseSlideAdapter
import com.ve.module.locker.R
import com.ve.module.locker.logic.http.model.PrivacyTag


/**
 * @Description hello word!
 * @Author  weiyi
 * @Date 2022/4/9
 */
class PrivacyTagAdapter:BaseSlideAdapter<PrivacyTag,BaseViewHolder>(R.layout.locker_item_tag) {

    override fun convert(holder: BaseViewHolder, item: PrivacyTag) {
        holder.setText(R.id.item_privacy_category_name,item.tagName)


        val tv = holder.getView(R.id.item_privacy_category_name) as TextView

        val url=item.tagCover
        if (url != null) {
            if(url.startsWith("http")){
                ImageLoader.loadView(context,url,tv)
            }else if( url.startsWith("#")){
                val gd: GradientDrawable = tv.background as GradientDrawable
                gd.setColor(Color.parseColor(item.tagCover))
            }
        }
    }
}
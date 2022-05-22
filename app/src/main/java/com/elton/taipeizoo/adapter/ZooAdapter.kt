package com.elton.taipeizoo.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.elton.taipeizoo.R
import com.elton.taipeizoo.api.data.ZooResults

class ZooAdapter(
    layoutResId: Int,
    data: MutableList<ZooResults>? = null
) : BaseQuickAdapter<ZooResults, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, item: ZooResults) {
        Glide.with(holder.itemView)
            .load(item.e_pic_url)
            .placeholder(R.drawable.brvah_sample_footer_loading)
            .error(R.drawable.ic_baseline_image_not_supported_24)
            .into(holder.getView(R.id.iv_img))
        holder.setText(R.id.tv_title, item.e_name)
        holder.setText(R.id.tv_info, item.e_info)
        holder.setText(R.id.tv_memo, item.e_memo)
    }
}
package com.elton.taipeizoo.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.elton.taipeizoo.R
import com.elton.taipeizoo.api.data.PlantResults

class PlantAdapter(
    layoutResId: Int,
    data: MutableList<PlantResults>? = null
) : BaseQuickAdapter<PlantResults, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, item: PlantResults) {
        Glide.with(holder.itemView)
            .load(item.pic01_URL)
            .placeholder(R.drawable.brvah_sample_footer_loading)
            .error(R.drawable.ic_baseline_image_not_supported_24)
            .into(holder.getView(R.id.iv_img))
        holder.setText(R.id.tv_title, item.name_Ch)
        holder.setText(R.id.tv_info, item.alsoKnow)
        holder.setGone(R.id.tv_memo, true)
    }
}
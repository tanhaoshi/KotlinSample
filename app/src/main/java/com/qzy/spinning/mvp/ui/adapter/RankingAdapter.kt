package com.qzy.spinning.mvp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.qzy.spinning.R

class RankingAdapter {

    class RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ranking_img: ImageView = itemView.findViewById(R.id.ranking_img)
        
    }
}
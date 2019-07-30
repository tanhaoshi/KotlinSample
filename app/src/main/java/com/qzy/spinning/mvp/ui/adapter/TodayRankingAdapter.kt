package com.qzy.spinning.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.qzy.spinning.R
import com.qzy.spinning.mvp.datamodel.TodayRanking

class TodayRankingAdapter : RecyclerView.Adapter<TodayRankingAdapter.RankingViewHolder> {

    var list : List<TodayRanking> ?= null
               set(value) {
                   field = value
                   notifyDataSetChanged()
               }

    private var context : Context? = null

    constructor(context: Context , list: List<TodayRanking>){
        this.context = context
        this.list = list
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RankingViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.adapter_ranking_list,p0,false)
        return RankingViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(holder: RankingViewHolder, position: Int) {
        holder.rankingSort.setText(list?.get(position)?.serial)
        Glide.with(context).load(list?.get(position)?.photo).into(holder.rankingPhoto)
        holder.rankingMember.setText(list?.get(position)?.memeberName)
        holder.rankingKCAL.setText(list?.get(position)?.kcal)
        holder.rankingAverageBeat.setText(list?.get(position)?.averageBeat)
        holder.rankingAverageLap.setText(list?.get(position)?.averageLap)
    }

   class RankingViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
       var rankingSort : TextView = itemView.findViewById(R.id.rankingSort)
       var rankingPhoto :ImageView = itemView.findViewById(R.id.rankingPhoto)
       var rankingMember : TextView = itemView.findViewById(R.id.rankingMember)
       var rankingKCAL : TextView = itemView.findViewById(R.id.rankingKCAL)
       var rankingAverageBeat : TextView = itemView.findViewById(R.id.rankingAverageBeat)
       var rankingAverageLap : TextView = itemView.findViewById(R.id.rankingAverageLap)
   }
}
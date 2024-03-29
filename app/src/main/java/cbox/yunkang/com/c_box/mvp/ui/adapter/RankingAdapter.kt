package cbox.yunkang.com.c_box.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.eventbus.User
import cbox.yunkang.com.c_box.mvp.datamodel.RankingData
import com.bumptech.glide.Glide

class RankingAdapter : RecyclerView.Adapter<RankingAdapter.RankingViewHolder>{

    private var context : Context ?= null

    var list : List<User> ?= null
            set(list) {
                field = list
                notifyDataSetChanged()
            }

    constructor(list: List<User>?, context: Context){
        this.list    = list

        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RankingViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.ranking_rc_item,p0,false)
        return RankingViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(p0: RankingViewHolder, p1: Int) {
        toViewholder(p1,p0)
    }

    private fun toViewholder(position:Int,rankingViewHolder: RankingViewHolder){
        if(position <= 2){
            toSpecial(position,rankingViewHolder)
        }else{
            rankingViewHolder.ranking_img.visibility = View.GONE
            with(rankingViewHolder.ranking_text){
                rankingViewHolder.ranking_text.visibility = View.VISIBLE
            }.also {
                rankingViewHolder.ranking_text.text = (position+1).toString()
            }
            Glide.with(context).load(list?.get(position)?.usrIconUrl).into(rankingViewHolder.ranking_photo)
            rankingViewHolder.name.text = list?.get(position)?.usrName
            rankingViewHolder.ranking_consume.text = list?.get(position)?.kcal.toString()
        }
    }

    private fun toSpecial(position: Int,rankingViewHolder: RankingViewHolder){
        when(position){
            0 -> Glide.with(context).load(R.drawable.ranking_one).into(rankingViewHolder.ranking_img)
            1 -> Glide.with(context).load(R.drawable.ranking_two).into(rankingViewHolder.ranking_img)
            2 -> Glide.with(context).load(R.drawable.ranking_three).into(rankingViewHolder.ranking_img)
        }
        Glide.with(context).load(list?.get(position)?.usrIconUrl).into(rankingViewHolder.ranking_photo)
        rankingViewHolder.name.text = list?.get(position)?.usrName
        rankingViewHolder.ranking_consume.text = list?.get(position)?.kcal.toString()
    }

    class RankingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ranking_img    :ImageView = itemView.findViewById(R.id.ranking_img)
        var ranking_text   :TextView  = itemView.findViewById(R.id.ranking_text)
        var ranking_photo  :ImageView = itemView.findViewById(R.id.ranking_photo)
        var name           :TextView  = itemView.findViewById(R.id.name)
        var ranking_consume:TextView  = itemView.findViewById(R.id.ranking_consume)
    }
}
package com.qzy.spinning.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qzy.spinning.R
import com.qzy.spinning.layout.RoundRectView

class PhysicalAdapter :RecyclerView.Adapter<PhysicalAdapter.PhysicalViewHolder> {

    var list : List<Int>? = null
            set(list) {
                field = list
                notifyDataSetChanged()
            }

    private var context : Context? = null

    constructor(dataSource:List<Int>,context:Context){
        this.list = dataSource
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhysicalViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.adapter_physical,p0,false)
        return PhysicalViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(p0: PhysicalViewHolder, p1: Int) {
        p0.roundRect.postInvalidate(list!![p1])
    }

    class PhysicalViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var roundRect : RoundRectView = itemView.findViewById(R.id.roundRect)
    }
}
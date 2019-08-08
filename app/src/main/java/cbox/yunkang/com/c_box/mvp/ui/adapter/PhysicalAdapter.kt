package cbox.yunkang.com.c_box.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cbox.yunkang.com.c_box.R

class PhysicalAdapter :RecyclerView.Adapter<PhysicalAdapter.PhysicalViewHolder> {

    var list : List<cbox.yunkang.com.c_box.eventbus.User>? = null
            set(list) {
                field = list
                notifyDataSetChanged()
            }

    private var context : Context? = null

    constructor(dataSource:List<cbox.yunkang.com.c_box.eventbus.User>, context:Context){
        this.list = dataSource
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhysicalViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.adapter_physical,p0,false)
        return PhysicalViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(p0: PhysicalViewHolder, p1: Int) {
//        list!![p1].tapinValue.toInt()/200*11
        p0.roundRect.postInvalidate(Math.round((list!![p1].tapinValue.toInt()/200*11).toDouble()).toInt())
    }

    class PhysicalViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var roundRect : cbox.yunkang.com.c_box.layout.RoundRectView = itemView.findViewById(R.id.roundRect)
    }
}
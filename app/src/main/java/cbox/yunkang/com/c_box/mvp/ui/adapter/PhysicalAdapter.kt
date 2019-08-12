package cbox.yunkang.com.c_box.mvp.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.eventbus.User
import cbox.yunkang.com.c_box.layout.CircleImageView
import cbox.yunkang.com.c_box.layout.RoundRectView
import cbox.yunkang.com.c_box.util.StringUtils
import com.bumptech.glide.Glide

class PhysicalAdapter :RecyclerView.Adapter<PhysicalAdapter.PhysicalViewHolder> {

    var list : List<User>? = null
            set(list) {
                field = list
                notifyDataSetChanged()
            }

    private var context : Context? = null

    constructor(dataSource:List<User>, context:Context){
        this.list = dataSource
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhysicalViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.adapter_physical,p0,false)
        return PhysicalViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(p0: PhysicalViewHolder, p1: Int) {
        p0.roundRect.postInvalidate(Math.round((list!![p1].tapinValue.toDouble()/200*10).toDouble()).toInt(),
                StringUtils.getColor(StringUtils.getStrainType(list!![p1].trainStrength)))

        Glide.with(context).load(list!![p1].usrIconUrl).into(p0.cirImg)
        p0.text.text = list!![p1].usrName
    }

    class PhysicalViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var roundRect : RoundRectView = itemView.findViewById(R.id.roundRect)
        var cirImg    : CircleImageView = itemView.findViewById(R.id.cirImg)
        var text      : TextView      = itemView.findViewById(R.id.text)
    }
}
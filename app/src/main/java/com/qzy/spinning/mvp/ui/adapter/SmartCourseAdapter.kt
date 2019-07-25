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
import com.qzy.spinning.layout.StarBarView
import com.qzy.spinning.mvp.datamodel.CourseModel

class SmartCourseAdapter : RecyclerView.Adapter<SmartCourseAdapter.SmartCourseViewHolder> {

    var list:List<CourseModel> ?= null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var context:Context ?= null

    constructor(list: List<CourseModel>,context: Context){
        this.list = list
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SmartCourseViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.adapter_smater_item,p0,false)
        return SmartCourseViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(viewHolder: SmartCourseViewHolder,position: Int) {
        viewHolder.courseName.setText(list?.get(position)?.courseName)
        viewHolder.star.setStartConut(list?.get(position)?.level!!)
        viewHolder.course_price.setText(list?.get(position)?.price)
        if(list?.get(position)?.pastPrice != null && list?.get(position)?.pastPrice?.length !! > 0){
            viewHolder.past.setText(list?.get(position)?.pastPrice)
            viewHolder.past_line.visibility = View.VISIBLE
        }else{
            viewHolder.past_line.visibility = View.GONE
        }
        Glide.with(context).load(list?.get(position)?.imagePath).into(viewHolder.detailsImage)
        if(list?.get(position)?.isAttempt!!){
            viewHolder.course_attempt.visibility = View.VISIBLE
        }else{
            viewHolder.course_attempt.visibility = View.GONE
        }
        viewHolder.use_count.setText("使用次数: "+list?.get(position)?.useCount)
        viewHolder.duration.setText("课时: "+list?.get(position)?.duration)
    }


    class SmartCourseViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var courseName : TextView = itemView.findViewById(R.id.courseName)
        var star       : StarBarView = itemView.findViewById(R.id.star)
        var course_price : TextView = itemView.findViewById(R.id.course_price)
        var past      : TextView = itemView.findViewById(R.id.past)
        var detailsImage : ImageView = itemView.findViewById(R.id.detailsImage)
        var course_attempt : TextView = itemView.findViewById(R.id.course_attempt)
        var past_line : TextView = itemView.findViewById(R.id.past_line)
        var use_count : TextView = itemView.findViewById(R.id.use_count)
        var duration  : TextView = itemView.findViewById(R.id.duration)
    }
}
package com.qzy.spinning.mvp.ui.adapter

import android.content.Context
import android.os.Environment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.downloader.*
import com.qzy.spinning.R
import com.qzy.spinning.layout.StarBarView
import com.qzy.spinning.mvp.datamodel.SmartCourse

class SmartCourseAdapter : RecyclerView.Adapter<SmartCourseAdapter.SmartCourseViewHolder> {

    var basePath = Environment.getExternalStorageDirectory().absolutePath + "spinningVideo"

    var list:List<SmartCourse.DataBean> ?= null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var context:Context ?= null

    constructor(list: List<SmartCourse.DataBean>,context: Context){
        this.list = list
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SmartCourseViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.adapter_smater_item,p0,false)
        return SmartCourseViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(viewHolder: SmartCourseViewHolder,position: Int) {
        viewHolder.courseName.setText(list?.get(position)?.title)
        viewHolder.star.setStartConut(list?.get(position)?.level!!)
        for(value in list?.get(position)?.priceInfo!!){
            if(value.type == 1){
                viewHolder.course_price.setText("¥"+value.price)
                viewHolder.past_line.visibility = View.VISIBLE
                viewHolder.course_price.setText("¥"+value.discountPrice)
            }else{
                viewHolder.past_line.visibility = View.GONE
            }
        }
        Glide.with(context).load(list?.get(position)?.cover).into(viewHolder.detailsImage)
        if(list?.get(position)?.classBuyStatus == null){
            viewHolder.course_attempt.visibility = View.VISIBLE
        }else{
            viewHolder.course_attempt.visibility = View.GONE
        }
        viewHolder.use_count.setText("使用次数: "+list?.get(position)?.useCount)
        viewHolder.duration.setText("课时: "+list?.get(position)?.duration)

        if(list?.get(position)?.leagueType == 2){

        }

        startUploader(position)
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
        var downloader_explain :TextView = itemView.findViewById(R.id.downloader_explain)
        var downloader_progress : ProgressBar = itemView.findViewById(R.id.downloader_progress)
    }

    private fun checkDownloaderStatus(position: Int,viewHolder: SmartCourseViewHolder){

    }

    private fun startUploader(position: Int){
        var downloadIdOne = 0

        if(Status.RUNNING == PRDownloader.getStatus(downloadIdOne)){
            PRDownloader.pause(downloadIdOne)
            return
        }

        if(Status.PAUSED == PRDownloader.getStatus(downloadIdOne)){
            PRDownloader.resume(downloadIdOne)
            return
        }

        var fileName : String = list?.get(position)?.video?.substringAfterLast("/") as String

        downloadIdOne = PRDownloader.download(list?.get(position)?.video, basePath, fileName)
                .build()
                .setOnStartOrResumeListener(object :OnStartOrResumeListener{
                    override fun onStartOrResume() {

                    }
                })
                .setOnPauseListener(object :OnPauseListener{
                    override fun onPause() {

                    }
                })
                .setOnCancelListener(object :OnCancelListener{
                    override fun onCancel() {

                    }
                })
                .setOnProgressListener(object :OnProgressListener{
                    override fun onProgress(progress: Progress?) {
                        var percent : Long = progress?.currentBytes!! * 100 / progress?.totalBytes
                        Log.i("onProgress","look over current percent = " + percent)
                    }
                })
                .start(object :OnDownloadListener{
                    override fun onDownloadComplete() {
                        Log.i("onDownloadComplete","complete")
                    }

                    override fun onError(error: Error?) {
                        Log.i("onDownloadComplete","error = " + error.toString())
                    }
                })

    }
}
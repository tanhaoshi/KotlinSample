package cbox.yunkang.com.c_box.mvp.ui.adapter

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import cbox.yunkang.com.c_box.mvp.ui.activity.CourseDescriptionActivity
import cbox.yunkang.com.c_box.mvp.ui.activity.CourseExplainActivity
import cbox.yunkang.com.c_box.mvp.ui.activity.QrCodeActivity
import cbox.yunkang.com.c_box.util.startActivity
import com.bumptech.glide.Glide
import com.downloader.*
import java.io.File
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.util.L

class SmartCourseAdapter : RecyclerView.Adapter<SmartCourseAdapter.SmartCourseViewHolder> {

    var basePath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "spinningVideo" + File.separator

    var list:List<cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse.DataBean> ?= null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var context: Context?= null

    var flag = 1


    constructor(list: List<cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse.DataBean>, context: Context){
        this.list = list
        this.context = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SmartCourseViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.adapter_smater_item,p0,false)
        return SmartCourseViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size !!

    override fun onBindViewHolder(viewHolder: SmartCourseViewHolder,position: Int) {
        viewHolder.courseName.text = list?.get(position)?.title
        viewHolder.star.setStartConut(list?.get(position)?.level!!)
        for(value in list?.get(position)?.priceInfo!!){
            if(value.type == 1){
                viewHolder.course_price.text = "¥"+value.price
                viewHolder.past_line.visibility = View.VISIBLE
                viewHolder.course_price.text = "¥"+value.discountPrice
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
        viewHolder.use_count.text = "使用次数: "+list?.get(position)?.useCount
        viewHolder.duration.text = "课时: "+list?.get(position)?.duration

        L.i("look over flag value = " + flag)

        if(flag == 2){

            viewHolder.coursePrice_rl.visibility = View.GONE

            viewHolder.downloader_layout.visibility = View.VISIBLE

            viewHolder.course_buy.visibility = View.GONE

            viewHolder.course_attempt.visibility = View.VISIBLE
            viewHolder.course_attempt.text = "查看详情"
            viewHolder.course_attempt.textSize = 17f

            viewHolder.course_details.visibility = View.GONE

            viewHolder.course_attempt.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    var bundle = Bundle()
                    bundle.putString("uuid",list?.get(position)?.uuid)
                    startActivity(context!!, CourseExplainActivity::class.java,bundle)
                }
            })

            showCourseStatus(position,viewHolder)

        }else{

            toBindView(position,viewHolder)
        }

        viewHolder.downloader_explain.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                checkDownloaderStatus(position,viewHolder)
            }
        })
    }

    private fun toBindView(position: Int,smartCourseViewHolder: SmartCourseViewHolder){

        smartCourseViewHolder.course_buy.visibility = View.VISIBLE

        smartCourseViewHolder.coursePrice_rl.visibility = View.VISIBLE

        smartCourseViewHolder.course_details.visibility = View.VISIBLE

        smartCourseViewHolder.downloader_layout.visibility = View.GONE

        smartCourseViewHolder.course_attempt.text = "试用"

        smartCourseViewHolder.course_attempt.textSize = 15f

        smartCourseViewHolder.course_attempt.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                callback.callBack(list?.get(position)?.uuid!!,position)
            }
        })

        smartCourseViewHolder.course_buy.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var bundle = Bundle()
                bundle.putString("uuid",list?.get(position)?.uuid)
                startActivity(context!!, QrCodeActivity::class.java,bundle)
            }
        })

        smartCourseViewHolder.course_details.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var bundle = Bundle()
                bundle.putString("uuid",list?.get(position)?.uuid)
                startActivity(context!!, CourseExplainActivity::class.java,bundle)
            }
        })
    }

    class SmartCourseViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var courseName : TextView = itemView.findViewById(R.id.courseName)
        var star       : cbox.yunkang.com.c_box.layout.StarBarView = itemView.findViewById(R.id.star)
        var course_price : TextView = itemView.findViewById(R.id.course_price)
        var past      : TextView = itemView.findViewById(R.id.past)
        var detailsImage : ImageView = itemView.findViewById(R.id.detailsImage)
        var course_attempt : TextView = itemView.findViewById(R.id.course_attempt)
        var past_line : TextView = itemView.findViewById(R.id.past_line)
        var use_count : TextView = itemView.findViewById(R.id.use_count)
        var duration  : TextView = itemView.findViewById(R.id.duration)
        var downloader_explain :TextView = itemView.findViewById(R.id.downloader_explain)
        var downloader_progress : ProgressBar = itemView.findViewById(R.id.downloader_progress)
        var downloader_layout  : LinearLayout = itemView.findViewById(R.id.downloader_layout)
        var course_buy  : TextView  = itemView.findViewById(R.id.course_buy)
        var course_details : TextView = itemView.findViewById(R.id.course_details)
        var coursePrice_rl : RelativeLayout = itemView.findViewById(R.id.coursePrice_rl)
    }

    private fun showCourseStatus(position: Int,viewHolder: SmartCourseViewHolder){
        var path = basePath + list?.get(position)?.uuid.toString()
        var file = File(path)
        if(!file.exists()){
            viewHolder.downloader_explain.text = "点击下载"
            viewHolder.downloader_explain.setTextColor(context?.resources?.getColor(R.color.downloder_finsh)!!)
        }else{
            viewHolder.downloader_explain.text = "开始上课"
            viewHolder.downloader_explain.setTextColor(context?.resources?.getColor(R.color.course_price_bg)!!)
            viewHolder.downloader_progress.visibility = View.GONE
        }
    }

    private fun checkDownloaderStatus(position: Int,viewHolder: SmartCourseViewHolder){
        var path = basePath + list?.get(position)?.uuid.toString()
        var file = File(path)
        if(!file.exists()){
            file.mkdirs()
            startUploader(position,viewHolder)
        }else{
            existsFile(file,position,viewHolder)
        }
    }

    private fun existsFile(file: File,position: Int,smartCourseViewHolder: SmartCourseViewHolder){
        if(file.listFiles() != null){
            if(file.listFiles().isNotEmpty()){
                for(value in file.listFiles()){
                    var urlName = list?.get(position)?.video?.substringAfterLast("/") as String
                    if(urlName != value.name){
                        startUploader(position,smartCourseViewHolder)
                    }else{
                        var bundle = Bundle()
                        bundle.putString("uuid",list?.get(position)?.uuid)
                        startActivity(context!!, CourseDescriptionActivity::class.java,bundle)
                    }
                }
            }else{
                startUploader(position,smartCourseViewHolder)
            }
        }else{
            startUploader(position,smartCourseViewHolder)
        }
    }

    private fun startUploader(position: Int,smartCourseViewHolder: SmartCourseViewHolder){
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

        var signalFile : String = list?.get(position)?.uuid.toString()

        downloadIdOne = PRDownloader.download(list?.get(position)?.video, basePath + signalFile , fileName)
                .build()
                .setOnStartOrResumeListener(object : OnStartOrResumeListener {
                    override fun onStartOrResume() {
                        smartCourseViewHolder.downloader_explain.setTextColor(context?.resources?.getColor(R.color.course_price_bg)!!)
                        smartCourseViewHolder.downloader_explain.text = "下载中"
                    }
                })
                .setOnPauseListener(object : OnPauseListener {
                    override fun onPause() {

                    }
                })
                .setOnCancelListener(object :OnCancelListener{
                    override fun onCancel() {

                    }
                })
                .setOnProgressListener(object : OnProgressListener {
                    override fun onProgress(progress: Progress?) {
                        var percent : Long = progress?.currentBytes!! * 100 / progress.totalBytes
                        smartCourseViewHolder.downloader_progress.progress = percent.toInt()
                        if(percent.toInt() == 100){
                            smartCourseViewHolder.downloader_explain.setTextColor(context?.resources?.getColor(R.color.course_price_bg)!!)
                            smartCourseViewHolder.downloader_explain.text = "下载完成"
                            smartCourseViewHolder.downloader_progress.visibility = View.GONE
                        }
                    }
                })
                .start(object :OnDownloadListener{
                    override fun onDownloadComplete() {
                        smartCourseViewHolder.downloader_explain.text = "开始上课"
                        smartCourseViewHolder
                    }

                    override fun onError(error: Error?) {
                    }
                })
    }

    lateinit var callback : Callback

    fun setCallbackListener(callbacks: Callback){
        this.callback = callbacks
    }

    interface Callback{
        fun callBack(uuid:String,position : Int)
    }
}
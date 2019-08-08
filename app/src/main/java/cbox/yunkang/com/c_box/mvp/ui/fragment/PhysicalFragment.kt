package cbox.yunkang.com.c_box.mvp.ui.fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.support.v4.app.ActivityCompat.finishAffinity
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.MediaController
import android.widget.TextView
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.eventbus.MessageEventbus
import cbox.yunkang.com.c_box.eventbus.User
import cbox.yunkang.com.c_box.mvp.contract.PhysicalContract
import cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain
import cbox.yunkang.com.c_box.mvp.datamodel.ScaleProgress
import cbox.yunkang.com.c_box.mvp.datamodel.SubmitPhsical
import cbox.yunkang.com.c_box.mvp.model.YunkangBoxManager
import cbox.yunkang.com.c_box.mvp.ui.activity.PhysicalActivity
import cbox.yunkang.com.c_box.mvp.ui.activity.TodayRankingActivity
import cbox.yunkang.com.c_box.mvp.ui.adapter.PhysicalAdapter
import cbox.yunkang.com.c_box.mvp.ui.adapter.RankingAdapter
import cbox.yunkang.com.c_box.util.*
import com.alibaba.fastjson.JSON
import kotlinx.android.synthetic.main.fragment_physical.*
import okhttp3.RequestBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import cbox.yunkang.com.c_box.util.DatetimeUtil.formatLongToTimeStr
import com.ykcx.bcore.utils.BasePreference
import kotlinx.android.synthetic.main.ranking_adjust_layout.*
import kotlinx.android.synthetic.main.ranking_detail_layout.*
import java.io.File


class PhysicalFragment : Fragment() , PhysicalContract.View{

    var basePath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "spinningVideo" +
        File.separator

    override lateinit var presenter: PhysicalContract.Presenter

    private lateinit var physicalAdapter : PhysicalAdapter

    private lateinit var rankingAdapter: RankingAdapter

    private lateinit var timer : Timer

    lateinit var uuid : String

    private var handler  : Handler? = Handler()

    private val refreshRunnable : Runnable = object :Runnable{
        override fun run() {
            time --

            val formatLongToTimeStr = formatLongToTimeStr(time.toLong())
            val split = formatLongToTimeStr.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            physical_schedule.text = split[1] +":"+ split[2]

            if(time > 0){
                handler?.postDelayed(this,1000)
            }
        }
    }

    companion object {
        fun newInstance() = PhysicalFragment()
    }

    override fun onResume() {
        super.onResume()
        initialize()
//        presenter.start()
    }

    private fun initialize(){
        var hashMap = HashMap<String,String>()
        hashMap["leagueUuid"] = uuid
        var requestMap = HttpUtils.generateRequestBody(hashMap)
        presenter.getPhysicalProgressTask(requestMap)
    }

    var time = 0

    var progressList = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.ScaleProgress>()

    var modelList = LinkedList<cbox.yunkang.com.c_box.mvp.datamodel.TableModel>()

    @SuppressLint("ResourceAsColor")
    override fun showPhysicalProgressTask(courseExplain: CourseExplain) {
        var hashmap = courseExplain.data.classLeague.stageGroup

        for(tableList:List<cbox.yunkang.com.c_box.mvp.datamodel.TableModel> in hashmap.values){
            for(listValue in tableList){
                time += listValue.duration.toInt()
                modelList.add(listValue)
            }
        }

        initializeView(modelList[0],0)

        for(tableModel in modelList){
            var scaleWidth : Double = (tableModel.duration.toDouble() / time)

            var scaleTop  :Double = (tableModel.stepFrequency.toDouble() / 10)

            var scaleProgress = ScaleProgress(scaleTop,scaleWidth,5,tableModel.duration.toLong())

            if(tableModel.heartRange == 1){
                scaleProgress.signalColor = resources.getColor(R.color.relaxationColor)
            }else if(tableModel.heartRange == 2){
                scaleProgress.signalColor = resources.getColor(R.color.fatColor)
            }else if(tableModel.heartRange == 3){
                scaleProgress.signalColor = resources.getColor(R.color.heartLungColor)
            }else if(tableModel.heartRange == 4){
                scaleProgress.signalColor = resources.getColor(R.color.lacticColor)
            }else if(tableModel.heartRange == 5){
                scaleProgress.signalColor = resources.getColor(R.color.limitationColor)
            }

            progressList.add(scaleProgress)

        }

        val formatLongToTimeStr = formatLongToTimeStr(time.toLong())
        val split = formatLongToTimeStr.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        physical_schedule.text = split[1] +":"+ split[2]

        progressBar.postInvalidateAction(progressList)

        startTimer()

        handler?.postDelayed(refreshRunnable ,1000)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
//        presenter.getRankingTasks()
        playVideo()
    }

    private inline fun playVideo(){
        var mediaController = MediaController(activity)
        var listFiles = getVideoSource(basePath + uuid)
        videoPlay.setVideoPath(basePath + uuid + File.separator + listFiles[0])
        videoPlay.setMediaController(mediaController)
        videoPlay.seekTo(0)
        videoPlay.requestFocus()
        videoPlay.start()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEventbus: MessageEventbus) {
        when(messageEventbus.type){
            Constant.BOX_USER_ICON -> postNotifyChangeAdapter(messageEventbus.`object` as List<cbox.yunkang.com.c_box.eventbus.User>)
        }
    }

    private inline fun postNotifyChangeAdapter(list: List<User>){

        L.i("physical manager process = " + list.size)

        this.userList = list as ArrayList<User>

        physicalAdapter.list = list

        Collections.sort(list,Collections.reverseOrder())

        if(list.size > 10){
            list.subList(0,10)
            physicalAdapter.list = list
        }else{
            rankingAdapter.list = list
        }
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_physical,container,false)

        var physicalActivity = activity as PhysicalActivity

        this.uuid = physicalActivity.uuid

        with(root){
            var recyclerView = findViewById<RecyclerView>(R.id.recyclerView).also {
                it.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            }
            physicalAdapter = PhysicalAdapter(ArrayList(0), activity!!)

            recyclerView.adapter = physicalAdapter

            var  rankingRecyclerView = findViewById<RecyclerView>(R.id.ranking_rc).also {
                it.layoutManager = LinearLayoutManager(activity)
            }
            rankingAdapter = RankingAdapter(ArrayList(0),activity!!)

            rankingRecyclerView.adapter = rankingAdapter

            var gripProgress = findViewById<cbox.yunkang.com.c_box.layout.GripProgressView>(R.id.gripProgress).also {
                it.power = 40
            }

            findViewById<TextView>(R.id.finish_course).setOnClickListener {
//                sumitPhysicalData()
                initDialog()
            }
        }
        return root
    }

    override fun showTasks(list: List<Int>) {
    }

    override fun showProgressTasks(list: List<cbox.yunkang.com.c_box.mvp.datamodel.ScaleProgress>) {
    }

    @SuppressLint("ResourceAsColor")
    private fun startTimer(){
        timer = Timer()

        var dateTime : Long = 0
        var nextPosition : Int = 0

        timer.schedule(object: TimerTask(){
            override fun run() {
                if(nextPosition == progressList.size){
                    timer.cancel()
                    return
                }

                if (dateTime <= (progressList[nextPosition].second) * 1000) {
                    progressBar.postDelayInvalidate(nextPosition)
                    dateTime += 2000
                } else {
                    if ((nextPosition + 1) == modelList.size) return
                    initializeView(modelList[nextPosition], nextPosition)
                    dateTime = 0
                    nextPosition += 1
                }

                YunkangBoxManager.getInstance().showUserIcon(null)
            }
        },0,2000)
    }

    private inline fun initializeView(tableModel : cbox.yunkang.com.c_box.mvp.datamodel.TableModel, nextPosition:Int){
        activity?.runOnUiThread {
            gripProgress.power = tableModel.resistance
            target_count.text = tableModel.stepFrequency.toString() + "分/次"
            target_heart.text = "脂肪燃烧:"+tableModel.heartRange.toString()
            target_action_step.text = tableModel.essential
            title.text = tableModel.title
            nextAction.text = "Next："+modelList.get(nextPosition+1).title
        }
    }

    override fun showRankingTasks(list: List<cbox.yunkang.com.c_box.mvp.datamodel.RankingData>) {
//        rankingAdapter.list = list
    }

    var userList = ArrayList<User>()

    private inline fun sumitPhysicalData(){
        var submitPhsical = SubmitPhsical()
        submitPhsical.gymAddr  = BasePreference.getInstance().gymAddress
        submitPhsical.duration = time
        submitPhsical.mac      = BasePreference.getInstance().wifiMac
        submitPhsical.winner   = "red"
        var list = ArrayList<SubmitPhsical.ListBean>()
        for (value in userList){
            var listBean = SubmitPhsical.ListBean()
            listBean.leagueUuid = "cafa399310c24b7786e01145f0eeb1"
            listBean.openId     = value.usrOpenId
            listBean.mileage    = "100"
            listBean.consume    = "556"
            listBean.maxFrequency = "50"
            listBean.avgFrequency = "40"
            listBean.avgSpeed    = "1"
            listBean.duration = "100"
            listBean.maxRate = "140"
            listBean.intensity = "80"
            listBean.heartRange = "9"
            listBean.avgRate = "80"
            listBean.color = "red"
            list.add(listBean)
        }
        submitPhsical.list = list
        var content = JSON.toJSONString(submitPhsical)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), content)
        presenter.submitPhysicalTask(body)
    }

    override fun showPhysicalFinishTask(responsePhysical: cbox.yunkang.com.c_box.mvp.datamodel.ResponsePhysical) {
        if(responsePhysical.code == 200) startActivity(activity?.applicationContext!!, TodayRankingActivity::class.java,null)
    }

    override fun showFailed(throwable: Throwable) {
    }

    override fun onDestroy() {
        super.onDestroy()
        checkNotNull(timer)
        timer.cancel()
        handler?.removeCallbacks(refreshRunnable)
        videoPlay?.suspend()
        videoPlay?.setOnErrorListener(null)
        videoPlay?.setOnPreparedListener(null)
        videoPlay?.setOnCompletionListener(null)
        videoPlay == null
    }

    lateinit var dialog : AlertDialog

    private fun initDialog() {
        val builder = AlertDialog.Builder(activity!!)
        val inflater = LayoutInflater.from(activity!!)
        val v = inflater.inflate(R.layout.dialog_datetime_settings, null)
        val custom_cannel = v.findViewById(R.id.custom_cannel) as TextView
        val custom_yes = v.findViewById(R.id.custom_yes) as TextView
        dialog = builder.create()
//        dialog.getWindow()!!.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        dialog.show()
        dialog.getWindow()!!.setContentView(v)
        dialog.getWindow()!!.setGravity(Gravity.CENTER)
        custom_cannel.setOnClickListener {

        }

        custom_yes.setOnClickListener {

        }
    }
}



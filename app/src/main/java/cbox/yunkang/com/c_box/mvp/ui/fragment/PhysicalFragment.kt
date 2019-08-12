package cbox.yunkang.com.c_box.mvp.ui.fragment

import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.Dialog
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.support.v4.app.ActivityCompat.finishAffinity
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.MediaController
import android.widget.TextView
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.R.id.*
import cbox.yunkang.com.c_box.eventbus.MessageEventbus
import cbox.yunkang.com.c_box.eventbus.User
import cbox.yunkang.com.c_box.mvp.contract.PhysicalContract
import cbox.yunkang.com.c_box.mvp.datamodel.*
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
import com.ykcx.bcore.cil.BoxCore
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

    fun isTimerinitialize() = ::timer.isInitialized

    lateinit var uuid : String

    private var handler  : Handler? = Handler()

    private val refreshRunnable : Runnable = object :Runnable{
        override fun run() {

            if(signalTime > 0){
                signalTime --
            }

            val formatLongToTimeStr = formatLongToTimeStr(signalTime.toLong())
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
    }

    private fun initialize(){
        var hashMap = HashMap<String,String>()
        hashMap["leagueUuid"] = uuid
        var requestMap = HttpUtils.generateRequestBody(hashMap)
        presenter.getPhysicalProgressTask(requestMap)
    }

    var time = 0

    var signalTime = 0

    var progressList = ArrayList<ScaleProgress>()

    var modelList = LinkedList<TableModel>()

    @SuppressLint("ResourceAsColor")
    override fun showPhysicalProgressTask(courseExplain: CourseExplain) {

        var hashmap = courseExplain.data.classLeague.stageGroup

        for(tableList:List<TableModel> in hashmap.values){
            for(listValue in tableList){
                time += DatetimeUtil.Date2ms(listValue.duration)
                modelList.add(listValue)
            }
        }

        signalTime = DatetimeUtil.Date2ms(modelList[0].duration)

        initializeView(modelList[0],0)

        for(tableModel in modelList){

            var scaleWidth : Double = (DatetimeUtil.Date2ms(tableModel.duration).toDouble() / time)

            var scaleTop  :Double = (DatetimeUtil.Date2ms(tableModel.stepFrequency.toString()).toDouble() / 200)

            var scaleProgress = ScaleProgress(scaleTop,scaleWidth,5,DatetimeUtil.Date2ms(tableModel.duration).toLong())

            if(tableModel.heartRange == 0){
                scaleProgress.signalColor = resources.getColor(R.color.relaxationColor)
            }else if(tableModel.heartRange == 1){
                scaleProgress.signalColor = resources.getColor(R.color.fatColor)
            }else if(tableModel.heartRange == 2){
                scaleProgress.signalColor = resources.getColor(R.color.heartLungColor)
            }else if(tableModel.heartRange == 3){
                scaleProgress.signalColor = resources.getColor(R.color.lacticColor)
            }else if(tableModel.heartRange == 4){
                scaleProgress.signalColor = resources.getColor(R.color.limitationColor)
            }

            progressList.add(scaleProgress)

        }

        val formatLongToTimeStr = formatLongToTimeStr(signalTime.toLong())
        val split = formatLongToTimeStr.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        physical_schedule.text = split[1] +":"+ split[2]

        progressBar.postInvalidateAction(progressList)

        startTimer()

        handler?.postDelayed(refreshRunnable ,1000)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
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
            Constant.BOX_USER_ICON -> changeNotifyData(messageEventbus.`object` as List<User>)
            Constant.BOX_USER_REFRESH ->changeNotifyData(messageEventbus.`object` as List<User>)
            Constant.BOX_USER_ALLOFFLINE ->changeNotifyData(messageEventbus.`object` as List<User>)
            Constant.BOX_USER_OFFLINE -> changeNotifyData(messageEventbus.`object` as List<User>)
            Constant.BOX_USER_SWITCHEP -> changeNotifyData(messageEventbus.`object` as List<User>)
        }
    }

    private fun changeNotifyData(list:List<User>){
        this.userList.clear()
        this.userList.addAll(list)

        if(list.size == 0) {
            physicalAdapter.list = list
            rankingAdapter.list = list
            return
        }
        physicalAdapter.list = list

        Collections.sort(list,Collections.reverseOrder())

        if(list.size > 10){
            list.subList(0,10)
            rankingAdapter.list = list
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
                initDialog()
            }
        }
        return root
    }

    override fun showTasks(list: List<Int>) {
    }

    override fun showProgressTasks(list: List<ScaleProgress>) {
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
                    if(modelList.size == 1){
                        timer.cancel()
                        return
                    }

                    nextPosition += 1
                    dateTime = 0

                    if(nextPosition == modelList.size){
                        signalTime = 0
                    }else{
                        signalTime = DatetimeUtil.Date2ms(modelList[nextPosition].duration)
                    }
                    if(nextPosition != modelList.size){
                        initializeView(modelList[nextPosition], nextPosition)
                    }else{
                        BoxCore.getInstance().notifyAllUserOffline()
                        sumitPhysicalData()
                        startActivity(activity?.applicationContext!!, TodayRankingActivity::class.java,null)
                        activity!!.finish()
                    }
                }
            }
        },0,2000)
    }

    private inline fun initializeView(tableModel : TableModel, nextPosition:Int){
        activity?.runOnUiThread {
            gripProgress.power = tableModel.resistance
            percent.text = tableModel.resistance.toString() + "%"
            target_count.text = tableModel.stepFrequency.toString() + "分/次"
            if(tableModel.heartRange == 0){
                target_heart.text = "休闲热身:(40%-60%)"
            }else if(tableModel.heartRange == 1){
                target_heart.text = "脂肪燃烧:(60%-70%)"
            }else if(tableModel.heartRange == 2){
                target_heart.text = "心肺提升:(70%-80%)"
            }else if(tableModel.heartRange == 3){
                target_heart.text = "乳酸阈值:(80%-90%)"
            }else if(tableModel.heartRange == 4){
                target_heart.text = "极限训练:(90%-100%)"
            }
            target_action_step.text = tableModel.essential
            title.text = tableModel.title
            if(modelList.size == 1){
                nextAction.text = "Next："+ "无"
            }else{
                if((modelList.size - nextPosition) == 1){
                    nextAction.text = "Next："+ "无"
                }else{
                    if(modelList.size == nextPosition){
                        nextAction.text = "Next："+"无"
                    }else{
                        nextAction.text = "Next："+modelList.get(nextPosition+1).title
                    }
                }
            }
        }
    }

    override fun showRankingTasks(list: List<RankingData>) {
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
            listBean.leagueUuid = randomUUID()
            listBean.openId     = value.usrOpenId
            listBean.mileage    = value.sportTotalValue
            listBean.consume    = value.kcal.toString()
            listBean.maxFrequency = YunkangBoxManager.getInstance().maxFrequency.toString()
            listBean.avgSpeed    = value.speedValue
            listBean.duration = (value.restartTime - value.onLineTime).toString()
            listBean.maxRate = YunkangBoxManager.getInstance().maxRate.toString()
            listBean.intensity = value.trainStrength
            listBean.heartRange = value.heartRateValue.toString()
            listBean.avgRate =  value.heartRateValue.toString()
            listBean.color = "red"
            list.add(listBean)
        }
        submitPhsical.list = list
        var content = JSON.toJSONString(submitPhsical)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), content)
        presenter.submitPhysicalTask(body)
    }

    private fun randomUUID() : String{
        var uuid = UUID.randomUUID()
        var randomUUID = uuid.toString()
        return randomUUID
    }

    override fun showPhysicalFinishTask(responsePhysical: cbox.yunkang.com.c_box.mvp.datamodel.ResponsePhysical) {
        if(responsePhysical.code == 200) dialog.dismiss()
        startActivity(activity?.applicationContext!!, TodayRankingActivity::class.java,null)
        activity!!.finish()
    }

    override fun showFailed(throwable: Throwable) {
        L.i("look over throwable message = " + throwable.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(isTimerinitialize()){
            if(timer != null){
                timer.cancel()
            }
        }
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
        dialog.show()
        var windowManager = dialog.window.attributes
        windowManager.width = 400
        windowManager.height = ActionBar.LayoutParams.WRAP_CONTENT
        dialog.window.attributes = windowManager
        dialog.getWindow()!!.setContentView(v)
        dialog.getWindow()!!.setGravity(Gravity.CENTER)
        custom_cannel.setOnClickListener {
            dialog.dismiss()
        }

        custom_yes.setOnClickListener {
            sumitPhysicalData()
        }
    }
}



package com.qzy.spinning.mvp.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.fastjson.JSON
import com.qzy.spinning.R
import com.qzy.spinning.eventbus.MessageEventbus
import com.qzy.spinning.eventbus.User
import com.qzy.spinning.layout.GripProgressView
import com.qzy.spinning.mvp.contract.PhysicalContract
import com.qzy.spinning.mvp.datamodel.*
import com.qzy.spinning.mvp.model.YunkangBoxManager
import com.qzy.spinning.mvp.ui.activity.CourseDescriptionActivity
import com.qzy.spinning.mvp.ui.activity.PhysicalActivity
import com.qzy.spinning.mvp.ui.activity.TodayRankingActivity
import com.qzy.spinning.mvp.ui.adapter.PhysicalAdapter
import com.qzy.spinning.mvp.ui.adapter.RankingAdapter
import com.qzy.spinning.util.Constant
import com.qzy.spinning.util.HttpUtils
import com.qzy.spinning.util.L
import com.qzy.spinning.util.startActivity
import kotlinx.android.synthetic.main.fragment_physical.*
import okhttp3.RequestBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class PhysicalFragment : Fragment() , PhysicalContract.View{

    override lateinit var presenter: PhysicalContract.Presenter

    private lateinit var physicalAdapter : PhysicalAdapter

    private lateinit var rankingAdapter: RankingAdapter

    private lateinit var timer : Timer

    private lateinit var list: List<ScaleProgress>

    lateinit var uuid : String

    companion object {
        fun newInstance() = PhysicalFragment()
    }

    override fun onResume() {
        super.onResume()
        initialize()
        presenter.start()
    }

    private fun initialize(){
        var hashMap = HashMap<String,String>()
        hashMap.put("leagueUuid","d0fcd25da7374e188fe3908a982c5a9e")
        var requestMap = HttpUtils.generateRequestBody(hashMap)
        presenter.getPhysicalProgressTask(requestMap)
    }

    override fun showPhysicalProgressTask(courseExplain: CourseExplain) {
        var hashmap = courseExplain.data.classLeague.stageGroup
        var list = LinkedList<TableModel>()
        var time = 0
        for(tableList:List<TableModel> in hashmap.values){
            for(listValue in tableList){
                time += listValue.duration.toInt()
                L.i("look over at time value = " + time)
                list.add(listValue)
            }
        }

        L.i("look over durations = " + courseExplain.data.classLeague.duration)

        L.i("look over times = " + time)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
        presenter.getRankingTasks()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEventbus: MessageEventbus) {
        when(messageEventbus.type){
            Constant.BOX_USER_ONLINE ->
            Constant.BOX_USER_ICON
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

            var gripProgress = findViewById<GripProgressView>(R.id.gripProgress).also {
                it.power = 40
            }

            findViewById<TextView>(R.id.finish_course).setOnClickListener {
                sumitPhysicalData()
            }
        }
        return root
    }

    override fun showTasks(list: List<Int>) {
        physicalAdapter.list = list
    }

    override fun showProgressTasks(list: List<ScaleProgress>) {
        for(item in list){
            item.signalColor = resources.getColor(R.color.grayColor)
        }

        this.list = list

        progressBar.postInvalidateAction(list)

        startTimer()
    }

    override fun showRankingTasks(list: List<RankingData>) {
        rankingAdapter.list = list
    }

    @SuppressLint("ResourceAsColor")
    private fun startTimer(){
        timer = Timer()

        for(item in list.indices){
            when(item){
                0 -> transform(0,60,R.color.redColor)
                1 -> transform(1,120,R.color.yellowColor)
                2 -> transform(2,60,R.color.greenColor)
                3 -> transform(3,60,R.color.blueColor)
                4 -> transform(4,60,R.color.violetColor)
                5 -> transform(5,70,R.color.yellowColor)
                6 -> transform(6,150,R.color.redColor)
            }
        }

        var dateTime : Long = 0
        var nextPosition : Int = 0

        timer.schedule(object: TimerTask(){
            override fun run() {
                if(nextPosition == list.size){
                    timer.cancel()
                    return
                }

                if(dateTime <= (list[nextPosition].second) * 1000){
                    progressBar.postDelayInvalidate(nextPosition)
                    dateTime += 2000
                }else{
                    nextPosition += 1
                    dateTime = 0
                }
            }
        },0,2000)
    }

    @SuppressLint("ResourceType")
    private inline fun transform(position: Int, second: Long, @ColorInt color:Int){
        list[position].second = second
        list[position].signalColor = resources.getColor(color)
    }

    private inline fun sumitPhysicalData(){
        var submitPhsical = SubmitPhsical()
        submitPhsical.gymAddr  = "00000142"
        submitPhsical.duration = 120
        submitPhsical.mac      = "sss"
        submitPhsical.winner   = "red"
        var list = ArrayList<SubmitPhsical.ListBean>()
        var listBean = SubmitPhsical.ListBean()
        listBean.leagueUuid = "cafa399310c24b7786e01145f0eeb1"
        listBean.openId     = "asss"
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
        submitPhsical.list = list
        var content = JSON.toJSONString(submitPhsical)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), content)
        presenter.submitPhysicalTask(body)
    }

    override fun showPhysicalFinishTask(responsePhysical: ResponsePhysical) {
        if(responsePhysical.code == 200) startActivity(activity?.applicationContext!!,TodayRankingActivity::class.java,null)
    }

    override fun showFailed(throwable: Throwable) {

    }

    override fun onDestroy() {
        super.onDestroy()
        checkNotNull(timer)
        timer.cancel()
    }

}



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
import com.qzy.spinning.R
import com.qzy.spinning.mvp.contract.PhysicalContract
import com.qzy.spinning.mvp.datamodel.RankingData
import com.qzy.spinning.mvp.datamodel.ScaleProgress
import com.qzy.spinning.mvp.ui.adapter.PhysicalAdapter
import kotlinx.android.synthetic.main.fragment_physical.*
import java.util.*
import kotlin.collections.ArrayList

class PhysicalFragment : Fragment() , PhysicalContract.View{

    override lateinit var presenter: PhysicalContract.Presenter

    private lateinit var physicalAdapter : PhysicalAdapter

    private lateinit var timer : Timer

    private lateinit var list: List<ScaleProgress>

    companion object {

        fun newInstance() = PhysicalFragment()
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onStart() {
        super.onStart()
        presenter.getRankingTasks()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_physical,container,false)

        with(root){
            var recyclerView = findViewById<RecyclerView>(R.id.recyclerView).also {
                it.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            }
            physicalAdapter = PhysicalAdapter(ArrayList(0), activity!!)

            recyclerView.adapter = physicalAdapter
        }

        with(root){
            var  recyclerView = findViewById<RecyclerView>(R.id.ranking_rc).also {
                it.layoutManager = LinearLayoutManager(activity)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

                if(dateTime <= (list.get(nextPosition).second) * 1000){
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
        list.get(position).second = second
        list.get(position).signalColor = resources.getColor(color)
    }

    override fun onDestroy() {
        super.onDestroy()
        checkNotNull(timer)
        timer.cancel()
    }

}



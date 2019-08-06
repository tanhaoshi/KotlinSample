package com.qzy.spinning.mvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.fastjson.JSON
import com.qzy.spinning.R
import com.qzy.spinning.mvp.contract.CourseTodayRankingContract
import com.qzy.spinning.mvp.datamodel.CourseTodayRanking
import com.qzy.spinning.mvp.datamodel.TodayRanking
import com.qzy.spinning.mvp.ui.adapter.TodayRankingAdapter
import com.qzy.spinning.util.L
import okhttp3.RequestBody



class TodayRankingFragment : Fragment(),CourseTodayRankingContract.View{

    override fun showCourseTodayRankingTask(courseTodayRanking: CourseTodayRanking) {
        L.i("look over list data = " + JSON.toJSONString(courseTodayRanking))
    }

    override fun showFiled(e: Throwable) {
        L.i("look over failed = " + e.message)
    }

    override lateinit var presenter: CourseTodayRankingContract.Presenter

    companion object {
        fun newInstance(): TodayRankingFragment{
            return TodayRankingFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root = inflater.inflate(R.layout.fragment_today_ranking,container,false)

        var list = ArrayList<TodayRanking>()

        for(i in 4..8){
            var todayRanking = TodayRanking(i.toString(),R.drawable.a1,"黄小洋人","96kcal",
                    "96bpm","89spm")
            list.add(todayRanking)
        }

        with(root){

            var rc = findViewById<RecyclerView>(R.id.rcRanking)

            rc.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL,false)

            var adapter = TodayRankingAdapter(activity?.applicationContext!!,list)

            rc.adapter = adapter

            adapter.notifyDataSetChanged()
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        var hashMap = HashMap<String,String>()
        hashMap["boxNum"] = "2000001"
        var content = JSON.toJSONString(hashMap)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), content)
        presenter.getCourseTodayRankingPresenter(body)
    }
}
package com.qzy.spinning.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.qzy.spinning.R
import com.qzy.spinning.mvp.datamodel.TodayRanking
import com.qzy.spinning.mvp.ui.adapter.TodayRankingAdapter
import kotlinx.android.synthetic.main.activity_today_ranking.*

class TodayRankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_ranking)
        var list = ArrayList<TodayRanking>()
        for(i in 4..8){
            var todayRanking = TodayRanking(i.toString(),R.drawable.a1,"黄小洋人","96kcal",
                    "96bpm","89spm")
            list.add(todayRanking)
        }

        var rc = rankingRc

        rc.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        var adapter = TodayRankingAdapter(this,list)

        rc.adapter = adapter
    }
}

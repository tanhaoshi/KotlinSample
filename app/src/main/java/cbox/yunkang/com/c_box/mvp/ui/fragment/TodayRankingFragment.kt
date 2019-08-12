package cbox.yunkang.com.c_box.mvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.mvp.contract.CourseTodayRankingContract
import cbox.yunkang.com.c_box.mvp.ui.adapter.TodayRankingAdapter
import cbox.yunkang.com.c_box.util.L
import com.alibaba.fastjson.JSON
import com.ykcx.bcore.utils.BasePreference
import okhttp3.RequestBody



class TodayRankingFragment : Fragment(), CourseTodayRankingContract.View{

    override fun showCourseTodayRankingTask(courseTodayRanking: cbox.yunkang.com.c_box.mvp.datamodel.CourseTodayRanking) {
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

        var list = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.TodayRanking>()

        for(i in 4..8){
            var todayRanking = cbox.yunkang.com.c_box.mvp.datamodel.TodayRanking(i.toString(),R.drawable.a1,"黄小洋人","96kcal",
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
        hashMap["boxNum"] = BasePreference.getInstance().boxNo
        var content = JSON.toJSONString(hashMap)
        val body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), content)
        presenter.getCourseTodayRankingPresenter(body)
    }
}
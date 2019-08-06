package com.qzy.spinning.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.qzy.spinning.R
import com.qzy.spinning.mvp.datamodel.TodayRanking
import com.qzy.spinning.mvp.model.Injection
import com.qzy.spinning.mvp.model.TaskRepository
import com.qzy.spinning.mvp.presenter.CourseTodayRankingPresenter
import com.qzy.spinning.mvp.ui.adapter.TodayRankingAdapter
import com.qzy.spinning.mvp.ui.fragment.TodayRankingFragment
import com.qzy.spinning.util.replaceFragmentInActivity
import kotlinx.android.synthetic.main.activity_today_ranking.*

class TodayRankingActivity : AppCompatActivity() {

    private lateinit var todayRankingPresenter: CourseTodayRankingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today_ranking)

        val todayRankingFragment = supportFragmentManager.findFragmentById(R.id.today_ranking_frame)
            as TodayRankingFragment? ?: TodayRankingFragment.newInstance().also {
            replaceFragmentInActivity(it,R.id.today_ranking_frame)
        }

        todayRankingPresenter = CourseTodayRankingPresenter(Injection.provideTaskRepository(applicationContext),todayRankingFragment)
    }
}

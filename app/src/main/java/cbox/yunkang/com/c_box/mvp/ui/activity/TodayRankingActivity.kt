package cbox.yunkang.com.c_box.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.mvp.model.Injection
import cbox.yunkang.com.c_box.mvp.presenter.CourseTodayRankingPresenter
import cbox.yunkang.com.c_box.mvp.ui.fragment.TodayRankingFragment
import cbox.yunkang.com.c_box.util.replaceFragmentInActivity

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

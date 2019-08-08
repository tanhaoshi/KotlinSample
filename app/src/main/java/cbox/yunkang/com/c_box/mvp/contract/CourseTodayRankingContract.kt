package cbox.yunkang.com.c_box.mvp.contract

import cbox.yunkang.com.c_box.mvp.base.BasePresenter
import cbox.yunkang.com.c_box.mvp.base.BaseView
import okhttp3.RequestBody

interface CourseTodayRankingContract {

    interface View : BaseView<Presenter> {
        fun showCourseTodayRankingTask(courseTodayRanking: cbox.yunkang.com.c_box.mvp.datamodel.CourseTodayRanking)
        fun showFiled(e:Throwable)
    }

    interface Presenter : BasePresenter {
        fun getCourseTodayRankingPresenter(body: RequestBody)
    }
}
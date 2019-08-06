package com.qzy.spinning.mvp.contract

import com.qzy.spinning.mvp.base.BasePresenter
import com.qzy.spinning.mvp.base.BaseView
import com.qzy.spinning.mvp.datamodel.CourseTodayRanking
import okhttp3.RequestBody

interface CourseTodayRankingContract {

    interface View : BaseView<Presenter>{
        fun showCourseTodayRankingTask(courseTodayRanking: CourseTodayRanking)
        fun showFiled(e:Throwable)
    }

    interface Presenter : BasePresenter{
        fun getCourseTodayRankingPresenter(body: RequestBody)
    }
}
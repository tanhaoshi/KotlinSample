package com.qzy.spinning.mvp.contract

import com.qzy.spinning.mvp.base.BasePresenter
import com.qzy.spinning.mvp.base.BaseView
import com.qzy.spinning.mvp.datamodel.RankingData
import com.qzy.spinning.mvp.datamodel.ScaleProgress

interface PhysicalContract {

    interface View : BaseView<Presenter>{
        fun showTasks(list: List<Int>)
        fun showProgressTasks(list: List<ScaleProgress>)
        fun showRankingTasks(list: List<RankingData>)
    }

    interface Presenter : BasePresenter{
        fun pullEngine()
        fun getRankingTasks()
    }
}
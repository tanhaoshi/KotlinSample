package com.qzy.spinning.mvp.contract

import com.qzy.spinning.mvp.base.BasePresenter
import com.qzy.spinning.mvp.base.BaseView
import com.qzy.spinning.mvp.datamodel.CourseExplain
import com.qzy.spinning.mvp.datamodel.RankingData
import com.qzy.spinning.mvp.datamodel.ResponsePhysical
import com.qzy.spinning.mvp.datamodel.ScaleProgress
import okhttp3.RequestBody

interface PhysicalContract {

    interface View : BaseView<Presenter>{
        fun showTasks(list: List<Int>)
        fun showProgressTasks(list: List<ScaleProgress>)
        fun showRankingTasks(list: List<RankingData>)
        fun showPhysicalFinishTask(responsePhysical: ResponsePhysical)
        fun showPhysicalProgressTask(courseExplain: CourseExplain)
        fun showFailed(throwable: Throwable)
    }

    interface Presenter : BasePresenter{
        fun pullEngine()
        fun getRankingTasks()
        fun submitPhysicalTask(requestBody: RequestBody)
        fun getPhysicalProgressTask(hashMap: HashMap<String, RequestBody>)
    }
}
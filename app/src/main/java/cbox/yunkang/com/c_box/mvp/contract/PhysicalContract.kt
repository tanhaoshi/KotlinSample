package cbox.yunkang.com.c_box.mvp.contract

import cbox.yunkang.com.c_box.mvp.base.BasePresenter
import cbox.yunkang.com.c_box.mvp.base.BaseView
import okhttp3.RequestBody

interface PhysicalContract {

    interface View : BaseView<Presenter> {
        fun showTasks(list: List<Int>)
        fun showProgressTasks(list: List<cbox.yunkang.com.c_box.mvp.datamodel.ScaleProgress>)
        fun showRankingTasks(list: List<cbox.yunkang.com.c_box.mvp.datamodel.RankingData>)
        fun showPhysicalFinishTask(responsePhysical: cbox.yunkang.com.c_box.mvp.datamodel.ResponsePhysical)
        fun showPhysicalProgressTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain)
        fun showFailed(throwable: Throwable)
    }

    interface Presenter : BasePresenter {
        fun pullEngine()
        fun getRankingTasks()
        fun submitPhysicalTask(requestBody: RequestBody)
        fun getPhysicalProgressTask(hashMap: HashMap<String, RequestBody>)
    }
}
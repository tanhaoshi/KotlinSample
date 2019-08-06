package com.qzy.spinning.mvp.presenter

import com.qzy.spinning.mvp.contract.CourseTodayRankingContract
import com.qzy.spinning.mvp.datamodel.CourseTodayRanking
import com.qzy.spinning.mvp.model.TaskRepository
import com.qzy.spinning.mvp.model.TasksDataSource
import okhttp3.RequestBody

class CourseTodayRankingPresenter(val taskRepository: TaskRepository,val courseTodayRankingView: CourseTodayRankingContract.View):
   CourseTodayRankingContract.Presenter{

    init {
        courseTodayRankingView.presenter = this
    }

    override fun getCourseTodayRankingPresenter(body:RequestBody) {
        taskRepository.getCourseTodayRankingTask(body,object :TasksDataSource.LoadCourseTodayRankingCallback{
            override fun onCourseTodayRankingTask(courseTodayRanking: CourseTodayRanking) {
                courseTodayRankingView.showCourseTodayRankingTask(courseTodayRanking)
            }
            override fun onDataNotAvailable(e: Throwable) {
                courseTodayRankingView.showFiled(e)
            }
        })
    }

    override fun start() {

    }

}
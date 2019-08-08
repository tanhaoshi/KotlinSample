package cbox.yunkang.com.c_box.mvp.presenter

import cbox.yunkang.com.c_box.mvp.contract.CourseTodayRankingContract
import cbox.yunkang.com.c_box.mvp.model.TaskRepository
import cbox.yunkang.com.c_box.mvp.model.TasksDataSource
import okhttp3.RequestBody

class CourseTodayRankingPresenter(val taskRepository: TaskRepository, val courseTodayRankingView: CourseTodayRankingContract.View):
   CourseTodayRankingContract.Presenter{

    init {
        courseTodayRankingView.presenter = this
    }

    override fun getCourseTodayRankingPresenter(body:RequestBody) {
        taskRepository.getCourseTodayRankingTask(body,object : TasksDataSource.LoadCourseTodayRankingCallback{
            override fun onCourseTodayRankingTask(courseTodayRanking: cbox.yunkang.com.c_box.mvp.datamodel.CourseTodayRanking) {
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
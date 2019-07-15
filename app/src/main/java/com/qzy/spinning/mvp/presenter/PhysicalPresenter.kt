package com.qzy.spinning.mvp.presenter

import com.qzy.spinning.mvp.contract.PhysicalContract
import com.qzy.spinning.mvp.datamodel.RankingData
import com.qzy.spinning.mvp.datamodel.ScaleProgress
import com.qzy.spinning.mvp.model.TaskRepository
import com.qzy.spinning.mvp.model.TasksDataSource

class PhysicalPresenter (val taskRepository: TaskRepository, val physicalView: PhysicalContract.View)
    : PhysicalContract.Presenter{

    init {
        physicalView.presenter = this
    }

    override fun start() {
        taskRepository.getTasks(object : TasksDataSource.LoadTasksCallback{
            override fun onTasksLoaded(list: List<Int>) {
                physicalView.showTasks(list)
            }

            override fun onDataNotAvailable() {}
        })

        pullEngine()
    }

    override fun pullEngine() {
       taskRepository.getProgressData(object : TasksDataSource.LoadProgressCallBack{
           override fun onTasksLoaded(list: List<ScaleProgress>) {
                physicalView.showProgressTasks(list)
           }

           override fun onDataNotAvailable() {

           }
       })
    }

    override fun getRankingTasks() {
        taskRepository.getRankingTask(object : TasksDataSource.LoadRankingTaskCallback{
            override fun onRankingTask(list: List<RankingData>) {
                physicalView.showRankingTasks(list)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

}
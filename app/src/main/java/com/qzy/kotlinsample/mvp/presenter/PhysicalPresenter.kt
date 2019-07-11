package com.qzy.kotlinsample.mvp.presenter

import com.qzy.kotlinsample.mvp.contract.PhysicalContract
import com.qzy.kotlinsample.mvp.datamodel.ScaleProgress
import com.qzy.kotlinsample.mvp.model.TaskRepository
import com.qzy.kotlinsample.mvp.model.TasksDataSource

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

            override fun onDataNotAvailable() {

            }

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

}
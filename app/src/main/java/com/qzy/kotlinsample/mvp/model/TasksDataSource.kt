package com.qzy.kotlinsample.mvp.model

import com.qzy.kotlinsample.mvp.datamodel.ScaleProgress

interface TasksDataSource {

    interface LoadTasksCallback{
        fun onTasksLoaded(list : List<Int>)
        fun onDataNotAvailable()
    }

    interface LoadProgressCallBack{
        fun onTasksLoaded(list : List<ScaleProgress>)
        fun onDataNotAvailable()
    }

    fun getTasks(callback : LoadTasksCallback)

    fun getProgressData(call : LoadProgressCallBack)
}
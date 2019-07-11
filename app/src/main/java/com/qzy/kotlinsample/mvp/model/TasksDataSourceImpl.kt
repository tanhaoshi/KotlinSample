package com.qzy.kotlinsample.mvp.model

import com.qzy.kotlinsample.mvp.datamodel.ScaleProgress
import kotlin.random.Random

class TasksDataSourceImpl private constructor() : TasksDataSource{

    override fun getProgressData(call: TasksDataSource.LoadProgressCallBack) {
        var list = ArrayList<ScaleProgress>()
        var scaleProgress = ScaleProgress(0.1,0.2,5)
        list.add(scaleProgress)
        var scaleProgress1 = ScaleProgress(0.3,0.3,5)
        list.add(scaleProgress1)
        var scaleProgress2 = ScaleProgress(0.1,0.2,5)
        list.add(scaleProgress2)
        var scaleProgress3 = ScaleProgress(0.2,0.25,5)
        list.add(scaleProgress3)
        var scaleProgress4 = ScaleProgress(0.3,0.05,5)
        list.add(scaleProgress4)
        call.onTasksLoaded(list)
    }

    override fun getTasks(callback: TasksDataSource.LoadTasksCallback) {
        var list = ArrayList<Int>()
        var random = Random
        for (i in 0..7){
            list.add(random.nextInt(11))
        }
        callback.onTasksLoaded(list)
    }

    companion object {

        private lateinit var INSTANCE:TasksDataSourceImpl
        private var needsNewInstance = true

        @JvmStatic fun getInstance() : TasksDataSourceImpl {
            if(needsNewInstance){
                INSTANCE = TasksDataSourceImpl()
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}
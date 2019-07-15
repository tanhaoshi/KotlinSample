package com.qzy.spinning.mvp.model

import com.qzy.spinning.mvp.datamodel.RankingData
import com.qzy.spinning.mvp.datamodel.ScaleProgress

interface TasksDataSource {

    interface LoadTasksCallback{
        fun onTasksLoaded(list : List<Int>)
        fun onDataNotAvailable()
    }

    interface LoadProgressCallBack{
        fun onTasksLoaded(list : List<ScaleProgress>)
        fun onDataNotAvailable()
    }

    interface LoadRankingTaskCallback{
        fun onRankingTask(list: List<RankingData>)
        fun onDataNotAvailable()
    }

    fun getTasks(callback : LoadTasksCallback)

    fun getProgressData(call : LoadProgressCallBack)

    fun getRankingTask(callback : LoadRankingTaskCallback)
}
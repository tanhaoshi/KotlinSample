package com.qzy.spinning.mvp.model

import com.qzy.spinning.mvp.datamodel.RankingData
import com.qzy.spinning.mvp.datamodel.ScaleProgress
import com.qzy.spinning.mvp.datamodel.SmartCourse
import okhttp3.RequestBody
import okhttp3.ResponseBody

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

    interface LoadSmartCourseCallback{
        fun onSmartCourseTask(responseBody : ResponseBody)
        fun onDataNotAvailable(e : Throwable)
    }

    fun getTasks(callback : LoadTasksCallback)

    fun getProgressData(call : LoadProgressCallBack)

    fun getRankingTask(callback : LoadRankingTaskCallback)

    fun getSmartCourseTask(hashMap: HashMap<String,RequestBody>,callback : LoadSmartCourseCallback)

}
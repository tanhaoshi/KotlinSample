package com.qzy.spinning.mvp.model

import com.qzy.spinning.mvp.datamodel.*
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

    interface LoadCourseTableCallback{
        fun onCourseTableTask(responseBody: CourseTable)
        fun onDataNotAvailable(e:Throwable)
    }

    interface LoadCourseExplainCallback{
        fun onCourseExplainTask(courseExplain: CourseExplain)
        fun onDataNotAvailable(e:Throwable)
    }

    interface LoadCourseDescriptionCallback{
        fun onCourseDescriptionTask(courseExplain: CourseExplain)
        fun onDataNotAvailable(e:Throwable)
    }

    interface LoadCourseTodayRankingCallback{
        fun onCourseTodayRankingTask(courseTodayRanking: CourseTodayRanking)
        fun onDataNotAvailable(e: Throwable)
    }

    interface SubmitCoursePhysicalCallback{
        fun onCoursePhysicalTask(responsePhysical: ResponsePhysical)
        fun onDataNotAvailable(e: Throwable)
    }

    fun getTasks(callback : LoadTasksCallback)

    fun getProgressData(call : LoadProgressCallBack)

    fun getRankingTask(callback : LoadRankingTaskCallback)

    fun getSmartCourseTask(hashMap: HashMap<String,RequestBody>,callback : LoadSmartCourseCallback)

    fun getCourseTableTask(callback: LoadCourseTableCallback)

    fun getCourseExplainTask(hashMap: HashMap<String, RequestBody>, callback: LoadCourseExplainCallback)

    fun getCourseDescriptionTask(hashMap:HashMap<String,RequestBody>,callback : LoadCourseDescriptionCallback)

    fun getCourseTodayRankingTask(body: RequestBody,callback:LoadCourseTodayRankingCallback)

    fun submitCoursePhysicalTask(body: RequestBody,callback:SubmitCoursePhysicalCallback)
}
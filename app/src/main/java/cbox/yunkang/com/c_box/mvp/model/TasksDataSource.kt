package cbox.yunkang.com.c_box.mvp.model

import cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse
import okhttp3.RequestBody
import okhttp3.ResponseBody

interface TasksDataSource {

    interface LoadTasksCallback{
        fun onTasksLoaded(list : List<Int>)
        fun onDataNotAvailable()
    }

    interface LoadProgressCallBack{
        fun onTasksLoaded(list : List<cbox.yunkang.com.c_box.mvp.datamodel.ScaleProgress>)
        fun onDataNotAvailable()
    }

    interface LoadRankingTaskCallback{
        fun onRankingTask(list: List<cbox.yunkang.com.c_box.mvp.datamodel.RankingData>)
        fun onDataNotAvailable()
    }

    interface LoadSmartCourseCallback{
        fun onSmartCourseTask(responseBody : SmartCourse)
        fun onDataNotAvailable(e : Throwable)
    }

    interface LoadCourseTableCallback{
        fun onCourseTableTask(responseBody: cbox.yunkang.com.c_box.mvp.datamodel.CourseTable)
        fun onDataNotAvailable(e:Throwable)
    }

    interface LoadCourseExplainCallback{
        fun onCourseExplainTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain)
        fun onDataNotAvailable(e:Throwable)
    }

    interface LoadCourseDescriptionCallback{
        fun onCourseDescriptionTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain)
        fun onDataNotAvailable(e:Throwable)
    }

    interface LoadCourseTodayRankingCallback{
        fun onCourseTodayRankingTask(courseTodayRanking: cbox.yunkang.com.c_box.mvp.datamodel.CourseTodayRanking)
        fun onDataNotAvailable(e: Throwable)
    }

    interface SubmitCoursePhysicalCallback{
        fun onCoursePhysicalTask(responsePhysical: cbox.yunkang.com.c_box.mvp.datamodel.ResponsePhysical)
        fun onDataNotAvailable(e: Throwable)
    }

    interface LoadCourseTryCallback{
        fun onCourseTryTask(responseBody: ResponseBody)
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

    fun getCourseTryTask(hashMap: HashMap<String, RequestBody>,callback:LoadCourseTryCallback)
}
package com.qzy.spinning.mvp.model

import okhttp3.RequestBody


class TaskRepository (private val tasksDataSource: TasksDataSource) : TasksDataSource{

    override fun getRankingTask(callback: TasksDataSource.LoadRankingTaskCallback) {
        tasksDataSource.getRankingTask(callback)
    }

    override fun getProgressData(call: TasksDataSource.LoadProgressCallBack) {
        tasksDataSource.getProgressData(call)
    }

    override fun getTasks(callback: TasksDataSource.LoadTasksCallback) {
        tasksDataSource.getTasks(callback)
    }

    override fun getSmartCourseTask(hashMap: HashMap<String,RequestBody>,callback: TasksDataSource.LoadSmartCourseCallback) {
        tasksDataSource.getSmartCourseTask(hashMap,callback)
    }

    override fun getCourseTableTask(callback: TasksDataSource.LoadCourseTableCallback) {
        tasksDataSource.getCourseTableTask(callback)
    }

    override fun getCourseExplainTask(hashMap: HashMap<String, RequestBody>, callback: TasksDataSource.LoadCourseExplainCallback) {
        tasksDataSource.getCourseExplainTask(hashMap,callback)
    }

    override fun getCourseDescriptionTask(hashMap: HashMap<String, RequestBody>, callback: TasksDataSource.LoadCourseDescriptionCallback) {
        tasksDataSource.getCourseDescriptionTask(hashMap,callback)
    }

    override fun getCourseTodayRankingTask(body: RequestBody, callback: TasksDataSource.LoadCourseTodayRankingCallback) {
        tasksDataSource.getCourseTodayRankingTask(body,callback)
    }

    override fun submitCoursePhysicalTask(body: RequestBody, callback: TasksDataSource.SubmitCoursePhysicalCallback) {
        tasksDataSource.submitCoursePhysicalTask(body,callback)
    }

    companion object {

        private var INSTANCE : TaskRepository ? = null

        @JvmStatic fun getInstance(tasksDataSource: TasksDataSource) : TaskRepository{
            return INSTANCE ?: TaskRepository(tasksDataSource)
                    .apply {
                        INSTANCE = this
                    }
        }

        @JvmStatic fun destroyInstance(){
            INSTANCE = null
        }
    }
}
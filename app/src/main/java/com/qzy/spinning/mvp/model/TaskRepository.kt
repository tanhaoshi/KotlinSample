package com.qzy.spinning.mvp.model

import okhttp3.RequestBody


class TaskRepository (val tasksDataSource: TasksDataSource) : TasksDataSource{

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
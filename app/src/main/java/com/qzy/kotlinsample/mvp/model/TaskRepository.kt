package com.qzy.kotlinsample.mvp.model

class TaskRepository (val tasksDataSource: TasksDataSource){

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
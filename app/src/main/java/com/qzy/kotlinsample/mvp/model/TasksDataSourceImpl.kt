package com.qzy.kotlinsample.mvp.model

class TasksDataSourceImpl private constructor() : TasksDataSource{

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
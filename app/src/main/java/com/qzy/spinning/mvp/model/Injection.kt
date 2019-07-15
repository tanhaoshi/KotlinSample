package com.qzy.spinning.mvp.model

import android.content.Context

object Injection {

    fun provideTaskRepository(context: Context) : TaskRepository{
        return TaskRepository.getInstance(TasksDataSourceImpl.getInstance())
    }
}
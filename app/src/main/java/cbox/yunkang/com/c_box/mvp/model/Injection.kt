package cbox.yunkang.com.c_box.mvp.model

import android.content.Context

object Injection {

    fun provideTaskRepository(context: Context) : TaskRepository{
        return TaskRepository.getInstance(TasksDataSourceImpl.getInstance())
    }
}
package com.qzy.spinning.mvp.presenter

import com.alibaba.fastjson.JSON
import com.qzy.spinning.mvp.contract.SmartCourseContract
import com.qzy.spinning.mvp.datamodel.SmartCourse
import com.qzy.spinning.mvp.model.TaskRepository
import com.qzy.spinning.mvp.model.TasksDataSource
import okhttp3.RequestBody
import okhttp3.ResponseBody

class SmartCoursePresenter(val taskRepository: TaskRepository,val smartCourseView: SmartCourseContract.View) : SmartCourseContract.Presenter {

    init {
        smartCourseView.presenter = this
    }

    override fun start() {

    }

    override fun getSmartCoursePresenter(hashMap: HashMap<String,RequestBody>) {
        taskRepository.getSmartCourseTask(hashMap,object : TasksDataSource.LoadSmartCourseCallback{
            override fun onDataNotAvailable(error : Throwable) {
                smartCourseView.showFailed(error.message!!)
            }

            override fun onSmartCourseTask(responseBody: ResponseBody) {
                var smartCourse : SmartCourse = JSON.parseObject(responseBody.string(),SmartCourse::class.java)
                smartCourseView.showSmartCourseTasks(smartCourse)
            }
        })
    }


}
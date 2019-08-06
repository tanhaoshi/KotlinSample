package com.qzy.spinning.mvp.presenter

import com.qzy.spinning.mvp.contract.CourseDescriptionContract
import com.qzy.spinning.mvp.datamodel.CourseExplain
import com.qzy.spinning.mvp.model.TaskRepository
import com.qzy.spinning.mvp.model.TasksDataSource
import okhttp3.RequestBody

class CourseDescriptionPresenter(val taskRepository: TaskRepository,val courseDescriptionView: CourseDescriptionContract.View)
    : CourseDescriptionContract.Presenter{

    init {
        courseDescriptionView.presenter = this
    }

    override fun start() {

    }

    override fun getCourseDescriptionPresenter(hashMap: HashMap<String, RequestBody>) {
        taskRepository.getCourseDescriptionTask(hashMap,object :TasksDataSource.LoadCourseDescriptionCallback{
            override fun onCourseDescriptionTask(courseExplain: CourseExplain) {
                courseDescriptionView.showCourseDescriptionTask(courseExplain)
            }

            override fun onDataNotAvailable(e: Throwable) {
                courseDescriptionView.showFailed(e!!)
            }
        })
    }
}
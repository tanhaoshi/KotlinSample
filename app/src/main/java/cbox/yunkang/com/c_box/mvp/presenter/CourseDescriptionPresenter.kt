package cbox.yunkang.com.c_box.mvp.presenter

import cbox.yunkang.com.c_box.mvp.contract.CourseDescriptionContract
import cbox.yunkang.com.c_box.mvp.model.TaskRepository
import cbox.yunkang.com.c_box.mvp.model.TasksDataSource
import okhttp3.RequestBody

class CourseDescriptionPresenter(val taskRepository: TaskRepository, val courseDescriptionView: CourseDescriptionContract.View)
    : CourseDescriptionContract.Presenter{

    init {
        courseDescriptionView.presenter = this
    }

    override fun start() {

    }

    override fun getCourseDescriptionPresenter(hashMap: HashMap<String, RequestBody>) {
        taskRepository.getCourseDescriptionTask(hashMap,object : TasksDataSource.LoadCourseDescriptionCallback{
            override fun onCourseDescriptionTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain) {
                courseDescriptionView.showCourseDescriptionTask(courseExplain)
            }

            override fun onDataNotAvailable(e: Throwable) {
                courseDescriptionView.showFailed(e!!)
            }
        })
    }
}
package com.qzy.spinning.mvp.presenter

import android.util.Log
import com.alibaba.fastjson.JSON
import com.qzy.spinning.mvp.contract.CourseExplainContract
import com.qzy.spinning.mvp.datamodel.CourseExplain
import com.qzy.spinning.mvp.datamodel.CourseTable
import com.qzy.spinning.mvp.model.TaskRepository
import com.qzy.spinning.mvp.model.TasksDataSource
import com.qzy.spinning.util.L
import okhttp3.RequestBody

class CourseExplainPresenter(val taskRepository: TaskRepository,val courseExplainView:CourseExplainContract.View):CourseExplainContract.Presenter{

    init {
        courseExplainView.presenter = this
    }

    override fun getCourseTablePresenter() {
        taskRepository.getCourseTableTask(object :TasksDataSource.LoadCourseTableCallback{
            override fun onCourseTableTask(responseBody: CourseTable) {
                L.i("data = "+JSON.toJSONString(responseBody))
                courseExplainView.showCourseTableTask(responseBody)
            }

            override fun onDataNotAvailable(e: Throwable) {
                courseExplainView.showFailed(e)
                Log.i("onDataNotAvailable","result : " + e.message)
            }
        })
    }

    override fun start() {

    }

    override fun getCourseExplainPresenter(hashMap: HashMap<String,RequestBody>) {
        taskRepository.getCourseExplainTask(hashMap,object :TasksDataSource.LoadCourseExplainCallback{
            override fun onCourseExplainTask(courseExplain: CourseExplain) {
                courseExplainView.showCourseExplainTask(courseExplain)
                Log.i("onCourseExplainTask","result : " + JSON.toJSONString(courseExplain))
            }

            override fun onDataNotAvailable(e: Throwable) {
                courseExplainView.showFailed(e)
                Log.i("onDataNotAvailable","error : " + e.message)
            }
        })
    }
}
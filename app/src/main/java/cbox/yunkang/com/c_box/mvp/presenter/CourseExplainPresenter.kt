package cbox.yunkang.com.c_box.mvp.presenter

import android.util.Log
import cbox.yunkang.com.c_box.mvp.contract.CourseExplainContract
import cbox.yunkang.com.c_box.mvp.model.TaskRepository
import cbox.yunkang.com.c_box.mvp.model.TasksDataSource
import cbox.yunkang.com.c_box.util.L
import com.alibaba.fastjson.JSON
import okhttp3.RequestBody

class CourseExplainPresenter(val taskRepository: TaskRepository, val courseExplainView: CourseExplainContract.View):CourseExplainContract.Presenter{

    init {
        courseExplainView.presenter = this
    }

    override fun getCourseTablePresenter() {
        taskRepository.getCourseTableTask(object :TasksDataSource.LoadCourseTableCallback{
            override fun onCourseTableTask(responseBody: cbox.yunkang.com.c_box.mvp.datamodel.CourseTable) {
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
        taskRepository.getCourseExplainTask(hashMap,object : TasksDataSource.LoadCourseExplainCallback{
            override fun onCourseExplainTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain) {
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
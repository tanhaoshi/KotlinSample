package cbox.yunkang.com.c_box.mvp.presenter

import cbox.yunkang.com.c_box.mvp.contract.SmartCourseContract
import cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse
import cbox.yunkang.com.c_box.mvp.model.TaskRepository
import cbox.yunkang.com.c_box.mvp.model.TasksDataSource
import com.alibaba.fastjson.JSON
import okhttp3.RequestBody
import okhttp3.ResponseBody

class SmartCoursePresenter(val taskRepository: TaskRepository, val smartCourseView: SmartCourseContract.View) : SmartCourseContract.Presenter {

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

            override fun onSmartCourseTask(responseBody: SmartCourse) {
                smartCourseView.showSmartCourseTasks(responseBody)
            }
        })
    }

    override fun sumitCourseTryPresenter(map: HashMap<String, RequestBody>) {
        taskRepository.getCourseTryTask(map,object :TasksDataSource.LoadCourseTryCallback{
            override fun onCourseTryTask(responseBody: ResponseBody) {
                var resultMap : HashMap<String,String> =
                        JSON.parseObject(responseBody.string(), HashMap<String,String>()::class.java)
                if(resultMap["code"].toString() == 200.toString()){
                    smartCourseView.showTryResult(resultMap["message"].toString())
                }
            }

            override fun onDataNotAvailable(e: Throwable) {
                smartCourseView.showFailed(e.message!!)
            }
        })
    }
}
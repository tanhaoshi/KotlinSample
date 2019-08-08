package cbox.yunkang.com.c_box.mvp.presenter

import cbox.yunkang.com.c_box.mvp.contract.PhysicalContract
import cbox.yunkang.com.c_box.mvp.model.TaskRepository
import cbox.yunkang.com.c_box.mvp.model.TasksDataSource
import okhttp3.RequestBody
import java.io.File



class PhysicalPresenter (val taskRepository: TaskRepository, val physicalView: PhysicalContract.View)
    : PhysicalContract.Presenter{

    init {
        physicalView.presenter = this
    }

    override fun start() {
        taskRepository.getTasks(object : TasksDataSource.LoadTasksCallback{
            override fun onTasksLoaded(list: List<Int>) {
                physicalView.showTasks(list)
            }

            override fun onDataNotAvailable() {}
        })

        pullEngine()
    }

    override fun pullEngine() {
       taskRepository.getProgressData(object : TasksDataSource.LoadProgressCallBack{
           override fun onTasksLoaded(list: List<cbox.yunkang.com.c_box.mvp.datamodel.ScaleProgress>) {
                physicalView.showProgressTasks(list)
           }
           override fun onDataNotAvailable() {

           }
       })
    }

    override fun getRankingTasks() {
        taskRepository.getRankingTask(object : TasksDataSource.LoadRankingTaskCallback{
            override fun onRankingTask(list: List<cbox.yunkang.com.c_box.mvp.datamodel.RankingData>) {
                physicalView.showRankingTasks(list)
            }
            override fun onDataNotAvailable() {

            }
        })
    }

    override fun submitPhysicalTask(requestBody: RequestBody) {
        taskRepository.submitCoursePhysicalTask(requestBody,object :TasksDataSource.SubmitCoursePhysicalCallback{
            override fun onCoursePhysicalTask(responsePhysical: cbox.yunkang.com.c_box.mvp.datamodel.ResponsePhysical) {
                physicalView.showPhysicalFinishTask(responsePhysical)
            }
            override fun onDataNotAvailable(e: Throwable) {
                physicalView.showFailed(e)
            }
        })
    }

    override fun getPhysicalProgressTask(hashMap: HashMap<String, RequestBody>) {
        taskRepository.getCourseDescriptionTask(hashMap,object :TasksDataSource.LoadCourseDescriptionCallback{
            override fun onCourseDescriptionTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain) {
                physicalView.showPhysicalProgressTask(courseExplain)
            }
            override fun onDataNotAvailable(e: Throwable) {
                physicalView.showFailed(e)
            }
        })
    }
}
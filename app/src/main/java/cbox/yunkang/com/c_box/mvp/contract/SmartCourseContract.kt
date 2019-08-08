package cbox.yunkang.com.c_box.mvp.contract

import cbox.yunkang.com.c_box.mvp.base.BasePresenter
import cbox.yunkang.com.c_box.mvp.base.BaseView
import cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse
import okhttp3.RequestBody

interface SmartCourseContract {

    interface View : BaseView<Presenter> {
        fun showSmartCourseTasks(smartCourse: SmartCourse)
        fun showFailed(string: String)
        fun showTryResult(result:String)
    }

    interface Presenter : BasePresenter {
        fun getSmartCoursePresenter(map: HashMap<String,RequestBody>)
        fun sumitCourseTryPresenter(map: HashMap<String,RequestBody>)
    }
}
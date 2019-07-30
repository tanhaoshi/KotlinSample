package com.qzy.spinning.mvp.contract

import com.qzy.spinning.mvp.base.BasePresenter
import com.qzy.spinning.mvp.base.BaseView
import com.qzy.spinning.mvp.datamodel.SmartCourse
import okhttp3.RequestBody

interface SmartCourseContract {

    interface View : BaseView<Presenter>{
        fun showSmartCourseTasks(smartCourse: SmartCourse)
        fun showFailed(string: String)
    }

    interface Presenter : BasePresenter{
        fun getSmartCoursePresenter(map: HashMap<String,RequestBody>)
    }
}
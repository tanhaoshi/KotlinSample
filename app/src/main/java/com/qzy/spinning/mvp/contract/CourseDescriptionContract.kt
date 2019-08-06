package com.qzy.spinning.mvp.contract

import com.qzy.spinning.mvp.base.BasePresenter
import com.qzy.spinning.mvp.base.BaseView
import com.qzy.spinning.mvp.datamodel.CourseExplain
import okhttp3.RequestBody

interface CourseDescriptionContract {

    interface View : BaseView<Presenter> {
        fun showCourseDescriptionTask(courseExplain:CourseExplain)
        fun showFailed(t:Throwable)
    }

    interface Presenter : BasePresenter{
        fun getCourseDescriptionPresenter(hashMap : HashMap<String,RequestBody>)
    }
}
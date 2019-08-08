package cbox.yunkang.com.c_box.mvp.contract

import cbox.yunkang.com.c_box.mvp.base.BasePresenter
import cbox.yunkang.com.c_box.mvp.base.BaseView
import okhttp3.RequestBody

interface CourseDescriptionContract {

    interface View : BaseView<Presenter> {
        fun showCourseDescriptionTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain)
        fun showFailed(t:Throwable)
    }

    interface Presenter : BasePresenter {
        fun getCourseDescriptionPresenter(hashMap : HashMap<String,RequestBody>)
    }
}
package cbox.yunkang.com.c_box.mvp.contract

import cbox.yunkang.com.c_box.mvp.base.BasePresenter
import cbox.yunkang.com.c_box.mvp.base.BaseView
import okhttp3.RequestBody

interface CourseExplainContract {

    interface View : BaseView<Presenter> {
        fun showCourseTableTask(courseTable: cbox.yunkang.com.c_box.mvp.datamodel.CourseTable)
        fun showFailed(e:Throwable)

        fun showCourseExplainTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain)
    }

    interface Presenter : BasePresenter {
        fun getCourseTablePresenter()
        fun getCourseExplainPresenter(hashMap: HashMap<String,RequestBody>)
    }
}
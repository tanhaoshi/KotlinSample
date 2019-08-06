package com.qzy.spinning.mvp.contract

import com.qzy.spinning.mvp.base.BasePresenter
import com.qzy.spinning.mvp.base.BaseView
import com.qzy.spinning.mvp.datamodel.CourseExplain
import com.qzy.spinning.mvp.datamodel.CourseTable
import okhttp3.RequestBody

interface CourseExplainContract {

    interface View : BaseView<Presenter>{
        fun showCourseTableTask(courseTable: CourseTable)
        fun showFailed(e:Throwable)

        fun showCourseExplainTask(courseExplain: CourseExplain)
    }

    interface Presenter : BasePresenter{
        fun getCourseTablePresenter()
        fun getCourseExplainPresenter(hashMap: HashMap<String,RequestBody>)
    }
}
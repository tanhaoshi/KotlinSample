package com.qzy.kotlinsample.mvp.contract

import com.qzy.kotlinsample.mvp.base.BasePresenter
import com.qzy.kotlinsample.mvp.base.BaseView
import com.qzy.kotlinsample.mvp.datamodel.ScaleProgress

interface PhysicalContract {

    interface View : BaseView<Presenter>{
        fun showTasks(list: List<Int>)
        fun showProgressTasks(list: List<ScaleProgress>)
    }

    interface Presenter : BasePresenter{
        fun pullEngine()
    }
}
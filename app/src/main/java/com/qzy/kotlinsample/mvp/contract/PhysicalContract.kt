package com.qzy.kotlinsample.mvp.contract

import com.qzy.kotlinsample.mvp.base.BasePresenter
import com.qzy.kotlinsample.mvp.base.BaseView

interface PhysicalContract {

    interface View : BaseView<Presenter>{

    }

    interface Presenter : BasePresenter{

    }
}
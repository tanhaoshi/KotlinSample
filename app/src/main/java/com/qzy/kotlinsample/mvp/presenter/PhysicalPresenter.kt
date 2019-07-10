package com.qzy.kotlinsample.mvp.presenter

import com.qzy.kotlinsample.mvp.contract.PhysicalContract
import com.qzy.kotlinsample.mvp.model.TaskRepository

class PhysicalPresenter (val taskRepository: TaskRepository, val physicalView: PhysicalContract.View)
    : PhysicalContract.Presenter{

    init {
        physicalView.presenter = this
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
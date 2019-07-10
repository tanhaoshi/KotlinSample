package com.qzy.kotlinsample.mvp.ui.activity

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.qzy.kotlinsample.R
import com.qzy.kotlinsample.mvp.contract.PhysicalContract
import com.qzy.kotlinsample.mvp.model.Injection
import com.qzy.kotlinsample.mvp.presenter.PhysicalPresenter
import com.qzy.kotlinsample.mvp.ui.fragment.PhysicalFragment
import com.qzy.kotlinsample.util.replaceFragmentInActivity


class PhysicalActivity : AppCompatActivity() {

    private lateinit var physicalPresenter: PhysicalContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(R.layout.activity_physical)

        val physicalFragment = supportFragmentManager.findFragmentById(R.id.fragment_content)
            as PhysicalFragment? ?: PhysicalFragment.newInstance().also {
                replaceFragmentInActivity(it,R.id.fragment_content)
        }

        physicalPresenter = PhysicalPresenter(Injection.provideTaskRepository(applicationContext),physicalFragment)
    }

}

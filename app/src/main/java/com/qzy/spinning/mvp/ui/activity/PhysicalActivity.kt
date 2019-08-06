package com.qzy.spinning.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.qzy.spinning.R
import com.qzy.spinning.mvp.contract.PhysicalContract
import com.qzy.spinning.mvp.model.Injection
import com.qzy.spinning.mvp.presenter.PhysicalPresenter
import com.qzy.spinning.mvp.ui.fragment.PhysicalFragment
import com.qzy.spinning.util.replaceFragmentInActivity


class PhysicalActivity : AppCompatActivity() {

    private lateinit var physicalPresenter: PhysicalContract.Presenter

    lateinit var uuid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_physical)

        var intent = intent

        var bundle = intent.getBundleExtra("bundle") as Bundle

        this.uuid = bundle.getString("uuid")

        val physicalFragment = supportFragmentManager.findFragmentById(R.id.fragment_content)
            as PhysicalFragment? ?: PhysicalFragment.newInstance().also {
                replaceFragmentInActivity(it,R.id.fragment_content)
        }

        physicalPresenter = PhysicalPresenter(Injection.provideTaskRepository(applicationContext),physicalFragment)
    }

}

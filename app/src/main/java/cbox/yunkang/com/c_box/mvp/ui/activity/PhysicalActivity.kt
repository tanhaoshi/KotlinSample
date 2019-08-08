package cbox.yunkang.com.c_box.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.mvp.contract.PhysicalContract
import cbox.yunkang.com.c_box.mvp.model.Injection
import cbox.yunkang.com.c_box.mvp.presenter.PhysicalPresenter
import cbox.yunkang.com.c_box.mvp.ui.fragment.PhysicalFragment
import cbox.yunkang.com.c_box.util.replaceFragmentInActivity


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

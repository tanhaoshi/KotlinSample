package com.qzy.spinning.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.qzy.spinning.R
import com.qzy.spinning.mvp.datamodel.CourseModel
import com.qzy.spinning.mvp.model.Injection
import com.qzy.spinning.mvp.presenter.SmartCoursePresenter
import com.qzy.spinning.mvp.ui.adapter.SmartCourseAdapter
import com.qzy.spinning.mvp.ui.fragment.PhysicalFragment
import com.qzy.spinning.mvp.ui.fragment.SmartCourseFragment
import com.qzy.spinning.util.replaceFragmentInActivity
import com.qzy.spinning.util.toast
import kotlinx.android.synthetic.main.activity_smart_course.*

class SmartCourseActivity : AppCompatActivity() {

    private lateinit var smartCoursePresenter: SmartCoursePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_course)

        val smartCourseFragment = supportFragmentManager.findFragmentById(R.id.smart_fragment)
                as SmartCourseFragment? ?: SmartCourseFragment.newInstance().also {
            replaceFragmentInActivity(it,R.id.smart_fragment)
        }

        smartCoursePresenter = SmartCoursePresenter(Injection.provideTaskRepository(applicationContext),smartCourseFragment)
    }

}

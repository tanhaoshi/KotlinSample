package cbox.yunkang.com.c_box.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.mvp.model.Injection
import cbox.yunkang.com.c_box.mvp.presenter.SmartCoursePresenter
import cbox.yunkang.com.c_box.mvp.ui.fragment.SmartCourseFragment
import cbox.yunkang.com.c_box.util.replaceFragmentInActivity

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

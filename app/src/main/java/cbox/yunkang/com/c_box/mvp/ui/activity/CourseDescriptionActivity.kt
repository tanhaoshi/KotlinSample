package cbox.yunkang.com.c_box.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.mvp.model.Injection
import cbox.yunkang.com.c_box.mvp.presenter.CourseDescriptionPresenter
import cbox.yunkang.com.c_box.mvp.ui.fragment.CourseDescriptionFragment
import cbox.yunkang.com.c_box.util.replaceFragmentInActivity

class CourseDescriptionActivity : AppCompatActivity(){

    private lateinit var courseDescriptionPresenter: CourseDescriptionPresenter

    lateinit var uuid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_description)

        var intent = intent

        var bundle = intent.getBundleExtra("bundle") as Bundle

        this.uuid = bundle.getString("uuid")

        val courseDescriptionFragment = supportFragmentManager.findFragmentById(R.id.description_content)
                as CourseDescriptionFragment? ?: CourseDescriptionFragment.newInstance().also {
            replaceFragmentInActivity(it,R.id.description_content)
        }

        courseDescriptionPresenter = CourseDescriptionPresenter(Injection.provideTaskRepository(applicationContext),courseDescriptionFragment)
    }

}

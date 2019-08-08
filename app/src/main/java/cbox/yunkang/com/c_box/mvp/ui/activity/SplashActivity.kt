package cbox.yunkang.com.c_box.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.util.startActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() ,View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        bike.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.bike -> startActivity(this,SmartCourseActivity::class.java,null)
        }
    }
}

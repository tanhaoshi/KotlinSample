package com.qzy.spinning.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.qzy.spinning.R
import com.qzy.spinning.mvp.datamodel.CourseModel
import com.qzy.spinning.mvp.ui.adapter.SmartCourseAdapter
import kotlinx.android.synthetic.main.activity_smart_course.*

class SmartCourseActivity : AppCompatActivity() {

    private lateinit var smartCourseAdapter: SmartCourseAdapter

    private var list = ArrayList<CourseModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_course)
        smartCourseAdapter = SmartCourseAdapter(list,this)
        var recyclerView = courseSmartRc.also {
            it.layoutManager = GridLayoutManager(this,6)
        }
        recyclerView.adapter = smartCourseAdapter

        initData()
    }

    private fun initData(){
        for(item in 0..5){
            list.add(CourseModel("初级减脂课",5,"19",
                    "998",R.drawable.spinning,"568","30min",true))
        }
        smartCourseAdapter.list = list
    }
}

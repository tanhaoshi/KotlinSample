package com.qzy.spinning.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.qzy.spinning.R
import com.qzy.spinning.mvp.model.Injection
import com.qzy.spinning.mvp.presenter.CourseDescriptionPresenter
import com.qzy.spinning.mvp.ui.fragment.CourseDescriptionFragment
import com.qzy.spinning.util.replaceFragmentInActivity

class CourseDescriptionActivity : AppCompatActivity(){

//    var courseList = ArrayList<CourseContent>()
//
//    var starBarView: StarBarView ?= null

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
//        var smartTable = smartTable
//
//        starBarView = star
//
//        starBarView ?.setStartConut(4)
//
//        for(item in 0..3){
//
//            var detailsList = ArrayList<CourseDetails>()
//
//            for(item in 0..3){
//
//                var durantionList = ArrayList<CourseDurantion>()
//
//                var durantion = CourseDurantion("2'30”")
//
//                durantionList.add(durantion)
//
//                var details = CourseDetails("姿势调整",durantionList)
//
//                detailsList.add(details)
//            }
//
//            var course = CourseContent("结集骑行",detailsList)
//
//            courseList.add(course)
//        }
//
//        var column = Column<String>("课程阶段","courseName")
//        var contentColumn = ArrayColumn<String>("内容","mCourseDetails.details")
////        var durantionColumn = ArrayColumn<String>("时长","mCourseDetails.mDurantions.durantion")
////
//        var tableData = TableData<CourseContent>("课程介绍",courseList,column,contentColumn)
//
//        smartTable.config.setShowTableTitle(false)
//
//        smartTable.config.setShowYSequence(false)
//
//        smartTable.config.setShowXSequence(false)
//
//        smartTable.config.verticalPadding = 12
//
//        smartTable.config.horizontalPadding = 85
//
//        FontStyle.setDefaultTextSize(18)
//
//        FontStyle.setDefaultTextColor(this.resources.getColor(R.color.white))
//
//        var lineStyle = LineStyle()
//        lineStyle.color = this.resources.getColor(R.color.ranking_detail_bg)
//
//        smartTable.config.contentGridStyle = lineStyle
//        smartTable.config.columnTitleGridStyle = lineStyle
//
//        smartTable.tableData = tableData

    }

}

package com.qzy.spinning.mvp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bin.david.form.data.column.ArrayColumn
import com.bin.david.form.data.column.Column
import com.bin.david.form.data.style.FontStyle
import com.bin.david.form.data.style.LineStyle
import com.bin.david.form.data.table.TableData
import com.qzy.spinning.R
import com.qzy.spinning.mvp.datamodel.CourseContent
import com.qzy.spinning.mvp.datamodel.CourseDetails
import com.qzy.spinning.mvp.datamodel.CourseDurantion
import kotlinx.android.synthetic.main.activity_course_description.*
import kotlinx.android.synthetic.main.activity_course_description.view.*
import java.util.ArrayList

class CourseDescriptionActivity : AppCompatActivity() {

    var courseList = ArrayList<CourseContent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_description)

        var smartTable = smartTable

        for(item in 0..3){

            var detailsList = ArrayList<CourseDetails>()

            for(item in 0..3){

                var durantionList = ArrayList<CourseDurantion>()

                var durantion = CourseDurantion("2'30”")

                durantionList.add(durantion)

                var details = CourseDetails("姿势调整",durantionList)

                detailsList.add(details)
            }

            var course = CourseContent("结集骑行",detailsList)

            courseList.add(course)
        }

        var column = Column<String>("课程阶段","courseName")
        var contentColumn = ArrayColumn<String>("内容","mCourseDetails.details")
        var durantionColumn = ArrayColumn<String>("时长","mCourseDetails.mDurantions.durantion")

        var tableData = TableData<CourseContent>("课程介绍",courseList,column,contentColumn,durantionColumn)

        smartTable.config.setShowTableTitle(false)

        smartTable.config.setShowYSequence(false)

        smartTable.config.setShowXSequence(false)

        smartTable.config.verticalPadding = 12

        smartTable.config.horizontalPadding = 80

        FontStyle.setDefaultTextSize(15)

        FontStyle.setDefaultTextColor(getColor(R.color.white))

        var lineStyle = LineStyle()
        lineStyle.color = this.getColor(R.color.ranking_detail_bg)

        smartTable.config.contentGridStyle = lineStyle
        smartTable.config.columnTitleGridStyle = lineStyle

        smartTable.tableData = tableData
    }

}

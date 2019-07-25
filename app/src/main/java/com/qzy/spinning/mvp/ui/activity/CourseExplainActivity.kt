package com.qzy.spinning.mvp.ui.activity

import android.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import com.bin.david.form.data.column.ArrayColumn
import com.bin.david.form.data.column.Column
import com.bin.david.form.data.style.FontStyle
import com.bin.david.form.data.style.LineStyle
import com.bin.david.form.data.table.TableData
import com.qzy.spinning.R
import com.qzy.spinning.mvp.datamodel.*
import com.qzy.spinning.util.dp2px
import com.qzy.spinning.util.getRandColor
import kotlinx.android.synthetic.main.activity_course_description.*
import kotlinx.android.synthetic.main.course_explain_layout.*

class CourseExplainActivity : AppCompatActivity() {

    var list = ArrayList<String>()

    var flater : LayoutInflater? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_explain)

        var flowLayout = flowLayout

        list.add("减脂")
        list.add("塑形")
        list.add("产后修复")

        flater = LayoutInflater.from(this)

        for(item in list){

            var tv = flater?.inflate(R.layout.flow_signal_layout,flowLayout,false) as TextView

            if(item?.length == 2){
                tv.width = dp2px(this,60f)
            }else if(item?.length == 3){
                tv.width = dp2px(this,80f)
            }else if(item?.length == 4){
                tv.width = dp2px(this,90f)
            }else if(item?.length > 4){
                tv.width = ActionBar.LayoutParams.WRAP_CONTENT
            }

            tv.setText(item)

            Log.i("CourseExplainActivity" , "getRandColor" + getRandColor())

            tv.setBackgroundColor(getRandColor())

            flowLayout.addView(tv)
        }
    }

    override fun onStart() {
        super.onStart()
        createSmartTable()
    }

    private fun createSmartTable(){

        var smartTable = smartTable

        var introduces = ArrayList<CourseIntroduce>()

        for(i in 0..2){

            if(i == 0){

                var actions = ArrayList<StageAction>()
                var stageAction = StageAction("放松")
                actions.add(stageAction)

                var beats = ArrayList<StageBeat>()
                var beat = StageBeat("休闲热身",actions)
                beats.add(beat)

                var durations = ArrayList<StageDuration>()
                var stageDuration = StageDuration("1'20“",beats)
                durations.add(stageDuration)

                var contents = ArrayList<StageContent>()
                var stageContent = StageContent("热身拉升",durations)
                contents.add(stageContent)

                var stages = ArrayList<CourseStage>()
                var courseStage = CourseStage("热身准备",contents)
                stages.add(courseStage)

                var courseIntroduce = CourseIntroduce(i.toString(),stages)
                introduces.add(courseIntroduce)
            }

            if(i == 1){

                var stages = ArrayList<CourseStage>()
                var contents = ArrayList<StageContent>()

                for(i in 0..2){

                    var actions = ArrayList<StageAction>()
                    var stageAction = StageAction("平推到下方时，杠杆距胸口…")
                    actions.add(stageAction)

                    var beats = ArrayList<StageBeat>()
                    var beat = StageBeat("脂肪燃烧",actions)
                    beats.add(beat)

                    var durations = ArrayList<StageDuration>()
                    var stageDuration = StageDuration("1'20“",beats)
                    durations.add(stageDuration)

                    var stageContent = StageContent("姿势调整",durations)
                    contents.add(stageContent)
                }

                var courseStage = CourseStage("集合骑行",contents)
                stages.add(courseStage)

                var courseIntroduce = CourseIntroduce(i.toString(),stages)
                introduces.add(courseIntroduce)
            }

            if(i == 2){
                var actions = ArrayList<StageAction>()
                var stageAction = StageAction("收紧腹部")
                actions.add(stageAction)

                var beats = ArrayList<StageBeat>()
                var beat = StageBeat("极限训练",actions)
                beats.add(beat)

                var durations = ArrayList<StageDuration>()
                var stageDuration = StageDuration("1'20“",beats)
                durations.add(stageDuration)

                var contents = ArrayList<StageContent>()
                var stageContent = StageContent("提高技巧",durations)
                contents.add(stageContent)

                var stages = ArrayList<CourseStage>()
                var courseStage = CourseStage("疯狂踩单车",contents)
                stages.add(courseStage)

                var courseIntroduce = CourseIntroduce(i.toString(),stages)
                introduces.add(courseIntroduce)
            }
        }

        var column  = Column<String>("序号", "serialName")
        var stage   = ArrayColumn<String>("课程阶段","mStages.stageName")
        var content = ArrayColumn<String>("内容","mStages.mContents.contentName")
        var duration = ArrayColumn<String>("时长 (min:s)","mStages.mContents.mDurations.durationName")
        var beat    = ArrayColumn<String>("心率区间","mStages.mContents.mDurations.mBeats.beatName")
        var action  = ArrayColumn<String>("动作要领","mStages.mContents.mDurations.mBeats.mActions.actionName")

        var tableData = TableData<CourseIntroduce>("课程安排",introduces,column,stage,content,duration,beat,action)

        smartTable.config.setShowTableTitle(false)

        smartTable.config.setShowYSequence(false)

        smartTable.config.setShowXSequence(false)

        smartTable.config.verticalPadding = 15

        smartTable.config.horizontalPadding = 100

        var fontStyle = FontStyle(20,getColor(R.color.white))

        var lineStyle = LineStyle()
        lineStyle.color = this.getColor(R.color.ranking_detail_bg)

        smartTable.config.contentGridStyle = lineStyle

        smartTable.config.columnTitleGridStyle = lineStyle

        smartTable.config.setContentStyle(fontStyle)

        smartTable.config.setColumnTitleStyle(fontStyle)

        smartTable.tableData = tableData
    }
}

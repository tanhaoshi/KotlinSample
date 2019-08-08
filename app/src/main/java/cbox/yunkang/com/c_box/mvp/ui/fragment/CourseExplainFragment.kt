package cbox.yunkang.com.c_box.mvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.mvp.contract.CourseExplainContract
import cbox.yunkang.com.c_box.mvp.ui.activity.CourseExplainActivity
import cbox.yunkang.com.c_box.mvp.ui.activity.QrCodeActivity
import cbox.yunkang.com.c_box.util.HttpUtils
import cbox.yunkang.com.c_box.util.startActivity
import com.bin.david.form.data.column.ArrayColumn
import com.bin.david.form.data.column.Column
import com.bin.david.form.data.style.FontStyle
import com.bin.david.form.data.style.LineStyle
import com.bin.david.form.data.table.TableData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.course_explain_layout.*
import kotlinx.android.synthetic.main.fragment_course_explain.*

class CourseExplainFragment : Fragment(), CourseExplainContract.View{

    override lateinit var presenter: CourseExplainContract.Presenter

    lateinit var uuid : String

    companion object {
        fun newInstance():CourseExplainFragment{
            return CourseExplainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_course_explain,container,false)

        var courseActivity = activity as CourseExplainActivity

        this.uuid = courseActivity.uuid

        return root
    }

    private fun initialize(){
        var hashMap = HashMap<String,String>()
        hashMap.put("leagueUuid",uuid)
        var requestMap = HttpUtils.generateRequestBody(hashMap)
        presenter.getCourseExplainPresenter(requestMap)
    }

    override fun onStart() {
        super.onStart()
        initialize()
        rlBuy.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("uuid",uuid)
            startActivity(activity!!.applicationContext, QrCodeActivity::class.java,bundle)
        }
    }

    override fun showCourseTableTask(courseTable: cbox.yunkang.com.c_box.mvp.datamodel.CourseTable) {

    }

    override fun showFailed(e: Throwable) {

    }

    override fun showCourseExplainTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain) {

        fillView(courseExplain)

        fillTable(courseExplain.data.classLeague.stageGroup)
    }

    private fun fillView(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain){
        courseName.text = courseExplain.data.classLeague.title
        Glide.with(activity).load(courseExplain.data.classLeague.cover).into(course_sample)
        star.setStartConut(courseExplain.data.classLeague.level)
        number.text = courseExplain.data.classLeague.price
        initialPrice.text = "¥ "+courseExplain.data.classLeague.discountPrice
        duration.text = courseExplain.data.classLeague.duration.toString()
        consume.text = courseExplain.data.classLeague.consume
        course_introduce_content.text = courseExplain.data.classLeague.introduce
        suitableHuman.text = courseExplain.data.classLeague.appropriateCrowd
        tabooHuman.text = courseExplain.data.classLeague.tabooCrowd
    }

    private fun fillTable(hashMap: HashMap<String,List<cbox.yunkang.com.c_box.mvp.datamodel.TableModel>>){
        var introduces = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.CourseIntroduce>()

        var seriaiName : Int = -1

        for(tableList:List<cbox.yunkang.com.c_box.mvp.datamodel.TableModel> in hashMap.values){

            seriaiName ++

            var contents = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.StageContent>()

            for(value in tableList){

                var actions = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.StageAction>()

                var action = cbox.yunkang.com.c_box.mvp.datamodel.StageAction(value.essential)

                actions.add(action)

                var beats = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.StageBeat>()

                var beat = cbox.yunkang.com.c_box.mvp.datamodel.StageBeat(value.heartRange.toString(),actions)

                beats.add(beat)

                var durantions = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.StageDuration>()

                var durantion = cbox.yunkang.com.c_box.mvp.datamodel.StageDuration(value.duration,beats)

                durantions.add(durantion)

                var stageContent = cbox.yunkang.com.c_box.mvp.datamodel.StageContent(value.title,durantions)

                contents.add(stageContent)

            }

            var stages = ArrayList<cbox.yunkang.com.c_box.mvp.datamodel.CourseStage>()

            var courseStage = cbox.yunkang.com.c_box.mvp.datamodel.CourseStage(tableList?.get(0).stage,contents)

            stages.add(courseStage)

            var courseIntroduce = cbox.yunkang.com.c_box.mvp.datamodel.CourseIntroduce(seriaiName.toString(),stages)
            introduces.add(courseIntroduce)
        }

        var smartTable = smartTable

        var column  = Column<String>("序号", "serialName")
        var stage   = ArrayColumn<String>("课程阶段","mStages.stageName")
        var content = ArrayColumn<String>("内容","mStages.mContents.contentName")
        var duration = ArrayColumn<String>("时长 (min:s)","mStages.mContents.mDurations.durationName")
        var beat    = ArrayColumn<String>("心率区间","mStages.mContents.mDurations.mBeats.beatName")
        var action  = ArrayColumn<String>("动作要领","mStages.mContents.mDurations.mBeats.mActions.actionName")

        var tableData = TableData<cbox.yunkang.com.c_box.mvp.datamodel.CourseIntroduce>("课程安排",introduces,column,stage,content,duration,beat,action)

        smartTable.config.setShowTableTitle(false)

        smartTable.config.setShowYSequence(false)

        smartTable.config.setShowXSequence(false)

        smartTable.config.verticalPadding = 15

        smartTable.config.horizontalPadding = 100

        var fontStyle = FontStyle(20,resources.getColor(R.color.white))

        var lineStyle = LineStyle()
        lineStyle.color = resources.getColor(R.color.ranking_detail_bg)

        smartTable.config.contentGridStyle = lineStyle

        smartTable.config.columnTitleGridStyle = lineStyle

        smartTable.config.setContentStyle(fontStyle)

        smartTable.config.setColumnTitleStyle(fontStyle)

        smartTable.tableData = tableData
    }
}
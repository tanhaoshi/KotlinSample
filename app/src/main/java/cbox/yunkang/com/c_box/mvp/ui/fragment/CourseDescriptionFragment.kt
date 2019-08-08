package cbox.yunkang.com.c_box.mvp.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.mvp.contract.CourseDescriptionContract
import cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain
import cbox.yunkang.com.c_box.mvp.ui.activity.CourseDescriptionActivity
import cbox.yunkang.com.c_box.mvp.ui.activity.PhysicalActivity
import cbox.yunkang.com.c_box.util.Constant
import cbox.yunkang.com.c_box.util.HttpUtils
import cbox.yunkang.com.c_box.util.L
import cbox.yunkang.com.c_box.util.startActivity
import com.alibaba.fastjson.JSON
import com.bin.david.form.data.column.ArrayColumn
import com.bin.david.form.data.style.FontStyle
import com.bin.david.form.data.style.LineStyle
import com.bin.david.form.data.table.TableData
import kotlinx.android.synthetic.main.course_details_layout.*
import kotlinx.android.synthetic.main.course_include_layout.*
import kotlinx.android.synthetic.main.description_title_layout.*
import kotlinx.android.synthetic.main.fragment_course_explain.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.Subscribe

class CourseDescriptionFragment :Fragment(), CourseDescriptionContract.View{

    override lateinit var presenter: CourseDescriptionContract.Presenter

    lateinit var uuid : String

    private var handler  : Handler ? = Handler()

    private var tempTime : Int = 120

    private val refreshRunnable : Runnable = object :Runnable{
        override fun run() {
            schedules.text = tempTime.toString()

            if(tempTime > 118){
                handler?.postDelayed(this,1000)
            }else{
                var bundle = Bundle()
                bundle.putString("uuid",uuid)
                startActivity(activity?.applicationContext!!, PhysicalActivity::class.java,bundle)
                activity?.finish()
                handler?.removeCallbacks(this)
            }

            tempTime--
        }
    }

    companion object {
        fun newInstance() : CourseDescriptionFragment{
            return CourseDescriptionFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var courseActivity = activity as CourseDescriptionActivity

        this.uuid = courseActivity.uuid

        var root = inflater.inflate(R.layout.fragment_course_description,container,false)

        return root
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
        initialize()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEventbus: cbox.yunkang.com.c_box.eventbus.MessageEventbus) {
        when(messageEventbus.type){
            Constant.BOX_USER_ONLINE -> postInitializeView(messageEventbus.`object` as List<cbox.yunkang.com.c_box.eventbus.User>)
            Constant.BOX_USER_ICON   -> postInitializeView(messageEventbus.`object` as List<cbox.yunkang.com.c_box.eventbus.User>)
        }
    }

    private fun postInitializeView(list: List<cbox.yunkang.com.c_box.eventbus.User>){
        var size = 0
        if(list.size > 1 ){
            size = list.size
        }else{
            size = 0
        }
        if(list[size].usrName == null){
            showAlert.text = "已上线 "+list.size + "人"
        }else{
            showAlert.text = "已上线 "+list.size + "人"+"   " + list[size].usrName + " 上线"
        }
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onResume() {
        super.onResume()
        handler?.postDelayed(refreshRunnable ,1000)
    }

    private fun initialize(){
        var hashMap = HashMap<String,String>()
        hashMap.put("leagueUuid",uuid)
        var requestMap = HttpUtils.generateRequestBody(hashMap)
        presenter.getCourseDescriptionPresenter(requestMap)
    }

    override fun showCourseDescriptionTask(courseExplain: cbox.yunkang.com.c_box.mvp.datamodel.CourseExplain) {
        postInitializeLayoutView(courseExplain)
        fillTable(courseExplain.data.classLeague.stageGroup)
    }

    private inline fun postInitializeLayoutView(courseExplain:CourseExplain){
        star.starMark = courseExplain.data.classLeague.level.toFloat()
        duration.text = courseExplain.data.classLeague.duration.toString()
        fat.text      = courseExplain.data.classLeague.consume
        for_human.text = courseExplain.data.classLeague.appropriateCrowd
        target_count.text = courseExplain.data.classLeague.tabooCrowd
    }

    override fun showFailed(t: Throwable) {

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

            var courseStage = cbox.yunkang.com.c_box.mvp.datamodel.CourseStage(tableList.get(0).stage,contents)

            stages.add(courseStage)

            var courseIntroduce = cbox.yunkang.com.c_box.mvp.datamodel.CourseIntroduce(seriaiName.toString(),stages)
            introduces.add(courseIntroduce)
        }

        var smartTable = smartTable

        var stage   = ArrayColumn<String>("课程阶段","mStages.stageName")
        var content = ArrayColumn<String>("内容","mStages.mContents.contentName")

        var tableData = TableData<cbox.yunkang.com.c_box.mvp.datamodel.CourseIntroduce>("课程安排",introduces,stage,content)

        smartTable.config.isShowTableTitle = false

        smartTable.config.isShowYSequence = false

        smartTable.config.isShowXSequence = false

        smartTable.config.verticalPadding = 15

        smartTable.config.horizontalPadding = 100

        var fontStyle = FontStyle(20,resources.getColor(R.color.white))

        var lineStyle = LineStyle()
        lineStyle.color = resources.getColor(R.color.ranking_detail_bg)

        smartTable.config.contentGridStyle = lineStyle

        smartTable.config.columnTitleGridStyle = lineStyle

        smartTable.config.contentStyle = fontStyle

        smartTable.config.columnTitleStyle = fontStyle

        smartTable.tableData = tableData
    }

    override fun onDestroy() {
        super.onDestroy()
        handler ?.removeCallbacks(refreshRunnable)
        handler = null
    }
}
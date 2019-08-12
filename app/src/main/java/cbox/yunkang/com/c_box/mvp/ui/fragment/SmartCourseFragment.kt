package cbox.yunkang.com.c_box.mvp.ui.fragment

import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.SpinningApplication
import cbox.yunkang.com.c_box.mvp.contract.SmartCourseContract
import cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse
import cbox.yunkang.com.c_box.mvp.ui.adapter.SmartCourseAdapter
import cbox.yunkang.com.c_box.util.HttpUtils
import cbox.yunkang.com.c_box.util.L
import cbox.yunkang.com.c_box.util.WlanUtils
import cbox.yunkang.com.c_box.util.toast
import com.ykcx.bcore.utils.BasePreference
import com.ykcx.bcore.utils.StringUtils
import kotlinx.android.synthetic.main.fragment_smart_course.*
import java.io.File

class SmartCourseFragment : Fragment() , SmartCourseContract.View,View.OnClickListener,SmartCourseAdapter.Callback{

    override lateinit var presenter: SmartCourseContract.Presenter

    private lateinit var smartCourseAdapter: SmartCourseAdapter

    private var list = ArrayList<SmartCourse.DataBean>()

    var basePath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "spinningVideo"

    companion object {
        fun newInstance() = SmartCourseFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_smart_course,container,false)

        checkFile()

        smartCourseAdapter = SmartCourseAdapter(list,activity?.applicationContext!!)

        smartCourseAdapter.setCallbackListener(this)

        with(root){
            var courseSmartRc = findViewById<RecyclerView>(R.id.courseSmartRc)
            courseSmartRc.layoutManager = GridLayoutManager(activity,6)
            courseSmartRc.adapter = smartCourseAdapter
        }

        root.findViewById<TextView>(R.id.smart_course).setOnClickListener(this)
        root.findViewById<TextView>(R.id.mine_course).setOnClickListener(this)

        return root
    }

    var flag = "1"

    override fun onStart() {
        super.onStart()
        startTransformValue("2",flag)
    }

    private fun checkFile(){
        var file = File(basePath)
        if(!file.exists()){
            file.mkdirs()
        }
    }

    private fun startTransformValue(leagueType:String,flag:String){
        var map = HashMap<String,String>()
        var boxNum = StringUtils.toTen(BasePreference.getInstance().boxNo)
        map.put("page","1")
        map.put("limit","10")
        map.put("boxNum",boxNum.toString())
        map.put("leagueType",leagueType)
        map.put("flag",flag)
        var hashmap = HttpUtils.generateRequestBody(map)
        presenter.getSmartCoursePresenter(hashmap)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.smart_course -> switchSmartStyle()
            R.id.mine_course  -> switchMineStyle()
        }
    }

    private var isSwitch = true

    private fun switchSmartStyle(){
        if(!isSwitch){
            smart_course.setTextSize(18f)
            smart_course.setTextColor(activity?.resources?.getColor(R.color.white)!!)

            mine_course.setTextSize(14f)
            mine_course.setTextColor(activity?.resources?.getColor(R.color.unselected)!!)

            isSwitch = true

            smartCourseAdapter.flag = 1

            flag = "1"

            startTransformValue("2","1")
        }
    }

    private fun switchMineStyle(){
        if(isSwitch){
            smart_course.setTextSize(14f)
            smart_course.setTextColor(activity?.resources?.getColor(R.color.unselected)!!)

            mine_course.setTextSize(18f)
            mine_course.setTextColor(activity?.resources?.getColor(R.color.white)!!)

            isSwitch = false

            smartCourseAdapter.flag = 2

            flag = "2"

            startTransformValue("2","2")
        }
    }

    override fun showSmartCourseTasks(smartCourse: cbox.yunkang.com.c_box.mvp.datamodel.SmartCourse) {
        smartCourseAdapter.list = smartCourse.data
        this.list = smartCourse.data as ArrayList<SmartCourse.DataBean>
    }

    override fun showFailed(string: String) {
        string.toast(activity?.applicationContext!!)
    }

    var tempPosition = -1

    override fun callBack(uuid : String,position : Int) {
        this.tempPosition = position
        var map = HashMap<String,String>()
        var boxNum = StringUtils.toTen(BasePreference.getInstance().boxNo)
        map.put("gymAddr",BasePreference.getInstance().gymAddress)
        map.put("boxNum",boxNum.toString())
        map.put("classLeagueUuid",uuid)
        var hashmap = HttpUtils.generateRequestBody(map)
        presenter.sumitCourseTryPresenter(hashmap)
    }

    override fun showTryResult(result: String) {
        result.toast(activity?.applicationContext!!)
        list.removeAt(tempPosition)
        smartCourseAdapter.list = list
    }
}
package com.qzy.spinning.mvp.ui.fragment

import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.qzy.spinning.R
import com.qzy.spinning.SpinningApplication
import com.qzy.spinning.mvp.contract.SmartCourseContract
import com.qzy.spinning.mvp.datamodel.SmartCourse
import com.qzy.spinning.mvp.ui.adapter.SmartCourseAdapter
import com.qzy.spinning.util.HttpUtils
import com.qzy.spinning.util.WlanUtils
import com.qzy.spinning.util.toast
import kotlinx.android.synthetic.main.fragment_smart_course.*
import kotlinx.android.synthetic.main.fragment_smart_course.view.*
import java.io.File

class SmartCourseFragment : Fragment() , SmartCourseContract.View,View.OnClickListener{

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

        with(root){
            courseSmartRc.layoutManager = GridLayoutManager(activity,6)
            courseSmartRc.adapter = smartCourseAdapter
        }

        root.findViewById<TextView>(R.id.smart_course).setOnClickListener(this)
        root.findViewById<TextView>(R.id.mine_course).setOnClickListener(this)

        return root
    }

    override fun onStart() {
        super.onStart()
        startTransformValue("1","1")
    }

    private fun checkFile(){
        var file = File(basePath)
        if(!file.exists()){
            file.mkdirs()
        }
    }

    private fun startTransformValue(leagueType:String,flag:String){
        var map = HashMap<String,String>()
        var mac = WlanUtils.getMacAddress(SpinningApplication.getContext())
        map.put("page","1")
        map.put("limit","1")
        map.put("boxNum","2000001")
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

            startTransformValue("1","1")
        }
    }

    private fun switchMineStyle(){
        if(isSwitch){
            smart_course.setTextSize(14f)
            smart_course.setTextColor(activity?.resources?.getColor(R.color.unselected)!!)

            mine_course.setTextSize(18f)
            mine_course.setTextColor(activity?.resources?.getColor(R.color.white)!!)

            isSwitch = false

            startTransformValue("2","2")
        }
    }

    override fun showSmartCourseTasks(smartCourse: SmartCourse) {
        smartCourseAdapter.list = smartCourse.data
    }

    override fun showFailed(string: String) {
        string.toast(activity?.applicationContext!!)
    }

}
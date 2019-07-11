package com.qzy.kotlinsample.mvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qzy.kotlinsample.R
import com.qzy.kotlinsample.mvp.contract.PhysicalContract
import com.qzy.kotlinsample.mvp.datamodel.ScaleProgress
import com.qzy.kotlinsample.mvp.ui.adapter.PhysicalAdapter
import kotlinx.android.synthetic.main.fragment_physical.*

class PhysicalFragment : Fragment() , PhysicalContract.View{

    override lateinit var presenter: PhysicalContract.Presenter

    private lateinit var physicalAdapter : PhysicalAdapter

    companion object {

        fun newInstance() = PhysicalFragment()
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_physical,container,false)

        with(root){
            var recyclerView = findViewById<RecyclerView>(R.id.recyclerView).also {
                it.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            }
            physicalAdapter = PhysicalAdapter(ArrayList(0), activity!!)

            recyclerView.adapter = physicalAdapter
        }

        return root
    }

    override fun showTasks(list: List<Int>) {
        physicalAdapter.list = list
    }

    override fun showProgressTasks(list: List<ScaleProgress>) {

        for(item in list){
            item.signalColor = resources.getColor(R.color.grayColor)
        }

        progressBar.postInvalidateAction(list)
    }

}
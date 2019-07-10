package com.qzy.kotlinsample.mvp.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qzy.kotlinsample.R
import com.qzy.kotlinsample.mvp.contract.PhysicalContract
import com.qzy.kotlinsample.mvp.ui.adapter.PhysicalAdapter
import kotlinx.android.synthetic.main.fragment_physical.*

class PhysicalFragment : Fragment() , PhysicalContract.View{

    override lateinit var presenter: PhysicalContract.Presenter

    private val physicalAdapter = PhysicalAdapter(ArrayList(0),activity!!)

    companion object {

        fun newInstance() = PhysicalFragment()
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_physical,container,false)

        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)

        recyclerView.adapter = physicalAdapter

        return root
    }

}
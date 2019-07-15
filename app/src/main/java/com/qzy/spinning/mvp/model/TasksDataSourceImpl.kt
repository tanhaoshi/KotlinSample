package com.qzy.spinning.mvp.model

import com.qzy.spinning.mvp.datamodel.RankingData
import com.qzy.spinning.mvp.datamodel.ScaleProgress
import java.util.*
import kotlin.random.Random

class TasksDataSourceImpl private constructor() : TasksDataSource{

    override fun getRankingTask(callback: TasksDataSource.LoadRankingTaskCallback) {
        var list = LinkedList<RankingData>()
        var rankingData1 = RankingData(1,"R.drawable.a1","100")
        list.add(rankingData1)
        var rankingData2 = RankingData(2,"R.drawable.a2","50")
        list.add(rankingData2)
        var rankingData3 = RankingData(3,"R.drawable.a3","30")
        list.add(rankingData3)
        var rankingData4 = RankingData(4,"R.drawable.a4","60")
        list.add(rankingData4)
        var rankingData5 = RankingData(5,"R.drawable.a5","10")
        list.add(rankingData5)
        var rankingData6 = RankingData(6,"R.drawable.a6","80")
        list.add(rankingData6)
        var rankingData7 = RankingData(7,"R.drawable.a7","20")
        list.add(rankingData7)
        var rankingData8 = RankingData(8,"R.drawable.a8","90")
        list.add(rankingData8)
        var rankingData9 = RankingData(9,"R.drawable.a9","70")
        list.add(rankingData9)
        var rankingData10 = RankingData(10,"R.mipmap.ic_launcher","40")
        list.add(rankingData10)
        callback.onRankingTask(list)
    }

    override fun getProgressData(call: TasksDataSource.LoadProgressCallBack) {
        var list = ArrayList<ScaleProgress>()
        var scaleProgress = ScaleProgress(0.1,0.2,5)
        list.add(scaleProgress)
        var scaleProgress1 = ScaleProgress(0.3,0.3,5)
        list.add(scaleProgress1)
        var scaleProgress2 = ScaleProgress(0.1,0.2,5)
        list.add(scaleProgress2)
        var scaleProgress3 = ScaleProgress(0.2,0.25,5)
        list.add(scaleProgress3)
        var scaleProgress4 = ScaleProgress(0.3,0.05,5)
        list.add(scaleProgress4)
        call.onTasksLoaded(list)
    }

    override fun getTasks(callback: TasksDataSource.LoadTasksCallback) {
        var list = ArrayList<Int>()
        var random = Random
        for (i in 0..7){
            list.add(random.nextInt(11))
        }
        callback.onTasksLoaded(list)
    }

    companion object {

        private lateinit var INSTANCE:TasksDataSourceImpl
        private var needsNewInstance = true

        @JvmStatic fun getInstance() : TasksDataSourceImpl {
            if(needsNewInstance){
                INSTANCE = TasksDataSourceImpl()
                needsNewInstance = false
            }
            return INSTANCE
        }
    }
}
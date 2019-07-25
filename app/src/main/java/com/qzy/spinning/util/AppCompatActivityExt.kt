package com.qzy.spinning.util

import android.content.Context
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import java.util.*

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, @IdRes fragmentId : Int){
     supportFragmentManager.beginTransaction().add(fragmentId,fragment).show(fragment).commit()
}

fun getRandColor(): Int {
     val random = Random()
     return -0x1000000 or random.nextInt(0x00ffffff)
}

fun dp2px(context: Context,dpValue:Float): Int {

     return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,

             dpValue, context.resources.displayMetrics).toInt()

}
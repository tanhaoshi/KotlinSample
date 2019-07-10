package com.qzy.kotlinsample.util

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment,@IdRes fragmentId : Int){
     supportFragmentManager.beginTransaction().replace(fragmentId,fragment)
}
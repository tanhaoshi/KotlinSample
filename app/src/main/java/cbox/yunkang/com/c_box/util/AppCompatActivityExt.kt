package cbox.yunkang.com.c_box.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.widget.Toast
import java.io.File
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

fun<T> startActivity(context: Context,clazz: Class<T>, bundle: Bundle?) {
     var intent = Intent(context,clazz)
     if(bundle != null) intent.putExtra("bundle",bundle)
     intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
     context.startActivity(intent)
}

fun getVideoSource(filePath: String): List<String> {
     var fileList = ArrayList<String>()
     var file = File(filePath)
     var files = file.listFiles()

     for (iFileLength in 0 until files.size) {
          if (!files[iFileLength].isDirectory) {
               val filename = files[iFileLength].name
               if (filename.trim { it <= ' ' }.toLowerCase().endsWith(".mp4")) {
                    fileList.add(filename)
               }
          }
     }
     return fileList
}

fun Any.toast(context: Context, duration:Int = Toast.LENGTH_SHORT) : Toast {
     return Toast.makeText(context,this.toString(),duration).apply { show() }
}



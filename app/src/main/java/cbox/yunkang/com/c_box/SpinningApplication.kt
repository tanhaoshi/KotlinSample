package cbox.yunkang.com.c_box

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import cbox.yunkang.com.c_box.mvp.model.YunkangBoxManager
import cbox.yunkang.com.c_box.util.L
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.ykcx.bcore.cil.BoxCore

class SpinningApplication : Application() {

    companion object {
        var  INSTANCE:Application? = null
        fun getContext(): Context {
            return INSTANCE!!
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        L.init(this.javaClass)
        initializeDownloader()
        initializeBox()
    }

    private fun initializeDownloader(){
        var config : PRDownloaderConfig = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .build() as PRDownloaderConfig
        PRDownloader.initialize(this,config)
    }

    private fun initializeBox(){
        BoxCore.getInstance().init(this, YunkangBoxManager.getInstance(),true)
    }
}
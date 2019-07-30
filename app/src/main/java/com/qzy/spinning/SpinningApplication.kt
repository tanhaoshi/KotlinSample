package com.qzy.spinning

import android.app.Application
import android.content.Context
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig

class SpinningApplication : Application() {

    companion object {
        var  INSTANCE:Application? = null
        fun getContext(): Context {
            return INSTANCE!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initializeDownloader()
    }

    private fun initializeDownloader(){
        var config : PRDownloaderConfig = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .build() as PRDownloaderConfig
        PRDownloader.initialize(this,config)
    }
}
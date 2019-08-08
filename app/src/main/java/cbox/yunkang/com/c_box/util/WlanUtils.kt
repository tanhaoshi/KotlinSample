package cbox.yunkang.com.c_box.util

import android.content.Context
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.text.TextUtils
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.Exception
import java.net.NetworkInterface
import java.util.*

object WlanUtils {

    fun getMacDefault(context: Context) : String{
        var mac = "02:00:00:00:00:00"

        if(context == null) return mac

        var wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager

        if(wifiManager == null) return mac

        var wifiInfo : WifiInfo? = null

        try{
            wifiInfo = wifiManager.connectionInfo
        }catch (e : Exception){
            e.printStackTrace()
        }

        if(wifiInfo == null) return mac

        mac = wifiInfo.macAddress

        if(!TextUtils.isEmpty(mac)){
            mac = mac.toUpperCase(Locale.ENGLISH)
        }

        return mac
    }

    fun getMacAddress() : String{
        var mac = "02:00:00:00:00:00"

        try{
            mac = BufferedReader(FileReader(File("/sys/class/net/wlan0/address"))).readLine()
        }catch (e : Exception){
            e.printStackTrace()
        }

        return mac
    }

    fun getMacFromHardware() : String{
        try {
            val all = Collections.list(NetworkInterface.getNetworkInterfaces())
            for (nif in all) {
                if (!nif.name.equals("wlan0",true)) continue
                val macBytes = nif.getHardwareAddress() ?: return ""

                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02X:", b))
                }

                if (res1.length > 0) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return "02:00:00:00:00:00"
    }

    fun getMacAddress(context: Context): String {
        var mac = "02:00:00:00:00:00"
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            mac = getMacDefault(context)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mac = getMacAddress()
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mac = getMacFromHardware()
        }
        return mac
    }
}
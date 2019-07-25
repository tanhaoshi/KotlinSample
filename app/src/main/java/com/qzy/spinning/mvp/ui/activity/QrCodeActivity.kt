package com.qzy.spinning.mvp.ui.activity

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.qzy.spinning.R
import com.qzy.spinning.util.QRCodeUtil
import kotlinx.android.synthetic.main.activity_qr_code.*
import java.io.ByteArrayOutputStream

class QrCodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code)

        var content : String = "动感单车牛逼呀!"

        var bitmap = QRCodeUtil.createQRImage(content,400,400)

        var byteSteam = ByteArrayOutputStream()

        bitmap?.compress(Bitmap.CompressFormat.PNG,100,byteSteam)

        var qrCodeImage = qrCode

        Glide.with(this).load(byteSteam.toByteArray()).into(qrCodeImage)
    }
}

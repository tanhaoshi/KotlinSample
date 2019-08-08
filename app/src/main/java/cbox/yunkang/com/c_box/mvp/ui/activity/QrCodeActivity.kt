package cbox.yunkang.com.c_box.mvp.ui.activity

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cbox.yunkang.com.c_box.R
import cbox.yunkang.com.c_box.util.Constant
import cbox.yunkang.com.c_box.util.QRCodeUtil
import cbox.yunkang.com.c_box.util.startActivity
import com.bumptech.glide.Glide
import com.ykcx.bcore.utils.BasePreference
import com.ykcx.bcore.utils.StringUtils
import kotlinx.android.synthetic.main.activity_qr_code.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.ByteArrayOutputStream

class QrCodeActivity : AppCompatActivity() {

    lateinit var uuid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code)

        EventBus.getDefault().register(this)

        var intent = intent

        var bundle = intent.getBundleExtra("bundle") as Bundle

        this.uuid = bundle.getString("uuid")

        var boxNum = StringUtils.toTen(BasePreference.getInstance().boxNo)

        var content : String = Constant.BASE_URL + Constant.BOX_WECHAT_PAY + "?boxNum="+boxNum + "&classLeagueUuid=" + uuid

        var bitmap = QRCodeUtil.createQRImage(content,400,400)

        var byteSteam = ByteArrayOutputStream()

        bitmap?.compress(Bitmap.CompressFormat.PNG,100,byteSteam)

        var qrCodeImage = qrCode

        Glide.with(this).load(byteSteam.toByteArray()).into(qrCodeImage)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEventbus: cbox.yunkang.com.c_box.eventbus.MessageEventbus) {
        when(messageEventbus.type){
            Constant.BOX_WECHAT_PAY -> jump()
        }
    }

    private inline fun jump(){
        startActivity(this,SmartCourseActivity::class.java,null)
        finish()
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}

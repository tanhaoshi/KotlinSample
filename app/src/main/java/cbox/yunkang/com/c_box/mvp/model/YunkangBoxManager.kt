package cbox.yunkang.com.c_box.mvp.model

import cbox.yunkang.com.c_box.util.Constant
import com.ykcx.bcore.bean.*
import com.ykcx.bcore.cil.UiRendering
import com.ykcx.bcore.cil.UserProfile
import java.util.*
import org.greenrobot.eventbus.EventBus


class YunkangBoxManager : UiRendering{

    override fun showUserSwitchAct(p0: UserProfile?): Boolean {
        return true
    }

    override fun showUserSync(p0: UserProfile?): Boolean {
        return true
    }

    override fun showUserSwitchEp(p0: UserProfile?): Boolean {
        return true
    }

    var list = LinkedList<cbox.yunkang.com.c_box.eventbus.User>()

    companion object {

        private lateinit var INSTANCE:YunkangBoxManager
        private var needsNewInstance = true

        @JvmStatic fun getInstance() : YunkangBoxManager {
            if(needsNewInstance){
                INSTANCE = YunkangBoxManager()
                needsNewInstance = false
            }
            return INSTANCE
        }
    }

    override fun showTeamCourseRecordData(p0: TeamWorkRecord?) {
    }

    override fun showTeamCourseAndActions(p0: CourseAndAction?) {
    }

    override fun showSortingModeChange(p0: Int): Boolean {
        return true
    }

    override fun showUserOffline(p0: UserProfile?): Boolean {
        return true
    }

    override fun showUserAllOffline(p0: String?): Boolean {
        postCommand(cbox.yunkang.com.c_box.eventbus.UserCommand.USEROFFINE,null!!)
        return true
    }

    override fun showUserResting(p0: UserProfile?): Boolean {
        return true
    }

    override fun showConfigureUpdaeOver(p0: Boolean): Boolean {
        return true
    }

    override fun showAppUpdate(p0: Int, p1: Int, p2: AppUpdateData?): Boolean {
        return true
    }

    override fun showDownloadResourceOver(): MutableList<String>? {
        return null
    }

    override fun showUserIcon(p0: UserProfile?): Boolean {
        if(p0 == null) return true
        postCommand(cbox.yunkang.com.c_box.eventbus.UserCommand.USERSHOWICON,p0!!)
        return true
    }

    override fun showDownloadResourceStart(): Boolean {
        return true
    }

    override fun showInitComplete(p0: Int, p1: String?, p2: String?, p3: String?): Boolean {
        return true
    }

    override fun showUserOnline(p0: UserProfile?): Boolean {
        postCommand(cbox.yunkang.com.c_box.eventbus.UserCommand.USERONLINE,p0!!)
        return true
    }

    override fun showGotEveryDayRanking(p0: Int, p1: MutableList<EveryDayRankData.BoxRankingData>?): Boolean {
        return true
    }

    override fun showUserUploadSportComplete(): Boolean {
        return true
    }

    override fun showNodesList(p0: Int, p1: MutableList<BoxNodeData.Data>?): Boolean {
        return true
    }

    override fun showTeamWorkRank(p0: MutableList<TeamActionUpload>?) {

    }

    override fun showNodeConnectChange(p0: Int, p1: Boolean, p2: String?): Boolean {
        return true
    }

    override fun showUserRefresh(p0: UserProfile?): Boolean {
        return true
    }

    override fun showTeamCourseBuyRecord(p0: TeamWorkRecord?) {
        var messageEventbus = cbox.yunkang.com.c_box.eventbus.MessageEventbus(Constant.BOX_WECHAT_PAY,p0)
        EventBus.getDefault().post(messageEventbus)
    }

    override fun showUserRefreshHeartRate(p0: UserProfile?): Boolean {
        return true
    }

    override fun showUserChangeWeight(p0: UserProfile?): Boolean {
        return true
    }

    override fun showConfigureUpdaeStart(p0: Int, p1: Int): Boolean {
        return true
    }

    override fun showGotSceneVideo(p0: SelectSceneData?): Boolean {
        return true
    }

    override fun showTeamCoursePayTrail(p0: Boolean) {

    }

    override fun showTeamCOursePrice(p0: MutableList<TeamWorkRecord.PriceInfo>?) {

    }

    override fun showGotSportRanking(p0: RankingData?): Boolean {
        return true
    }

    fun postCommand(command: Int, userProfile: UserProfile) {
        val user: cbox.yunkang.com.c_box.eventbus.User = cbox.yunkang.com.c_box.eventbus.User.obtain(userProfile)
        when (command) {
            cbox.yunkang.com.c_box.eventbus.UserCommand.USERONLINE -> onLinePush(user)
            cbox.yunkang.com.c_box.eventbus.UserCommand.USEROFFINE -> user.recycle()
            cbox.yunkang.com.c_box.eventbus.UserCommand.USERSWITCHEP -> {}
            cbox.yunkang.com.c_box.eventbus.UserCommand.USERREFRESH,
            cbox.yunkang.com.c_box.eventbus.UserCommand.USERSWITCHAC,
            cbox.yunkang.com.c_box.eventbus.UserCommand.USERCHANGEWEIGHT,
            cbox.yunkang.com.c_box.eventbus.UserCommand.USEREFRESHHEART,
            cbox.yunkang.com.c_box.eventbus.UserCommand.USERSHOWICON -> reflashPush(user)
            cbox.yunkang.com.c_box.eventbus.UserCommand.USERRESTING -> {}
        }
    }

       /**
     * 用户上线
     * @param user
     */
    private fun onLinePush(user: cbox.yunkang.com.c_box.eventbus.User?): Boolean {
        if (user == null || list == null) {
            return false
        }
        val index = list.indexOf(user)
        if (index == -1) {
            list.add(user)
        } else
        // 断网重连
        {
            val userCache = list[index]
            list[index] = userCache
        }
        var messageEventbus = cbox.yunkang.com.c_box.eventbus.MessageEventbus(Constant.BOX_USER_ONLINE,list)
        EventBus.getDefault().post(messageEventbus)
        return true
    }

    private fun reflashPush(user: cbox.yunkang.com.c_box.eventbus.User?): Boolean {
        if (user == null || list == null) {
            return false
        }
        val index = list.indexOf(user)
        if (index != -1) {
            list[index] = user
        }
        var messageEventbus = cbox.yunkang.com.c_box.eventbus.MessageEventbus(Constant.BOX_USER_ICON,list)
        EventBus.getDefault().post(messageEventbus)
        return false
    }
}
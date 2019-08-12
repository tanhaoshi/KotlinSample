package cbox.yunkang.com.c_box.mvp.model

import cbox.yunkang.com.c_box.eventbus.MessageEventbus
import cbox.yunkang.com.c_box.eventbus.User
import cbox.yunkang.com.c_box.eventbus.UserCommand
import cbox.yunkang.com.c_box.util.Constant
import cbox.yunkang.com.c_box.util.L
import com.alibaba.fastjson.JSON
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

    //切换器械
    override fun showUserSwitchEp(p0: UserProfile?): Boolean {
        postCommand(UserCommand.USERSWITCHEP,p0!!)
        return true
    }

    var list = LinkedList<User>()

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

    //用户下线
    override fun showUserOffline(p0: UserProfile?): Boolean {
        postCommand(UserCommand.USEROFFLINE,p0!!)
        return true
    }

    //用户全部下线
    override fun showUserAllOffline(p0: String?): Boolean {
        postCommand(UserCommand.USERAllOFFINE,null!!)
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
        postCommand(UserCommand.USERSHOWICON,p0!!)
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

    // 数据一直在刷新
    override fun showUserRefresh(p0: UserProfile?): Boolean {
        postCommand(UserCommand.USERREFRESH,p0!!)
        return true
    }

    override fun showTeamCourseBuyRecord(p0: TeamWorkRecord?) {
        var messageEventbus = MessageEventbus.obtain(Constant.BOX_WECHAT_PAY,p0)
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
        var user : User? = null
        if(userProfile != null){
            user = User.obtain(userProfile)
        }
        when (command) {
            UserCommand.USERONLINE -> onLinePush(user)
            UserCommand.USEROFFLINE -> userOffline(user)
            UserCommand.USERAllOFFINE -> allUserOffline()
            UserCommand.USERSWITCHEP -> switchEpAction(user)
            UserCommand.USERREFRESH -> refreshData(user)
            UserCommand.USERSWITCHAC,
            UserCommand.USERCHANGEWEIGHT,
            UserCommand.USEREFRESHHEART,
            UserCommand.USERSHOWICON -> reflashPush(user)
            UserCommand.USERRESTING -> {}
        }
    }

       /**
     * 用户上线
     * @param user
     */
    private fun onLinePush(user: User?): Boolean {
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
        var messageEventbus = MessageEventbus.obtain(Constant.BOX_USER_ONLINE,list)
        EventBus.getDefault().post(messageEventbus)
        return true
    }

    /**
     * 用户下线
     */
    private fun userOffline(user: User?):Boolean{
        if (user == null || list == null) {
            return false
        }
        val index = list.indexOf(user)
        if (index != -1) {
            list.remove(user)
        }
        var messageEventbus = MessageEventbus.obtain(Constant.BOX_USER_OFFLINE,list)
        EventBus.getDefault().post(messageEventbus)
        return true
    }

    private fun reflashPush(user: User?): Boolean {
        if (user == null || list == null) {
            return false
        }
        val index = list.indexOf(user)
        if (index != -1) {
            list[index] = user
        }else{
            list.add(user)
        }
        var messageEventbus = MessageEventbus.obtain(Constant.BOX_USER_ICON,list)
        EventBus.getDefault().post(messageEventbus)
        return false
    }

    var maxFrequency : Float = 0F
    var maxRate      = 0

    private fun refreshData(user:User?) :Boolean{
        if (user == null || list == null) {
            return false
        }
        val index = list.indexOf(user)
        if (index != -1) {
            if(user.tapinValue.toFloat() > list[index].tapinValue.toFloat()){
                maxFrequency = user.tapinValue.toFloat()
            }else{
                maxFrequency = list[index].tapinValue.toFloat()
            }

            if(user.heartRateValue > list[index].heartRateValue){
                maxRate = user.heartRateValue
            }else{
                maxRate = list[index].heartRateValue
            }

            list[index] = user
        }
        var messageEventbus = MessageEventbus.obtain(Constant.BOX_USER_REFRESH,list)
        EventBus.getDefault().post(messageEventbus)
        return false
    }

    /**
     * 用户全部下线
     */
    private fun allUserOffline(){
        if (list == null) {
            return
        }

        list.clear()
        var messageEventbus = MessageEventbus.obtain(Constant.BOX_USER_ALLOFFLINE,list)
        EventBus.getDefault().post(messageEventbus)
    }

    /**
     * 切换器械
     */
    private fun switchEpAction(user: User?) : Boolean {

        if (user == null || list == null) {
            return false
        }
        val index = list.indexOf(user)

        if (index != -1) {
            if(list[index].bindEpType != user.bindEpType){

                list.remove(user)
            }else{

                list[index] = user
            }
            var messageEventbus = MessageEventbus.obtain(Constant.BOX_USER_SWITCHEP,list)
            EventBus.getDefault().post(messageEventbus)
        }
        return false
    }
}
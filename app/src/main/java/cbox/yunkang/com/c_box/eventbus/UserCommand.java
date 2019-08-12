package cbox.yunkang.com.c_box.eventbus;

public class UserCommand {

    /**
     * 用户上线(用户上屏）
     */
    public static final int USERONLINE = 1;

    /**
     * 全部用户下线（用户下屏）
     */
    public static final int USERAllOFFINE = 2;

    /**
     * 单个用户下线
     */
    public static final int USEROFFLINE = 0;

    /**
     * 用户切换器械
     */
    public static final int USERSWITCHEP = 3;

    /**
     * 用户切换动作
     */
    public static final int USERSWITCHAC = 4;

    /**
     * 用户切换负载重量
     */
    public static final int USERCHANGEWEIGHT = 5;

    /**
     * 用户更新运动数据
     */
    public static final int USERREFRESH = 6;

    /**
     * 用户更新心率
     */
    public static final int USEREFRESHHEART = 7;

    /**
     * 用户显示头像
     */
    public static final int USERSHOWICON = 8;

    /**
     * 用户运动组间休息
     */
    public static final int USERRESTING = 9;


    public static final int USERALLOFFLINE = 19;

    public static final int USERSORTS = 20;

    /**
     * 健身配置开始更新
     */
    public static final int CONFIGUREUPDAESTART = 10;

    /**
     * 健身配置完成更新
     */
    public static final int CONFIGUREUPDAEOVER = 11;

    /**
     * 获取实景视频源
     */
    public static final int SCENEVIDEO = 12;

    /**
     * 获取健身房单日排行榜
     */
    public static final int SPORTRANKING = 13;

    /**
     * 用户上传完一组数据
     */
    public static final int UPLOADSPORTCOMPLETE = 14;

    /**
     *  排序方式改变
     */
    public static final int SORTINGMODECHANGE = 15;


    /**
     *  显示初始结果
     */
    public static final int INITRESULT = 16;

    /**
     *  显示正在下载的背景视频资源
     */
    public static final int DOWNLOADRESOURCESTART = 17;

    /**
     *  显示已完成下载背景视频资源
     */
    public static final int DOWNLOADRESOURCEOVER = 18;
}

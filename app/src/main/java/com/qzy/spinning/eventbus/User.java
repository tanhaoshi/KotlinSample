package com.qzy.spinning.eventbus;

import android.support.v4.util.Pools;
import android.text.TextUtils;

import com.ykcx.bcore.cil.UserProfile;

public class User {

    private static final Pools.SimplePool<User> sPool = new Pools.SimplePool<>(10);

    public  static User obtain(UserProfile userProfile){
        User instance = sPool.acquire();
        return (instance != null) ? instance : builderUser(userProfile);
    }

    private static User builderUser(UserProfile userProfile){
        User user = new UserBuilder()
                .bindEpName(userProfile.getBindEpName())
                .format(userProfile.getFormat())
                .usrOpenId(userProfile.getUsrOpenId())
                .usrBandId(userProfile.getUsrBandId())
                .usrIconUrl(userProfile.getUsrIconUrl())
                .sportValue(userProfile.getSportValue())
                .sportTotalValue(userProfile.getSportTotalValue())
                .usrName(userProfile.getUsrName())
                .bindEpType(userProfile.getBindEpType())
                .curActionName(userProfile.getCurActionName())
                .heartRateValue(userProfile.getHeartRateValue())
                .kcal(userProfile.getKcal())
                .trainStrength(userProfile.getTrainStrength())
                .epWeight(userProfile.getEpWeight())
                .build();
        return user;
    }

    public void recycle(){
        sPool.release(this);
    }

    /**
     *用户手环ID
     */
    private String usrBandId;

    /**
     * 用户openID
     */
    private String usrOpenId;

    /**
     * 当前运动主数据
     */
    private String sportValue;

    /**
     * 器械负载重量
     */
    private float EpWeight;

    /**
     * 用户名
     */
    private String usrName;

    /**
     * 用户头像
     */
    private String usrIconUrl;

    /**
     * 绑定的器械名称
     */
    private String bindEpName;

    /**
     * 绑定器械的类型
     */
    private int bindEpType;

    /**
     * 累计运动主数据
     */
    private String sportTotalValue;

    /**
     * 当前运动动作名称
     */
    private String curActionName;

    /**
     * 排版格式
     * 0 ----纯心率排版格式
     * 1 ----有氧器械排版格式
     * 2 ----力量器械排版格式
     */
    private int format;

    /**
     * 实时速度数据
     */
    private String speedValue;

    /**
     * 用户上线时间
     */
    private long onLineTime ;

    /**
     * 用户休息时间
     */
    private long restartTime;

    /**
     * 实时卡路里
     */
    private double kcal;

    /**
     * 心率实时数据
     */
    private int heartRateValue;

    /**
     * 所有用户下线所带消息
     */
    private String msg;

    /**
     * 训练强度数据
     */
    private String trainStrength;

    private String tapinValue;

    private String equipPartType;

    private int commandType = -1;

    private User(UserBuilder userBuilder){
        this.format = userBuilder.format;
        this.bindEpName = userBuilder.bindEpName;
        this.usrOpenId = userBuilder.usrOpenId;
        this.usrBandId = userBuilder.usrBandId;
        this.usrIconUrl = userBuilder.usrIconUrl;
        this.sportValue = userBuilder.sportValue;
        this.sportTotalValue = userBuilder.sportTotalValue;
        this.usrName = userBuilder.usrName;
        this.bindEpType = userBuilder.bindEpType;
        this.curActionName = userBuilder.curActionName;
        this.heartRateValue = userBuilder.heartRateValue;
        this.kcal = userBuilder.kcal;
        this.trainStrength = userBuilder.trainStrength;
        this.EpWeight = userBuilder.EpWeight;
    }

    public String getTrainStrength() {
        return trainStrength;
    }

    public void setTrainStrength(String trainStrength) {
        this.trainStrength = trainStrength;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public int getHeartRateValue() {
        return heartRateValue;
    }

    public String getSpeedValue() {
        return speedValue;
    }

    public void setSpeedValue(String speedValue) {
        this.speedValue = speedValue;
    }

    public void setHeartRateValue(int heartRateValue) {
        this.heartRateValue = heartRateValue;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public long getRestartTime() {
        return restartTime;
    }

    public float getEpWeight() {
        return EpWeight;
    }

    public void setEpWeight(float epWeight) {
        EpWeight = epWeight;
    }

    public void setRestartTime(long restartTime)
    {
        this.restartTime = restartTime;
    }

    public long getOnLineTime() {
        return onLineTime;
    }

    public void setOnLineTime(long onLineTime) {
        this.onLineTime = onLineTime;
    }


    public String getUsrBandId() {
        return usrBandId;
    }

    public void setUsrBandId(String usrBandId) {
        this.usrBandId = usrBandId;
    }

    public String getUsrOpenId() {
        return usrOpenId;
    }

    public void setUsrOpenId(String usrOpenId) {
        this.usrOpenId = usrOpenId;
    }

    public String getSportValue() {
        return sportValue;
    }

    public void setSportValue(String sportValue) {
        this.sportValue = sportValue;
    }

    public String getUsrName()
    {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrIconUrl() {
        return usrIconUrl;
    }

    public void setUsrIconUrl(String usrIconUrl) {
        this.usrIconUrl = usrIconUrl;
    }

    public String getBindEpName() {
        return bindEpName;
    }

    public void setBindEpName(String bindEpName) {
        this.bindEpName = bindEpName;
    }

    public int getBindEpType() {
        return bindEpType;
    }

    public void setBindEpType(int bindEpType) {
        this.bindEpType = bindEpType;
    }

    public String getSportTotalValue() {
        return sportTotalValue;
    }

    public void setSportTotalValue(String sportTotalValue) {
        this.sportTotalValue = sportTotalValue;
    }

    public String getCurActionName() {
        return curActionName;
    }

    public void setCurActionName(String curActionName) {
        this.curActionName = curActionName;
    }

    public String getTapinValue() {
        return tapinValue;
    }

    public void setTapinValue(String tapinValue) {
        this.tapinValue = tapinValue;
    }

    public String getEquipPartType() {
        return equipPartType;
    }

    public void setEquipPartType(String equipPartType) {
        this.equipPartType = equipPartType;
    }

    public static class UserBuilder{
        private String usrBandId;
        private String usrOpenId;
        private String sportValue;
        private float EpWeight;
        private String usrName;
        private String usrIconUrl;
        private String bindEpName;
        private int bindEpType;
        private String sportTotalValue;
        private String curActionName;
        private int format;
        private String speedValue;
        private long onLineTime ;
        private long restartTime;
        private double kcal;
        private int heartRateValue;
        private String msg;
        private String trainStrength;
        private int commandType = -1;
        private String tapinValue;
        private String equipPartType;

        public UserBuilder(){

        }

        public UserBuilder usrBandId(String usrBandId){
            this.usrBandId = usrBandId;
            return this;
        }

        public UserBuilder usrOpenId(String usrOpenId){
            this.usrOpenId = usrOpenId;
            return this;
        }

        public UserBuilder sportValue(String sportValue){
            this.sportValue = sportValue;
            return this;
        }

        public UserBuilder epWeight(float EpWeight){
            this.EpWeight = EpWeight;
            return this;
        }

        public UserBuilder usrName(String usrName){
            this.usrName = usrName;
            return this;
        }

        public UserBuilder usrIconUrl(String usrIconUrl){
            this.usrIconUrl = usrIconUrl;
            return this;
        }

        public UserBuilder bindEpName(String bindEpName){
            this.bindEpName = bindEpName;
            return this;
        }

        public UserBuilder bindEpType(int bindEpType){
            this.bindEpType = bindEpType;
            return this;
        }

        public UserBuilder sportTotalValue(String sportTotalValue){
            this.sportTotalValue = sportTotalValue;
            return this;
        }

        public UserBuilder curActionName(String curActionName){
            this.curActionName = curActionName;
            return this;
        }

        public UserBuilder format(int format){
            this.format = format;
            return this;
        }

        public UserBuilder onLineTime(long onLineTime){
            this.onLineTime = onLineTime;
            return this;
        }

        public UserBuilder restartTime(long restartTime){
            this.restartTime = restartTime;
            return this;
        }

        public UserBuilder kcal(double kcal){
            this.kcal = kcal;
            return this;
        }

        public UserBuilder heartRateValue(int heartRateValue){
            this.heartRateValue = heartRateValue;
            return this;
        }

        public UserBuilder msg(String msg){
            this.msg = msg;
            return this;
        }

        public UserBuilder trainStrength(String trainStrength){
            this.trainStrength = trainStrength;
            return this;
        }

        public UserBuilder tapinValue(String tapinValue){
            this.tapinValue = tapinValue;
            return this;
        }

        public UserBuilder equipPartType(String equipPartType){
            this.equipPartType = equipPartType;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj != null)
        {
            User person= (User) obj;
            if(!TextUtils.isEmpty(usrOpenId) && !TextUtils.isEmpty(person.getUsrOpenId()))
            {
                return usrOpenId.equals(person.getUsrOpenId());
            }
            else if(!TextUtils.isEmpty(usrBandId) && !TextUtils.isEmpty(person.getUsrBandId()))
            {
                return usrBandId.equals(person.getUsrBandId());
            }
            else
            {
                return false;
            }
        }
        return false;
    }
}

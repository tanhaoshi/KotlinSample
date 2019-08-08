package cbox.yunkang.com.c_box.mvp.datamodel;

import java.util.List;

public class CourseTodayRanking {

    /**
     * code : 200
     * data : [{"id":8,"mileage":"100","duration":"100","consume":"556","maxFrequency":"50","avgFrequency":"40","avgSpeed":"1","maxRate":"140","avgRate":"80","intensity":"80","leagueUuid":"cafa399310c24b7786e01145f0eeb129","openId":"ed1f89def1769b392204b17bb007bc21","postTime":1564730488000,"startTime":1564723288000,"classDuration":null,"classGroup":"20190802719323","heartRange":"","color":"red","box":"stewtw","gymAddr":"00000142","nickname":"whochange","head":"https://shuibianpic04.whochange.com/screenLogo1536980064469.png","winner":1,"sort":1},{"id":9,"mileage":"100","duration":"100","consume":"556","maxFrequency":"50","avgFrequency":"40","avgSpeed":"1","maxRate":"140","avgRate":"80","intensity":"80","leagueUuid":"cafa399310c24b7786e01145f0eeb129","openId":"6820e90773767a5243f8477e6d9e558d","postTime":1564730488000,"startTime":1564723288000,"classDuration":null,"classGroup":"20190802719323","heartRange":"","color":"blue","box":"stewtw","gymAddr":"00000142","nickname":"梦马年华","head":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJg4hs2wGNnQnAmXSiadS0tibjJ6cUrJ4IsJn8iboxGcwLHvHVqu4k2cE7vbkrRsJqC15fY7vicNg0O3A/132","winner":0,"sort":2}]
     * message : OK
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 8
         * mileage : 100
         * duration : 100
         * consume : 556
         * maxFrequency : 50
         * avgFrequency : 40
         * avgSpeed : 1
         * maxRate : 140
         * avgRate : 80
         * intensity : 80
         * leagueUuid : cafa399310c24b7786e01145f0eeb129
         * openId : ed1f89def1769b392204b17bb007bc21
         * postTime : 1564730488000
         * startTime : 1564723288000
         * classDuration : null
         * classGroup : 20190802719323
         * heartRange :
         * color : red
         * box : stewtw
         * gymAddr : 00000142
         * nickname : whochange
         * head : https://shuibianpic04.whochange.com/screenLogo1536980064469.png
         * winner : 1
         * sort : 1
         */

        private int id;
        private String mileage;
        private String duration;
        private String consume;
        private String maxFrequency;
        private String avgFrequency;
        private String avgSpeed;
        private String maxRate;
        private String avgRate;
        private String intensity;
        private String leagueUuid;
        private String openId;
        private long postTime;
        private long startTime;
        private Object classDuration;
        private String classGroup;
        private String heartRange;
        private String color;
        private String box;
        private String gymAddr;
        private String nickname;
        private String head;
        private int winner;
        private int sort;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMileage() {
            return mileage;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getConsume() {
            return consume;
        }

        public void setConsume(String consume) {
            this.consume = consume;
        }

        public String getMaxFrequency() {
            return maxFrequency;
        }

        public void setMaxFrequency(String maxFrequency) {
            this.maxFrequency = maxFrequency;
        }

        public String getAvgFrequency() {
            return avgFrequency;
        }

        public void setAvgFrequency(String avgFrequency) {
            this.avgFrequency = avgFrequency;
        }

        public String getAvgSpeed() {
            return avgSpeed;
        }

        public void setAvgSpeed(String avgSpeed) {
            this.avgSpeed = avgSpeed;
        }

        public String getMaxRate() {
            return maxRate;
        }

        public void setMaxRate(String maxRate) {
            this.maxRate = maxRate;
        }

        public String getAvgRate() {
            return avgRate;
        }

        public void setAvgRate(String avgRate) {
            this.avgRate = avgRate;
        }

        public String getIntensity() {
            return intensity;
        }

        public void setIntensity(String intensity) {
            this.intensity = intensity;
        }

        public String getLeagueUuid() {
            return leagueUuid;
        }

        public void setLeagueUuid(String leagueUuid) {
            this.leagueUuid = leagueUuid;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public long getPostTime() {
            return postTime;
        }

        public void setPostTime(long postTime) {
            this.postTime = postTime;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public Object getClassDuration() {
            return classDuration;
        }

        public void setClassDuration(Object classDuration) {
            this.classDuration = classDuration;
        }

        public String getClassGroup() {
            return classGroup;
        }

        public void setClassGroup(String classGroup) {
            this.classGroup = classGroup;
        }

        public String getHeartRange() {
            return heartRange;
        }

        public void setHeartRange(String heartRange) {
            this.heartRange = heartRange;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getBox() {
            return box;
        }

        public void setBox(String box) {
            this.box = box;
        }

        public String getGymAddr() {
            return gymAddr;
        }

        public void setGymAddr(String gymAddr) {
            this.gymAddr = gymAddr;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public int getWinner() {
            return winner;
        }

        public void setWinner(int winner) {
            this.winner = winner;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}

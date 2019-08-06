package com.qzy.spinning.mvp.datamodel;

import java.util.List;

public class SubmitPhsical {


    /**
     * gymAddr : 00000142
     * duration : 120
     * mac : sss
     * winner : red
     * list : [{"leagueUuid":"cafa399310c24b7786e01145f0eeb1","openId":"asss","mileage":"100","consume":"556","maxFrequency":"50","avgFrequency":"40","avgSpeed":"1","duration":"100","maxRate":"140","intensity":"80","heartRange":"9","avgRate":"80","color":"red"}]
     */

    private String gymAddr;
    private int duration;
    private String mac;
    private String winner;
    private List<ListBean> list;

    public String getGymAddr() {
        return gymAddr;
    }

    public void setGymAddr(String gymAddr) {
        this.gymAddr = gymAddr;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * leagueUuid : cafa399310c24b7786e01145f0eeb1
         * openId : asss
         * mileage : 100
         * consume : 556
         * maxFrequency : 50
         * avgFrequency : 40
         * avgSpeed : 1
         * duration : 100
         * maxRate : 140
         * intensity : 80
         * heartRange : 9
         * avgRate : 80
         * color : red
         */

        private String leagueUuid;
        private String openId;
        private String mileage;
        private String consume;
        private String maxFrequency;
        private String avgFrequency;
        private String avgSpeed;
        private String duration;
        private String maxRate;
        private String intensity;
        private String heartRange;
        private String avgRate;
        private String color;

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

        public String getMileage() {
            return mileage;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
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

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getMaxRate() {
            return maxRate;
        }

        public void setMaxRate(String maxRate) {
            this.maxRate = maxRate;
        }

        public String getIntensity() {
            return intensity;
        }

        public void setIntensity(String intensity) {
            this.intensity = intensity;
        }

        public String getHeartRange() {
            return heartRange;
        }

        public void setHeartRange(String heartRange) {
            this.heartRange = heartRange;
        }

        public String getAvgRate() {
            return avgRate;
        }

        public void setAvgRate(String avgRate) {
            this.avgRate = avgRate;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}

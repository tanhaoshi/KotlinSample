package com.qzy.spinning.mvp.datamodel;

import java.util.List;

public class SmartCourse {


    /**
     * code : 200
     * data : [{"uuid":"ebe77dee11f2497ea80e1746685ab765","title":"12","cover":"https://intelligentclasspic.whochange.com/class1564386071350.jpeg","video":"https://intelligentclasspic.whochange.com/class1564384385260.mp4","priceInfo":[{"price":"1","discountPrice":"1","startTime":"2019-07-24 12:00:00","endTime":"2019-07-31 12:00:00","type":1},{"price":"1","discountPrice":"2","startTime":"2019-07-31 12:00:00","endTime":"2019-07-30 12:00:00","type":2},{"price":"12","discountPrice":"3","startTime":"2019-07-23 12:00:00","endTime":"2019-07-31 12:00:00","type":3},{"price":"21","discountPrice":"1","startTime":"2019-07-31 12:00:00","endTime":"2019-07-31 12:00:00","type":4},{"price":"23","discountPrice":"12","startTime":"2019-07-11 12:00:00","endTime":"2019-07-31 12:00:00","type":5},{"price":"123","discountPrice":"12","startTime":"2019-07-04 12:00:00","endTime":"2019-07-23 12:00:00","type":6}],"level":3,"useCount":"0","actions":[{"strength":1,"sort":0,"uuid":"3","group":1}],"version":"1","duration":123,"leagueType":1,"boxMac":null,"classBuyStatus":null,"classBuyStart":null,"classBuyCycle":null,"updateTime":null}]
     * count : 8
     * message : OK
     */

    private int code;
    private int count;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
         * uuid : ebe77dee11f2497ea80e1746685ab765
         * title : 12
         * cover : https://intelligentclasspic.whochange.com/class1564386071350.jpeg
         * video : https://intelligentclasspic.whochange.com/class1564384385260.mp4
         * priceInfo : [{"price":"1","discountPrice":"1","startTime":"2019-07-24 12:00:00","endTime":"2019-07-31 12:00:00","type":1},{"price":"1","discountPrice":"2","startTime":"2019-07-31 12:00:00","endTime":"2019-07-30 12:00:00","type":2},{"price":"12","discountPrice":"3","startTime":"2019-07-23 12:00:00","endTime":"2019-07-31 12:00:00","type":3},{"price":"21","discountPrice":"1","startTime":"2019-07-31 12:00:00","endTime":"2019-07-31 12:00:00","type":4},{"price":"23","discountPrice":"12","startTime":"2019-07-11 12:00:00","endTime":"2019-07-31 12:00:00","type":5},{"price":"123","discountPrice":"12","startTime":"2019-07-04 12:00:00","endTime":"2019-07-23 12:00:00","type":6}]
         * level : 3
         * useCount : 0
         * actions : [{"strength":1,"sort":0,"uuid":"3","group":1}]
         * version : 1
         * duration : 123
         * leagueType : 1
         * boxMac : null
         * classBuyStatus : null未激活未试用，1未激活试用中，2未激活试用期已过，3已激活有期限，4未激活使用期限到期，5无限激活
         * classBuyStart : null
         * classBuyCycle : null
         * updateTime : null
         */

        private String uuid;
        private String title;
        private String cover;
        private String video;
        private int level;
        private String useCount;
        private String version;
        private int duration;
        private int leagueType;
        private Object boxMac;
        private Object classBuyStatus;
        private Object classBuyStart;
        private Object classBuyCycle;
        private Object updateTime;
        private List<PriceInfoBean> priceInfo;
        private List<ActionsBean> actions;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getUseCount() {
            return useCount;
        }

        public void setUseCount(String useCount) {
            this.useCount = useCount;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getLeagueType() {
            return leagueType;
        }

        public void setLeagueType(int leagueType) {
            this.leagueType = leagueType;
        }

        public Object getBoxMac() {
            return boxMac;
        }

        public void setBoxMac(Object boxMac) {
            this.boxMac = boxMac;
        }

        public Object getClassBuyStatus() {
            return classBuyStatus;
        }

        public void setClassBuyStatus(Object classBuyStatus) {
            this.classBuyStatus = classBuyStatus;
        }

        public Object getClassBuyStart() {
            return classBuyStart;
        }

        public void setClassBuyStart(Object classBuyStart) {
            this.classBuyStart = classBuyStart;
        }

        public Object getClassBuyCycle() {
            return classBuyCycle;
        }

        public void setClassBuyCycle(Object classBuyCycle) {
            this.classBuyCycle = classBuyCycle;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public List<PriceInfoBean> getPriceInfo() {
            return priceInfo;
        }

        public void setPriceInfo(List<PriceInfoBean> priceInfo) {
            this.priceInfo = priceInfo;
        }

        public List<ActionsBean> getActions() {
            return actions;
        }

        public void setActions(List<ActionsBean> actions) {
            this.actions = actions;
        }

        public static class PriceInfoBean {
            /**
             * price : 1
             * discountPrice : 1
             * startTime : 2019-07-24 12:00:00
             * endTime : 2019-07-31 12:00:00
             * type : 1
             */

            private String price;
            private String discountPrice;
            private String startTime;
            private String endTime;
            private int type;

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(String discountPrice) {
                this.discountPrice = discountPrice;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class ActionsBean {
            /**
             * strength : 1
             * sort : 0
             * uuid : 3
             * group : 1
             */

            private int strength;
            private int sort;
            private String uuid;
            private int group;

            public int getStrength() {
                return strength;
            }

            public void setStrength(int strength) {
                this.strength = strength;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public int getGroup() {
                return group;
            }

            public void setGroup(int group) {
                this.group = group;
            }
        }
    }
}

package cbox.yunkang.com.c_box.mvp.datamodel;

import java.util.List;

public class SmartCourse {

    /**
     * code : 200
     * data : [{"uuid":"d0fcd25da7374e188fe3908a982c5a9e","title":"名称","cover":"https://intelligentclasspic.whochange.com/class1564467035063.jpg","video":"https://intelligentclasspic.whochange.com/class1564467040017.mp4","priceInfo":[{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-24 12:00:00","endTime":"2019-07-31 12:00:00","type":1},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-30 12:00:00","type":2},{"price":"0.01","discountPrice":"3","startTime":"2019-07-23 12:00:00","endTime":"2019-07-31 12:00:00","type":3},{"price":"21","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-31 12:00:00","type":4},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-11 12:00:00","endTime":"2019-07-31 12:00:00","type":5},{"price":"123","discountPrice":"12","startTime":"2019-07-04 12:00:00","endTime":"2019-07-23 12:00:00","type":6}],"level":5,"useCount":"0","actions":[22,23,24,25],"version":"1","duration":12,"leagueType":2,"boxNum":null,"classBuyStatus":null,"classBuyStart":null,"classBuyCycle":null,"updateTime":null},{"uuid":"18285031bf734c99b832949ff980a701","title":"标题","cover":"https://intelligentclasspic.whochange.com/class1564468409625.jpg","video":"https://intelligentclasspic.whochange.com/class1564468362329.mp4","priceInfo":[{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-24 12:00:00","endTime":"2019-07-31 12:00:00","type":1},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-30 12:00:00","type":2},{"price":"0.01","discountPrice":"3","startTime":"2019-07-23 12:00:00","endTime":"2019-07-31 12:00:00","type":3},{"price":"21","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-31 12:00:00","type":4},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-11 12:00:00","endTime":"2019-07-31 12:00:00","type":5},{"price":"123","discountPrice":"12","startTime":"2019-07-04 12:00:00","endTime":"2019-07-23 12:00:00","type":6}],"level":5,"useCount":"0","actions":[25],"version":"1","duration":123,"leagueType":2,"boxNum":null,"classBuyStatus":null,"classBuyStart":null,"classBuyCycle":null,"updateTime":null},{"uuid":"cf661e6eedba495ebbf34bb6b6544cdf","title":"12","cover":"https://intelligentclasspic.whochange.com/class1564021999291.png","video":"https://intelligentclasspic.whochange.com/class1564022003128.mp4","priceInfo":[{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-24 12:00:00","endTime":"2019-07-31 12:00:00","type":1},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-30 12:00:00","type":2},{"price":"0.01","discountPrice":"3","startTime":"2019-07-23 12:00:00","endTime":"2019-07-31 12:00:00","type":3},{"price":"21","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-31 12:00:00","type":4},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-11 12:00:00","endTime":"2019-07-31 12:00:00","type":5},{"price":"123","discountPrice":"12","startTime":"2019-07-04 12:00:00","endTime":"2019-07-23 12:00:00","type":6}],"level":5,"useCount":"0","actions":null,"version":"1","duration":123,"leagueType":2,"boxNum":null,"classBuyStatus":null,"classBuyStart":null,"classBuyCycle":null,"updateTime":null}]
     * count : 3
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
         * uuid : d0fcd25da7374e188fe3908a982c5a9e
         * title : 名称
         * cover : https://intelligentclasspic.whochange.com/class1564467035063.jpg
         * video : https://intelligentclasspic.whochange.com/class1564467040017.mp4
         * priceInfo : [{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-24 12:00:00","endTime":"2019-07-31 12:00:00","type":1},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-30 12:00:00","type":2},{"price":"0.01","discountPrice":"3","startTime":"2019-07-23 12:00:00","endTime":"2019-07-31 12:00:00","type":3},{"price":"21","discountPrice":"0.01","startTime":"2019-07-31 12:00:00","endTime":"2019-07-31 12:00:00","type":4},{"price":"0.01","discountPrice":"0.01","startTime":"2019-07-11 12:00:00","endTime":"2019-07-31 12:00:00","type":5},{"price":"123","discountPrice":"12","startTime":"2019-07-04 12:00:00","endTime":"2019-07-23 12:00:00","type":6}]
         * level : 5
         * useCount : 0
         * actions : [22,23,24,25]
         * version : 1
         * duration : 12
         * leagueType : 2
         * boxNum : null
         * classBuyStatus : null
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
        private Object boxNum;
        private Object classBuyStatus;
        private Object classBuyStart;
        private Object classBuyCycle;
        private Object updateTime;
        private List<PriceInfoBean> priceInfo;
        private List<Integer> actions;

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

        public Object getBoxNum() {
            return boxNum;
        }

        public void setBoxNum(Object boxNum) {
            this.boxNum = boxNum;
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

        public List<Integer> getActions() {
            return actions;
        }

        public void setActions(List<Integer> actions) {
            this.actions = actions;
        }

        public static class PriceInfoBean {
            /**
             * price : 0.01
             * discountPrice : 0.01
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
    }
}

package cbox.yunkang.com.c_box.mvp.datamodel;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CourseExplain {


    /**
     * code : 200
     * data : {"classLeague":{"id":94,"page":0,"limit":0,"start":0,"uuid":"18285031bf734c99b832949ff980a701","title":"标题","cover":"https://intelligentclasspic.whochange.com/class1564468409625.jpg","price":null,"discountPrice":null,"label":"12312 123123","level":5,"beginTime":null,"endTime":null,"consume":"123","introduce":"123","appropriateCrowd":"123","tabooCrowd":"123","weight":"","status":1,"createTime":1564421690000,"buyCount":null,"activateCount":null,"useCount":"1","duration":123,"actions":"[25]","leagueType":2,"priceInfo":"[{\"discountPrice\":\"11\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"12\",\"startTime\":\"2019-07-23 12:00:00\",\"type\":1},{\"discountPrice\":\"12\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"23\",\"startTime\":\"2019-07-02 12:00:00\",\"type\":2},{\"discountPrice\":\"2\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"12\",\"startTime\":\"2019-07-02 12:00:00\",\"type\":3},{\"discountPrice\":\"23\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"34\",\"startTime\":\"2019-07-10 12:00:00\",\"type\":4},{\"discountPrice\":\"31\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"41\",\"startTime\":\"2019-07-09 12:00:00\",\"type\":5},{\"discountPrice\":\"12\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"12\",\"startTime\":\"2019-07-09 12:00:00\",\"type\":6}]","actionList":null,"actionSpinList":null,"priceInfoList":null,"stageGroup":{"123":[{"id":25,"uuid":null,"title":"123","stage":"123","duration":"12","heartRange":3,"resistance":112,"stepFrequency":1,"handlePosition":1,"essential":"12"}]}}}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * classLeague : {"id":94,"page":0,"limit":0,"start":0,"uuid":"18285031bf734c99b832949ff980a701","title":"标题","cover":"https://intelligentclasspic.whochange.com/class1564468409625.jpg","price":null,"discountPrice":null,"label":"12312 123123","level":5,"beginTime":null,"endTime":null,"consume":"123","introduce":"123","appropriateCrowd":"123","tabooCrowd":"123","weight":"","status":1,"createTime":1564421690000,"buyCount":null,"activateCount":null,"useCount":"1","duration":123,"actions":"[25]","leagueType":2,"priceInfo":"[{\"discountPrice\":\"11\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"12\",\"startTime\":\"2019-07-23 12:00:00\",\"type\":1},{\"discountPrice\":\"12\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"23\",\"startTime\":\"2019-07-02 12:00:00\",\"type\":2},{\"discountPrice\":\"2\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"12\",\"startTime\":\"2019-07-02 12:00:00\",\"type\":3},{\"discountPrice\":\"23\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"34\",\"startTime\":\"2019-07-10 12:00:00\",\"type\":4},{\"discountPrice\":\"31\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"41\",\"startTime\":\"2019-07-09 12:00:00\",\"type\":5},{\"discountPrice\":\"12\",\"endTime\":\"2019-07-31 12:00:00\",\"price\":\"12\",\"startTime\":\"2019-07-09 12:00:00\",\"type\":6}]","actionList":null,"actionSpinList":null,"priceInfoList":null,"stageGroup":{"123":[{"id":25,"uuid":null,"title":"123","stage":"123","duration":"12","heartRange":3,"resistance":112,"stepFrequency":1,"handlePosition":1,"essential":"12"}]}}
         */

        private ClassLeagueBean classLeague;

        public ClassLeagueBean getClassLeague() {
            return classLeague;
        }

        public void setClassLeague(ClassLeagueBean classLeague) {
            this.classLeague = classLeague;
        }

        public static class ClassLeagueBean {
            /**
             * id : 94
             * page : 0
             * limit : 0
             * start : 0
             * uuid : 18285031bf734c99b832949ff980a701
             * title : 标题
             * cover : https://intelligentclasspic.whochange.com/class1564468409625.jpg
             * price : null
             * discountPrice : null
             * label : 12312 123123
             * level : 5
             * beginTime : null
             * endTime : null
             * consume : 123
             * introduce : 123
             * appropriateCrowd : 123
             * tabooCrowd : 123
             * weight :
             * status : 1
             * createTime : 1564421690000
             * buyCount : null
             * activateCount : null
             * useCount : 1
             * duration : 123
             * actions : [25]
             * leagueType : 2
             * priceInfo : [{"discountPrice":"11","endTime":"2019-07-31 12:00:00","price":"12","startTime":"2019-07-23 12:00:00","type":1},{"discountPrice":"12","endTime":"2019-07-31 12:00:00","price":"23","startTime":"2019-07-02 12:00:00","type":2},{"discountPrice":"2","endTime":"2019-07-31 12:00:00","price":"12","startTime":"2019-07-02 12:00:00","type":3},{"discountPrice":"23","endTime":"2019-07-31 12:00:00","price":"34","startTime":"2019-07-10 12:00:00","type":4},{"discountPrice":"31","endTime":"2019-07-31 12:00:00","price":"41","startTime":"2019-07-09 12:00:00","type":5},{"discountPrice":"12","endTime":"2019-07-31 12:00:00","price":"12","startTime":"2019-07-09 12:00:00","type":6}]
             * actionList : null
             * actionSpinList : null
             * priceInfoList : null
             * stageGroup : {"123":[{"id":25,"uuid":null,"title":"123","stage":"123","duration":"12","heartRange":3,"resistance":112,"stepFrequency":1,"handlePosition":1,"essential":"12"}]}
             */

            private int id;
            private int page;
            private int limit;
            private int start;
            private String uuid;
            private String title;
            private String cover;
            private String price;
            private String discountPrice;
            private String label;
            private int level;
            private Object beginTime;
            private Object endTime;
            private String consume;
            private String introduce;
            private String appropriateCrowd;
            private String tabooCrowd;
            private String weight;
            private int status;
            private long createTime;
            private Object buyCount;
            private Object activateCount;
            private String useCount;
            private int duration;
            private String actions;
            private int leagueType;
            private String priceInfo;
            private Object actionList;
            private Object actionSpinList;
            private Object priceInfoList;
            private LinkedHashMap<String,List<TableModel>> stageGroup;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getStart() {
                return start;
            }

            public void setStart(int start) {
                this.start = start;
            }

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

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public Object getBeginTime() {
                return beginTime;
            }

            public void setBeginTime(Object beginTime) {
                this.beginTime = beginTime;
            }

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
                this.endTime = endTime;
            }

            public String getConsume() {
                return consume;
            }

            public void setConsume(String consume) {
                this.consume = consume;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getAppropriateCrowd() {
                return appropriateCrowd;
            }

            public void setAppropriateCrowd(String appropriateCrowd) {
                this.appropriateCrowd = appropriateCrowd;
            }

            public String getTabooCrowd() {
                return tabooCrowd;
            }

            public void setTabooCrowd(String tabooCrowd) {
                this.tabooCrowd = tabooCrowd;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getBuyCount() {
                return buyCount;
            }

            public void setBuyCount(Object buyCount) {
                this.buyCount = buyCount;
            }

            public Object getActivateCount() {
                return activateCount;
            }

            public void setActivateCount(Object activateCount) {
                this.activateCount = activateCount;
            }

            public String getUseCount() {
                return useCount;
            }

            public void setUseCount(String useCount) {
                this.useCount = useCount;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public String getActions() {
                return actions;
            }

            public void setActions(String actions) {
                this.actions = actions;
            }

            public int getLeagueType() {
                return leagueType;
            }

            public void setLeagueType(int leagueType) {
                this.leagueType = leagueType;
            }

            public String getPriceInfo() {
                return priceInfo;
            }

            public void setPriceInfo(String priceInfo) {
                this.priceInfo = priceInfo;
            }

            public Object getActionList() {
                return actionList;
            }

            public void setActionList(Object actionList) {
                this.actionList = actionList;
            }

            public Object getActionSpinList() {
                return actionSpinList;
            }

            public void setActionSpinList(Object actionSpinList) {
                this.actionSpinList = actionSpinList;
            }

            public Object getPriceInfoList() {
                return priceInfoList;
            }

            public void setPriceInfoList(Object priceInfoList) {
                this.priceInfoList = priceInfoList;
            }

            public LinkedHashMap<String, List<TableModel>> getStageGroup() {
                return stageGroup;
            }

            public void setStageGroup(LinkedHashMap<String, List<TableModel>> stageGroup) {
                this.stageGroup = stageGroup;
            }
        }
    }
}

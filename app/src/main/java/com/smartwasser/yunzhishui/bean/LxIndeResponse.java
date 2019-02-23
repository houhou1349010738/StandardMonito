package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/5/19 0019.
 */
public class LxIndeResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"indeList":[{"accuracyInter":5,"accuracyPoint":2,"busiType":"污水处理","busiTypeChd":"请选择","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-04-25 13:07:57","creatUnit":"137120684996966501528","dataType":"数值","dataUnit":"mg","defaultValue":"","gatherType":"非在线","id":"b19ee4c80aa311e6907e5c260a3ed263","indeCode":"fsdf","indeFreq":"分","indeHaveName":"","indeLevel":"一般","indeName":"月报指标1","indeNiceName":"","indeStat":"有效","maxValue":"","minValue":"","subjectType":"能源计量","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-05-08 19:27:03","updateUnit":"137120684996966501528"}]}
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;
    public void setData(DataEntity data) {
        this.data = data;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static class DataEntity {
        /**
         * accuracyInter : 5
         * accuracyPoint : 2
         * busiType : 污水处理
         * busiTypeChd : 请选择
         * creatManCode : root
         * creatManName : 后台管理员
         * creatTime : 2016-04-25 13:07:57
         * creatUnit : 137120684996966501528
         * dataType : 数值
         * dataUnit : mg
         * defaultValue :
         * gatherType : 非在线
         * id : b19ee4c80aa311e6907e5c260a3ed263
         * indeCode : fsdf
         * indeFreq : 分
         * indeHaveName :
         * indeLevel : 一般
         * indeName : 月报指标1
         * indeNiceName :
         * indeStat : 有效
         * maxValue :
         * minValue :
         * subjectType : 能源计量
         * updateManCode : root
         * updateManName : 后台管理员
         * updateTime : 2016-05-08 19:27:03
         * updateUnit : 137120684996966501528
         */

        private List<IndeListEntity> indeList;

        public void setIndeList(List<IndeListEntity> indeList) {
            this.indeList = indeList;
        }

        public List<IndeListEntity> getIndeList() {
            return indeList;
        }

        public static class IndeListEntity {
            private int accuracyInter;
            private int accuracyPoint;
            private String busiType;
            private String busiTypeChd;
            private String creatManCode;
            private String creatManName;
            private String creatTime;
            private String creatUnit;
            private String dataType;
            private String dataUnit;
            private String defaultValue;
            private String gatherType;
            private String id;
            private String indeCode;
            private String indeFreq;
            private String indeHaveName;
            private String indeLevel;
            private String indeName;
            private String indeNiceName;
            private String indeStat;
            private String maxValue;
            private String minValue;
            private String subjectType;
            private String updateManCode;
            private String updateManName;
            private String updateTime;
            private String updateUnit;

            public void setAccuracyInter(int accuracyInter) {
                this.accuracyInter = accuracyInter;
            }

            public void setAccuracyPoint(int accuracyPoint) {
                this.accuracyPoint = accuracyPoint;
            }

            public void setBusiType(String busiType) {
                this.busiType = busiType;
            }

            public void setBusiTypeChd(String busiTypeChd) {
                this.busiTypeChd = busiTypeChd;
            }

            public void setCreatManCode(String creatManCode) {
                this.creatManCode = creatManCode;
            }

            public void setCreatManName(String creatManName) {
                this.creatManName = creatManName;
            }

            public void setCreatTime(String creatTime) {
                this.creatTime = creatTime;
            }

            public void setCreatUnit(String creatUnit) {
                this.creatUnit = creatUnit;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public void setDataUnit(String dataUnit) {
                this.dataUnit = dataUnit;
            }

            public void setDefaultValue(String defaultValue) {
                this.defaultValue = defaultValue;
            }

            public void setGatherType(String gatherType) {
                this.gatherType = gatherType;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIndeCode(String indeCode) {
                this.indeCode = indeCode;
            }

            public void setIndeFreq(String indeFreq) {
                this.indeFreq = indeFreq;
            }

            public void setIndeHaveName(String indeHaveName) {
                this.indeHaveName = indeHaveName;
            }

            public void setIndeLevel(String indeLevel) {
                this.indeLevel = indeLevel;
            }

            public void setIndeName(String indeName) {
                this.indeName = indeName;
            }

            public void setIndeNiceName(String indeNiceName) {
                this.indeNiceName = indeNiceName;
            }

            public void setIndeStat(String indeStat) {
                this.indeStat = indeStat;
            }

            public void setMaxValue(String maxValue) {
                this.maxValue = maxValue;
            }

            public void setMinValue(String minValue) {
                this.minValue = minValue;
            }

            public void setSubjectType(String subjectType) {
                this.subjectType = subjectType;
            }

            public void setUpdateManCode(String updateManCode) {
                this.updateManCode = updateManCode;
            }

            public void setUpdateManName(String updateManName) {
                this.updateManName = updateManName;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public void setUpdateUnit(String updateUnit) {
                this.updateUnit = updateUnit;
            }

            public int getAccuracyInter() {
                return accuracyInter;
            }

            public int getAccuracyPoint() {
                return accuracyPoint;
            }

            public String getBusiType() {
                return busiType;
            }

            public String getBusiTypeChd() {
                return busiTypeChd;
            }

            public String getCreatManCode() {
                return creatManCode;
            }

            public String getCreatManName() {
                return creatManName;
            }

            public String getCreatTime() {
                return creatTime;
            }

            public String getCreatUnit() {
                return creatUnit;
            }

            public String getDataType() {
                return dataType;
            }

            public String getDataUnit() {
                return dataUnit;
            }

            public String getDefaultValue() {
                return defaultValue;
            }

            public String getGatherType() {
                return gatherType;
            }

            public String getId() {
                return id;
            }

            public String getIndeCode() {
                return indeCode;
            }

            public String getIndeFreq() {
                return indeFreq;
            }

            public String getIndeHaveName() {
                return indeHaveName;
            }

            public String getIndeLevel() {
                return indeLevel;
            }

            public String getIndeName() {
                return indeName;
            }

            public String getIndeNiceName() {
                return indeNiceName;
            }

            public String getIndeStat() {
                return indeStat;
            }

            public String getMaxValue() {
                return maxValue;
            }

            public String getMinValue() {
                return minValue;
            }

            public String getSubjectType() {
                return subjectType;
            }

            public String getUpdateManCode() {
                return updateManCode;
            }

            public String getUpdateManName() {
                return updateManName;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public String getUpdateUnit() {
                return updateUnit;
            }
        }
    }
}

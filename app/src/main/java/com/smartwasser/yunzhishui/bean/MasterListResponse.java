package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/5/6 0006.
 */
public class MasterListResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"masters":[{"accuracyInter":5,"accuracyPoint":2,"busiType":"管网业务指标","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-04-11 13:06:25","creatUnit":"137120684996966501528","dataType":"数值","dataUnit":"kg","defaultValue":"","id":"243ecfc3ffa311e5ba535c260a3ed263","indeCode":"fsdf","indeName":"afds","maxValue":"","minValue":"","pid":"281841DD797978DCE050007F010032E5","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 13:49:44","updateUnit":"137120684996966501528"},{"accuracyInter":5,"accuracyPoint":2,"busiType":"污水处理","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-04-25 13:07:57","creatUnit":"137120684996966501528","dataType":"数值","dataUnit":"mg","defaultValue":"","id":"b19ee4c80aa311e6907e5c260a3ed263","indeCode":"fsdf","indeName":"月报指标1","maxValue":"","minValue":"","pid":"281841DD797978DCE050007F010032E5"},{"accuracyInter":2,"accuracyPoint":2,"busiType":"污泥处置","creatManCode":"root","creatManName":"后台管理员","creatTime":"2016-04-11 13:21:38","creatUnit":"137120684996966501528","dataType":"数值","dataUnit":"mg","defaultValue":"","id":"43ff144effa511e5ba535c260a3ed263","indeCode":"asss","indeName":"aaaa","maxValue":"","minValue":"","pid":"281841DD797978DCE050007F010032E5","updateManCode":"root","updateManName":"后台管理员","updateTime":"2016-04-11 13:50:08","updateUnit":"137120684996966501528"}]}
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
         * accuracyInter : 5.0
         * accuracyPoint : 2.0
         * busiType : 管网业务指标
         * creatManCode : root
         * creatManName : 后台管理员
         * creatTime : 2016-04-11 13:06:25
         * creatUnit : 137120684996966501528
         * dataType : 数值
         * dataUnit : kg
         * defaultValue :
         * id : 243ecfc3ffa311e5ba535c260a3ed263
         * indeCode : fsdf
         * indeName : afds
         * maxValue :
         * minValue :
         * pid : 281841DD797978DCE050007F010032E5
         * updateManCode : root
         * updateManName : 后台管理员
         * updateTime : 2016-04-11 13:49:44
         * updateUnit : 137120684996966501528
         */

        private List<MastersEntity> masters;

        public void setMasters(List<MastersEntity> masters) {
            this.masters = masters;
        }

        public List<MastersEntity> getMasters() {
            return masters;
        }

        public static class MastersEntity {
            private double accuracyInter;
            private double accuracyPoint;
            private String busiType;
            private String creatManCode;
            private String creatManName;
            private String creatTime;
            private String creatUnit;
            private String dataType;
            private String dataUnit;
            private String defaultValue;
            private String id;
            private String indeCode;
            private String indeName;
            private String maxValue;
            private String minValue;
            private String pid;
            private String updateManCode;
            private String updateManName;
            private String updateTime;
            private String updateUnit;

            public void setAccuracyInter(double accuracyInter) {
                this.accuracyInter = accuracyInter;
            }

            public void setAccuracyPoint(double accuracyPoint) {
                this.accuracyPoint = accuracyPoint;
            }

            public void setBusiType(String busiType) {
                this.busiType = busiType;
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

            public void setId(String id) {
                this.id = id;
            }

            public void setIndeCode(String indeCode) {
                this.indeCode = indeCode;
            }

            public void setIndeName(String indeName) {
                this.indeName = indeName;
            }

            public void setMaxValue(String maxValue) {
                this.maxValue = maxValue;
            }

            public void setMinValue(String minValue) {
                this.minValue = minValue;
            }

            public void setPid(String pid) {
                this.pid = pid;
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

            public double getAccuracyInter() {
                return accuracyInter;
            }

            public double getAccuracyPoint() {
                return accuracyPoint;
            }

            public String getBusiType() {
                return busiType;
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

            public String getId() {
                return id;
            }

            public String getIndeCode() {
                return indeCode;
            }

            public String getIndeName() {
                return indeName;
            }

            public String getMaxValue() {
                return maxValue;
            }

            public String getMinValue() {
                return minValue;
            }

            public String getPid() {
                return pid;
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

package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/13 0013.
 */
public class WeightUpdateResponse extends RBResponse {
    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"carWeigh":{"id":"CZD111606040036","carNo":"冀BQ6957","grossWeight":66.54,"tareWeightTime":"2016-06-03 11:14:50","grossWeightTime":"2016-06-04 11:13:03","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 03:16:53","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.2,"netWeight":51.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""}}
     */

    private String errorCode;
    private String errorMsg;
    /**
     * carWeigh : {"id":"CZD111606040036","carNo":"冀BQ6957","grossWeight":66.54,"tareWeightTime":"2016-06-03 11:14:50","grossWeightTime":"2016-06-04 11:13:03","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 03:16:53","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.2,"netWeight":51.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""}
     */

    private DataEntity data;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * id : CZD111606040036
         * carNo : 冀BQ6957
         * grossWeight : 66.54
         * tareWeightTime : 2016-06-03 11:14:50
         * grossWeightTime : 2016-06-04 11:13:03
         * wnKind : 脱水泥饼
         * busiUnit : CZD11
         * createTime : 2016-06-04 03:16:53
         * stat : null
         * repeatFlag : null
         * deleteFlag : null
         * heWeight : null
         * dataSource : 1
         * tareWeight : 15.2
         * netWeight : 51.34
         * updateNetWeight :
         * updateUser : null
         * updateTime : null
         * createUser : 赵振凤
         * remark :
         */

        private CarWeighEntity carWeigh;

        public void setCarWeigh(CarWeighEntity carWeigh) {
            this.carWeigh = carWeigh;
        }

        public CarWeighEntity getCarWeigh() {
            return carWeigh;
        }

        public static class CarWeighEntity {
            private String id;
            private String carNo;
            private double grossWeight;
            private String tareWeightTime;
            private String grossWeightTime;
            private String wnKind;
            private String busiUnit;
            private String createTime;
            private Object stat;
            private Object repeatFlag;
            private Object deleteFlag;
            private Object heWeight;
            private String dataSource;
            private double tareWeight;
            private double netWeight;
            private String updateNetWeight;
            private Object updateUser;
            private Object updateTime;
            private String createUser;
            private String remark;

            public void setId(String id) {
                this.id = id;
            }

            public void setCarNo(String carNo) {
                this.carNo = carNo;
            }

            public void setGrossWeight(double grossWeight) {
                this.grossWeight = grossWeight;
            }

            public void setTareWeightTime(String tareWeightTime) {
                this.tareWeightTime = tareWeightTime;
            }

            public void setGrossWeightTime(String grossWeightTime) {
                this.grossWeightTime = grossWeightTime;
            }

            public void setWnKind(String wnKind) {
                this.wnKind = wnKind;
            }

            public void setBusiUnit(String busiUnit) {
                this.busiUnit = busiUnit;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public void setStat(Object stat) {
                this.stat = stat;
            }

            public void setRepeatFlag(Object repeatFlag) {
                this.repeatFlag = repeatFlag;
            }

            public void setDeleteFlag(Object deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public void setHeWeight(Object heWeight) {
                this.heWeight = heWeight;
            }

            public void setDataSource(String dataSource) {
                this.dataSource = dataSource;
            }

            public void setTareWeight(double tareWeight) {
                this.tareWeight = tareWeight;
            }

            public void setNetWeight(double netWeight) {
                this.netWeight = netWeight;
            }

            public void setUpdateNetWeight(String updateNetWeight) {
                this.updateNetWeight = updateNetWeight;
            }

            public void setUpdateUser(Object updateUser) {
                this.updateUser = updateUser;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getId() {
                return id;
            }

            public String getCarNo() {
                return carNo;
            }

            public double getGrossWeight() {
                return grossWeight;
            }

            public String getTareWeightTime() {
                return tareWeightTime;
            }

            public String getGrossWeightTime() {
                return grossWeightTime;
            }

            public String getWnKind() {
                return wnKind;
            }

            public String getBusiUnit() {
                return busiUnit;
            }

            public String getCreateTime() {
                return createTime;
            }

            public Object getStat() {
                return stat;
            }

            public Object getRepeatFlag() {
                return repeatFlag;
            }

            public Object getDeleteFlag() {
                return deleteFlag;
            }

            public Object getHeWeight() {
                return heWeight;
            }

            public String getDataSource() {
                return dataSource;
            }

            public double getTareWeight() {
                return tareWeight;
            }

            public double getNetWeight() {
                return netWeight;
            }

            public String getUpdateNetWeight() {
                return updateNetWeight;
            }

            public Object getUpdateUser() {
                return updateUser;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public String getCreateUser() {
                return createUser;
            }

            public String getRemark() {
                return remark;
            }
        }
    }
}

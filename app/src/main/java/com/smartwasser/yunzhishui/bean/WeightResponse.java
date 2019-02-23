package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/11 0011.
 */
public class WeightResponse extends RBResponse {

    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"TransportTask":{"rows":[{"id":"CZD111607050002","carNo":"冀R72371","grossWeight":11,"tareWeightTime":"2016-07-02 01:07:18","grossWeightTime":"2016-07-06 01:07:22","wnKind":"堆肥产成品","busiUnit":"CZD11","createTime":"2016-07-06 09:07:34","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":11,"netWeight":111,"updateNetWeight":"1","updateUser":null,"updateTime":null,"createUser":"系统管理员","remark":"11"},{"id":"CZD111606040036","carNo":"冀BQ6957","grossWeight":66.54,"tareWeightTime":"2016-06-03 11:14:50","grossWeightTime":"2016-06-04 11:13:03","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 11:16:53","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.2,"netWeight":51.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040035","carNo":"冀HE8172","grossWeight":63.6,"tareWeightTime":"2016-06-03 10:35:37","grossWeightTime":"2016-06-04 10:35:47","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:37:46","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":14.5,"netWeight":48.8,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040034","carNo":"冀BR7075","grossWeight":67.46,"tareWeightTime":"2016-06-03 10:32:22","grossWeightTime":"2016-06-04 10:31:33","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:34:19","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.9,"netWeight":51.56,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040033","carNo":"京AQ3950","grossWeight":74.82,"tareWeightTime":"2016-06-03 10:29:28","grossWeightTime":"2016-06-04 10:28:40","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:31:29","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":22.2,"netWeight":52.62,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040032","carNo":"冀HM5587","grossWeight":69.94,"tareWeightTime":"2016-06-03 10:25:33","grossWeightTime":"2016-06-04 10:25:47","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:27:40","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.6,"netWeight":54.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040031","carNo":"冀HM3020","grossWeight":72.98,"tareWeightTime":"2016-06-03 10:22:31","grossWeightTime":"2016-06-04 10:20:42","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:24:30","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":17.32,"netWeight":55.66,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040030","carNo":"冀HU1519","grossWeight":69.1,"tareWeightTime":"2016-06-04 06:18:43","grossWeightTime":"2016-06-04 10:17:58","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:20:48","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":16.84,"netWeight":52.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040029","carNo":"京AS8561","grossWeight":74.2,"tareWeightTime":"2016-06-04 06:08:11","grossWeightTime":"2016-06-04 10:13:44","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:16:35","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":22.6,"netWeight":51.6,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040028","carNo":"冀R72371","grossWeight":70.76,"tareWeightTime":"2016-06-04 04:05:48","grossWeightTime":"2016-06-04 10:05:18","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:08:13","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":17.52,"netWeight":53.24,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""}],"total":130}}
     */

    private String errorCode;
    private String errorMsg;
    /**
     * TransportTask : {"rows":[{"id":"CZD111607050002","carNo":"冀R72371","grossWeight":11,"tareWeightTime":"2016-07-02 01:07:18","grossWeightTime":"2016-07-06 01:07:22","wnKind":"堆肥产成品","busiUnit":"CZD11","createTime":"2016-07-06 09:07:34","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":11,"netWeight":111,"updateNetWeight":"1","updateUser":null,"updateTime":null,"createUser":"系统管理员","remark":"11"},{"id":"CZD111606040036","carNo":"冀BQ6957","grossWeight":66.54,"tareWeightTime":"2016-06-03 11:14:50","grossWeightTime":"2016-06-04 11:13:03","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 11:16:53","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.2,"netWeight":51.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040035","carNo":"冀HE8172","grossWeight":63.6,"tareWeightTime":"2016-06-03 10:35:37","grossWeightTime":"2016-06-04 10:35:47","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:37:46","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":14.5,"netWeight":48.8,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040034","carNo":"冀BR7075","grossWeight":67.46,"tareWeightTime":"2016-06-03 10:32:22","grossWeightTime":"2016-06-04 10:31:33","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:34:19","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.9,"netWeight":51.56,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040033","carNo":"京AQ3950","grossWeight":74.82,"tareWeightTime":"2016-06-03 10:29:28","grossWeightTime":"2016-06-04 10:28:40","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:31:29","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":22.2,"netWeight":52.62,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040032","carNo":"冀HM5587","grossWeight":69.94,"tareWeightTime":"2016-06-03 10:25:33","grossWeightTime":"2016-06-04 10:25:47","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:27:40","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.6,"netWeight":54.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040031","carNo":"冀HM3020","grossWeight":72.98,"tareWeightTime":"2016-06-03 10:22:31","grossWeightTime":"2016-06-04 10:20:42","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:24:30","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":17.32,"netWeight":55.66,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040030","carNo":"冀HU1519","grossWeight":69.1,"tareWeightTime":"2016-06-04 06:18:43","grossWeightTime":"2016-06-04 10:17:58","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:20:48","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":16.84,"netWeight":52.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040029","carNo":"京AS8561","grossWeight":74.2,"tareWeightTime":"2016-06-04 06:08:11","grossWeightTime":"2016-06-04 10:13:44","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:16:35","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":22.6,"netWeight":51.6,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040028","carNo":"冀R72371","grossWeight":70.76,"tareWeightTime":"2016-06-04 04:05:48","grossWeightTime":"2016-06-04 10:05:18","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:08:13","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":17.52,"netWeight":53.24,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""}],"total":130}
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
         * rows : [{"id":"CZD111607050002","carNo":"冀R72371","grossWeight":11,"tareWeightTime":"2016-07-02 01:07:18","grossWeightTime":"2016-07-06 01:07:22","wnKind":"堆肥产成品","busiUnit":"CZD11","createTime":"2016-07-06 09:07:34","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":11,"netWeight":111,"updateNetWeight":"1","updateUser":null,"updateTime":null,"createUser":"系统管理员","remark":"11"},{"id":"CZD111606040036","carNo":"冀BQ6957","grossWeight":66.54,"tareWeightTime":"2016-06-03 11:14:50","grossWeightTime":"2016-06-04 11:13:03","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 11:16:53","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.2,"netWeight":51.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040035","carNo":"冀HE8172","grossWeight":63.6,"tareWeightTime":"2016-06-03 10:35:37","grossWeightTime":"2016-06-04 10:35:47","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:37:46","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":14.5,"netWeight":48.8,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040034","carNo":"冀BR7075","grossWeight":67.46,"tareWeightTime":"2016-06-03 10:32:22","grossWeightTime":"2016-06-04 10:31:33","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:34:19","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.9,"netWeight":51.56,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040033","carNo":"京AQ3950","grossWeight":74.82,"tareWeightTime":"2016-06-03 10:29:28","grossWeightTime":"2016-06-04 10:28:40","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:31:29","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":22.2,"netWeight":52.62,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040032","carNo":"冀HM5587","grossWeight":69.94,"tareWeightTime":"2016-06-03 10:25:33","grossWeightTime":"2016-06-04 10:25:47","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:27:40","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":15.6,"netWeight":54.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040031","carNo":"冀HM3020","grossWeight":72.98,"tareWeightTime":"2016-06-03 10:22:31","grossWeightTime":"2016-06-04 10:20:42","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:24:30","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":17.32,"netWeight":55.66,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040030","carNo":"冀HU1519","grossWeight":69.1,"tareWeightTime":"2016-06-04 06:18:43","grossWeightTime":"2016-06-04 10:17:58","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:20:48","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":16.84,"netWeight":52.34,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040029","carNo":"京AS8561","grossWeight":74.2,"tareWeightTime":"2016-06-04 06:08:11","grossWeightTime":"2016-06-04 10:13:44","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:16:35","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":22.6,"netWeight":51.6,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""},{"id":"CZD111606040028","carNo":"冀R72371","grossWeight":70.76,"tareWeightTime":"2016-06-04 04:05:48","grossWeightTime":"2016-06-04 10:05:18","wnKind":"脱水泥饼","busiUnit":"CZD11","createTime":"2016-06-04 10:08:13","stat":null,"repeatFlag":null,"deleteFlag":null,"heWeight":null,"dataSource":"1","tareWeight":17.52,"netWeight":53.24,"updateNetWeight":"","updateUser":null,"updateTime":null,"createUser":"赵振凤","remark":""}]
         * total : 130
         */

        private TransportTaskEntity TransportTask;

        public void setTransportTask(TransportTaskEntity TransportTask) {
            this.TransportTask = TransportTask;
        }

        public TransportTaskEntity getTransportTask() {
            return TransportTask;
        }

        public static class TransportTaskEntity {
            private int total;
            /**
             * id : CZD111607050002
             * carNo : 冀R72371
             * grossWeight : 11.0
             * tareWeightTime : 2016-07-02 01:07:18
             * grossWeightTime : 2016-07-06 01:07:22
             * wnKind : 堆肥产成品
             * busiUnit : CZD11
             * createTime : 2016-07-06 09:07:34
             * stat : null
             * repeatFlag : null
             * deleteFlag : null
             * heWeight : null
             * dataSource : 1
             * tareWeight : 11.0
             * netWeight : 111.0
             * updateNetWeight : 1
             * updateUser : null
             * updateTime : null
             * createUser : 系统管理员
             * remark : 11
             */

            private List<RowsEntity> rows;

            public void setTotal(int total) {
                this.total = total;
            }

            public void setRows(List<RowsEntity> rows) {
                this.rows = rows;
            }

            public int getTotal() {
                return total;
            }

            public List<RowsEntity> getRows() {
                return rows;
            }

            public static class RowsEntity {
                private String id;
                private String carNo;
                private double grossWeight;
                private String tareWeightTimeName;
                private String grossWeightTimeName;
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

                public void setTareWeightTimeName(String tareWeightTime) {
                    this.tareWeightTimeName = tareWeightTime;
                }

                public void setGrossWeightTimeName(String grossWeightTime) {
                    this.grossWeightTimeName = grossWeightTime;
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

                public String getTareWeightTimeName() {
                    return tareWeightTimeName;
                }

                public String getGrossWeightTimeName() {
                    return grossWeightTimeName;
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
}

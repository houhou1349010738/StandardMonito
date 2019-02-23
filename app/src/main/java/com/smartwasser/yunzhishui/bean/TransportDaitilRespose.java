package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/14 0014.
 */
public class TransportDaitilRespose extends RBResponse {

    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"taskRevise":null,"task":{"transportTaskId":"402880855516cb1e015517c6e82e002c","carWeighId":"CZD111606040034","vehicleNo":"冀BR7075","tareWeightTime":"2016-06-03 10:32","grossWeightTime":"2016-06-04 10:31","wnKind":"脱水泥饼","busiUnit":"CZD11","carWeightCreateTime":"2016-06-04 02:34","busiUnitName":"通州北堤寺处置场","startHistoryDataId":"dd8b233c29c111e684de0242c0a80003","startPositionLng":116.743365,"startPositionLat":39.722665,"startTime":"2016-06-04 10:31","endHistoryDataId":"77630d1d29d711e684de0242c0a80003","endPositionLng":116.663555,"endPositionLat":39.3288,"palingInfoId":"402880845510a101015511cd88190001","mudId":"8a92e481533fb5d701537d51e32900b6","mudName":"永清县别古庄镇刘庄村（朱官屯西）","distance":64276.022349536375,"endTime":"2016-06-04 13:06","createTime":"2016-06-04 02:39","status":1,"statusName":"完成","runTime":null,"stat":null,"repeatFlag":null,"setTransportDistance":null,"reviseDistance":null,"count":0}}
     */
    private String errorCode;
    private String errorMsg;
    /**
     * taskRevise : null
     * task : {"transportTaskId":"402880855516cb1e015517c6e82e002c","carWeighId":"CZD111606040034","vehicleNo":"冀BR7075","tareWeightTime":"2016-06-03 10:32","grossWeightTime":"2016-06-04 10:31","wnKind":"脱水泥饼","busiUnit":"CZD11","carWeightCreateTime":"2016-06-04 02:34","busiUnitName":"通州北堤寺处置场","startHistoryDataId":"dd8b233c29c111e684de0242c0a80003","startPositionLng":116.743365,"startPositionLat":39.722665,"startTime":"2016-06-04 10:31","endHistoryDataId":"77630d1d29d711e684de0242c0a80003","endPositionLng":116.663555,"endPositionLat":39.3288,"palingInfoId":"402880845510a101015511cd88190001","mudId":"8a92e481533fb5d701537d51e32900b6","mudName":"永清县别古庄镇刘庄村（朱官屯西）","distance":64276.022349536375,"endTime":"2016-06-04 13:06","createTime":"2016-06-04 02:39","status":1,"statusName":"完成","runTime":null,"stat":null,"repeatFlag":null,"setTransportDistance":null,"reviseDistance":null,"count":0}
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
        private Object taskRevise;
        /**
         * transportTaskId : 402880855516cb1e015517c6e82e002c
         * carWeighId : CZD111606040034
         * vehicleNo : 冀BR7075
         * tareWeightTime : 2016-06-03 10:32
         * grossWeightTime : 2016-06-04 10:31
         * wnKind : 脱水泥饼
         * busiUnit : CZD11
         * carWeightCreateTime : 2016-06-04 02:34
         * busiUnitName : 通州北堤寺处置场
         * startHistoryDataId : dd8b233c29c111e684de0242c0a80003
         * startPositionLng : 116.743365
         * startPositionLat : 39.722665
         * startTime : 2016-06-04 10:31
         * endHistoryDataId : 77630d1d29d711e684de0242c0a80003
         * endPositionLng : 116.663555
         * endPositionLat : 39.3288
         * palingInfoId : 402880845510a101015511cd88190001
         * mudId : 8a92e481533fb5d701537d51e32900b6
         * mudName : 永清县别古庄镇刘庄村（朱官屯西）
         * distance : 64276.022349536375
         * endTime : 2016-06-04 13:06
         * createTime : 2016-06-04 02:39
         * status : 1
         * statusName : 完成
         * runTime : null
         * stat : null
         * repeatFlag : null
         * setTransportDistance : null
         * reviseDistance : null
         * count : 0
         */

        private TaskEntity task;

        public void setTaskRevise(Object taskRevise) {
            this.taskRevise = taskRevise;
        }

        public void setTask(TaskEntity task) {
            this.task = task;
        }

        public Object getTaskRevise() {
            return taskRevise;
        }

        public TaskEntity getTask() {
            return task;
        }

        public static class TaskEntity {
            private String transportTaskId;
            private String carWeighId;
            private String vehicleNo;
            private String tareWeightTime;
            private String grossWeightTime;
            private String wnKind;
            private String busiUnit;
            private String carWeightCreateTime;
            private String busiUnitName;
            private String startHistoryDataId;
            private double startPositionLng;
            private double startPositionLat;
            private String startTime;
            private String endHistoryDataId;
            private double endPositionLng;
            private double endPositionLat;
            private String palingInfoId;
            private String mudId;
            private String mudName;
            private double distance;
            private String endTime;
            private String createTime;
            private int status;
            private String statusName;
            private Object runTime;
            private Object stat;
            private Object repeatFlag;
            private Object setTransportDistance;
            private Object reviseDistance;
            private int count;

            public void setTransportTaskId(String transportTaskId) {
                this.transportTaskId = transportTaskId;
            }

            public void setCarWeighId(String carWeighId) {
                this.carWeighId = carWeighId;
            }

            public void setVehicleNo(String vehicleNo) {
                this.vehicleNo = vehicleNo;
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

            public void setCarWeightCreateTime(String carWeightCreateTime) {
                this.carWeightCreateTime = carWeightCreateTime;
            }

            public void setBusiUnitName(String busiUnitName) {
                this.busiUnitName = busiUnitName;
            }

            public void setStartHistoryDataId(String startHistoryDataId) {
                this.startHistoryDataId = startHistoryDataId;
            }

            public void setStartPositionLng(double startPositionLng) {
                this.startPositionLng = startPositionLng;
            }

            public void setStartPositionLat(double startPositionLat) {
                this.startPositionLat = startPositionLat;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public void setEndHistoryDataId(String endHistoryDataId) {
                this.endHistoryDataId = endHistoryDataId;
            }

            public void setEndPositionLng(double endPositionLng) {
                this.endPositionLng = endPositionLng;
            }

            public void setEndPositionLat(double endPositionLat) {
                this.endPositionLat = endPositionLat;
            }

            public void setPalingInfoId(String palingInfoId) {
                this.palingInfoId = palingInfoId;
            }

            public void setMudId(String mudId) {
                this.mudId = mudId;
            }

            public void setMudName(String mudName) {
                this.mudName = mudName;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            public void setRunTime(Object runTime) {
                this.runTime = runTime;
            }

            public void setStat(Object stat) {
                this.stat = stat;
            }

            public void setRepeatFlag(Object repeatFlag) {
                this.repeatFlag = repeatFlag;
            }

            public void setSetTransportDistance(Object setTransportDistance) {
                this.setTransportDistance = setTransportDistance;
            }

            public void setReviseDistance(Object reviseDistance) {
                this.reviseDistance = reviseDistance;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getTransportTaskId() {
                return transportTaskId;
            }

            public String getCarWeighId() {
                return carWeighId;
            }

            public String getVehicleNo() {
                return vehicleNo;
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

            public String getCarWeightCreateTime() {
                return carWeightCreateTime;
            }

            public String getBusiUnitName() {
                return busiUnitName;
            }

            public String getStartHistoryDataId() {
                return startHistoryDataId;
            }

            public double getStartPositionLng() {
                return startPositionLng;
            }

            public double getStartPositionLat() {
                return startPositionLat;
            }

            public String getStartTime() {
                return startTime;
            }

            public String getEndHistoryDataId() {
                return endHistoryDataId;
            }

            public double getEndPositionLng() {
                return endPositionLng;
            }

            public double getEndPositionLat() {
                return endPositionLat;
            }

            public String getPalingInfoId() {
                return palingInfoId;
            }

            public String getMudId() {
                return mudId;
            }

            public String getMudName() {
                return mudName;
            }

            public double getDistance() {
                return distance;
            }

            public String getEndTime() {
                return endTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public int getStatus() {
                return status;
            }

            public String getStatusName() {
                return statusName;
            }

            public Object getRunTime() {
                return runTime;
            }

            public Object getStat() {
                return stat;
            }

            public Object getRepeatFlag() {
                return repeatFlag;
            }

            public Object getSetTransportDistance() {
                return setTransportDistance;
            }

            public Object getReviseDistance() {
                return reviseDistance;
            }

            public int getCount() {
                return count;
            }
        }
    }
}

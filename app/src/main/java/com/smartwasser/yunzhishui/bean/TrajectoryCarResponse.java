package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/17 0017.
 */
public class TrajectoryCarResponse extends RBResponse {
    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"冀R72371":[{"historyDataId":"1e64ed3c2a0811e684de0242c0a80003","gpsId":"EN656577","vehicleNo":"冀R72371","speed":0,"lng":116.453235,"lat":39.642936666,"direction":72,"recordTime":1465066492000,"rtPio":null,"createTime":1465037703000,"gpsTime":1465066492000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":3,"qdCmd":0,"locFlag":"A","dataFlag":"W"},{"historyDataId":"3f4e50c62a0811e684de0242c0a80003","gpsId":"EN656577","vehicleNo":"冀R72371","speed":0,"lng":116.453235,"lat":39.642936666,"direction":72,"recordTime":1465066552000,"rtPio":null,"createTime":1465037759000,"gpsTime":1465066552000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":21,"qdCmd":0,"locFlag":"A","dataFlag":"W"}]}
     */

    private String errorCode;
    private String errorMsg;
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
         * historyDataId : 1e64ed3c2a0811e684de0242c0a80003
         * gpsId : EN656577
         * vehicleNo : 冀R72371
         * speed : 0
         * lng : 116.453235
         * lat : 39.642936666
         * direction : 72
         * recordTime : 1465066492000
         * rtPio : null
         * createTime : 1465037703000
         * gpsTime : 1465066492000
         * oilInfo : 0
         * startState : 0
         * powerSource : 0
         * gpsState : 0
         * gprsSignal : 3
         * qdCmd : 0
         * locFlag : A
         * dataFlag : W
         */

        private List<Entity> HistoryData;

        public void setHistoryData(List<Entity> name) {
            this.HistoryData =name;
        }

        public List<Entity> getHistoryData() {
            return HistoryData;
        }

        public static class Entity {
            private String historyDataId;
            private String gpsId;
            private String vehicleNo;
            private int speed;
            private double lng;
            private double lat;
            private int direction;
            private long recordTime;
            private Object rtPio;
            private long createTime;
            private long gpsTime;
            private int oilInfo;
            private int startState;
            private int powerSource;
            private int gpsState;
            private int gprsSignal;
            private int qdCmd;
            private String locFlag;
            private String dataFlag;

            public void setHistoryDataId(String historyDataId) {
                this.historyDataId = historyDataId;
            }

            public void setGpsId(String gpsId) {
                this.gpsId = gpsId;
            }

            public void setVehicleNo(String vehicleNo) {
                this.vehicleNo = vehicleNo;
            }

            public void setSpeed(int speed) {
                this.speed = speed;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public void setDirection(int direction) {
                this.direction = direction;
            }

            public void setRecordTime(long recordTime) {
                this.recordTime = recordTime;
            }

            public void setRtPio(Object rtPio) {
                this.rtPio = rtPio;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public void setGpsTime(long gpsTime) {
                this.gpsTime = gpsTime;
            }

            public void setOilInfo(int oilInfo) {
                this.oilInfo = oilInfo;
            }

            public void setStartState(int startState) {
                this.startState = startState;
            }

            public void setPowerSource(int powerSource) {
                this.powerSource = powerSource;
            }

            public void setGpsState(int gpsState) {
                this.gpsState = gpsState;
            }

            public void setGprsSignal(int gprsSignal) {
                this.gprsSignal = gprsSignal;
            }

            public void setQdCmd(int qdCmd) {
                this.qdCmd = qdCmd;
            }

            public void setLocFlag(String locFlag) {
                this.locFlag = locFlag;
            }

            public void setDataFlag(String dataFlag) {
                this.dataFlag = dataFlag;
            }

            public String getHistoryDataId() {
                return historyDataId;
            }

            public String getGpsId() {
                return gpsId;
            }

            public String getVehicleNo() {
                return vehicleNo;
            }

            public int getSpeed() {
                return speed;
            }

            public double getLng() {
                return lng;
            }

            public double getLat() {
                return lat;
            }

            public int getDirection() {
                return direction;
            }

            public long getRecordTime() {
                return recordTime;
            }

            public Object getRtPio() {
                return rtPio;
            }

            public long getCreateTime() {
                return createTime;
            }

            public long getGpsTime() {
                return gpsTime;
            }

            public int getOilInfo() {
                return oilInfo;
            }

            public int getStartState() {
                return startState;
            }

            public int getPowerSource() {
                return powerSource;
            }

            public int getGpsState() {
                return gpsState;
            }

            public int getGprsSignal() {
                return gprsSignal;
            }

            public int getQdCmd() {
                return qdCmd;
            }

            public String getLocFlag() {
                return locFlag;
            }

            public String getDataFlag() {
                return dataFlag;
            }
        }
    }
}
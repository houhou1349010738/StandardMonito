package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/18 0018.
 */
public class CarJanKanResponse extends RBResponse{
    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"realTimeData":{"realTimeDataId":"AA33F05239EA4F6FB99D3E6CAAF41CF7","gpsId":"CN653613","vehicleNo":"京AAL600","speed":0,"lng":116.6003,"lat":39.9859,"direction":288,"recordTime":"2016-11-12 12:01:11","rtPio":"8a92e48152a143140152a4aa0e200027","gpsTime":1478923271000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":0,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false}}
     */
    private String errorCode;
    private String errorMsg;
    /**
     * realTimeData : {"realTimeDataId":"AA33F05239EA4F6FB99D3E6CAAF41CF7","gpsId":"CN653613","vehicleNo":"京AAL600","speed":0,"lng":116.6003,"lat":39.9859,"direction":288,"recordTime":"2016-11-12 12:01:11","rtPio":"8a92e48152a143140152a4aa0e200027","gpsTime":1478923271000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":0,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false}
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
         * realTimeDataId : AA33F05239EA4F6FB99D3E6CAAF41CF7
         * gpsId : CN653613
         * vehicleNo : 京AAL600
         * speed : 0
         * lng : 116.6003
         * lat : 39.9859
         * direction : 288
         * recordTime : 2016-11-12 12:01:11
         * rtPio : 8a92e48152a143140152a4aa0e200027
         * gpsTime : 1478923271000
         * oilInfo : 0
         * startState : 0
         * powerSource : 0
         * gpsState : 0
         * gprsSignal : 0
         * qdCmd : 0
         * locFlag : A
         * dataFlag : C
         * waiting : false
         */

        private RealTimeDataEntity realTimeData;

        public void setRealTimeData(RealTimeDataEntity realTimeData) {
            this.realTimeData = realTimeData;
        }

        public RealTimeDataEntity getRealTimeData() {
            return realTimeData;
        }

        public static class RealTimeDataEntity {
            private String realTimeDataId;
            private String gpsId;
            private String vehicleNo;
            private int speed;
            private double lng;
            private double lat;
            private int direction;
            private String recordTime;
            private String rtPio;
            private long gpsTime;
            private int oilInfo;
            private int startState;
            private int powerSource;
            private int gpsState;
            private int gprsSignal;
            private int qdCmd;
            private String locFlag;
            private String dataFlag;
            private boolean waiting;

            public void setRealTimeDataId(String realTimeDataId) {
                this.realTimeDataId = realTimeDataId;
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

            public void setRecordTime(String recordTime) {
                this.recordTime = recordTime;
            }

            public void setRtPio(String rtPio) {
                this.rtPio = rtPio;
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

            public void setWaiting(boolean waiting) {
                this.waiting = waiting;
            }

            public String getRealTimeDataId() {
                return realTimeDataId;
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

            public String getRecordTime() {
                return recordTime;
            }

            public String getRtPio() {
                return rtPio;
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

            public boolean isWaiting() {
                return waiting;
            }
        }
    }
}

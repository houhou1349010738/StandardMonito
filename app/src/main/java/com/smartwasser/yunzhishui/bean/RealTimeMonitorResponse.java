package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/15 0015.
 */
public class RealTimeMonitorResponse extends RBResponse{
    /**
     * errorCode : 00000
     * errorMsg : success
     * data : {"realTimeData":[{"realTimeDataId":"82AD6B4C4C7F4667982BF6E78ECA06C3","gpsId":"EN655977","vehicleNo":"京AAB505","speed":0,"lng":116,"lat":40,"direction":203,"recordTime":"2042-02-02 09:23:16","rtPio":null,"gpsTime":2274916996000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":26,"qdCmd":0,"locFlag":"A","dataFlag":"U","waiting":false},{"realTimeDataId":"B7ED63F9998A4792964C5B54DBC9A239","gpsId":"EP657048","vehicleNo":"京AC3154","speed":0,"lng":117,"lat":40,"direction":289,"recordTime":"2017-01-02 12:15:18","rtPio":null,"gpsTime":1483330518000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":24,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"88943A19150A467888AE9DC6471EDF0A","gpsId":"EN656205","vehicleNo":"京AQ1156","speed":0,"lng":117,"lat":40,"direction":79,"recordTime":"2057-07-02 05:57:46","rtPio":"8a92e48152a143140152a4aa0e200027","gpsTime":2761250266000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":17,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"7AD68D022DC94AF0B2A1E97BD4E520AC","gpsId":"EP656512","vehicleNo":"京AQ6131","speed":0,"lng":1116,"lat":2840,"direction":0,"recordTime":"2017-01-01 16:48:11","rtPio":null,"gpsTime":1483260491000,"oilInfo":24,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":31,"qdCmd":0,"locFlag":"B","dataFlag":"X","waiting":false},{"realTimeDataId":"D1BE044A0E274D688989B2012FDE8A08","gpsId":"EN656630","vehicleNo":"京AQ6137","speed":54,"lng":116,"lat":40,"direction":177,"recordTime":"2057-02-02 08:12:17","rtPio":null,"gpsTime":2748298337000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":24,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"C32ED13942894E44AEF3C513877D40CE","gpsId":"EP657012","vehicleNo":"京AQ6163","speed":0,"lng":116,"lat":40,"direction":97,"recordTime":"2017-01-02 12:15:48","rtPio":null,"gpsTime":1483330548000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":0,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"C97349A382D64BD0A63786EB7B40E991","gpsId":"EN656638","vehicleNo":"京AQ9287","speed":0,"lng":1,"lat":0,"direction":0,"recordTime":"2036-01-16 02:08:44","rtPio":null,"gpsTime":2084033324000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":1,"gprsSignal":29,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"3926D3E55F744B90A678A4C908D0813D","gpsId":"EN656639","vehicleNo":"京AR1327","speed":67,"lng":117,"lat":40,"direction":46,"recordTime":"2021-02-07 01:03:42","rtPio":null,"gpsTime":1612631022000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":1,"gprsSignal":22,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"D0241B66467E400BA58777E1DDA9B072","gpsId":"CN653609","vehicleNo":"京AR2761","speed":0,"lng":117,"lat":40,"direction":223,"recordTime":"2016-11-22 08:25:59","rtPio":null,"gpsTime":1479774359000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":23,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"38C9CC2CDD0F4777A08E92B1ED23AA0C","gpsId":"CN651425","vehicleNo":"京AR2766","speed":0,"lng":116,"lat":40,"direction":255,"recordTime":"2036-02-02 14:13:39","rtPio":null,"gpsTime":2085545619000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":20,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"AA33F05239EA4F6FB99D3E6CAAF41CF7","gpsId":"CN653613","vehicleNo":"京AR2768","speed":0,"lng":117,"lat":40,"direction":288,"recordTime":"2016-11-12 12:01:11","rtPio":null,"gpsTime":1478923271000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":0,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"B5DC13FB1D524E029247D6EB9A5233C6","gpsId":"CN651435","vehicleNo":"京AR2769","speed":0,"lng":0,"lat":0,"direction":119,"recordTime":"2038-02-11 20:00:27","rtPio":null,"gpsTime":2149502427000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":19,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"630F3ED87B7E49EF9187D39AD0CEFC82","gpsId":"EN656641","vehicleNo":"京AR6535","speed":70,"lng":116,"lat":40,"direction":95,"recordTime":"2027-01-07 14:05:22","rtPio":null,"gpsTime":1799301922000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":1,"gprsSignal":16,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"B957AA8F77A5481392240665FA818254","gpsId":"CN651429","vehicleNo":"京AS1705","speed":52,"lng":117,"lat":40,"direction":181,"recordTime":"2016-11-12 07:01:01","rtPio":null,"gpsTime":1478905261000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":0,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"EB1E1545E5124EF0AD658AB516A2047C","gpsId":"CN651418","vehicleNo":"京AS2011","speed":63,"lng":116,"lat":40,"direction":248,"recordTime":"2055-04-10 10:49:50","rtPio":null,"gpsTime":2690938190000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":27,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"88DED42FC18445338ED0D4631D46A725","gpsId":"EP656480","vehicleNo":"京AS8867","speed":59,"lng":116,"lat":40,"direction":193,"recordTime":"2035-02-02 07:40:48","rtPio":null,"gpsTime":2053986048000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":14,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"84D3A4FB88BC40A7A09EB3044CD5730A","gpsId":"EP657051","vehicleNo":"京AS8921","speed":0,"lng":116,"lat":40,"direction":160,"recordTime":"2057-01-09 11:09:45","rtPio":null,"gpsTime":2746235385000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":28,"qdCmd":0,"locFlag":"A","dataFlag":"U","waiting":false},{"realTimeDataId":"6EC1EE974EBB4E57B472EBB429C42443","gpsId":"EN656642","vehicleNo":"京AT1575","speed":0,"lng":116,"lat":40,"direction":0,"recordTime":"2017-01-02 12:15:40","rtPio":null,"gpsTime":1483330540000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":26,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"41B2F73CA8314DF0A7983233306B869B","gpsId":"CN653636","vehicleNo":"京AX3792","speed":10,"lng":116,"lat":40,"direction":169,"recordTime":"2050-01-13 13:55:09","rtPio":null,"gpsTime":2525666109000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":20,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"E718E586E8924C63B6611CB9555DB450","gpsId":"EP657043","vehicleNo":"京G27257","speed":0,"lng":116,"lat":40,"direction":333,"recordTime":"2035-02-02 07:40:59","rtPio":null,"gpsTime":2053986059000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":20,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"F1E0BDEF2AF2468FA21240CD2E6EEA98","gpsId":"EN656204","vehicleNo":"京G44088","speed":0,"lng":116,"lat":40,"direction":181,"recordTime":"2035-04-04 15:00:22","rtPio":null,"gpsTime":2059282822000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":1,"gprsSignal":31,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"DD933F31C0B34F5A9DE0711B5577F16F","gpsId":"EN656640","vehicleNo":"京G47727","speed":0,"lng":117,"lat":40,"direction":117,"recordTime":"2057-02-02 11:00:32","rtPio":null,"gpsTime":2748308432000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":23,"qdCmd":0,"locFlag":"A","dataFlag":"U","waiting":false},{"realTimeDataId":"AB8982FBF4674FD9BAEE4335E4A9B81E","gpsId":"EP657029","vehicleNo":"京G47732","speed":0,"lng":116,"lat":40,"direction":283,"recordTime":"2047-01-15 14:27:40","rtPio":null,"gpsTime":2431146460000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":16,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"A8EB9EEF1102418E8AF864E14A19F520","gpsId":"EN656221","vehicleNo":"京G50585","speed":0,"lng":0,"lat":0,"direction":0,"recordTime":"2044-01-24 23:31:13","rtPio":null,"gpsTime":2337262273000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":30,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"285857FC0DEF408390F80353510B71A9","gpsId":"EN656637","vehicleNo":"京G50722","speed":0,"lng":116,"lat":40,"direction":0,"recordTime":"2035-02-02 07:00:46","rtPio":null,"gpsTime":2053983646000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":21,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"9A337BB28E82435CA6DC3EA9F7B69176","gpsId":"EN656638","vehicleNo":"京G71590","speed":0,"lng":116,"lat":40,"direction":0,"recordTime":"2057-02-01 22:21:53","rtPio":null,"gpsTime":2748262913000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":18,"qdCmd":0,"locFlag":"A","dataFlag":"U","waiting":false},{"realTimeDataId":"9869CB151A404AAC9EBE01AC348C6B2C","gpsId":"EP656533","vehicleNo":"京G86991","speed":0,"lng":116,"lat":40,"direction":32,"recordTime":"2035-02-02 07:40:49","rtPio":null,"gpsTime":2053986049000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":26,"qdCmd":0,"locFlag":"A","dataFlag":"C","waiting":false},{"realTimeDataId":"0D11FECC86AB4F6C9E1A2E988C4F04FD","gpsId":"EP657041","vehicleNo":"冀FF2091","speed":0,"lng":117,"lat":40,"direction":268,"recordTime":"2035-02-02 07:40:51","rtPio":null,"gpsTime":2053986051000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":22,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false},{"realTimeDataId":"451F67E3F25449B28CB22079DF88F1BC","gpsId":"EN656228","vehicleNo":"冀FG7672","speed":26,"lng":116,"lat":40,"direction":178,"recordTime":"2029-01-24 13:22:03","rtPio":null,"gpsTime":1863926523000,"oilInfo":0,"startState":0,"powerSource":0,"gpsState":0,"gprsSignal":31,"qdCmd":0,"locFlag":"A","dataFlag":"W","waiting":false}]}
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
         * realTimeDataId : 82AD6B4C4C7F4667982BF6E78ECA06C3
         * gpsId : EN655977
         * vehicleNo : 京AAB505
         * speed : 0
         * lng : 116.0
         * lat : 40.0
         * direction : 203
         * recordTime : 2042-02-02 09:23:16
         * rtPio : null
         * gpsTime : 2274916996000
         * oilInfo : 0
         * startState : 0
         * powerSource : 0
         * gpsState : 0
         * gprsSignal : 26
         * qdCmd : 0
         * locFlag : A
         * dataFlag : U
         * waiting : false
         */

        private List<RealTimeDataEntity> realTimeData;

        public void setRealTimeData(List<RealTimeDataEntity> realTimeData) {
            this.realTimeData = realTimeData;
        }

        public List<RealTimeDataEntity> getRealTimeData() {
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

package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class RainTopResponse extends RBResponse{

    /**
     * avgRain : {"inde_value":85.761}
     * rainIList : [{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"辛店","ri":"6.60","unit_code":"Y39"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"太平街南延","ri":"6.00","unit_code":"Y70"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"马家堡","ri":"0.00","unit_code":"Y14"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"四惠","ri":"0.00","unit_code":"Y36"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"大钟寺","ri":"0.00","unit_code":"Y46"}]
     * rainList : [{"INDE_VALUE":"9","UNIT_CODE":"Y49","UNIT_NAME":"京包"},{"INDE_VALUE":"8","UNIT_CODE":"Y53","UNIT_NAME":"西二旗"},{"INDE_VALUE":"8","UNIT_CODE":"Y45","UNIT_NAME":"北二街"},{"INDE_VALUE":"7","UNIT_CODE":"Y42","UNIT_NAME":"左安东路"},{"INDE_VALUE":"7","UNIT_CODE":"Y50","UNIT_NAME":"上地南"}]
     */

    private DataEntity data;
    /**
     * data : {"avgRain":{"inde_value":85.761},"rainIList":[{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"辛店","ri":"6.60","unit_code":"Y39"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"太平街南延","ri":"6.00","unit_code":"Y70"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"马家堡","ri":"0.00","unit_code":"Y14"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"四惠","ri":"0.00","unit_code":"Y36"},{"MAX(t":{"data_time)":"2016-07-22 17:21:26"},"UNIT_NAME":"大钟寺","ri":"0.00","unit_code":"Y46"}],"rainList":[{"INDE_VALUE":"9","UNIT_CODE":"Y49","UNIT_NAME":"京包"},{"INDE_VALUE":"8","UNIT_CODE":"Y53","UNIT_NAME":"西二旗"},{"INDE_VALUE":"8","UNIT_CODE":"Y45","UNIT_NAME":"北二街"},{"INDE_VALUE":"7","UNIT_CODE":"Y42","UNIT_NAME":"左安东路"},{"INDE_VALUE":"7","UNIT_CODE":"Y50","UNIT_NAME":"上地南"}]}
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
         * inde_value : 85.761
         */

        private AvgRainEntity avgRain;
        /**
         * MAX(t : {"data_time)":"2016-07-22 17:21:26"}
         * UNIT_NAME : 辛店
         * ri : 6.60
         * unit_code : Y39
         */

        private List<RainIListEntity> rainIList;
        /**
         * INDE_VALUE : 9
         * UNIT_CODE : Y49
         * UNIT_NAME : 京包
         */

        private List<RainListEntity> rainList;

        public void setAvgRain(AvgRainEntity avgRain) {
            this.avgRain = avgRain;
        }

        public void setRainIList(List<RainIListEntity> rainIList) {
            this.rainIList = rainIList;
        }

        public void setRainList(List<RainListEntity> rainList) {
            this.rainList = rainList;
        }

        public AvgRainEntity getAvgRain() {
            return avgRain;
        }

        public List<RainIListEntity> getRainIList() {
            return rainIList;
        }

        public List<RainListEntity> getRainList() {
            return rainList;
        }

        public static class AvgRainEntity {
            private double inde_value;

            public void setInde_value(double inde_value) {
                this.inde_value = inde_value;
            }

            public double getInde_value() {
                return inde_value;
            }
        }

        public static class RainIListEntity {
            private String UNIT_NAME;
            private String ri;
            private String unit_code;

            public void setUNIT_NAME(String UNIT_NAME) {
                this.UNIT_NAME = UNIT_NAME;
            }

            public void setRi(String ri) {
                this.ri = ri;
            }

            public void setUnit_code(String unit_code) {
                this.unit_code = unit_code;
            }

            public String getUNIT_NAME() {
                return UNIT_NAME;
            }

            public String getRi() {
                return ri;
            }

            public String getUnit_code() {
                return unit_code;
            }
        }

        public static class RainListEntity {
            private String INDE_VALUE;
            private String UNIT_CODE;
            private String UNIT_NAME;

            public void setINDE_VALUE(String INDE_VALUE) {
                this.INDE_VALUE = INDE_VALUE;
            }

            public void setUNIT_CODE(String UNIT_CODE) {
                this.UNIT_CODE = UNIT_CODE;
            }

            public void setUNIT_NAME(String UNIT_NAME) {
                this.UNIT_NAME = UNIT_NAME;
            }

            public String getINDE_VALUE() {
                return INDE_VALUE;
            }

            public String getUNIT_CODE() {
                return UNIT_CODE;
            }

            public String getUNIT_NAME() {
                return UNIT_NAME;
            }
        }
    }
}

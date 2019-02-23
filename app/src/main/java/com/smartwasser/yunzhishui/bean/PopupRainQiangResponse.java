package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/9/6 0006.
 */
public class PopupRainQiangResponse extends RBResponse{

    private DataEntity data;
    /**
     * data : {"PumpRaininessTopInfo":[{"dataTime":"2016-07-15 16:29:00","id":"8a82e94a55e48a5d0155ee0171380a8f","isFinishRepair":"1","isFinishRi":"1","isOriginal":"0","ri10":"0.01","ri15":"0.013","ri20":"0.015","ri30":"0.017","ri5":"0.0","unitCode":"Y80","value":"0.8"}]}
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
         * dataTime : 2016-07-15 16:29:00
         * id : 8a82e94a55e48a5d0155ee0171380a8f
         * isFinishRepair : 1
         * isFinishRi : 1
         * isOriginal : 0
         * ri10 : 0.01
         * ri15 : 0.013
         * ri20 : 0.015
         * ri30 : 0.017
         * ri5 : 0.0
         * unitCode : Y80
         * value : 0.8
         */

        private List<PumpRaininessTopInfoEntity> PumpRaininessTopInfo;

        public void setPumpRaininessTopInfo(List<PumpRaininessTopInfoEntity> PumpRaininessTopInfo) {
            this.PumpRaininessTopInfo = PumpRaininessTopInfo;
        }

        public List<PumpRaininessTopInfoEntity> getPumpRaininessTopInfo() {
            return PumpRaininessTopInfo;
        }

        public static class PumpRaininessTopInfoEntity {
            private String dataTime;
            private String id;
            private String isFinishRepair;
            private String isFinishRi;
            private String isOriginal;
            private String ri10;
            private String ri15;
            private String ri20;
            private String ri30;
            private String ri5;
            private String unitCode;
            private double value;

            public void setDataTime(String dataTime) {
                this.dataTime = dataTime;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIsFinishRepair(String isFinishRepair) {
                this.isFinishRepair = isFinishRepair;
            }

            public void setIsFinishRi(String isFinishRi) {
                this.isFinishRi = isFinishRi;
            }

            public void setIsOriginal(String isOriginal) {
                this.isOriginal = isOriginal;
            }

            public void setRi10(String ri10) {
                this.ri10 = ri10;
            }

            public void setRi15(String ri15) {
                this.ri15 = ri15;
            }

            public void setRi20(String ri20) {
                this.ri20 = ri20;
            }

            public void setRi30(String ri30) {
                this.ri30 = ri30;
            }

            public void setRi5(String ri5) {
                this.ri5 = ri5;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public String getDataTime() {
                return dataTime;
            }

            public String getId() {
                return id;
            }

            public String getIsFinishRepair() {
                return isFinishRepair;
            }

            public String getIsFinishRi() {
                return isFinishRi;
            }

            public String getIsOriginal() {
                return isOriginal;
            }

            public String getRi10() {
                return ri10;
            }

            public String getRi15() {
                return ri15;
            }

            public String getRi20() {
                return ri20;
            }

            public String getRi30() {
                return ri30;
            }

            public String getRi5() {
                return ri5;
            }

            public String getUnitCode() {
                return unitCode;
            }

            public double getValue() {
                return value;
            }
        }
    }
}

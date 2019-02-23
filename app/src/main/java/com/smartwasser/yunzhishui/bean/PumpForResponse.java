package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class PumpForResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"ylMap":[{"points":"116.41043735421:39.877863548215","status":"g","txcElevation":"27.6","txcHighest":"33.7","txcValue":"0","unitCode":"Y89","unitName":"永定门"},{"points":"116.44574996421:39.899563479015","status":"g","txcElevation":"25","txcHighest":"31","txcValue":"56","unitCode":"Y90","unitName":"夕照寺"},{"points":"116.58433138721:39.906560745715","status":"g","txcElevation":"17.2","txcHighest":"22.4","txcValue":"34","unitCode":"Y92","unitName":"双桥"}]}
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
         * points : 116.41043735421:39.877863548215
         * status : g
         * txcElevation : 27.6
         * txcHighest : 33.7
         * txcValue : 0
         * unitCode : Y89
         * unitName : 永定门
         */

        private List<YlMapEntity> ylMap;

        public void setYlMap(List<YlMapEntity> ylMap) {
            this.ylMap = ylMap;
        }

        public List<YlMapEntity> getYlMap() {
            return ylMap;
        }

        public static class YlMapEntity {
            private String points;
            private String status;
            private double txcElevation;
            private double txcHighest;
            private double txcValue;
            private String unitCode;
            private String unitName;

            public void setPoints(String points) {
                this.points = points;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setTxcElevation(double txcElevation) {
                this.txcElevation = txcElevation;
            }

            public void setTxcHighest(double txcHighest) {
                this.txcHighest = txcHighest;
            }

            public void setTxcValue(double txcValue) {
                this.txcValue = txcValue;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public String getPoints() {
                return points;
            }

            public String getStatus() {
                return status;
            }

            public double getTxcElevation() {
                return txcElevation;
            }

            public double getTxcHighest() {
                return txcHighest;
            }

            public Double getTxcValue() {
                return txcValue;
            }

            public String getUnitCode() {
                return unitCode;
            }

            public String getUnitName() {
                return unitName;
            }
        }
    }
}

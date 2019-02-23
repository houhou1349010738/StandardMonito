package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/22 0022.
 */
public class PumpForCqResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"ylMap":[{"cqcElevation":"38.2","cqcHighest":"40.35","cqcValue":"4","points":"116.35229178921:39.974517078415","status":"w","unitCode":"Y46","unitName":"大钟寺"},{"cqcElevation":"25.98","cqcHighest":"30.1","cqcValue":"0.000424","points":"116.40788741121:39.860783399215","status":"w","unitCode":"Y66","unitName":"木樨园"},{"cqcElevation":"33","cqcHighest":"36.2","cqcValue":"68","points":"116.32535821621:39.864351919515","status":"w","unitCode":"Y74","unitName":"西南三环"},{"cqcElevation":"81.8","cqcHighest":"86.6","cqcValue":"0","points":"116.13824143921:39.943520876115","status":"w","unitCode":"Y84","unitName":"麻裕"},{"cqcElevation":"17.2","cqcHighest":"20.5","cqcValue":"0.000424","points":"116.58433138721:39.906560745715","status":"w","unitCode":"Y92","unitName":"双桥"},{"cqcElevation":"15.9","cqcHighest":"19.2","cqcValue":"0","points":"116.61458527821:39.903996388615","status":"w","unitCode":"Y86","unitName":"中古"},{"cqcElevation":"30.35","cqcHighest":"33.4","cqcValue":"0.000424","points":"116.35398254021:39.860785369015","status":"w","unitCode":"Y87","unitName":"双营"},{"cqcElevation":"20","cqcHighest":"26","cqcValue":"0","points":"116.45405284621:39.834782722815","status":"w","unitCode":"Y88","unitName":"成寿寺"},{"cqcElevation":"25","cqcHighest":"30.1","cqcValue":"0","points":"116.44574996421:39.899563479015","status":"w","unitCode":"Y90","unitName":"夕照寺"},{"cqcElevation":"27.6","cqcHighest":"31.6","cqcValue":"0.000424","points":"116.41043735421:39.877863548215","status":"w","unitCode":"Y89","unitName":"永定门"},{"cqcElevation":"26.4","cqcHighest":"31.6","cqcValue":"0.000424","points":"116.47051386221:39.877348452015","status":"w","unitCode":"Y42","unitName":"左安东路"},{"cqcElevation":"29.25","cqcHighest":"32.47","cqcValue":"-999999","points":"116.42415699821:39.878498944315","status":"w","unitCode":"Y11","unitName":"西蒲"},{"cqcElevation":"25","cqcHighest":"30.1","cqcValue":"0","points":"116.44574996421:39.899563479015","status":"w","unitCode":"Y90","unitName":"夕照寺"},{"cqcElevation":"29.6","cqcHighest":"34.1","cqcValue":"5","points":"116.43658448021:39.976915828515","status":"w","unitCode":"Y25","unitName":"和平里"},{"cqcElevation":"36.6","cqcHighest":"40.3","cqcValue":"-999999","points":"116.40151034721:39.975754990115","status":"w","unitCode":"Y15","unitName":"安华桥"},{"cqcElevation":"24.55","cqcHighest":"31.95","cqcValue":"-999999","points":"116.44709532621:39.877758199315","status":"w","unitCode":"Y13","unitName":"左安门"},{"cqcElevation":"33","cqcHighest":"36.2","cqcValue":"68","points":"116.32535821621:39.864351919515","status":"w","unitCode":"Y74","unitName":"西南三环"},{"cqcElevation":"38.2","cqcHighest":"40.35","cqcValue":"4","points":"116.35229178921:39.974517078415","status":"w","unitCode":"Y46","unitName":"大钟寺"},{"cqcElevation":"25.98","cqcHighest":"30.1","cqcValue":"0.000424","points":"116.40788741121:39.860783399215","status":"w","unitCode":"Y66","unitName":"木樨园"},{"cqcElevation":"15.9","cqcHighest":"19.2","cqcValue":"0","points":"116.61458527821:39.903996388615","status":"w","unitCode":"Y86","unitName":"中古"},{"cqcElevation":"81.8","cqcHighest":"86.6","cqcValue":"0","points":"116.13824143921:39.943520876115","status":"w","unitCode":"Y84","unitName":"麻裕"},{"cqcElevation":"30.35","cqcHighest":"33.4","cqcValue":"0.000424","points":"116.35398254021:39.860785369015","status":"w","unitCode":"Y87","unitName":"双营"}]}
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
         * cqcElevation : 38.2
         * cqcHighest : 40.35
         * cqcValue : 4
         * points : 116.35229178921:39.974517078415
         * status : w
         * unitCode : Y46
         * unitName : 大钟寺
         */

        private List<YlMapEntity> ylMap;

        public void setYlMap(List<YlMapEntity> ylMap) {
            this.ylMap = ylMap;
        }

        public List<YlMapEntity> getYlMap() {
            return ylMap;
        }

        public static class YlMapEntity {
            private double cqcElevation;
            private double cqcHighest;
            private double cqcValue;
            private String points;
            private String status;
            private String unitCode;
            private String unitName;

            public void setCqcElevation(double cqcElevation) {
                this.cqcElevation = cqcElevation;
            }

            public void setCqcHighest(double cqcHighest) {
                this.cqcHighest = cqcHighest;
            }

            public void setCqcValue(double cqcValue) {
                this.cqcValue = cqcValue;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public double getCqcElevation() {
                return cqcElevation;
            }

            public double getCqcHighest() {
                return cqcHighest;
            }

            public double getCqcValue() {
                return cqcValue;
            }

            public String getPoints() {
                return points;
            }

            public String getStatus() {
                return status;
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

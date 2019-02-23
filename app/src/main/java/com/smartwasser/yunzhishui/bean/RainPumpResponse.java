package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/23 0023.
 */
public class RainPumpResponse extends RBResponse {
    private DataEntity data;
    /**
     * data : {"ylMap":[{"createTime":"2016-07-22 22:32:33","id":"402881ee38f714670138f96345970592","points":"116.41355918921:39.955944953915","status":"0","unitCode":"Y1","unitName":"安定门","unitType":"雨水泵站"}]}
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
         * createTime : 2016-07-22 22:32:33
         * id : 402881ee38f714670138f96345970592
         * points : 116.41355918921:39.955944953915
         * status : 0
         * unitCode : Y1
         * unitName : 安定门
         * unitType : 雨水泵站
         */

        private List<YlMapEntity> ylMap;

        public void setYlMap(List<YlMapEntity> ylMap) {
            this.ylMap = ylMap;
        }

        public List<YlMapEntity> getYlMap() {
            return ylMap;
        }

        public static class YlMapEntity {
            private String createTime;
            private String id;
            private String points;
            private String status;
            private String unitCode;
            private String unitName;
            private String unitType;

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public void setId(String id) {
                this.id = id;
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

            public void setUnitType(String unitType) {
                this.unitType = unitType;
            }

            public String getCreateTime() {
                return createTime;
            }

            public String getId() {
                return id;
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

            public String getUnitType() {
                return unitType;
            }
        }
    }
}
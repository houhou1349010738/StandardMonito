package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/9/5 0005.
 */
public class PopupwindRainResponse extends RBResponse{

    private DataEntity data;
    /**
     * data : {"rainlist":[{"createtime":"2016-07-15 18:34:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee1f3a673d0f","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:40:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee24c5263d6b","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:41:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee259ba73da1","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:42:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee268ad53de0","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:43:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee2770433e18","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:44:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee2865e63e68","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:48:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee2c09933eb4","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:49:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee2ce7ff3ee2","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:52:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee2fba0c3f34","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:53:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee308bfa3f59","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:55:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee326fa43f9a","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:56:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee335e743fe3","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:57:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee344a0a4033","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 19:00:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee370de4409a","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 19:01:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee37f04640e0","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 19:04:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee3aaca14123","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 19:05:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee3b8e67415d","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 19:07:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee3d69e641a1","indeCode":"A0001","unitCode":"Y80","value":0},{"createtime":"2016-07-15 18:28:20","dataTime":"2016-07-15 18:27:45","id":"8a82e94a55e48a630155ee19a1553cc6","indeCode":"A0001","stateFlag":"2","unitCode":"Y80","value":0}]}
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
         * createtime : 2016-07-15 18:34:20
         * dataTime : 2016-07-15 18:27:45
         * id : 8a82e94a55e48a630155ee1f3a673d0f
         * indeCode : A0001
         * unitCode : Y80
         * value : 0
         */

        private List<RainlistEntity> rainlist;

        public void setRainlist(List<RainlistEntity> rainlist) {
            this.rainlist = rainlist;
        }

        public List<RainlistEntity> getRainlist() {
            return rainlist;
        }

        public static class RainlistEntity {
            private String createtime;
            private String dataTime;
            private String id;
            private String indeCode;
            private String unitCode;
            private double value;

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public void setDataTime(String dataTime) {
                this.dataTime = dataTime;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIndeCode(String indeCode) {
                this.indeCode = indeCode;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public String getCreatetime() {
                return createtime;
            }

            public String getDataTime() {
                return dataTime;
            }

            public String getId() {
                return id;
            }

            public String getIndeCode() {
                return indeCode;
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

package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/21 0021.
 */
public class AddToResponse extends RBResponse{

    /**
     * map : {"$ref":"@"}
     * userName : 测试用户
     * ysCode : 20160721104
     */

    private DataEntity data;
    /**
     * data : {"map":{"$ref":"@"},"userName":"测试用户","ysCode":"20160721104"}
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
         * $ref : @
         */

        private MapEntity map;
        private String userName;
        private String ysCode;

        public void setMap(MapEntity map) {
            this.map = map;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setYsCode(String ysCode) {
            this.ysCode = ysCode;
        }

        public MapEntity getMap() {
            return map;
        }

        public String getUserName() {
            return userName;
        }

        public String getYsCode() {
            return ysCode;
        }

        public static class MapEntity {
            private String $ref;

            public void set$ref(String $ref) {
                this.$ref = $ref;
            }

            public String get$ref() {
                return $ref;
            }
        }
    }
}

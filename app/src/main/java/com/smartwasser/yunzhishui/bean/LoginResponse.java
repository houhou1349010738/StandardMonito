package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/4/26 0026.
 */
public class LoginResponse extends RBResponse{

    /**
     * JSESSIONID : 782b6067-bc32-40a0-b7a9-cab718d78809
     * userid : 1
     */

    private DataEntity data;
    /**
     * data : {"JSESSIONID":"782b6067-bc32-40a0-b7a9-cab718d78809","userid":"1"}
     * errorCode : 000000
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
        private String JSESSIONID;
        private String userid;

        public void setJSESSIONID(String JSESSIONID) {
            this.JSESSIONID = JSESSIONID;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getJSESSIONID() {
            return JSESSIONID;
        }

        public String getUserid() {
            return userid;
        }
    }
}

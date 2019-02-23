package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/21 0021.
 */
public class IsFillResponse extends RBResponse {
    /**
     * size : 1
     */

    private DataEntity data;
    /**
     * data : {"size":1}
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
        private int size;

        public void setSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }
}

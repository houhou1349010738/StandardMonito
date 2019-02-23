package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/7 0007.
 */
public class HtichQrRespon extends RBResponse {
    /**
     * errorCode : 00000
     * errorMsg : success
     */
    private String errorCode;
    private String errorMsg;

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}

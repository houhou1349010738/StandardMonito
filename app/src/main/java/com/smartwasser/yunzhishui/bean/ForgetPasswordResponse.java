package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/4/27 0027.
 */
public class ForgetPasswordResponse extends RBResponse{
    /**
     * errorCode : 00003
     * errorMsg : 请求参数不正确
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

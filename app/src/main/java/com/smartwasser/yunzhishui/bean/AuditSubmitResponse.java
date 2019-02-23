package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/5/10 0010.
 */
public class AuditSubmitResponse  extends RBResponse{
    private String errorCode;
    private String errorMsg;
    public String getErrorCode() {
        return errorCode;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

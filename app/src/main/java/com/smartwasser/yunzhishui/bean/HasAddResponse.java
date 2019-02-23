package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/5/6 0006.
 */
public class HasAddResponse extends RBResponse {
    /**
     * hasAdd : true
     * hasCheck : true
     * hasEdit : true
     * hasReview : true
     */
    private DataEntity data;
    /**
     * data : {"hasAdd":true,"hasCheck":true,"hasEdit":true,"hasReview":true}
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
        private boolean hasAdd;
        private boolean hasCheck;
        private boolean hasEdit;
        private boolean hasReview;

        public void setHasAdd(boolean hasAdd) {
            this.hasAdd = hasAdd;
        }

        public void setHasCheck(boolean hasCheck) {
            this.hasCheck = hasCheck;
        }

        public void setHasEdit(boolean hasEdit) {
            this.hasEdit = hasEdit;
        }

        public void setHasReview(boolean hasReview) {
            this.hasReview = hasReview;
        }

        public boolean isHasAdd() {
            return hasAdd;
        }

        public boolean isHasCheck() {
            return hasCheck;
        }

        public boolean isHasEdit() {
            return hasEdit;
        }

        public boolean isHasReview() {
            return hasReview;
        }
    }
}

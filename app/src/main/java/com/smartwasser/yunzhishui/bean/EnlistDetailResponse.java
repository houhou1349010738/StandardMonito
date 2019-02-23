package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/4 0004.
 */
public class EnlistDetailResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"supplierList":[{"applyTime":"2016-08-01 19:52:52","checkResult":"DSH","id":"64","name":"农行","projectId":"a72a420b585511e6aa18000c29030dc2","state":"0"}]}
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
         * applyTime : 2016-08-01 19:52:52
         * checkResult : DSH
         * id : 64
         * name : 农行
         * projectId : a72a420b585511e6aa18000c29030dc2
         * state : 0
         */

        private List<SupplierListEntity> supplierList;

        public void setSupplierList(List<SupplierListEntity> supplierList) {
            this.supplierList = supplierList;
        }

        public List<SupplierListEntity> getSupplierList() {
            return supplierList;
        }

        public static class SupplierListEntity {
            private String applyTime;
            private String checkResult;
            private String id;
            private String name;
            private String projectId;
            private String state;

            public void setApplyTime(String applyTime) {
                this.applyTime = applyTime;
            }

            public void setCheckResult(String checkResult) {
                this.checkResult = checkResult;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setProjectId(String projectId) {
                this.projectId = projectId;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getApplyTime() {
                return applyTime;
            }

            public String getCheckResult() {
                return checkResult;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getProjectId() {
                return projectId;
            }

            public String getState() {
                return state;
            }
        }
    }
}

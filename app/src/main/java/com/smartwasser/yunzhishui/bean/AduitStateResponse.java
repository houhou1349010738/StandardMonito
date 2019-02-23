package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/20 0020.
 */
public class AduitStateResponse extends RBResponse {
    /**
     * PayOperationProcess : {"rows":[{"buCode":"1","buName":"公司机关","claimId":"e43cec454ce211e6aa18000c29030dc2","flownode":"费用报销申请","id":"d1c6e0c64d6111e6aa18000c29030dc2","operTime":"2016-07-18 20:35:20","operUsername":"root","operUsernamecn":"测试用户"},{"buCode":"1","buName":"公司机关","claimId":"e43cec454ce211e6aa18000c29030dc2","flownode":"项目经理审核","id":"bcfa55da4d8b11e6aa18000c29030dc2","message":"通过","operResult":"同意","operTime":"2016-07-19 01:35:24","operUsername":"root","operUsernamecn":"测试用户","zn":""}],"total":2}
     */
    private DataEntity data;
    /**
     * data : {"PayOperationProcess":{"rows":[{"buCode":"1","buName":"公司机关","claimId":"e43cec454ce211e6aa18000c29030dc2","flownode":"费用报销申请","id":"d1c6e0c64d6111e6aa18000c29030dc2","operTime":"2016-07-18 20:35:20","operUsername":"root","operUsernamecn":"测试用户"},{"buCode":"1","buName":"公司机关","claimId":"e43cec454ce211e6aa18000c29030dc2","flownode":"项目经理审核","id":"bcfa55da4d8b11e6aa18000c29030dc2","message":"通过","operResult":"同意","operTime":"2016-07-19 01:35:24","operUsername":"root","operUsernamecn":"测试用户","zn":""}],"total":2}}
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
         * rows : [{"buCode":"1","buName":"公司机关","claimId":"e43cec454ce211e6aa18000c29030dc2","flownode":"费用报销申请","id":"d1c6e0c64d6111e6aa18000c29030dc2","operTime":"2016-07-18 20:35:20","operUsername":"root","operUsernamecn":"测试用户"},{"buCode":"1","buName":"公司机关","claimId":"e43cec454ce211e6aa18000c29030dc2","flownode":"项目经理审核","id":"bcfa55da4d8b11e6aa18000c29030dc2","message":"通过","operResult":"同意","operTime":"2016-07-19 01:35:24","operUsername":"root","operUsernamecn":"测试用户","zn":""}]
         * total : 2
         */

        private PayOperationProcessEntity PayOperationProcess;

        public void setPayOperationProcess(PayOperationProcessEntity PayOperationProcess) {
            this.PayOperationProcess = PayOperationProcess;
        }

        public PayOperationProcessEntity getPayOperationProcess() {
            return PayOperationProcess;
        }

        public static class PayOperationProcessEntity {
            private int total;
            /**
             * buCode : 1
             * buName : 公司机关
             * claimId : e43cec454ce211e6aa18000c29030dc2
             * flownode : 费用报销申请
             * id : d1c6e0c64d6111e6aa18000c29030dc2
             * operTime : 2016-07-18 20:35:20
             * operUsername : root
             * operUsernamecn : 测试用户
             */

            private List<RowsEntity> rows;

            public void setTotal(int total) {
                this.total = total;
            }

            public void setRows(List<RowsEntity> rows) {
                this.rows = rows;
            }

            public int getTotal() {
                return total;
            }

            public List<RowsEntity> getRows() {
                return rows;
            }

            public static class RowsEntity {
                private String buCode;
                private String buName;
                private String claimId;
                private String flownode;
                private String id;
                private String operTime;
                private String operUsername;
                private String operUsernamecn;
                private String operResult;

                public String getOperResult() {
                    return operResult;
                }

                public void setOperResult(String operResult) {
                    this.operResult = operResult;
                }

                public void setBuCode(String buCode) {
                    this.buCode = buCode;
                }

                public void setBuName(String buName) {
                    this.buName = buName;
                }

                public void setClaimId(String claimId) {
                    this.claimId = claimId;
                }

                public void setFlownode(String flownode) {
                    this.flownode = flownode;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public void setOperTime(String operTime) {
                    this.operTime = operTime;
                }

                public void setOperUsername(String operUsername) {
                    this.operUsername = operUsername;
                }

                public void setOperUsernamecn(String operUsernamecn) {
                    this.operUsernamecn = operUsernamecn;
                }

                public String getBuCode() {
                    return buCode;
                }

                public String getBuName() {
                    return buName;
                }

                public String getClaimId() {
                    return claimId;
                }

                public String getFlownode() {
                    return flownode;
                }

                public String getId() {
                    return id;
                }

                public String getOperTime() {
                    return operTime;
                }

                public String getOperUsername() {
                    return operUsername;
                }

                public String getOperUsernamecn() {
                    return operUsernamecn;
                }
            }
        }
    }
}

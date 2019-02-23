package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/26 0026.
 */
public class PaymentResponse extends RBResponse {
    /**
     * FeeIncome : {"rows":[{"applyMoney":0,"applySummary":"","applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","buCode":"DSWY0015","contrId":"c80b7e0b4fcc11e6aa18000c29030dc2","id":"4147cf664fd711e6aa18000c29030dc2","payUnit":"www","status":"审核完成"}],"total":1}
     */
    private DataEntity data;
    /**
     * data : {"FeeIncome":{"rows":[{"applyMoney":0,"applySummary":"","applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","buCode":"DSWY0015","contrId":"c80b7e0b4fcc11e6aa18000c29030dc2","id":"4147cf664fd711e6aa18000c29030dc2","payUnit":"www","status":"审核完成"}],"total":1}}
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
         * rows : [{"applyMoney":0,"applySummary":"","applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","buCode":"DSWY0015","contrId":"c80b7e0b4fcc11e6aa18000c29030dc2","id":"4147cf664fd711e6aa18000c29030dc2","payUnit":"www","status":"审核完成"}]
         * total : 1
         */

        private FeeIncomeEntity FeeIncome;

        public void setFeeIncome(FeeIncomeEntity FeeIncome) {
            this.FeeIncome = FeeIncome;
        }

        public FeeIncomeEntity getFeeIncome() {
            return FeeIncome;
        }

        public static class FeeIncomeEntity {
            private int total;
            /**
             * applyMoney : 0.0
             * applySummary :
             * applyTime : 2016-06-22
             * applyUsername : root
             * applyUsernamecn : 测试用户
             * buCode : DSWY0015
             * contrId : c80b7e0b4fcc11e6aa18000c29030dc2
             * id : 4147cf664fd711e6aa18000c29030dc2
             * payUnit : www
             * status : 审核完成
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
                private double applyMoney;
                private String applySummary;
                private String applyTime;
                private String applyUsername;
                private String applyUsernamecn;
                private String buCode;
                private String contrId;
                private String id;
                private String payUnit;
                private String status;

                public void setApplyMoney(double applyMoney) {
                    this.applyMoney = applyMoney;
                }

                public void setApplySummary(String applySummary) {
                    this.applySummary = applySummary;
                }

                public void setApplyTime(String applyTime) {
                    this.applyTime = applyTime;
                }

                public void setApplyUsername(String applyUsername) {
                    this.applyUsername = applyUsername;
                }

                public void setApplyUsernamecn(String applyUsernamecn) {
                    this.applyUsernamecn = applyUsernamecn;
                }

                public void setBuCode(String buCode) {
                    this.buCode = buCode;
                }

                public void setContrId(String contrId) {
                    this.contrId = contrId;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public void setPayUnit(String payUnit) {
                    this.payUnit = payUnit;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public double getApplyMoney() {
                    return applyMoney;
                }

                public String getApplySummary() {
                    return applySummary;
                }

                public String getApplyTime() {
                    return applyTime;
                }

                public String getApplyUsername() {
                    return applyUsername;
                }

                public String getApplyUsernamecn() {
                    return applyUsernamecn;
                }

                public String getBuCode() {
                    return buCode;
                }

                public String getContrId() {
                    return contrId;
                }

                public String getId() {
                    return id;
                }

                public String getPayUnit() {
                    return payUnit;
                }

                public String getStatus() {
                    return status;
                }
            }
        }
    }
}

package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/25 0025.
 */
public class ContractDetailsListResponse extends RBResponse {
    /**
     * FeeIncome : {"rows":[{"applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"1","bankNumber":"1","buCode":"DSWY0015","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"3139d23e520b11e6aa18000c29030dc2","incomeMoney":11,"organizationAdd":"11","organizationName":"1","phone":"111","status":"收款通知","taxpayer":"1"},{"applyTime":"2016-06-07","applyUsername":"root","applyUsernamecn":"测试用户","bank":"中国工商银行大屯路支行","bankName":"jjjjjj","bankNumber":"uuuu","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-203","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"2a266f684fd011e6aa18000c29030dc2","incomeMoney":1000,"organizationAdd":"uuuuu","organizationName":"yjjj","phone":"iiii","status":"收款完结","taxpayer":"u"},{"applyTime":"2016-06-01","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"ddd","bankNumber":"ddd","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-203","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"b175a9484fd211e6aa18000c29030dc2","incomeMoney":9000,"organizationAdd":"dddd","organizationName":"dd","phone":"dddd","status":"收款完结","taxpayer":"ddd"}],"total":3}
     */
    private DataEntity data;
    /**
     * data : {"FeeIncome":{"rows":[{"applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"1","bankNumber":"1","buCode":"DSWY0015","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"3139d23e520b11e6aa18000c29030dc2","incomeMoney":11,"organizationAdd":"11","organizationName":"1","phone":"111","status":"收款通知","taxpayer":"1"},{"applyTime":"2016-06-07","applyUsername":"root","applyUsernamecn":"测试用户","bank":"中国工商银行大屯路支行","bankName":"jjjjjj","bankNumber":"uuuu","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-203","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"2a266f684fd011e6aa18000c29030dc2","incomeMoney":1000,"organizationAdd":"uuuuu","organizationName":"yjjj","phone":"iiii","status":"收款完结","taxpayer":"u"},{"applyTime":"2016-06-01","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"ddd","bankNumber":"ddd","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-203","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"b175a9484fd211e6aa18000c29030dc2","incomeMoney":9000,"organizationAdd":"dddd","organizationName":"dd","phone":"dddd","status":"收款完结","taxpayer":"ddd"}],"total":3}}
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
         * rows : [{"applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"1","bankNumber":"1","buCode":"DSWY0015","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"3139d23e520b11e6aa18000c29030dc2","incomeMoney":11,"organizationAdd":"11","organizationName":"1","phone":"111","status":"收款通知","taxpayer":"1"},{"applyTime":"2016-06-07","applyUsername":"root","applyUsernamecn":"测试用户","bank":"中国工商银行大屯路支行","bankName":"jjjjjj","bankNumber":"uuuu","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-203","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"2a266f684fd011e6aa18000c29030dc2","incomeMoney":1000,"organizationAdd":"uuuuu","organizationName":"yjjj","phone":"iiii","status":"收款完结","taxpayer":"u"},{"applyTime":"2016-06-01","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"ddd","bankNumber":"ddd","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-203","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"b175a9484fd211e6aa18000c29030dc2","incomeMoney":9000,"organizationAdd":"dddd","organizationName":"dd","phone":"dddd","status":"收款完结","taxpayer":"ddd"}]
         * total : 3
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
             * applyTime : 2016-06-22
             * applyUsername : root
             * applyUsernamecn : 测试用户
             * bank : 农行北京农大南路支行
             * bankName : 1
             * bankNumber : 1
             * buCode : DSWY0015
             * contrId : cb7801ea4fcb11e6aa18000c29030dc2
             * id : 3139d23e520b11e6aa18000c29030dc2
             * incomeMoney : 11.0
             * organizationAdd : 11
             * organizationName : 1
             * phone : 111
             * status : 收款通知
             * taxpayer : 1
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
                private String applyTime;
                private String applyUsername;
                private String applyUsernamecn;
                private String bank;
                private String bankName;
                private String bankNumber;
                private String buCode;
                private String contrId;
                private String id;
                private double incomeMoney;
                private String organizationAdd;
                private String organizationName;
                private String phone;
                private String status;
                private String taxpayer;

                public void setApplyTime(String applyTime) {
                    this.applyTime = applyTime;
                }

                public void setApplyUsername(String applyUsername) {
                    this.applyUsername = applyUsername;
                }

                public void setApplyUsernamecn(String applyUsernamecn) {
                    this.applyUsernamecn = applyUsernamecn;
                }

                public void setBank(String bank) {
                    this.bank = bank;
                }

                public void setBankName(String bankName) {
                    this.bankName = bankName;
                }

                public void setBankNumber(String bankNumber) {
                    this.bankNumber = bankNumber;
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

                public void setIncomeMoney(double incomeMoney) {
                    this.incomeMoney = incomeMoney;
                }

                public void setOrganizationAdd(String organizationAdd) {
                    this.organizationAdd = organizationAdd;
                }

                public void setOrganizationName(String organizationName) {
                    this.organizationName = organizationName;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public void setTaxpayer(String taxpayer) {
                    this.taxpayer = taxpayer;
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

                public String getBank() {
                    return bank;
                }

                public String getBankName() {
                    return bankName;
                }

                public String getBankNumber() {
                    return bankNumber;
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

                public double getIncomeMoney() {
                    return incomeMoney;
                }

                public String getOrganizationAdd() {
                    return organizationAdd;
                }

                public String getOrganizationName() {
                    return organizationName;
                }

                public String getPhone() {
                    return phone;
                }

                public String getStatus() {
                    return status;
                }

                public String getTaxpayer() {
                    return taxpayer;
                }
            }
        }
    }
}

package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/25 0025.
 */
public class ContractDetailResponse extends RBResponse {
    /**
     * applyUsernamecn : 测试用户
     * feeStatus : 1
     * po : {"auditTime":"2016-07-21 22:49:48","auditUser":"root","beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":23000,"contrCode":"dianying","contrFirstParty":"甲","contrName":"电影","contrSecondParty":"乙","contrSummary":"www","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-29 00:00:00","financialAuditOpinion":"aaa","fundsType":"收款","id":"cb7801ea4fcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":10000,"professionSubject":"13000","settlementMethod":"2 3","signTime":"2016-07-22 00:00:00","status":"复核退回","type":"1","unitName":"电影城频道项目"}
     * status : 收款通知
     * unitName :
     */

    private DataEntity data;
    /**
     * data : {"applyUsernamecn":"测试用户","feeStatus":"1","po":{"auditTime":"2016-07-21 22:49:48","auditUser":"root","beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":23000,"contrCode":"dianying","contrFirstParty":"甲","contrName":"电影","contrSecondParty":"乙","contrSummary":"www","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-29 00:00:00","financialAuditOpinion":"aaa","fundsType":"收款","id":"cb7801ea4fcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":10000,"professionSubject":"13000","settlementMethod":"2 3","signTime":"2016-07-22 00:00:00","status":"复核退回","type":"1","unitName":"电影城频道项目"},"status":"收款通知","unitName":"ç\u0094µå½±å\u009f\u008eé¢\u0091é\u0081\u0093é¡¹ç\u009b®"}
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
        private String applyUsernamecn;
        private String feeStatus;
        /**
         * auditTime : 2016-07-21 22:49:48
         * auditUser : root
         * beginTime : 2016-07-22 00:00:00
         * buCode : DSWY0015
         * contrAmount : 23000.0
         * contrCode : dianying
         * contrFirstParty : 甲
         * contrName : 电影
         * contrSecondParty : 乙
         * contrSummary : www
         * contrType : 合同类型(收款)
         * crtime : 2016-07-21 00:00:00
         * cruser : root
         * endTime : 2016-07-29 00:00:00
         * financialAuditOpinion : aaa
         * fundsType : 收款
         * id : cb7801ea4fcb11e6aa18000c29030dc2
         * incomeSource :
         * initialAmount : 10000.0
         * professionSubject : 13000
         * settlementMethod : 2 3
         * signTime : 2016-07-22 00:00:00
         * status : 复核退回
         * type : 1
         * unitName : 电影城频道项目
         */

        private PoEntity po;
        private String status;
        private String unitName;

        public void setApplyUsernamecn(String applyUsernamecn) {
            this.applyUsernamecn = applyUsernamecn;
        }

        public void setFeeStatus(String feeStatus) {
            this.feeStatus = feeStatus;
        }

        public void setPo(PoEntity po) {
            this.po = po;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getApplyUsernamecn() {
            return applyUsernamecn;
        }

        public String getFeeStatus() {
            return feeStatus;
        }

        public PoEntity getPo() {
            return po;
        }

        public String getStatus() {
            return status;
        }

        public String getUnitName() {
            return unitName;
        }

        public static class PoEntity {
            private String auditTime;
            private String auditUser;
            private String beginTime;
            private String buCode;
            private double contrAmount;
            private String contrCode;
            private String contrFirstParty;
            private String contrName;
            private String contrSecondParty;
            private String contrSummary;
            private String contrType;
            private String crtime;
            private String cruser;
            private String endTime;
            private String financialAuditOpinion;
            private String fundsType;
            private String id;
            private String incomeSource;
            private double initialAmount;
            private String professionSubject;
            private String settlementMethod;
            private String signTime;
            private String status;
            private String type;
            private String unitName;

            public void setAuditTime(String auditTime) {
                this.auditTime = auditTime;
            }

            public void setAuditUser(String auditUser) {
                this.auditUser = auditUser;
            }

            public void setBeginTime(String beginTime) {
                this.beginTime = beginTime;
            }

            public void setBuCode(String buCode) {
                this.buCode = buCode;
            }

            public void setContrAmount(double contrAmount) {
                this.contrAmount = contrAmount;
            }

            public void setContrCode(String contrCode) {
                this.contrCode = contrCode;
            }

            public void setContrFirstParty(String contrFirstParty) {
                this.contrFirstParty = contrFirstParty;
            }

            public void setContrName(String contrName) {
                this.contrName = contrName;
            }

            public void setContrSecondParty(String contrSecondParty) {
                this.contrSecondParty = contrSecondParty;
            }

            public void setContrSummary(String contrSummary) {
                this.contrSummary = contrSummary;
            }

            public void setContrType(String contrType) {
                this.contrType = contrType;
            }

            public void setCrtime(String crtime) {
                this.crtime = crtime;
            }

            public void setCruser(String cruser) {
                this.cruser = cruser;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public void setFinancialAuditOpinion(String financialAuditOpinion) {
                this.financialAuditOpinion = financialAuditOpinion;
            }

            public void setFundsType(String fundsType) {
                this.fundsType = fundsType;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIncomeSource(String incomeSource) {
                this.incomeSource = incomeSource;
            }

            public void setInitialAmount(double initialAmount) {
                this.initialAmount = initialAmount;
            }

            public void setProfessionSubject(String professionSubject) {
                this.professionSubject = professionSubject;
            }

            public void setSettlementMethod(String settlementMethod) {
                this.settlementMethod = settlementMethod;
            }

            public void setSignTime(String signTime) {
                this.signTime = signTime;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }

            public String getAuditTime() {
                return auditTime;
            }

            public String getAuditUser() {
                return auditUser;
            }

            public String getBeginTime() {
                return beginTime;
            }

            public String getBuCode() {
                return buCode;
            }

            public double getContrAmount() {
                return contrAmount;
            }

            public String getContrCode() {
                return contrCode;
            }

            public String getContrFirstParty() {
                return contrFirstParty;
            }

            public String getContrName() {
                return contrName;
            }

            public String getContrSecondParty() {
                return contrSecondParty;
            }

            public String getContrSummary() {
                return contrSummary;
            }

            public String getContrType() {
                return contrType;
            }

            public String getCrtime() {
                return crtime;
            }

            public String getCruser() {
                return cruser;
            }

            public String getEndTime() {
                return endTime;
            }

            public String getFinancialAuditOpinion() {
                return financialAuditOpinion;
            }

            public String getFundsType() {
                return fundsType;
            }

            public String getId() {
                return id;
            }

            public String getIncomeSource() {
                return incomeSource;
            }

            public double getInitialAmount() {
                return initialAmount;
            }

            public String getProfessionSubject() {
                return professionSubject;
            }

            public String getSettlementMethod() {
                return settlementMethod;
            }

            public String getSignTime() {
                return signTime;
            }

            public String getStatus() {
                return status;
            }

            public String getType() {
                return type;
            }

            public String getUnitName() {
                return unitName;
            }
        }
    }
}

package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/27 0027.
 */
public class PaymentDetaulResponse extends RBResponse {

    /**
     * applyUsernamecn : 测试用户
     * feeStatus : 0
     * po : {"beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":333,"contrCode":"jiyin","contrFirstParty":"a","contrName":"基因","contrSecondParty":"b","contrSummary":"aaaa","contrType":"合同类型(付款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-23 00:00:00","fundsType":"支付","id":"c80b7e0b4fcc11e6aa18000c29030dc2","incomeSource":"","initialAmount":333,"professionSubject":"333.0","settlementMethod":"123567","signTime":"2016-07-22 00:00:00","status":"复核","type":"1","unitName":"电影城频道项目"}
     * unitName : 电影城频道项目
     */

    private DataEntity data;
    /**
     * data : {"applyUsernamecn":"测试用户","feeStatus":"0","po":{"beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":333,"contrCode":"jiyin","contrFirstParty":"a","contrName":"基因","contrSecondParty":"b","contrSummary":"aaaa","contrType":"合同类型(付款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-23 00:00:00","fundsType":"支付","id":"c80b7e0b4fcc11e6aa18000c29030dc2","incomeSource":"","initialAmount":333,"professionSubject":"333.0","settlementMethod":"123567","signTime":"2016-07-22 00:00:00","status":"复核","type":"1","unitName":"电影城频道项目"},"unitName":"电影城频道项目"}
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
         * beginTime : 2016-07-22 00:00:00
         * buCode : DSWY0015
         * contrAmount : 333.0
         * contrCode : jiyin
         * contrFirstParty : a
         * contrName : 基因
         * contrSecondParty : b
         * contrSummary : aaaa
         * contrType : 合同类型(付款)
         * crtime : 2016-07-21 00:00:00
         * cruser : root
         * endTime : 2016-07-23 00:00:00
         * fundsType : 支付
         * id : c80b7e0b4fcc11e6aa18000c29030dc2
         * incomeSource :
         * initialAmount : 333.0
         * professionSubject : 333.0
         * settlementMethod : 123567
         * signTime : 2016-07-22 00:00:00
         * status : 复核
         * type : 1
         * unitName : 电影城频道项目
         */

        private PoEntity po;
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

        public String getUnitName() {
            return unitName;
        }

        public static class PoEntity {
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

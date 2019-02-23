package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/26 0026.
 */
public class ContractLookResponse extends RBResponse{

    /**
     * fundsType : "SK"
     * inv : {"contrId":"3139d23e520b11e6aa18000c29030dc2","id":"4a9ee3fa520b11e6aa18000c29030dc2","invoiceMoney":9.91,"invoiceTax":1.09,"invoiceTaxes":"11","invoiceType":"ZY"}
     * po : {"auditTime":"2016-07-21 22:49:48","auditUser":"root","beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":23000,"contrCode":"dianying","contrFirstParty":"甲","contrName":"电影","contrSecondParty":"乙","contrSummary":"www","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-29 00:00:00","financialAuditOpinion":"aaa","fundsType":"收款","id":"cb7801ea4fcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":10000,"professionSubject":"12989","settlementMethod":"2 3","signTime":"2016-07-22 00:00:00","status":"复核退回","type":"1","unitName":"电影城频道项目"}
     * unitName : "电影城频道项目"
     * vo : {"applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"1","bankNumber":"1","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-207","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"3139d23e520b11e6aa18000c29030dc2","incomeMoney":11,"incomeSummary":"11","organizationAdd":"11","organizationName":"1","phone":"111","status":"收款完结","taxpayer":"1"}
     */

    private DataEntity data;
    /**
     * data : {"fundsType":"\"SK\"","inv":{"contrId":"3139d23e520b11e6aa18000c29030dc2","id":"4a9ee3fa520b11e6aa18000c29030dc2","invoiceMoney":9.91,"invoiceTax":1.09,"invoiceTaxes":"11","invoiceType":"ZY"},"po":{"auditTime":"2016-07-21 22:49:48","auditUser":"root","beginTime":"2016-07-22 00:00:00","buCode":"DSWY0015","contrAmount":23000,"contrCode":"dianying","contrFirstParty":"甲","contrName":"电影","contrSecondParty":"乙","contrSummary":"www","contrType":"合同类型(收款)","crtime":"2016-07-21 00:00:00","cruser":"root","endTime":"2016-07-29 00:00:00","financialAuditOpinion":"aaa","fundsType":"收款","id":"cb7801ea4fcb11e6aa18000c29030dc2","incomeSource":"","initialAmount":10000,"professionSubject":"12989","settlementMethod":"2 3","signTime":"2016-07-22 00:00:00","status":"复核退回","type":"1","unitName":"电影城频道项目"},"unitName":"\"电影城频道项目\"","vo":{"applyTime":"2016-06-22","applyUsername":"root","applyUsernamecn":"测试用户","bank":"农行北京农大南路支行","bankName":"1","bankNumber":"1","buCode":"DSWY0015","confirmNamecn":"测试用户","confirmTime":"2016-07-207","confirmUser":"root","contrId":"cb7801ea4fcb11e6aa18000c29030dc2","id":"3139d23e520b11e6aa18000c29030dc2","incomeMoney":11,"incomeSummary":"11","organizationAdd":"11","organizationName":"1","phone":"111","status":"收款完结","taxpayer":"1"}}
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
        private String fundsType;
        /**
         * contrId : 3139d23e520b11e6aa18000c29030dc2
         * id : 4a9ee3fa520b11e6aa18000c29030dc2
         * invoiceMoney : 9.91
         * invoiceTax : 1.09
         * invoiceTaxes : 11
         * invoiceType : ZY
         */

        private InvEntity inv;
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
         * professionSubject : 12989
         * settlementMethod : 2 3
         * signTime : 2016-07-22 00:00:00
         * status : 复核退回
         * type : 1
         * unitName : 电影城频道项目
         */

        private PoEntity po;
        private String unitName;
        /**
         * applyTime : 2016-06-22
         * applyUsername : root
         * applyUsernamecn : 测试用户
         * bank : 农行北京农大南路支行
         * bankName : 1
         * bankNumber : 1
         * buCode : DSWY0015
         * confirmNamecn : 测试用户
         * confirmTime : 2016-07-207
         * confirmUser : root
         * contrId : cb7801ea4fcb11e6aa18000c29030dc2
         * id : 3139d23e520b11e6aa18000c29030dc2
         * incomeMoney : 11.0
         * incomeSummary : 11
         * organizationAdd : 11
         * organizationName : 1
         * phone : 111
         * status : 收款完结
         * taxpayer : 1
         */

        private VoEntity vo;

        public void setFundsType(String fundsType) {
            this.fundsType = fundsType;
        }

        public void setInv(InvEntity inv) {
            this.inv = inv;
        }

        public void setPo(PoEntity po) {
            this.po = po;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public void setVo(VoEntity vo) {
            this.vo = vo;
        }

        public String getFundsType() {
            return fundsType;
        }

        public InvEntity getInv() {
            return inv;
        }

        public PoEntity getPo() {
            return po;
        }

        public String getUnitName() {
            return unitName;
        }

        public VoEntity getVo() {
            return vo;
        }

        public static class InvEntity {
            private String contrId;
            private String id;
            private double invoiceMoney;
            private double invoiceTax;
            private String invoiceTaxes;
            private String invoiceType;

            public void setContrId(String contrId) {
                this.contrId = contrId;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setInvoiceMoney(double invoiceMoney) {
                this.invoiceMoney = invoiceMoney;
            }

            public void setInvoiceTax(double invoiceTax) {
                this.invoiceTax = invoiceTax;
            }

            public void setInvoiceTaxes(String invoiceTaxes) {
                this.invoiceTaxes = invoiceTaxes;
            }

            public void setInvoiceType(String invoiceType) {
                this.invoiceType = invoiceType;
            }

            public String getContrId() {
                return contrId;
            }

            public String getId() {
                return id;
            }

            public double getInvoiceMoney() {
                return invoiceMoney;
            }

            public double getInvoiceTax() {
                return invoiceTax;
            }

            public String getInvoiceTaxes() {
                return invoiceTaxes;
            }

            public String getInvoiceType() {
                return invoiceType;
            }
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

        public static class VoEntity {
            private String applyTime;
            private String applyUsername;
            private String applyUsernamecn;
            private String bank;
            private String bankName;
            private String bankNumber;
            private String buCode;
            private String confirmNamecn;
            private String confirmTime;
            private String confirmUser;
            private String contrId;
            private String id;
            private double incomeMoney;
            private String incomeSummary;
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

            public void setConfirmNamecn(String confirmNamecn) {
                this.confirmNamecn = confirmNamecn;
            }

            public void setConfirmTime(String confirmTime) {
                this.confirmTime = confirmTime;
            }

            public void setConfirmUser(String confirmUser) {
                this.confirmUser = confirmUser;
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

            public void setIncomeSummary(String incomeSummary) {
                this.incomeSummary = incomeSummary;
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

            public String getConfirmNamecn() {
                return confirmNamecn;
            }

            public String getConfirmTime() {
                return confirmTime;
            }

            public String getConfirmUser() {
                return confirmUser;
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

            public String getIncomeSummary() {
                return incomeSummary;
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

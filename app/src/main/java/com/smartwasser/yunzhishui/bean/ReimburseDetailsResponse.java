package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/19 0019.
 */
public class ReimburseDetailsResponse extends RBResponse {

    /**
     * FeeSubjectRelation : [{"contrId":"DSWY0015","feeAmount":23,"feeId":"e43cec454ce211e6aa18000c29030dc2","id":"f9e4ec524ce211e6aa18000c29030dc2","indeName":"车辆租赁费","maxValue":"444.00","minValue":"421.00","professionSubject":"JB0314"}]
     * inv : {"contrId":"e43cec454ce211e6aa18000c29030dc2","id":"f9e1ba794ce211e6aa18000c29030dc2","invoiceMoney":23,"invoiceTax":0.46,"invoiceTaxes":"2","invoiceTotal":23.46,"invoiceType":"ZY"}
     * po : {"appendixDesc":"23","claimDep":"DSWY0015","claimDesc":"223","claimId":"e43cec454ce211e6aa18000c29030dc2","claimRealuser":"测试用户","claimSum":23.46,"claimSumcn":"贰拾叁元肆角陆分","claimTime":"2016-06-15","claimUser":"root","claimYear":20160718101,"claimtypeId":"收入预算","examineState":"分子公司/管理处审核","fgld":"","fgldid":"","isContract":"否","scopetypeId":"ZCBXD","xfdw":"2","zjl":"","zn":"","znid":""}
     * unitName : 电影城频道项目
     */
    private DataEntity data;
    /**
     * data : {"FeeSubjectRelation":[{"contrId":"DSWY0015","feeAmount":23,"feeId":"e43cec454ce211e6aa18000c29030dc2","id":"f9e4ec524ce211e6aa18000c29030dc2","indeName":"车辆租赁费","maxValue":"444.00","minValue":"421.00","professionSubject":"JB0314"}],"inv":{"contrId":"e43cec454ce211e6aa18000c29030dc2","id":"f9e1ba794ce211e6aa18000c29030dc2","invoiceMoney":23,"invoiceTax":0.46,"invoiceTaxes":"2","invoiceTotal":23.46,"invoiceType":"ZY"},"po":{"appendixDesc":"23","claimDep":"DSWY0015","claimDesc":"223","claimId":"e43cec454ce211e6aa18000c29030dc2","claimRealuser":"测试用户","claimSum":23.46,"claimSumcn":"贰拾叁元肆角陆分","claimTime":"2016-06-15","claimUser":"root","claimYear":20160718101,"claimtypeId":"收入预算","examineState":"分子公司/管理处审核","fgld":"","fgldid":"","isContract":"否","scopetypeId":"ZCBXD","xfdw":"2","zjl":"","zn":"","znid":""},"unitName":"电影城频道项目"}
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
         * contrId : e43cec454ce211e6aa18000c29030dc2
         * id : f9e1ba794ce211e6aa18000c29030dc2
         * invoiceMoney : 23.0
         * invoiceTax : 0.46
         * invoiceTaxes : 2
         * invoiceTotal : 23.46
         * invoiceType : ZY
         */

        private InvEntity inv;
        /**
         * appendixDesc : 23
         * claimDep : DSWY0015
         * claimDesc : 223
         * claimId : e43cec454ce211e6aa18000c29030dc2
         * claimRealuser : 测试用户
         * claimSum : 23.46
         * claimSumcn : 贰拾叁元肆角陆分
         * claimTime : 2016-06-15
         * claimUser : root
         * claimYear : 20160718101
         * claimtypeId : 收入预算
         * examineState : 分子公司/管理处审核
         * fgld :
         * fgldid :
         * isContract : 否
         * scopetypeId : ZCBXD
         * xfdw : 2
         * zjl :
         * zn :
         * znid :
         */

        private PoEntity po;
        private String unitName;
        /**
         * contrId : DSWY0015
         * feeAmount : 23.0
         * feeId : e43cec454ce211e6aa18000c29030dc2
         * id : f9e4ec524ce211e6aa18000c29030dc2
         * indeName : 车辆租赁费
         * maxValue : 444.00
         * minValue : 421.00
         * professionSubject : JB0314
         */

        private List<FeeSubjectRelationEntity> FeeSubjectRelation;

        public void setInv(InvEntity inv) {
            this.inv = inv;
        }

        public void setPo(PoEntity po) {
            this.po = po;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public void setFeeSubjectRelation(List<FeeSubjectRelationEntity> FeeSubjectRelation) {
            this.FeeSubjectRelation = FeeSubjectRelation;
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

        public List<FeeSubjectRelationEntity> getFeeSubjectRelation() {
            return FeeSubjectRelation;
        }

        public static class InvEntity {
            private String contrId;
            private String id;
            private double invoiceMoney;
            private double invoiceTax;
            private double invoiceTaxes;
            private double invoiceTotal;
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

            public void setInvoiceTaxes(double invoiceTaxes) {
                this.invoiceTaxes = invoiceTaxes;
            }

            public void setInvoiceTotal(double invoiceTotal) {
                this.invoiceTotal = invoiceTotal;
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

            public double getInvoiceTaxes() {
                return invoiceTaxes;
            }

            public double getInvoiceTotal() {
                return invoiceTotal;
            }

            public String getInvoiceType() {
                return invoiceType;
            }
        }

        public static class PoEntity {
            private String appendixDesc;
            private String claimDep;
            private String claimDesc;
            private String claimId;
            private String claimRealuser;
            private double claimSum;
            private String claimSumcn;
            private String claimTime;
            private String claimUser;
            private String claimYear;
            private String claimtypeId;
            private String examineState;
            private String fgld;
            private String fgldid;
            private String isContract;
            private String scopetypeId;
            private String xfdw;
            private String zjl;
            private String zn;
            private String znid;

            public void setAppendixDesc(String appendixDesc) {
                this.appendixDesc = appendixDesc;
            }

            public void setClaimDep(String claimDep) {
                this.claimDep = claimDep;
            }

            public void setClaimDesc(String claimDesc) {
                this.claimDesc = claimDesc;
            }

            public void setClaimId(String claimId) {
                this.claimId = claimId;
            }

            public void setClaimRealuser(String claimRealuser) {
                this.claimRealuser = claimRealuser;
            }

            public void setClaimSum(double claimSum) {
                this.claimSum = claimSum;
            }

            public void setClaimSumcn(String claimSumcn) {
                this.claimSumcn = claimSumcn;
            }

            public void setClaimTime(String claimTime) {
                this.claimTime = claimTime;
            }

            public void setClaimUser(String claimUser) {
                this.claimUser = claimUser;
            }

            public void setClaimYear(String claimYear) {
                this.claimYear = claimYear;
            }

            public void setClaimtypeId(String claimtypeId) {
                this.claimtypeId = claimtypeId;
            }

            public void setExamineState(String examineState) {
                this.examineState = examineState;
            }

            public void setFgld(String fgld) {
                this.fgld = fgld;
            }

            public void setFgldid(String fgldid) {
                this.fgldid = fgldid;
            }

            public void setIsContract(String isContract) {
                this.isContract = isContract;
            }

            public void setScopetypeId(String scopetypeId) {
                this.scopetypeId = scopetypeId;
            }

            public void setXfdw(String xfdw) {
                this.xfdw = xfdw;
            }

            public void setZjl(String zjl) {
                this.zjl = zjl;
            }

            public void setZn(String zn) {
                this.zn = zn;
            }

            public void setZnid(String znid) {
                this.znid = znid;
            }

            public String getAppendixDesc() {
                return appendixDesc;
            }

            public String getClaimDep() {
                return claimDep;
            }

            public String getClaimDesc() {
                return claimDesc;
            }

            public String getClaimId() {
                return claimId;
            }

            public String getClaimRealuser() {
                return claimRealuser;
            }

            public double getClaimSum() {
                return claimSum;
            }

            public String getClaimSumcn() {
                return claimSumcn;
            }

            public String getClaimTime() {
                return claimTime;
            }

            public String getClaimUser() {
                return claimUser;
            }

            public String getClaimYear() {
                return claimYear;
            }

            public String getClaimtypeId() {
                return claimtypeId;
            }

            public String getExamineState() {
                return examineState;
            }

            public String getFgld() {
                return fgld;
            }

            public String getFgldid() {
                return fgldid;
            }

            public String getIsContract() {
                return isContract;
            }

            public String getScopetypeId() {
                return scopetypeId;
            }

            public String getXfdw() {
                return xfdw;
            }

            public String getZjl() {
                return zjl;
            }

            public String getZn() {
                return zn;
            }

            public String getZnid() {
                return znid;
            }
        }

        public static class FeeSubjectRelationEntity {
            private String contrId;
            private double feeAmount;
            private String feeId;
            private String id;
            private String indeName;
            private String maxValue;
            private String minValue;
            private String professionSubject;

            public void setContrId(String contrId) {
                this.contrId = contrId;
            }

            public void setFeeAmount(double feeAmount) {
                this.feeAmount = feeAmount;
            }

            public void setFeeId(String feeId) {
                this.feeId = feeId;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setIndeName(String indeName) {
                this.indeName = indeName;
            }

            public void setMaxValue(String maxValue) {
                this.maxValue = maxValue;
            }

            public void setMinValue(String minValue) {
                this.minValue = minValue;
            }

            public void setProfessionSubject(String professionSubject) {
                this.professionSubject = professionSubject;
            }

            public String getContrId() {
                return contrId;
            }

            public double getFeeAmount() {
                return feeAmount;
            }

            public String getFeeId() {
                return feeId;
            }

            public String getId() {
                return id;
            }

            public String getIndeName() {
                return indeName;
            }

            public String getMaxValue() {
                return maxValue;
            }

            public String getMinValue() {
                return minValue;
            }

            public String getProfessionSubject() {
                return professionSubject;
            }
        }
    }
}

package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/8/5 0005.
 */
public class QuoteDetailResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"supplierQuoteList":[{"checkResult":"SHTG","countNum":1,"firstQuoteDate":"2016-08-01 00:57:09","lastQuoteDate":"2016-08-01 00:57:09","projId":"60af5aeb57b311e6aa18000c29030dc2","quotePrice":21500,"quoteStage":"DSH","supplierId":"67","supplierName":"建行"},{"checkResult":"SHTG","countNum":4,"firstQuoteDate":"2016-08-01 00:18:54","lastQuoteDate":"2016-08-01 01:03:03","projId":"60af5aeb57b311e6aa18000c29030dc2","quotePrice":22300,"quoteStage":"DSH","supplierId":"64","supplierName":"农行"}]}
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
         * checkResult : SHTG
         * countNum : 1
         * firstQuoteDate : 2016-08-01 00:57:09
         * lastQuoteDate : 2016-08-01 00:57:09
         * projId : 60af5aeb57b311e6aa18000c29030dc2
         * quotePrice : 21500
         * quoteStage : DSH
         * supplierId : 67
         * supplierName : 建行
         */

        private List<SupplierQuoteListEntity> supplierQuoteList;

        public void setSupplierQuoteList(List<SupplierQuoteListEntity> supplierQuoteList) {
            this.supplierQuoteList = supplierQuoteList;
        }

        public List<SupplierQuoteListEntity> getSupplierQuoteList() {
            return supplierQuoteList;
        }

        public static class SupplierQuoteListEntity {
            private String checkResult;
            private String countNum;
            private String firstQuoteDate;
            private String lastQuoteDate;
            private String projId;
            private String quotePrice;
            private String quoteStage;
            private String supplierId;
            private String supplierName;

            public void setCheckResult(String checkResult) {
                this.checkResult = checkResult;
            }

            public void setCountNum(String countNum) {
                this.countNum = countNum;
            }

            public void setFirstQuoteDate(String firstQuoteDate) {
                this.firstQuoteDate = firstQuoteDate;
            }

            public void setLastQuoteDate(String lastQuoteDate) {
                this.lastQuoteDate = lastQuoteDate;
            }

            public void setProjId(String projId) {
                this.projId = projId;
            }

            public void setQuotePrice(String quotePrice) {
                this.quotePrice = quotePrice;
            }

            public void setQuoteStage(String quoteStage) {
                this.quoteStage = quoteStage;
            }

            public void setSupplierId(String supplierId) {
                this.supplierId = supplierId;
            }

            public void setSupplierName(String supplierName) {
                this.supplierName = supplierName;
            }

            public String getCheckResult() {
                return checkResult;
            }

            public String getCountNum() {
                return countNum;
            }

            public String getFirstQuoteDate() {
                return firstQuoteDate;
            }

            public String getLastQuoteDate() {
                return lastQuoteDate;
            }

            public String getProjId() {
                return projId;
            }

            public String getQuotePrice() {
                return quotePrice;
            }

            public String getQuoteStage() {
                return quoteStage;
            }

            public String getSupplierId() {
                return supplierId;
            }

            public String getSupplierName() {
                return supplierName;
            }
        }
    }
}

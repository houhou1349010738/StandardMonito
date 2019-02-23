package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/26 0026.
 */
public class ContractlistResponse extends RBResponse {

    private DataEntity data;
    /**
     * data : {"list1":[{"contrId":"DSWY0015","feeAmount":9.91,"feeId":"3139d23e520b11e6aa18000c29030dc2","feeType":"收款","id":"4a9cab31520b11e6aa18000c29030dc2","indeName":"房屋租赁费","maxValue":"122333.00","minValue":"122107.01","professionSubject":"JB0313"}]}
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
         * contrId : DSWY0015
         * feeAmount : 9.91
         * feeId : 3139d23e520b11e6aa18000c29030dc2
         * feeType : 收款
         * id : 4a9cab31520b11e6aa18000c29030dc2
         * indeName : 房屋租赁费
         * maxValue : 122333.00
         * minValue : 122107.01
         * professionSubject : JB0313
         */

        private List<List1Entity> list1;

        public void setList1(List<List1Entity> list1) {
            this.list1 = list1;
        }

        public List<List1Entity> getList1() {
            return list1;
        }

        public static class List1Entity {
            private String contrId;
            private double feeAmount;
            private String feeId;
            private String feeType;
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

            public void setFeeType(String feeType) {
                this.feeType = feeType;
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

            public String getFeeType() {
                return feeType;
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

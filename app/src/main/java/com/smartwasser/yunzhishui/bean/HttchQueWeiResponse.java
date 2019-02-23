package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/7 0007.
 */
public class HttchQueWeiResponse extends RBResponse {
    /**
     * EqFailure : {"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipName":"污水泵","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"aaaaa","failureEdate":"2016-05-24 00:00:00","failureId":"2325622e20ad11e69ffe000c29b2d655","failurePart":"10","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"402881e44c797e4b014c7df5cae10053","startend":"2016-06-01 12:00:00\u2014\u20142016-05-24 12:00:00"}
     */
    private DataEntity data;
    /**
     * data : {"EqFailure":{"checkMethod":"aa","equipAscode":"3301080016","equipCode":"00000297","equipLocCodeName":"高碑店污泥","equipName":"污水泵","equipOwnDept":"高碑店污泥","failureAppear":"轴承磨损","failureDeal":"aaaaa","failureEdate":"2016-05-24 00:00:00","failureId":"2325622e20ad11e69ffe000c29b2d655","failurePart":"10","failureReason":"aaaa","failureRemark":"","failureSdate":"2016-06-01 00:00:00","failureState":1,"failureTbType":"402881e44c797e4b014c7df5cae10053","startend":"2016-06-01 12:00:00\u2014\u20142016-05-24 12:00:00"}}
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
         * checkMethod : aa
         * equipAscode : 3301080016
         * equipCode : 00000297
         * equipLocCodeName : 高碑店污泥
         * equipName : 污水泵
         * equipOwnDept : 高碑店污泥
         * failureAppear : 轴承磨损
         * failureDeal : aaaaa
         * failureEdate : 2016-05-24 00:00:00
         * failureId : 2325622e20ad11e69ffe000c29b2d655
         * failurePart : 10
         * failureReason : aaaa
         * failureRemark :
         * failureSdate : 2016-06-01 00:00:00
         * failureState : 1
         * failureTbType : 402881e44c797e4b014c7df5cae10053
         * startend : 2016-06-01 12:00:00——2016-05-24 12:00:00
         */

        private EqFailureEntity EqFailure;

        public void setEqFailure(EqFailureEntity EqFailure) {
            this.EqFailure = EqFailure;
        }

        public EqFailureEntity getEqFailure() {
            return EqFailure;
        }

        public static class EqFailureEntity {
            private String checkMethod;
            private String equipAscode;
            private String equipCode;
            private String equipLocCodeName;
            private String equipName;
            private String equipOwnDept;
            private String failureAppear;
            private String failureDeal;
            private String failureEdate;
            private String failureId;
            private String failurePart;
            private String failureReason;
            private String failureRemark;
            private String failureSdate;
            private int failureState;
            private String failureTbType;
            private String startend;

            public void setCheckMethod(String checkMethod) {
                this.checkMethod = checkMethod;
            }

            public void setEquipAscode(String equipAscode) {
                this.equipAscode = equipAscode;
            }

            public void setEquipCode(String equipCode) {
                this.equipCode = equipCode;
            }

            public void setEquipLocCodeName(String equipLocCodeName) {
                this.equipLocCodeName = equipLocCodeName;
            }

            public void setEquipName(String equipName) {
                this.equipName = equipName;
            }

            public void setEquipOwnDept(String equipOwnDept) {
                this.equipOwnDept = equipOwnDept;
            }

            public void setFailureAppear(String failureAppear) {
                this.failureAppear = failureAppear;
            }

            public void setFailureDeal(String failureDeal) {
                this.failureDeal = failureDeal;
            }

            public void setFailureEdate(String failureEdate) {
                this.failureEdate = failureEdate;
            }

            public void setFailureId(String failureId) {
                this.failureId = failureId;
            }

            public void setFailurePart(String failurePart) {
                this.failurePart = failurePart;
            }

            public void setFailureReason(String failureReason) {
                this.failureReason = failureReason;
            }

            public void setFailureRemark(String failureRemark) {
                this.failureRemark = failureRemark;
            }

            public void setFailureSdate(String failureSdate) {
                this.failureSdate = failureSdate;
            }

            public void setFailureState(int failureState) {
                this.failureState = failureState;
            }

            public void setFailureTbType(String failureTbType) {
                this.failureTbType = failureTbType;
            }

            public void setStartend(String startend) {
                this.startend = startend;
            }

            public String getCheckMethod() {
                return checkMethod;
            }

            public String getEquipAscode() {
                return equipAscode;
            }

            public String getEquipCode() {
                return equipCode;
            }

            public String getEquipLocCodeName() {
                return equipLocCodeName;
            }

            public String getEquipName() {
                return equipName;
            }

            public String getEquipOwnDept() {
                return equipOwnDept;
            }

            public String getFailureAppear() {
                return failureAppear;
            }

            public String getFailureDeal() {
                return failureDeal;
            }

            public String getFailureEdate() {
                return failureEdate;
            }

            public String getFailureId() {
                return failureId;
            }

            public String getFailurePart() {
                return failurePart;
            }

            public String getFailureReason() {
                return failureReason;
            }

            public String getFailureRemark() {
                return failureRemark;
            }

            public String getFailureSdate() {
                return failureSdate;
            }

            public int getFailureState() {
                return failureState;
            }

            public String getFailureTbType() {
                return failureTbType;
            }

            public String getStartend() {
                return startend;
            }
        }
    }
}

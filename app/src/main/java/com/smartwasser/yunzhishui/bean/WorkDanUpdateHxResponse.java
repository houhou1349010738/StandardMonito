package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/10 0010.
 */
public class WorkDanUpdateHxResponse extends RBResponse {

    /**
     * EqMaintain : {"maintainCharge":"lisi","maintainEdate":"2016-07-29 00:00:00","maintainId":"742e72b2465e11e69bf5000c29b2d655","maintainImpDept":"wangwu","maintainMonth":"07","maintainName":"111","maintainSdate":"2016-07-13 00:00:00","maintainStatus":1}
     */

    private DataEntity data;
    /**
     * data : {"EqMaintain":{"maintainCharge":"lisi","maintainEdate":"2016-07-29 00:00:00","maintainId":"742e72b2465e11e69bf5000c29b2d655","maintainImpDept":"wangwu","maintainMonth":"07","maintainName":"111","maintainSdate":"2016-07-13 00:00:00","maintainStatus":1}}
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
         * maintainCharge : lisi
         * maintainEdate : 2016-07-29 00:00:00
         * maintainId : 742e72b2465e11e69bf5000c29b2d655
         * maintainImpDept : wangwu
         * maintainMonth : 07
         * maintainName : 111
         * maintainSdate : 2016-07-13 00:00:00
         * maintainStatus : 1
         */

        private EqMaintainEntity EqMaintain;

        public void setEqMaintain(EqMaintainEntity EqMaintain) {
            this.EqMaintain = EqMaintain;
        }

        public EqMaintainEntity getEqMaintain() {
            return EqMaintain;
        }

        public static class EqMaintainEntity {
            private String maintainCharge;
            private String maintainEdate;
            private String maintainId;
            private String maintainImpDept;
            private String maintainMonth;
            private String maintainName;
            private String maintainSdate;
            private int maintainStatus;

            public void setMaintainCharge(String maintainCharge) {
                this.maintainCharge = maintainCharge;
            }

            public void setMaintainEdate(String maintainEdate) {
                this.maintainEdate = maintainEdate;
            }

            public void setMaintainId(String maintainId) {
                this.maintainId = maintainId;
            }

            public void setMaintainImpDept(String maintainImpDept) {
                this.maintainImpDept = maintainImpDept;
            }

            public void setMaintainMonth(String maintainMonth) {
                this.maintainMonth = maintainMonth;
            }

            public void setMaintainName(String maintainName) {
                this.maintainName = maintainName;
            }

            public void setMaintainSdate(String maintainSdate) {
                this.maintainSdate = maintainSdate;
            }

            public void setMaintainStatus(int maintainStatus) {
                this.maintainStatus = maintainStatus;
            }

            public String getMaintainCharge() {
                return maintainCharge;
            }

            public String getMaintainEdate() {
                return maintainEdate;
            }

            public String getMaintainId() {
                return maintainId;
            }

            public String getMaintainImpDept() {
                return maintainImpDept;
            }

            public String getMaintainMonth() {
                return maintainMonth;
            }

            public String getMaintainName() {
                return maintainName;
            }

            public String getMaintainSdate() {
                return maintainSdate;
            }

            public int getMaintainStatus() {
                return maintainStatus;
            }
        }
    }
}

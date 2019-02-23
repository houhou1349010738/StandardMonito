package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/9 0009.
 */
public class WorkDanUpdateResponse extends RBResponse {

    /**
     * EqMaintain : {"equipAscode":"3301090006","equipCode":"00000249","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"管道泵","id":"aafcc0ea459311e69bf5000c29b2d655","maintainComment":"111","maintainDate":"2016-07-06 00:00:00","maintainId":"32eb930c44d711e69bf5000c29b2d655","maintainName":"调整","maintainPart":13,"maintainPartName":"密封","maintainRemark":"11","maintainStatus":1,"maintainType":2,"maintainUnitName":"111"}
     */

    private DataEntity data;
    /**
     * data : {"EqMaintain":{"equipAscode":"3301090006","equipCode":"00000249","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"管道泵","id":"aafcc0ea459311e69bf5000c29b2d655","maintainComment":"111","maintainDate":"2016-07-06 00:00:00","maintainId":"32eb930c44d711e69bf5000c29b2d655","maintainName":"调整","maintainPart":13,"maintainPartName":"密封","maintainRemark":"11","maintainStatus":1,"maintainType":2,"maintainUnitName":"111"}}
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
         * equipAscode : 3301090006
         * equipCode : 00000249
         * equipDeptCode : CZWN0830
         * equipDeptName : 高碑店污泥
         * equipName : 管道泵
         * id : aafcc0ea459311e69bf5000c29b2d655
         * maintainComment : 111
         * maintainDate : 2016-07-06 00:00:00
         * maintainId : 32eb930c44d711e69bf5000c29b2d655
         * maintainName : 调整
         * maintainPart : 13
         * maintainPartName : 密封
         * maintainRemark : 11
         * maintainStatus : 1
         * maintainType : 2
         * maintainUnitName : 111
         */

        private EqMaintainEntity EqMaintain;

        public void setEqMaintain(EqMaintainEntity EqMaintain) {
            this.EqMaintain = EqMaintain;
        }

        public EqMaintainEntity getEqMaintain() {
            return EqMaintain;
        }

        public static class EqMaintainEntity {
            private String equipAscode;
            private String equipCode;
            private String equipDeptCode;
            private String equipDeptName;
            private String equipName;
            private String id;
            private String maintainComment;
            private String maintainDate;
            private String maintainId;
            private String maintainName;
            private int maintainPart;
            private String maintainPartName;
            private String maintainRemark;
            private int maintainStatus;
            private int maintainType;
            private String maintainUnitName;

            public void setEquipAscode(String equipAscode) {
                this.equipAscode = equipAscode;
            }

            public void setEquipCode(String equipCode) {
                this.equipCode = equipCode;
            }

            public void setEquipDeptCode(String equipDeptCode) {
                this.equipDeptCode = equipDeptCode;
            }

            public void setEquipDeptName(String equipDeptName) {
                this.equipDeptName = equipDeptName;
            }

            public void setEquipName(String equipName) {
                this.equipName = equipName;
            }

            public void setId(String id) {
                this.id = id;
            }

            public void setMaintainComment(String maintainComment) {
                this.maintainComment = maintainComment;
            }

            public void setMaintainDate(String maintainDate) {
                this.maintainDate = maintainDate;
            }

            public void setMaintainId(String maintainId) {
                this.maintainId = maintainId;
            }

            public void setMaintainName(String maintainName) {
                this.maintainName = maintainName;
            }

            public void setMaintainPart(int maintainPart) {
                this.maintainPart = maintainPart;
            }

            public void setMaintainPartName(String maintainPartName) {
                this.maintainPartName = maintainPartName;
            }

            public void setMaintainRemark(String maintainRemark) {
                this.maintainRemark = maintainRemark;
            }

            public void setMaintainStatus(int maintainStatus) {
                this.maintainStatus = maintainStatus;
            }

            public void setMaintainType(int maintainType) {
                this.maintainType = maintainType;
            }

            public void setMaintainUnitName(String maintainUnitName) {
                this.maintainUnitName = maintainUnitName;
            }

            public String getEquipAscode() {
                return equipAscode;
            }

            public String getEquipCode() {
                return equipCode;
            }

            public String getEquipDeptCode() {
                return equipDeptCode;
            }

            public String getEquipDeptName() {
                return equipDeptName;
            }

            public String getEquipName() {
                return equipName;
            }

            public String getId() {
                return id;
            }

            public String getMaintainComment() {
                return maintainComment;
            }

            public String getMaintainDate() {
                return maintainDate;
            }

            public String getMaintainId() {
                return maintainId;
            }

            public String getMaintainName() {
                return maintainName;
            }

            public int getMaintainPart() {
                return maintainPart;
            }

            public String getMaintainPartName() {
                return maintainPartName;
            }

            public String getMaintainRemark() {
                return maintainRemark;
            }

            public int getMaintainStatus() {
                return maintainStatus;
            }

            public int getMaintainType() {
                return maintainType;
            }

            public String getMaintainUnitName() {
                return maintainUnitName;
            }
        }
    }
}

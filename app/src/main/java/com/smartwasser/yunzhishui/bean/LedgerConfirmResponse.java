package com.smartwasser.yunzhishui.bean;

/**
 * Created by huangmengjie on 2016/7/8 0008.
 */
public class LedgerConfirmResponse extends RBResponse{
    /**
     * EqEquipInfo : {"abcType":3,"asCode":"3301080050","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000270","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c79615e610028","equipLocCode":"402836814c72eddf014c73139362000c","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"14＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipUseStatus":1,"isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014"}
     */

    private DataEntity data;
    /**
     * data : {"EqEquipInfo":{"abcType":3,"asCode":"3301080050","asDept":"CZWN0830","asValue":61581,"equipCharge":"","equipCode":"00000270","equipEnabledDate":"2004-12-30 00:00:00","equipEntryDate":"2004-12-30 00:00:00","equipId":"402881e44c790cb8014c79615e610028","equipLocCode":"402836814c72eddf014c73139362000c","equipMakeCode":"","equipMakeCountry":"中国","equipMakedate":"2004-11-15 00:00:00","equipMaker":"飞力","equipModel":"","equipName":"14＃消化池排泥泵","equipOwnDept":"CZWN0830","equipOwnStruct":"402881ed4090aa2e014090bbab810002","equipOwnStructName":"进水泵房","equipStandard":"","equipTecStatus":1,"equipUseStatus":1,"isFiling":0,"overhaulCycle":0,"pdCode":"","remark":"","sbxzCode":"1","typeCode":"402836814c6e7f2a014c6eb199260014"}}
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
         * abcType : 3
         * asCode : 3301080050
         * asDept : CZWN0830
         * asValue : 61581
         * equipCharge :
         * equipCode : 00000270
         * equipEnabledDate : 2004-12-30 00:00:00
         * equipEntryDate : 2004-12-30 00:00:00
         * equipId : 402881e44c790cb8014c79615e610028
         * equipLocCode : 402836814c72eddf014c73139362000c
         * equipMakeCode :
         * equipMakeCountry : 中国
         * equipMakedate : 2004-11-15 00:00:00
         * equipMaker : 飞力
         * equipModel :
         * equipName : 14＃消化池排泥泵
         * equipOwnDept : CZWN0830
         * equipOwnStruct : 402881ed4090aa2e014090bbab810002
         * equipOwnStructName : 进水泵房
         * equipStandard :
         * equipTecStatus : 1
         * equipUseStatus : 1
         * isFiling : 0
         * overhaulCycle : 0
         * pdCode :
         * remark :
         * sbxzCode : 1
         * typeCode : 402836814c6e7f2a014c6eb199260014
         */

        private EqEquipInfoEntity EqEquipInfo;

        public void setEqEquipInfo(EqEquipInfoEntity EqEquipInfo) {
            this.EqEquipInfo = EqEquipInfo;
        }

        public EqEquipInfoEntity getEqEquipInfo() {
            return EqEquipInfo;
        }

        public static class EqEquipInfoEntity {
            private int abcType;
            private String asCode;
            private String asDept;
            private int asValue;
            private String equipCharge;
            private String equipCode;
            private String equipEnabledDate;
            private String equipEntryDate;
            private String equipId;
            private String equipLocCode;
            private String equipMakeCode;
            private String equipMakeCountry;
            private String equipMakedate;
            private String equipMaker;
            private String equipModel;
            private String cgDate;


            private String equipName;
            private String equipOwnDept;
            private String equipOwnStruct;
            private String equipOwnStructName;
            private String equipStandard;
            private int equipTecStatus;
            private int equipUseStatus;
            private int isFiling;
            private int overhaulCycle;
            private String pdCode;
            private String remark;
            private String sbxzCode;
            private String typeCode;
            private String bxDate;
            private String equipScrapDate;

            public String getEquipScrapDate() {
                return equipScrapDate;
            }

            public void setEquipScrapDate(String equipScrapDate) {
                this.equipScrapDate = equipScrapDate;
            }

            public String getBxDate() {
                return bxDate;
            }

            public void setBxDate(String bxDate) {
                this.bxDate = bxDate;
            }

            public void setAbcType(int abcType) {
                this.abcType = abcType;
            }

            public void setAsCode(String asCode) {
                this.asCode = asCode;
            }

            public void setAsDept(String asDept) {
                this.asDept = asDept;
            }

            public void setAsValue(int asValue) {
                this.asValue = asValue;
            }

            public void setEquipCharge(String equipCharge) {
                this.equipCharge = equipCharge;
            }

            public void setEquipCode(String equipCode) {
                this.equipCode = equipCode;
            }

            public void setEquipEnabledDate(String equipEnabledDate) {
                this.equipEnabledDate = equipEnabledDate;
            }

            public void setEquipEntryDate(String equipEntryDate) {
                this.equipEntryDate = equipEntryDate;
            }
            public void setCgDate(String cgDate) {
                this.cgDate = cgDate;
            }

            public String getCgDate() {

                return cgDate;
            }
            public void setEquipId(String equipId) {
                this.equipId = equipId;
            }

            public void setEquipLocCode(String equipLocCode) {
                this.equipLocCode = equipLocCode;
            }

            public void setEquipMakeCode(String equipMakeCode) {
                this.equipMakeCode = equipMakeCode;
            }

            public void setEquipMakeCountry(String equipMakeCountry) {
                this.equipMakeCountry = equipMakeCountry;
            }

            public void setEquipMakedate(String equipMakedate) {
                this.equipMakedate = equipMakedate;
            }

            public void setEquipMaker(String equipMaker) {
                this.equipMaker = equipMaker;
            }

            public void setEquipModel(String equipModel) {
                this.equipModel = equipModel;
            }

            public void setEquipName(String equipName) {
                this.equipName = equipName;
            }

            public void setEquipOwnDept(String equipOwnDept) {
                this.equipOwnDept = equipOwnDept;
            }

            public void setEquipOwnStruct(String equipOwnStruct) {
                this.equipOwnStruct = equipOwnStruct;
            }

            public void setEquipOwnStructName(String equipOwnStructName) {
                this.equipOwnStructName = equipOwnStructName;
            }

            public void setEquipStandard(String equipStandard) {
                this.equipStandard = equipStandard;
            }

            public void setEquipTecStatus(int equipTecStatus) {
                this.equipTecStatus = equipTecStatus;
            }

            public void setEquipUseStatus(int equipUseStatus) {
                this.equipUseStatus = equipUseStatus;
            }

            public void setIsFiling(int isFiling) {
                this.isFiling = isFiling;
            }

            public void setOverhaulCycle(int overhaulCycle) {
                this.overhaulCycle = overhaulCycle;
            }

            public void setPdCode(String pdCode) {
                this.pdCode = pdCode;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public void setSbxzCode(String sbxzCode) {
                this.sbxzCode = sbxzCode;
            }

            public void setTypeCode(String typeCode) {
                this.typeCode = typeCode;
            }

            public int getAbcType() {
                return abcType;
            }

            public String getAsCode() {
                return asCode;
            }

            public String getAsDept() {
                return asDept;
            }

            public int getAsValue() {
                return asValue;
            }

            public String getEquipCharge() {
                return equipCharge;
            }

            public String getEquipCode() {
                return equipCode;
            }

            public String getEquipEnabledDate() {
                return equipEnabledDate;
            }

            public String getEquipEntryDate() {
                return equipEntryDate;
            }

            public String getEquipId() {
                return equipId;
            }

            public String getEquipLocCode() {
                return equipLocCode;
            }

            public String getEquipMakeCode() {
                return equipMakeCode;
            }

            public String getEquipMakeCountry() {
                return equipMakeCountry;
            }

            public String getEquipMakedate() {
                return equipMakedate;
            }

            public String getEquipMaker() {
                return equipMaker;
            }

            public String getEquipModel() {
                return equipModel;
            }

            public String getEquipName() {
                return equipName;
            }

            public String getEquipOwnDept() {
                return equipOwnDept;
            }

            public String getEquipOwnStruct() {
                return equipOwnStruct;
            }

            public String getEquipOwnStructName() {
                return equipOwnStructName;
            }

            public String getEquipStandard() {
                return equipStandard;
            }

            public int getEquipTecStatus() {
                return equipTecStatus;
            }

            public int getEquipUseStatus() {
                return equipUseStatus;
            }

            public int getIsFiling() {
                return isFiling;
            }

            public int getOverhaulCycle() {
                return overhaulCycle;
            }

            public String getPdCode() {
                return pdCode;
            }

            public String getRemark() {
                return remark;
            }

            public String getSbxzCode() {
                return sbxzCode;
            }

            public String getTypeCode() {
                return typeCode;
            }
        }
    }
}

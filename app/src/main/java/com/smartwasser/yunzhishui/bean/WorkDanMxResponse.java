package com.smartwasser.yunzhishui.bean;

import java.util.List;

/**
 * Created by huangmengjie on 2016/7/8 0008.
 */
public class WorkDanMxResponse extends RBResponse{
    /**
     * EqMaintainDetail : {"rows":[{"equipAscode":"3301080053","equipCode":"00000267qqqqq","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"1＃不锈钢热水潜污泵","id":"a9e46569287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-04 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainPart":12,"maintainPartName":"存储","maintainRemark":"11","maintainStatus":2,"maintainUnitName":"1"},{"equipAscode":"3301080016","equipCode":"00000297","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"污水泵","id":"c087518d287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-24 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainRemark":"11","maintainStatus":2,"maintainUnitName":"11"},{"equipAscode":"3301010009","equipCode":"00000364","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"1#采暖循环泵","id":"ced1891a287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-18 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainName":"紧固","maintainPart":2,"maintainPartName":"传动","maintainRemark":"11","maintainStatus":1,"maintainType":4,"maintainUnitName":"11"}],"total":3}
     */
    private DataEntity data;
    /**
     * data : {"EqMaintainDetail":{"rows":[{"equipAscode":"3301080053","equipCode":"00000267qqqqq","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"1＃不锈钢热水潜污泵","id":"a9e46569287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-04 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainPart":12,"maintainPartName":"存储","maintainRemark":"11","maintainStatus":2,"maintainUnitName":"1"},{"equipAscode":"3301080016","equipCode":"00000297","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"污水泵","id":"c087518d287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-24 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainRemark":"11","maintainStatus":2,"maintainUnitName":"11"},{"equipAscode":"3301010009","equipCode":"00000364","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"1#采暖循环泵","id":"ced1891a287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-18 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainName":"紧固","maintainPart":2,"maintainPartName":"传动","maintainRemark":"11","maintainStatus":1,"maintainType":4,"maintainUnitName":"11"}],"total":3}}
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
         * rows : [{"equipAscode":"3301080053","equipCode":"00000267qqqqq","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"1＃不锈钢热水潜污泵","id":"a9e46569287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-04 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainPart":12,"maintainPartName":"存储","maintainRemark":"11","maintainStatus":2,"maintainUnitName":"1"},{"equipAscode":"3301080016","equipCode":"00000297","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"污水泵","id":"c087518d287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-24 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainRemark":"11","maintainStatus":2,"maintainUnitName":"11"},{"equipAscode":"3301010009","equipCode":"00000364","equipDeptCode":"CZWN0830","equipDeptName":"高碑店污泥","equipName":"1#采暖循环泵","id":"ced1891a287011e69ffe000c29b2d655","maintainComment":"11","maintainDate":"2016-06-18 00:00:00","maintainId":"85c9f5da286e11e69ffe000c29b2d655","maintainName":"紧固","maintainPart":2,"maintainPartName":"传动","maintainRemark":"11","maintainStatus":1,"maintainType":4,"maintainUnitName":"11"}]
         * total : 3
         */

        private EqMaintainDetailEntity EqMaintainDetail;

        public void setEqMaintainDetail(EqMaintainDetailEntity EqMaintainDetail) {
            this.EqMaintainDetail = EqMaintainDetail;
        }

        public EqMaintainDetailEntity getEqMaintainDetail() {
            return EqMaintainDetail;
        }

        public static class EqMaintainDetailEntity {
            private int total;
            /**
             * equipAscode : 3301080053
             * equipCode : 00000267qqqqq
             * equipDeptCode : CZWN0830
             * equipDeptName : 高碑店污泥
             * equipName : 1＃不锈钢热水潜污泵
             * id : a9e46569287011e69ffe000c29b2d655
             * maintainComment : 11
             * maintainDate : 2016-06-04 00:00:00
             * maintainId : 85c9f5da286e11e69ffe000c29b2d655
             * maintainPart : 12
             * maintainPartName : 存储
             * maintainRemark : 11
             * maintainStatus : 2
             * maintainUnitName : 1
             */
            private List<RowsEntity> rows;

            public void setTotal(int total) {
                this.total = total;
            }

            public void setRows(List<RowsEntity> rows) {
                this.rows = rows;
            }

            public int getTotal() {
                return total;
            }

            public List<RowsEntity> getRows() {
                return rows;
            }

            public static class RowsEntity {
                private String equipAscode;
                private String equipCode;
                private String equipDeptCode;
                private String equipDeptName;
                private String equipName;
                private String id;
                private String maintainComment;
                private String maintainDate;
                private String maintainId;
                private int maintainPart;
                private String maintainPartName;
                private String maintainRemark;
                private String maintainStatus;
                private String maintainUnitName;

                public String getMaintainName() {
                    return maintainName;
                }

                public void setMaintainName(String maintainName) {
                    this.maintainName = maintainName;
                }

                private String maintainName;
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

                public void setMaintainPart(int maintainPart) {
                    this.maintainPart = maintainPart;
                }

                public void setMaintainPartName(String maintainPartName) {
                    this.maintainPartName = maintainPartName;
                }

                public void setMaintainRemark(String maintainRemark) {
                    this.maintainRemark = maintainRemark;
                }

                public void setMaintainStatus(String maintainStatus) {
                    this.maintainStatus = maintainStatus;
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

                public int getMaintainPart() {
                    return maintainPart;
                }

                public String getMaintainPartName() {
                    return maintainPartName;
                }

                public String getMaintainRemark() {
                    return maintainRemark;
                }

                public String getMaintainStatus() {
                    return maintainStatus;
                }

                public String getMaintainUnitName() {
                    return maintainUnitName;
                }
            }
        }
    }
}
